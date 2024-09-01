package priv.ray.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @ClassName: ByteUtil
 * @Author: WA
 * @Description: byte相关工具
 * @Date: 2021/10/12 9:17
 * @Version: 1.0
 */
@Slf4j
public class ByteUtil {
    public final static int INT = 0;
    public final static int STRING = 1;
    public final static int CP56TIME = 3;
    public final static int SHORT = 5;
    public final static int BCD = 6;
    public final static int LONG = 7;

    //初始长度为8的buff，每次使用后清空
    static ByteBuf bufLen8 = ByteBufAllocator.DEFAULT.heapBuffer(8);

    //长度域取反(文档和实际不同，实际为长度的反码)
    public static String cutNumber0(Object number) {
        return new BigDecimal(String.valueOf(number)).toString();
    }

    public static Long bcd2Long(Object numStr) {
        Long parseLong = null;
        try {
            parseLong = Long.parseLong(String.valueOf(numStr));
        }catch (Exception e){
            log.error("将String类型流水号转为long出错，可能数值超过long上限");
            e.printStackTrace();
        }
        return  parseLong;
    }


    /**
     * 获取校验码
     * @param data
     * @return
     */
    public static byte[] getCRC(byte[] data) {
        int len = data.length;

        // 预置 1 个 16 位的寄存器为十六进制FFFF, 称此寄存器为 CRC寄存器。
        int crc = 0xFFFF;
        int i, j;
        for (i = 0; i < len; i++) {
            // 把第一个 8 位二进制数据 与 16 位的 CRC寄存器的低 8 位相异或, 把结果放于 CRC寄存器
            crc = ((crc & 0xFF00) | (crc & 0x00FF) ^ (data[i] & 0xFF));
            for (j = 0; j < 8; j++) {
                // 把 CRC 寄存器的内容右移一位( 朝低位)用 0 填补最高位, 并检查右移后的移出位
                if ((crc & 0x0001) > 0) {
                    // 如果移出位为 1, CRC寄存器与多项式A001进行异或
                    crc = crc >> 1;
                    crc = crc ^ 0xA001;
                } else {
                    // 如果移出位为 0,再次右移一位
                    crc = crc >> 1;
                }
            }
        }
        //低字节在前，高字节在后
        byte[] src = new byte[2];
        src[1] = (byte) ((crc >> 8) & 0xFF);
        src[0] = (byte) (crc & 0xFF);
        return src;
    }


    public static int bytes2Int(byte[] b) {
        int value;
        value = (int) ((b[0] & 0xFF)
                | ((b[1] & 0xFF) << 8)
                | ((b[2] & 0xFF) << 16)
                | ((b[3] & 0xFF) << 24));
        return value;
    }

    public static int byte2Int(byte b) {
        return b & 0xff;
    }


    public static byte[] int2Bytes(int value ) {
            byte[] src = new byte[4];
            src[0] =  (byte) (value & 0xFF);
            src[1] =  (byte) ((value>>8) & 0xFF);
            src[2] =  (byte) ((value>>16) & 0xFF);
            src[3] =  (byte) ((value>>24) & 0xFF);
            return src;
        }

    public static byte[] long2Bytes(long value ) {
        byte[] src = new byte[8];
        src[0] =  (byte) (value & 0xFF);
        src[1] =  (byte) ((value>>8) & 0xFF);
        src[2] =  (byte) ((value>>16) & 0xFF);
        src[3] =  (byte) ((value>>24) & 0xFF);

        src[5] =  (byte) ((value>>32) & 0xFF);
        src[5] =  (byte) ((value>>40) & 0xFF);
        src[6] =  (byte) ((value>>48) & 0xFF);
        src[7] =  (byte) ((value>>56) & 0xFF);
        return src;
    }

    public static long byte2LongLe(byte[] b)  {
        synchronized (bufLen8){
            //每次操作前清空
            bufLen8.clear();
            bufLen8.writeBytes(b);
            return bufLen8.readLongLE();
        }
    }
    public static long byte2Long(byte[] b)  {
        synchronized (bufLen8){
            //每次操作前清空
            bufLen8.clear();
            bufLen8.writeBytes(b);
            return bufLen8.readLong();
        }
    }

    public static short byte2Short(byte[] b) {
        short value = 0;
        for (int i = 1; i >= 0; i--) {
            value <<= 8;
            value |= (b[i] & 0xff);
        }
        return value;
    }

    public static byte[] short2Byte(short s) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) ((s >> 8) & 0xff);
        bytes[1] = (byte) (s & 0xff);
        return bytes;
    }

    public static byte[] string2Byte(String s,int len) {
        byte[] bytes = new byte[len];
        byte[] stringBytes = s.getBytes(StandardCharsets.US_ASCII);
        if (stringBytes.length>len){
            log.error("string转byte[]出错，长度大于指定值，默认全0,stringBytes:{};len:{}",stringBytes,len);
            Arrays.fill(bytes, (byte) 0x00);
        }else if (stringBytes.length == len){
            bytes = stringBytes;
        }else {
            for (int i = 0; i < bytes.length; i++) {
                if (i<len-stringBytes.length){
                    bytes[i] = 0x00;
                }else {
                    bytes[i] = stringBytes[i+stringBytes.length-len];
                }
            }
        }
        return bytes;
    }

    public static boolean[] readBit(byte[] bytes) {
        boolean[] booleans = new boolean[8 * bytes.length];
        for (int j=0;j<bytes.length;j++){
            for(int i=0;i<8;i++){
                if(((bytes[bytes.length-1-j]>>i)&0x01)==1){
                    booleans[i+(j*8)] = true;
                } else{
                    booleans[i+(j*8)] = false;
                }
            }
        }
        return booleans;
    }

    public static byte[] time2Byte(LocalDateTime date) {
        if (date == null) {
            date = LocalDateTime.now();
        }
        byte[] bytes = new byte[7];

        short second = (short) (date.getSecond() * 1000);
        bytes[0] = (byte) (second & 0xff);
        bytes[1] = (byte) ((second >> 8) & 0xff);
        bytes[2] = (byte) date.getMinute();
        bytes[3] = (byte) date.getHour();
        bytes[4] = (byte) date.getDayOfMonth();
        bytes[5] = (byte) date.getMonthValue();
        bytes[6] = (byte) (date.getYear()-2000);
        return bytes;
    }
    public static String byte2Time(byte[] bytes)  {
        int year = bytes[6] & 0x7F;
        int month = bytes[5] & 0x0F;
        int day = bytes[4] & 0x1F;
        int hour = bytes[3] & 0x1F;
        int minute = bytes[2] & 0x3F;
        int second = ((bytes[1] & 0xFF) << 8)+ (bytes[0]& 0xFF);
        StringBuilder result = new StringBuilder( );
        result.append("20").append(year) .append("-" ).append(String.format ( "%02d" , month ) ) .append("-")
                .append (String.format ( "%02d", day ) ) .append( " " ).append(String.format ( "%02d" , hour )) .append( ":" ).append(String.format ( "%02d" , minute ))
                .append(":").append(String.format("%02d",second / 1000));
        return result.toString();
    }



    public static byte[] bcd2Byte(Object num,int byteLen)  {
        String number = String.valueOf(num);
        byte[] bytes = new byte[(number.length()+1)/2];
        int charpos = 0; //char where we start
        int bufpos = 0;

        if (number.length() % 2 == 1) {
            //for odd lengths we encode just the first digit in the first byte
            bytes[0] = (byte)(number.charAt(0) - 48);
            charpos = 1;
            bufpos = 1;
        }
        //encode the rest of the string
        while (charpos < number.length()) {
            bytes[bufpos] = (byte)(((number.charAt(charpos) - 48) << 4)
                    | (number.charAt(charpos + 1) - 48));
            charpos += 2;
            bufpos++;
        }
        byte[] result = new byte[byteLen];
        for (int i = 0; i < result.length; i++) {
            if (i>= result.length-bytes.length){
                result[i] = bytes[i+bytes.length-result.length];
            }
        }
        return result;
    }


    //传入tar数组长度务必为正好的，且从0开始capy
    public static Object byte2Type(byte[] src, int sPos, byte[] tar, int type) {
        System.arraycopy(src, sPos, tar, 0, tar.length);
        if (type == STRING) {
            return new String(tar, StandardCharsets.US_ASCII).trim();
        } else if (type == INT) {
            return bytes2Int(tar);
        }else if (type == SHORT) {
            return byte2Short(tar);
        } else if(type == BCD){
            StringBuffer temp = new StringBuffer(tar.length * 2);
            for (int i = 0; i < tar.length; i++) {
                temp.append((byte) ((tar[i] & 0xf0) >>> 4));
                temp.append((byte) (tar[i] & 0x0f));
            }
            return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
                    .toString().substring(1) : temp.toString();
        }else if (type == CP56TIME) {
            return byte2Time(tar);
        } else if (type == LONG) {
            return byte2LongLe(tar);
        } else {
            return null;
        }
    }
}

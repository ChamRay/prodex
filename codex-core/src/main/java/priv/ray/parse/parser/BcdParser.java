package priv.ray.parse.parser;

import priv.ray.parse.enums.CodexEnum;
import priv.ray.util.ByteUtil;

/**
 * @author Ray
 * @data 2024/8/15 16:35
 * @description: bcd编解码器
 */
public class BcdParser implements CodexParser<String> {


    @Override
    public CodexEnum getCodexType() {
        return CodexEnum.BCD;
    }

    @Override
    public byte[] encode(String hexString)  {
        hexString = hexString.trim();
        int length = hexString.length();
        return hexStringToByteArray(hexString.trim());
    }

    @Override
    public String decode(byte[] bytes) {
        return byteArrayToBCDString(bytes);
    }
    private static String byteArrayToBCDString(byte[] byteArray) {
        StringBuilder sb = new StringBuilder(byteArray.length * 2);

        for (byte b : byteArray) {
            // 计算字节的高 4 位（高 nibble）和低 4 位（低 nibble）
            char highNibble = Character.forDigit((b >> 4) & 0x0F, 16);
            char lowNibble = Character.forDigit(b & 0x0F, 16);

            // 将高 nibble 和低 nibble 转换为字符，并附加到字符串构建器中
            sb.append(highNibble);
            sb.append(lowNibble);
        }

        return sb.toString();
    }

    // 将十六进制字符串转换为字节数组
    private static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return data;
    }


}

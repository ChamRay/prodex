package priv.ray.parse.enums;

/**
 * @author Ray
 * @date 2020/11/26
 * @decription  协议帧中包含的编解码格式标识
 */

public enum CodexEnum {

    // 协议帧中包含的编解码格式均为低位在前，高位在后
    BYTE,
    INT,
    SHORT,
    LONG,
    /**
     * BCD 码，八位组成，每四位为一个十进制数，范围为0-9。
     * 例如：1234 表示为：00010010 00110100
     * 注意：BCD码在协议帧中使用的是低位在前，高位在后的存储方式
     */
    BCD,
    ASCII,
    CP56Time2a
    ;



}

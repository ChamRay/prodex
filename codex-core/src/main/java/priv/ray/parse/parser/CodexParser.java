package priv.ray.parse.parser;

import priv.ray.parse.enums.CodexEnum;

/**
 * @author Ray
 * @description 用于对应的编解码解析器
 * @param <T> 编解码的实体类，数据对象的载体
 */
public interface CodexParser<T> {


    CodexEnum getCodexType();
    /**
     * 将字段数据编码为byte数组
     * @param t 任意类型对象
     * @return
     */
    public byte[] encode(T t) ;

    /**
     * 将byte数组解码为字段数据
     * @param bytes 字节数组
     * @return
     */
    public T decode(byte[] bytes);

}

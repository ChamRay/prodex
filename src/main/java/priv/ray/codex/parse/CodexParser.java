package priv.ray.codex.parse;

import priv.ray.codex.enums.CodexEnum;

/**
 * @author Ray
 * @description 用于对应的编解码解析器
 * @param <T> 编解码的实体类，数据对象的载体
 */
public interface CodexParser<T> {


    /**
     * 将字段数据编码为byte数组
     * @param t
     * @return
     */
    public byte[] encode(byte[] bytes, T t, CodexEnum type);

    /**
     * 将byte数组解码为字段数据
     * @param bytes
     * @return
     */
    public T decode(byte[] bytes, CodexEnum type);

}

package priv.ray.wrapper;

import priv.ray.parse.parser.CodexParser;

import java.util.function.Function;

/**
 * @author Ray
 * @data 2024/9/1 16:56
 * @description: 编解码处理器，用于处理实体属性的编解码操作
 */
public class WeakFieldWrapper<E> {

    private Function<E,String> encoder;
    private Class<? extends CodexParser> parserClass;

    public WeakFieldWrapper(Function<E,String> encoder, Class<? extends CodexParser> parserClass) {
        this.encoder = encoder;
        this.parserClass = parserClass;
    }


}

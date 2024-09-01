package priv.ray.build;

import priv.ray.parse.parser.CodexParser;
import java.util.function.Function;

/**
 * @author Ray
 * @data 2024/8/21 18:49
 * @description: 编解码器建造方法
 */
public interface CodexWrapper<T> {

    default CodexWrapper<T> addWrapper(Function<T,String> func, Class<? extends CodexParser> parser) {return null;};

    CodexWrapper<T> setType(Class<T> clazz);
}

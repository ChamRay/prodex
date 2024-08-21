package priv.ray.build;

import priv.ray.parse.parser.CodexParser;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Ray
 * @data 2024/8/21 18:49
 * @description: 编解码器建造方法
 */
public interface CodexWrapper {

    CodexWrapper addLast(Function function);

    CodexWrapper setParser(CodexParser parser);
}

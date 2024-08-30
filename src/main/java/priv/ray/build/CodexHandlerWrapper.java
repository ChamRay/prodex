package priv.ray.build;

import lombok.NoArgsConstructor;
import priv.ray.parse.parser.CodexParser;

import java.util.LinkedList;
import java.util.function.Function;

/**
 * @author Ray
 * @data 2024/8/21 18:51
 * @description: 编解码包装器
 */
@NoArgsConstructor
public class CodexHandlerWrapper implements CodexWrapper {
    private Object object;
    private LinkedList<Function> fieldsList = new LinkedList<>();
    private CodexParser parser;

    @Override
    public CodexWrapper addLast(Function function){
        Object field = function.apply(object);

        this.fieldsList.push(function);
        return this;
    }

    @Override
    public CodexWrapper setParser(CodexParser parser){
        if (this.parser !=null) {
            throw new RuntimeException("parser is already set");
        }
        this.parser = parser;
        return this;
    }




}

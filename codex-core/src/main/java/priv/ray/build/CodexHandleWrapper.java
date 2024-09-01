package priv.ray.build;

import lombok.NoArgsConstructor;
import priv.ray.parse.parser.CodexParser;
import priv.ray.wrapper.WeakFieldWrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Ray
 * @data 2024/8/21 18:51
 * @description: 编解码包装器
 */
@NoArgsConstructor
public class CodexHandleWrapper<T> implements CodexWrapper<T> {
    private Class<T> clazz;
    private List<WeakFieldWrapper<T>> fieldsList = new LinkedList<>();

    @Override
    public CodexWrapper<T> addWrapper(Function<T,String> func, Class<? extends CodexParser> parser){
        this.fieldsList.add(new WeakFieldWrapper<>(func,parser));
        return this;
    }

    @Override
    public CodexWrapper<T> setType(Class<T> clazz){
        this.clazz = clazz;
        return this;
    }




}

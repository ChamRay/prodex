package priv.ray.support;

import java.util.function.Function;

/**
 * 属性字段的函数式接口
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface PFunction<T,R> extends Function<T,R> {
}

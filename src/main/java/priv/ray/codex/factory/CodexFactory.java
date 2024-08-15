package priv.ray.codex.factory;

import priv.ray.codex.coding.Coding;
import priv.ray.codex.enums.CodexEnum;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ray
 * @data 2024/8/8 22:26
 * @description: 用于创建编解码器的工厂
 */
public class CodexFactory {


    private static Map<CodexEnum, ? extends Coding> codexMap;

    // 获取Coding接口的所有子类，反射获取子实现类，并封装到codexMap中
    static {
        Reflections reflections = new Reflections("com.ray");
        Set<Class<? extends Coding>> subTypesOf = reflections.getSubTypesOf(Coding.class);
        codexMap = subTypesOf.stream().map(clazz -> {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toMap(Coding::getCodexType, a -> a));
    }


    public static Coding getInstance(CodexEnum codexEnum) {
        return codexMap.get(codexEnum);
    }


}

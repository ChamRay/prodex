package priv.ray.codex.factory;

import priv.ray.codex.enums.CodexEnum;
import org.reflections.Reflections;
import priv.ray.codex.parse.CodexParser;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ray
 * @data 2024/8/8 22:26
 * @description: 用于创建编解码器的工厂
 */
public class CodexFactory {


    private static Map<CodexEnum, ? extends CodexParser> codexMap;

    // 获取Coding接口的所有子类，反射获取子实现类，并封装到codexMap中
    static {
        // todo 替换成可配置路径
        Reflections reflections = new Reflections("com.ray");
        Set<Class<? extends CodexParser>> subTypesOf = reflections.getSubTypesOf(CodexParser.class);
        codexMap = subTypesOf.stream().map(clazz -> {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toMap(CodexParser::getCodexType, a -> a));
    }


    public static <E extends CodexParser> E getInstance(CodexEnum codexEnum) {
        return (E)codexMap.get(codexEnum);
    }


}

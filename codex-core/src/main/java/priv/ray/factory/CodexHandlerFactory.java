package priv.ray.factory;


import lombok.extern.slf4j.Slf4j;
import priv.ray.parse.enums.CodexEnum;
import priv.ray.parse.parser.CodexParser;
import priv.ray.util.ReflectionUtils;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ray
 * @data 2024/8/8 22:26
 * @description: 用于创建编解码器的工厂
 */
@Slf4j
public class CodexHandlerFactory {


    private static Map<CodexEnum, ? extends CodexParser> codexMap;


    // 获取Coding接口的所有子类，反射获取子实现类，并封装到codexMap中
    static {
        Set<Class<? extends CodexParser>> subTypesOf = ReflectionUtils.getSubClassesWithPackages(CodexParser.class,"priv.ray.codex.parse");
        codexMap = subTypesOf.stream().map(clazz -> {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                log.error("创建对象失败：{}",clazz.getName());
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toMap(CodexParser::getCodexType, a -> a));
        log.debug("缓存中的对象有：{}个",codexMap.size());
    }


    public static <E extends CodexParser> E getInstance(CodexEnum codexEnum) {
        return (E)codexMap.get(codexEnum);
    }


}

package priv.ray.util;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

/**
 * @author Ray
 * @data 2024/8/21 10:35
 * @description: 反射工具类
 */
public class ReflectionUtils {



    public static <E> Set<Class<? extends E>> getSubClassesWithPackages(Class<E> clazz,String... packages){
        // todo 对包名的格式做校验
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages(packages)
                .addScanners(new SubTypesScanner()));
        return reflections.getSubTypesOf(clazz);
    }
}

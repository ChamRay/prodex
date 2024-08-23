package priv.ray.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Ray
 * @data 2024/8/21 10:44
 * @description: 自定义解析器的包扫描器 要结合spring包扫描一起使用
 */
@Inherited
@Retention(RetentionPolicy.CLASS)

public @interface ParserScanner {

    // 扫描的包名
    String packageName() default "";
    // 扫描的包名列表
    String[] packages() default {};
    // 描述
    String desc() default "";

}

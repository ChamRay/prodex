package priv.ray.codex;

import priv.ray.parse.parser.CodexParser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Codex {


    /**
     * 协议帧的字节长度
     * @return
     */
    int length() default 0;

    /**
     * 报文中结束的位
     */
    int endPos();


    /**
     * 解析器 自定义解析规则，有值则覆盖CodeEnum的指定规则
     * 解析器要是 org.jeecg.codex.CodexParser 的子实现类
     * @return
     */
    Class<? extends CodexParser> codexParser() ;



    /**
     * 描述 描述字段含义
     */
    String desc() default "";

    /**
     * 是否必须
     */
    boolean necessary() default true;






}

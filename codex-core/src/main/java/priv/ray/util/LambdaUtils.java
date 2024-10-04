package priv.ray.util;

import priv.ray.support.PFunction;

import javax.management.ReflectionException;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author Ray
 * @data 2024/8/21 21:25
 * @description: lambda解析工具类
 */
public class LambdaUtils {


    public static  <T> T extra(PFunction<T,?> fieldFunc) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ReflectionException {
        Method method = fieldFunc.getClass().getDeclaredMethod("writeReplace");
        method.setAccessible(true);
        SerializedLambda serializedLambda = (SerializedLambda) method.invoke(fieldFunc);
        return (T)methodToProperty(serializedLambda.getImplMethodName());
    }



    public static String methodToProperty(String methodName) throws ReflectionException {
        if (methodName.startsWith("is")){
            methodName = methodName.substring(2);
        }else {
            if (methodName.startsWith("get")||methodName.startsWith("set")){
                methodName = methodName.substring(3);
            }else {
                throw new ReflectionException(new Exception("转换方法名"+methodName+"为字段名异常，方法名错误！"));
            }
        }
        return methodName;
    }

}

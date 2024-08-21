package priv.ray;

import org.junit.jupiter.api.Test;
import priv.entity.ChargeSerial;
import priv.ray.build.CodexWrapper;
import priv.ray.build.CodexWrapperHandler;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author Ray
 * @data 2024/8/21 18:59
 * @description: 编解码建造器测试类
 */
public class CodexWrapperTest {

    @Test
    public void test() {
        CodexWrapper wrapperHandler = new CodexWrapperHandler();
        wrapperHandler.addLast(ChargeSerial::getStatus)

    }
}

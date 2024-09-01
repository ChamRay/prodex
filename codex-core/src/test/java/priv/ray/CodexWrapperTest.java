package priv.ray;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import priv.ray.build.CodexWrapper;
import priv.ray.build.CodexHandleWrapper;
import priv.ray.entity.ChargeSerial;
import priv.ray.parse.parser.BcdParser;
import priv.ray.parse.parser.BinByteParser;

/**
 * @author Ray
 * @data 2024/8/21 18:59
 * @description: 编解码建造器测试类
 */
@Slf4j
public class CodexWrapperTest {


    @Test
    public void test() {
        CodexWrapper<ChargeSerial> wrapperHandler = new CodexHandleWrapper<>();
        wrapperHandler.setType(ChargeSerial.class)
                .addWrapper(ChargeSerial::getSerial, BcdParser.class)
                .addWrapper(ChargeSerial::getStatus, BinByteParser.class);
        log.info("保存的信息为：{}!",wrapperHandler);
    }
}

package org.ray;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ray.build.CodexWrapper;
import org.ray.build.CodexHandleWrapper;
import org.ray.entity.ChargeSerial;
import org.ray.parse.parser.BcdParser;
import org.ray.parse.parser.BinByteParser;

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

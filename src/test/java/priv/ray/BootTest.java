package priv.ray;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import priv.ray.parse.enums.CodexEnum;
import priv.ray.factory.CodexFactory;
import priv.ray.parse.parser.CodexParser;

/**
 * @author Ray
 * @data 2024/8/15 21:05
 * @description: 启动测试类
 */

@Slf4j
public class BootTest {


    @Test
    public  void test() {
        Byte b = 2;
        CodexParser<Byte> parser = CodexFactory.getInstance(CodexEnum.BYTE);
        log.info("{}",parser.hashCode());
        byte[] encode = parser.encode(b);
        Byte decode = parser.decode(encode);

    }
}

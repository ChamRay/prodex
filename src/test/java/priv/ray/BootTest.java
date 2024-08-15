package priv.ray;

import priv.ray.codex.enums.CodexEnum;
import priv.ray.codex.factory.CodexFactory;
import priv.ray.codex.parse.CodexParser;

/**
 * @author Ray
 * @data 2024/8/15 21:05
 * @description: 启动测试类
 */


public class BootTest {

    public static void main(String[] args) {
        Byte b = 2;
        CodexParser<Byte> parser = CodexFactory.getInstance(CodexEnum.BYTE);
        byte[] encode = parser.encode(b);
        Byte decode = parser.decode(encode);


    }
}

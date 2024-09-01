package priv.ray.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import priv.ray.parse.parser.CodexParser;

/**
 * @author Ray
 * @data 2024/9/1 17:13
 * @description: 测试实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ChargeSerial{

    private String status;
    private String serial;
}

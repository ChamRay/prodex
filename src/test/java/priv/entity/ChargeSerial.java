package priv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Ray
 * @data 2024/8/21 20:39
 * @description: 实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ChargeSerial {

    private Integer status;
    private String chargeSerial;


}

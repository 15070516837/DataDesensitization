package com.example.masking.entity;

import com.example.masking.enums.DataMaskingFuncEnum;
import com.example.masking.service.DataMasking;
import lombok.Data;

/**
 * @ProjectName: demo1
 * @Package: com.example.demo1.entity
 * @ClassName: User
 * @Author: json
 * @Description:
 * @Date: 2022/9/28 16:11
 * @Version: 1.0
 */
@Data
public class User {

    private Integer age;

    @DataMasking(maskFunc = DataMaskingFuncEnum.NO_MASK)
    private String name;
}

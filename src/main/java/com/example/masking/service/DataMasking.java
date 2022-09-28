package com.example.masking.service;

import com.example.masking.enums.DataMaskingFuncEnum;

import java.lang.annotation.*;

/**
 * @ProjectName: demo1
 * @Package: com.example.demo1.enums
 * @ClassName: DataMasking
 * @Author: json
 * @Description:
 * @Date: 2022/9/28 15:47
 * @Version: 1.0
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {

    DataMaskingFuncEnum maskFunc() default DataMaskingFuncEnum.NO_MASK;

}

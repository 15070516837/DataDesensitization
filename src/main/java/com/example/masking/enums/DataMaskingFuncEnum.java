package com.example.masking.enums;

import com.example.masking.service.DataMaskingOperation;
import org.springframework.util.StringUtils;

/**
 * @ProjectName: demo1
 * @Package: com.example.demo1.enums
 * @ClassName: DataMaskingFunc
 * @Author: json
 * @Description:
 * @Date: 2022/9/28 15:50
 * @Version: 1.0
 */
public enum DataMaskingFuncEnum {
    //使用&加密
    NO_MASK((v1, v2) -> {
        if (StringUtils.hasLength(v1)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < v1.length(); i++) {
                sb.append(!StringUtils.hasLength(v1) ? v1 : "&");
            }
            return sb.toString();
        } else {
            return v1;
        }
    }),

    //使用*加密
    ALL_MASK((v1, v2) -> {
        if (StringUtils.hasLength(v1)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < v1.length(); i++) {
                sb.append(!StringUtils.hasLength(v1) ? v1 : "*");
            }
            return sb.toString();
        } else {
            return v1;
        }
    });

    /**
     * 加密策略
     */
    private final DataMaskingOperation operation;

    DataMaskingFuncEnum(DataMaskingOperation operation) {
        this.operation = operation;
    }

    public DataMaskingOperation getOperation() {
        return this.operation;
    }
}

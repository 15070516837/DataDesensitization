package com.example.masking.service;

/**
 * @ProjectName: demo1
 * @Package: com.example.demo1.service
 * @ClassName: DataMaskingOperation
 * @Author: json
 * @Description:
 * @Date: 2022/9/28 15:49
 * @Version: 1.0
 */
public interface DataMaskingOperation {

    String MASK_CHAR = "*";

    /**
     * 加密策略
     *
     * @param content
     * @param maskChar
     * @return
     */
    String mask(String content, String maskChar);

}

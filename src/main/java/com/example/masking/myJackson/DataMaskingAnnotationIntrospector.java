package com.example.masking.myJackson;

import com.example.masking.service.DataMasking;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;

/**
 * @ProjectName: demo1
 * @Package: com.example.demo1
 * @ClassName: DataMaskingAnnotationIntrospector
 * @Author: json
 * @Description:
 * @Date: 2022/9/28 16:03
 * @Version: 1.0
 */
public class DataMaskingAnnotationIntrospector extends NopAnnotationIntrospector {

    @Override
    public Object findSerializer(Annotated am) {
        DataMasking annotation = am.getAnnotation(DataMasking.class);
        if (annotation != null) {
            return new DataMaskingSerializer(annotation.maskFunc().getOperation());
        }
        return null;
    }
}

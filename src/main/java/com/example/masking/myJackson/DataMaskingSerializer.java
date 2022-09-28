package com.example.masking.myJackson;

import com.example.masking.enums.DataMaskingFuncEnum;
import com.example.masking.service.DataMaskingOperation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @ProjectName: demo1
 * @Package: com.example.demo1.mySerializer
 * @ClassName: DataMaskingSerializer
 * @Author: json
 * @Description:
 * @Date: 2022/9/28 15:56
 * @Version: 1.0
 */
public class DataMaskingSerializer extends StdScalarSerializer<Object> {

    private final DataMaskingOperation operation;

    public DataMaskingSerializer(DataMaskingOperation operation) {
        super(String.class, false);
        this.operation = operation;
    }

    @Override
    public boolean isEmpty(SerializerProvider prov, Object value) {
        String str = (String) value;
        return str.isEmpty();
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if (Objects.isNull(operation)) {
            String content = DataMaskingFuncEnum.ALL_MASK.getOperation().mask((String) value, null);
            gen.writeString(content);
        } else {
            String content = operation.mask((String) value, null);
            gen.writeString(content);
        }
    }

    @Override
    public final void serializeWithType(Object value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
        this.serialize(value, gen, provider);
    }

    @Override
    public JsonNode getSchema(SerializerProvider provider, Type typeHint) throws JsonMappingException {
        return this.createSchemaNode("string", true);
    }

    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
        super.acceptJsonFormatVisitor(visitor, typeHint);
    }
}

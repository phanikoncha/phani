package com.amex.sms.school.config;

import com.amex.sms.school.student.entity.Student;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

/**
 * @author Mayukha
 * Created on 28 Nov, 2023
 * @project school
 */
@Component
public class StudentSerializer extends JsonSerializer<Student> {


    @Override
    public void serialize(Student student, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        if(CollectionUtils.isEmpty(student.getFields())) {
            jsonGenerator.writeNumberField("id", student.getId());
            jsonGenerator.writeStringField("name", student.getName());
            jsonGenerator.writeStringField("email", student.getEmail());

        } else{
            for (String field : student.getFields()){
                    switch(field){
                        case "id":
                            jsonGenerator.writeNumberField("id", student.getId());
                            break;
                        case "name":
                            jsonGenerator.writeStringField("name", student.getName());
                            break;
                        case "email" :
                            jsonGenerator.writeStringField("email", student.getEmail());
                            break;
                }
            }
        }

        jsonGenerator.writeEndObject();

    }
}

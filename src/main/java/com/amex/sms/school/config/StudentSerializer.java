package com.amex.sms.school.config;

import com.amex.sms.school.student.entity.Student;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;

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
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        if(CollectionUtils.isEmpty(student.getFields())) {
            jsonGenerator.writeNumberField("id", student.getId());
            jsonGenerator.writeStringField("fname", student.getFname());
            jsonGenerator.writeStringField("mname", student.getMname());
            jsonGenerator.writeStringField("lname", student.getLname());
            jsonGenerator.writeNumberField("grade", student.getGrade());
            try {
                jsonGenerator.writeStringField("doj",simpleDateFormat.format(student.getDoj()));
            } catch (Exception e) {
                jsonGenerator.writeStringField("doj",null);
            }
            try {
                jsonGenerator.writeStringField("dob",simpleDateFormat.format(student.getDob()));
            } catch (Exception e) {
                jsonGenerator.writeStringField("dob",null);
            }
            jsonGenerator.writeStringField("email", student.getEmail());
            jsonGenerator.writeStringField("phone", student.getPhone());
        } else{
            for (String field : student.getFields()){
                    switch(field){
                        case "id":
                            jsonGenerator.writeNumberField("id", student.getId());
                            break;
                        case "fname":
                            jsonGenerator.writeStringField("fname", student.getFname());
                            break;
                        case "mname" :
                            jsonGenerator.writeStringField("mname", student.getMname());
                            break;
                        case "lname":
                            jsonGenerator.writeStringField("lname", student.getLname());
                            break;
                        case "grade":
                            jsonGenerator.writeNumberField("grade", student.getGrade());
                            break;
                        case "dob" :
                            try {
                                jsonGenerator.writeStringField("dob",simpleDateFormat.format(student.getDob()));
                            } catch (Exception e) {
                                jsonGenerator.writeStringField("dob",null);
                            }
                            break;
                        case "doj" :
                            try {
                                jsonGenerator.writeStringField("doj",simpleDateFormat.format(student.getDoj()));
                            } catch (Exception e) {
                                jsonGenerator.writeStringField("doj",null);
                            }
                            break;
                        case "email" :
                            jsonGenerator.writeStringField("email", student.getEmail());
                            break;
                        case "phone":
                            jsonGenerator.writeStringField("phone", student.getPhone());
                            break;
                }
            }
        }

        jsonGenerator.writeEndObject();

    }
}

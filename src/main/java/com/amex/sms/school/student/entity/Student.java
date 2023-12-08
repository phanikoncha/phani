package com.amex.sms.school.student.entity;

import com.amex.sms.school.config.StudentSerializer;
import com.amex.sms.school.validators.AmexEmail;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student")
@Schema (description = "All details about the student")

@JsonSerialize(using = StudentSerializer.class)
public class Student {

    @Id
    @Column(name="sid")
    @Schema(name= "id",  description = "ID of the student which is unique", example = "0")
    private int id;

    @Column(name="sname")
    @NotBlank(message = "Student name is required")
    @Schema(name ="name", description = "Full name of the student with max of 255 characters", example = "sateesh gullipalli")
    @JacksonXmlProperty(localName = "studentName")
    private String name;


    @Column(name="email")
    @Email(message = "Email format is not valid")
    @AmexEmail(message = "Email id should end with @axp.com" )
    @Schema(name = "email", description = "Email id of the student with max of 255 characters and should end with @aexp.com", example = "sateesh.gullipalli@aexp.com")
    private String email;

    @Transient
    private List<String> fields;

}

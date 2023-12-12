package com.amex.sms.school.teacher.entity;

import com.amex.sms.school.validators.AmexEmail;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "teacher")

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tid")
    @Schema(name= "id",  description = "ID of the student which is unique", example = "0")
    private int Id;

    @Column(name="fname")
    @NotBlank(message = "Student first name is required")
    @Schema(name ="first name", description = "First name of the student with max of 255 characters", example = "phani")
    @JacksonXmlProperty(localName = "studentName")
    private String fname;

    @Column(name="mname")
    @Schema(name ="middle name", description = "Middle name of the student with max of 255 characters", example = "phani")
    @JacksonXmlProperty(localName = "studentName")
    private String mname;

    @Column(name="lname")
    @NotBlank(message = "Student last name is required")
    @Schema(name ="last name", description = "Last name of the student with max of 255 characters", example = "phani")
    @JacksonXmlProperty(localName = "studentName")
    private String lname;


    @Column(name="email")
    @Email(message = "Email format is not valid")
   // @AmexEmail(message = "Email id should end with @axp.com" )
    @Schema(name = "email", description = "Email id of the student with max of 255 characters and should end with @aexp.com", example = "sateesh.gullipalli@aexp.com")
    private String email;

    @Column(name = "dob")
    //@NotBlank(message = "date of birth is required")
    private Date dob;

    @Column(name = "doj")
    //@NotBlank(message = "date of joining is required")
    private Date doj;

    @Min(value = 1)
    @Max(value = 10)
    @Column(name = "grade")
    private int grade;

    @Column(name = "phone")
    private String phone;

    @Column(name="subject")
    private String subject;

    @Transient
    private List<String> fields;

    @Transient
    // @NotBlank(message = "DOB shouldn't be blank")
    private String dobStr;

    @Transient
    // @NotBlank(message = "DOJ shouldn't be blank")
    private String dojStr;



}

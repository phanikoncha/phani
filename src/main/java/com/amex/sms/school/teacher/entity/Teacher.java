package com.amex.sms.school.teacher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "teacher")

public class Teacher {

    @Id
    @Column(name="tid")
    private int Id;

    @Column(name="name")
    @NotBlank(message = "Teacher name is required")
    @Size( max = 15, message = "Teacher name should not be more than 15 Characters")
    private String Name;

    @Column(name="mail")
    @NotBlank(message = "Email id is required")
    @Email(message = "Email format is not valid")
    @Size( max = 25, message = "Teacher email-id should not be more than 15 Characters")
    private String mail;

    @Column(name="subject")
    private String subject;

}

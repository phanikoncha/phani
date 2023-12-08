package com.amex.sms.school.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


import java.io.Serializable;

/**
 * $table.getTableComment()
 */
/**@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Empid", nullable = false)
    private Long eid;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String mail;

    @Column(name = "ActiveFlag")
    private boolean ActiveFlag;

    @Column(name = "dob")
    private  date;

    @Column(name = "Email")
    private String mail;

}
*/
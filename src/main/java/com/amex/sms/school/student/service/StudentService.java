package com.amex.sms.school.student.service;

import com.amex.sms.school.employee.service.BaseService;
import com.amex.sms.school.model.PaginatedResponse;
import com.amex.sms.school.student.entity.Student;

import java.util.List;

/**
 * @author Mayukha
 * Created on 13 Nov, 2023
 * @project school
 */
public interface StudentService extends BaseService <Student> {

    Student create(Student t);
    Student update(int id,Student t);
    Student get(int id);
    List<Student> getAll();
    void delete(int id);
    PaginatedResponse<Student> getStudentPagination(Integer pageNumber, Integer pageSize, String sort, String email);

    List<Student> search(String email, String sortFieldName, String sortOrder);
}


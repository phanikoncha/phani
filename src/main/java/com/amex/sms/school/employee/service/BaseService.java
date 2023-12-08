package com.amex.sms.school.employee.service;

import com.amex.sms.school.model.PaginatedResponse;
import com.amex.sms.school.student.entity.Student;

import java.util.List;

/**
 * @author Mayukha
 * Created on 13 Nov, 2023
 * @project school
 */
public interface BaseService <T>{

    T create(T t);
    T update(int id,T t);
    T get(int id);
    List<T> getAll();
    void delete(int id);

   // PaginatedResponse<T> getStudentPagination(Integer pageNumber, Integer pageSize, String sort, String email);
}

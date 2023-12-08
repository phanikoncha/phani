package com.amex.sms.school.rest;

import com.amex.sms.school.student.entity.Student;
import com.amex.sms.school.student.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author Mayukha
 * Created on 09 Nov, 2023
 * @project school
 */
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    StudentServiceImpl studentService;

    @InjectMocks
    StudentController studentController;



    @Test
    void getAllP() {

    }



    @Test
    void getAll() {
        List<Student> list= new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            list.add(new Student(i,"name"+i,"email"+i+"@aexp.com",null));
        }
        when(studentService.getAll()).thenReturn(list);
        List<Student> response = studentController.getAll(null);
        assertEquals(list,response);
    }

    @Test
    void search() {
    }

    @Test
    void get() {
    }

    @Test
    void create() {
        Student student= new Student(101,"Sai","Sai@aexp.com", null);
        when(studentService.create(student)).thenReturn(student);
        Student response = studentController.create(student, null).getBody();
        assertEquals(student,response);

    }

    /*@Test
    /*void update(int id) {
        Student student= new Student(105,"Sai5","Sai5@aexp.com");
        when(studentService.create(student)).thenReturn(student);
        Student response = studentController.update(int id, Student student);
        assertEquals(student,response);
    }
    //public Student update(int id, Student student) {
    //       student.setId(id);
    //       if(studentRepository.existsById(id)) {
    //           return studentRepository.save(student);
    //       }
    //        throw new NotFoundException("Student with  ID : "+id +"is not found");
    //    }

    @Test
    void delete() {
    }*/


}

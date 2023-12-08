package com.amex.sms.school.teacher.service;

import com.amex.sms.school.exceptions.NotFoundException;
import com.amex.sms.school.student.entity.Student;
import com.amex.sms.school.teacher.entity.Teacher;
import com.amex.sms.school.teacher.repo.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    static Logger logger= LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAll(String email){
        logger.info("This is where Business Logic is present");
        return teacherRepository.findAll();
    }

    public Teacher get(int id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(teacher.isPresent()){
            return teacher.get();
        }
        throw new NotFoundException("Teacher with id "+id+" is not found");
    }

    public Teacher create(Teacher teacher){
        if(!teacherRepository.existsById(teacher.getId())) {
            return teacherRepository.save(teacher);

        }
        return null;
    }

    public Teacher update(int id, Teacher teacher) {
       teacher.setId(id);
       if(teacherRepository.existsById(id)) {
           return teacherRepository.save(teacher);
       }
        throw new NotFoundException("Teacher with  ID : "+id +"is not found");
    }


    public void Delete(int id) {
        if(teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
        }
        throw new NotFoundException("Teacher with  ID : "+id +"is not found");
    }


}

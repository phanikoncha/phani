package com.amex.sms.school.student.service;

import com.amex.sms.school.employee.service.BaseService;
import com.amex.sms.school.exceptions.NotFoundException;
import com.amex.sms.school.exceptions.RecordAlreadyExistException;
import com.amex.sms.school.model.PaginatedResponse;
import com.amex.sms.school.student.entity.Student;
import com.amex.sms.school.student.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    static Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentRepository studentRepository;



    public List<Student> search(String email, String sortFieldName, String sortOrder){
        logger.info("This is where Business Logic is present");
        if(StringUtils.hasLength(email)){
            if(email.contains(",")){
                return studentRepository.findByEmailIn(Arrays.asList(email.split(",")));
            }
            return studentRepository.findByEmailIgnoreCase(email);
        }
        if("ASC".equalsIgnoreCase(sortOrder)){
            switch(sortFieldName.toLowerCase()){

                case "email" :
                    return studentRepository.findAllByOrderByEmailAsc();
                case "name" :
                    return studentRepository.findAllByOrderByNameAsc();
                default:
                    return studentRepository.findAllByOrderByIdAsc();
            }
        } else{
            switch(sortFieldName.toLowerCase()) {

                case "email":
                    return studentRepository.findAllByOrderByEmailDesc();
                case "name":
                    return studentRepository.findAllByOrderByNameDesc();
                default:
                    return studentRepository.findAllByOrderByIdDesc();
            }
        }

    }


    @Override
    public Student get(int id){
        Optional <Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        throw new NotFoundException("Student with  ID : "+id +"is not found");
    }


    @Override
    public Student create(Student student){
        if(!studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);

        }
        throw new RecordAlreadyExistException("Record with id Already Exist");
    }

    public Student update(int id, Student student) {
       student.setId(id);
       if(studentRepository.existsById(id)) {
           return studentRepository.save(student);
       }
        throw new NotFoundException("Student with  ID : "+id +"is not found");
    }


    public void delete(int id) {
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ;
        }
        throw new NotFoundException("Student with  ID : "+id +"is not found");
    }

    public PaginatedResponse<Student> getStudentPagination(Integer pageNumber, Integer pageSize, String sort, String email) {
        Pageable pageable = null;
        if (sort != null) {
            // with sorting
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sort);
        } else {
            // without sorting
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        Page<Student> result = studentRepository.findAll(pageable);
        PaginatedResponse<Student> response = new PaginatedResponse<>();
        response.setContent(result.getContent());
        response.setLast(result.isLast());
        response.setPageNo(result.getNumber());
        response.setPageSize(result.getSize());
        response.setTotalElements(result.getTotalElements());
        response.setTotalPages(result.getTotalPages());
        return response;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}

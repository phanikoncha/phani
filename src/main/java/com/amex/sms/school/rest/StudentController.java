package com.amex.sms.school.rest;

import java.util.List;

import com.amex.sms.school.SchoolApplication;
import com.amex.sms.school.model.AppError;
import com.amex.sms.school.model.PaginatedResponse;
import com.amex.sms.school.student.entity.Student;
import com.amex.sms.school.student.service.StudentService;
import com.amex.sms.school.student.service.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class StudentController {

    static Logger logger= LoggerFactory.getLogger(SchoolApplication.class);

    @Autowired
    Environment environment;

    @Autowired
    StudentService studentService;

    @Operation(summary = "Get Students list in Paginated way")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Server Error", content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AppError.class))})
    })

    @GetMapping(value = "/students_with_paginated", produces = "application/json")
    public PaginatedResponse<Student> getAllP(@RequestParam(value = "email", required = false) String email,
                                              @RequestParam(value="pageNumber",required = false, defaultValue = "1") Integer pageNumber,
                                              @RequestParam(value="pageSize", required = false, defaultValue = "10") Integer pageSize,
                                              @RequestParam(value="sort", required = false, defaultValue = "id") String sort){
        logger.info("GET All Request received");
        if(pageNumber > 0){
            pageNumber = pageNumber - 1;
        }

        return studentService.getStudentPagination(pageNumber, pageSize, sort, email);
    }

    @GetMapping("/students")
    public List<Student> getAll(@RequestParam(value="fields",required=false) List<String>fields){
        logger.info("GET All Request received->"+fields);
        List<Student> students = studentService.getAll();
        students.forEach(student-> student.setFields(fields));

        return students;
    }

    @GetMapping("/student_search")
    public List<Student> search(@RequestParam(value = "email", required = false) String email, @RequestParam(value = "sortFieldName", required = false, defaultValue = "id") String sortFieldName ,@RequestParam(value = "sortOrder", required = false, defaultValue = "ASC") String sortOrder ){
        logger.info("GET One Request received");
        return studentService.search(email, sortFieldName , sortOrder);
    }

    @Operation(summary = "Get One Student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Student Not found", content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AppError.class))}),
            @ApiResponse(responseCode = "500", description = "Server Error", content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AppError.class))})
    })

    @GetMapping(value = "/students/{id}", produces = "application/json")
        public Student get(@PathVariable("id") int id){
        logger.info("GET request received for id "+id);
        return studentService.get(id);

    }

    @Operation(summary = "Create Student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created Student"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AppError.class))}),
            @ApiResponse(responseCode = "500", description = "Server Error", content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AppError.class))}),
            @ApiResponse(responseCode = "409", description = "Conflict/Student with ID Already Exists", content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = AppError.class))})
    })


    @PostMapping(value = "/students", produces = "application/json")
    //@ResponseStatus(value = HttpStatus.CREATED)
        public ResponseEntity<Student> create(@RequestBody @Valid Student student, HttpServletResponse httpServletResponse){
        logger.info("CREATE request received");
        logger.info(student.toString());
        //httpServletResponse.setStatus(201);
        return new ResponseEntity<>(studentService.create(student),HttpStatus.CREATED);
        //return studentService.create(student);
    }

   // @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/students/{id}")
    public Student update(@PathVariable("id") int id, @RequestBody Student student){
        logger.info("UPDATE request received for id "+id);
        logger.info(student.toString());
        return studentService.update(id, student);
    }

    @Operation(summary = "Delete a Student Record")
    //@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(value = "/students/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") int id){
        logger.info("DELETE request received for id "+id);
        studentService.delete(id);
        return "{\"Code \"\" \"200\", \"message\" : \"Student is deleted Successfully\"}";
    }

}

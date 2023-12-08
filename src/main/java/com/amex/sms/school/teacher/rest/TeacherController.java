package com.amex.sms.school.teacher.rest;

import com.amex.sms.school.SchoolApplication;
import com.amex.sms.school.teacher.entity.Teacher;
import com.amex.sms.school.teacher.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**@author Srujana Ponnuru
 *
 */
@RestController

public class TeacherController {

    static Logger logger= LoggerFactory.getLogger(SchoolApplication.class);

    @Autowired
    Environment environment;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers")
    public List<Teacher> getAll(@RequestParam(value = "mail", required = false) String mail){
        logger.info("GET All Request received");
        return teacherService.getAll(mail);
    }

    @GetMapping("/teachers/{id}")
    public Teacher get(@PathVariable("id") int id){
        logger.info("GET request received for id "+id);
        return teacherService.get(id);
    }

    @PostMapping("/teachers")
    public Teacher create(@RequestBody Teacher teacher){
        logger.info("CREATE request received");
        logger.info(teacher.toString());
        return teacherService.create(teacher);
    }

    @PutMapping("/teachers/{id}")
    public Teacher update(@PathVariable("id") int id, @RequestBody Teacher teacher){
        logger.info("UPDATE request received for id "+id);
        logger.info(teacher.toString());
        return teacherService.update(id, teacher);
    }

    @DeleteMapping("/teachers/{id}")
    public void delete(@PathVariable("id") int id){
        logger.info("DELETE request received for id "+id);
        teacherService.Delete(id);
    }

}

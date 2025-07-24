package com.synergystudy.synergystudy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergystudy.synergystudy.dtos.requests.AddNewAdminRequest;
import com.synergystudy.synergystudy.dtos.requests.DeleteCourseRequest;
import com.synergystudy.synergystudy.dtos.requests.FindInstructorRequest;
import com.synergystudy.synergystudy.dtos.requests.FindStudentRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginAdminRequest;
import com.synergystudy.synergystudy.dtos.requests.RemoveInstructorRequest;
import com.synergystudy.synergystudy.dtos.requests.ValidateInstructorRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewAdminResponse;
import com.synergystudy.synergystudy.dtos.response.DeleteCourseResponse;
import com.synergystudy.synergystudy.dtos.response.FindInstructorResponse;
import com.synergystudy.synergystudy.dtos.response.FindStudentResponse;
import com.synergystudy.synergystudy.dtos.response.LoginAdminResponse;
import com.synergystudy.synergystudy.dtos.response.RemoveInstructorResponse;
import com.synergystudy.synergystudy.dtos.response.ValidateInstructorResponse;
import com.synergystudy.synergystudy.services.AdminService;
import com.synergystudy.synergystudy.services.AdminServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    AdminServiceImpl adminServiceImpl;

    @PostMapping("register/admin/")
    public ResponseEntity<?> adminRegistration(@RequestBody AddNewAdminRequest request) {
        try{
            AddNewAdminResponse response = adminService.registerAdmin(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("login/admin/")
    public ResponseEntity<?> adminLogin(@RequestBody LoginAdminRequest request) {
        try{
            LoginAdminResponse response = adminService.loginAdmin(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

     @DeleteMapping("remove/instructor/")
    public ResponseEntity<?> removeAnyInstructor(@RequestBody RemoveInstructorRequest request) {
        try{
            RemoveInstructorResponse response = adminServiceImpl.removeInstructor(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("find/instructor/")
    public ResponseEntity<?> findAnyInstructor(@RequestBody FindInstructorRequest request) {
        try{
            FindInstructorResponse response = adminServiceImpl.findInstructor(request);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

     @GetMapping("find/student/")
    public ResponseEntity<?> findAnyStudent(@RequestBody FindStudentRequest request) {
        try{
            FindStudentResponse response = adminServiceImpl.findStudent(request);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/course/")
    public ResponseEntity<?> deleteRegisteredCourse(@RequestBody DeleteCourseRequest request) {
        try{
            DeleteCourseResponse response = adminServiceImpl.deleteCourse(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

     @PostMapping("validate/instructor/")
    public ResponseEntity<?> validateAvailableCourses(@RequestBody ValidateInstructorRequest request) {
        try{
            ValidateInstructorResponse response = adminServiceImpl.validateInstructor(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

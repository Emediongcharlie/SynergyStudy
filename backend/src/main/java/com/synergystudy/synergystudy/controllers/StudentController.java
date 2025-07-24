package com.synergystudy.synergystudy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergystudy.synergystudy.dtos.requests.AddNewStudentRequest;
import com.synergystudy.synergystudy.dtos.requests.CancelCourseRequest;
import com.synergystudy.synergystudy.dtos.requests.GetNotifictaionRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginStudentRequest;
import com.synergystudy.synergystudy.dtos.requests.RegisterCourseRequest;
import com.synergystudy.synergystudy.dtos.requests.SearchCourseRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewStudentResponse;
import com.synergystudy.synergystudy.dtos.response.CancelCourseResponse;
import com.synergystudy.synergystudy.dtos.response.GetNotificationResponse;
import com.synergystudy.synergystudy.dtos.response.LoginStudentResponse;
import com.synergystudy.synergystudy.dtos.response.RegisterCourseResponse;
import com.synergystudy.synergystudy.dtos.response.SearchCourseResponse;
import com.synergystudy.synergystudy.services.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("register/student/")
    public ResponseEntity<?> studentRegistration(@RequestBody AddNewStudentRequest request) {
        try{
            AddNewStudentResponse response = studentService.registerStudent(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("login/student/")
    public ResponseEntity<?> sellerLogin(@RequestBody LoginStudentRequest request) {
        try{
            LoginStudentResponse response = studentService.loginStudent(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("student/register-course/")
    public ResponseEntity<?> studentCourseRegistration(@RequestBody RegisterCourseRequest request) {
        try{
            RegisterCourseResponse response = studentService.registerCourse(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("student/cancel-course/")
    public ResponseEntity<?> cancelCourseRegistration(@RequestBody CancelCourseRequest request) {
        try{
            CancelCourseResponse response = studentService.cancelCourse(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> sentNotification(@RequestBody GetNotifictaionRequest getNotificationRequest){
        try{
            GetNotificationResponse response = studentService.getNotification(getNotificationRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> searchForCourseById(@RequestBody SearchCourseRequest searchCourseRequest){
        try{
            SearchCourseResponse response = studentService.searchCourseById(searchCourseRequest);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> searchForCourseByTitle(@RequestBody SearchCourseRequest searchCourseRequest){
         try{
            SearchCourseResponse response = studentService.searchCourseByTitle(searchCourseRequest);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

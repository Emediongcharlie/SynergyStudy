package com.synergystudy.synergystudy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergystudy.synergystudy.dtos.requests.AddNewInstructorRequest;
import com.synergystudy.synergystudy.dtos.requests.CreateCourseRequest;
import com.synergystudy.synergystudy.dtos.requests.DeleteCourseRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginInstructorRequest;
import com.synergystudy.synergystudy.dtos.requests.UpdateCourseRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewInstructorResponse;
import com.synergystudy.synergystudy.dtos.response.CreateCourseResponse;
import com.synergystudy.synergystudy.dtos.response.DeleteCourseResponse;
import com.synergystudy.synergystudy.dtos.response.LoginInstructorResponse;
import com.synergystudy.synergystudy.dtos.response.UpdateCourseResponse;
import com.synergystudy.synergystudy.services.InstructorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class InstructorController {

    @Autowired
    InstructorService instructorService;


    @PostMapping("register/instructor/")
    public ResponseEntity<?> instructorRegistration(@RequestBody AddNewInstructorRequest request) {
        try{
            AddNewInstructorResponse response = instructorService.registerInstructor(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("login/instructor/")
    public ResponseEntity<?> instructorLogin(@RequestBody LoginInstructorRequest request) {
        try{
            LoginInstructorResponse response = instructorService.loginInstructor(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("instructor/create-course/")
    public ResponseEntity<?> createNewCourse(@RequestBody CreateCourseRequest request) {
        try{
            CreateCourseResponse response = instructorService.createCourse(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("instructor/delete-course5/")
    public ResponseEntity<?> deleteAnyCourse(@RequestBody DeleteCourseRequest request) {
        try{
            DeleteCourseResponse response = instructorService.deleteCourse(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("instructor/update-course5/")
    public ResponseEntity<?> updateAvailableCourse(@RequestBody UpdateCourseRequest request) {
        try{
            UpdateCourseResponse response = instructorService.updateCourse(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

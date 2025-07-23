package com.synergystudy.synergystudy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergystudy.synergystudy.dtos.requests.AddNewInstructorRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginInstructorRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewInstructorResponse;
import com.synergystudy.synergystudy.dtos.response.LoginInstructorResponse;
import com.synergystudy.synergystudy.services.InstructorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class InstructorController {

    @Autowired
    InstructorService instructorService;


    @PostMapping("register/instructor/")
    public ResponseEntity<?> adminRegistration(@RequestBody AddNewInstructorRequest request) {
        try{
            AddNewInstructorResponse response = instructorService.registerInstructor(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("login/instructor/")
    public ResponseEntity<?> adminLogin(@RequestBody LoginInstructorRequest request) {
        try{
            LoginInstructorResponse response = instructorService.loginInstructor(request);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

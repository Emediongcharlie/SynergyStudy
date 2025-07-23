package com.synergystudy.synergystudy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synergystudy.synergystudy.dtos.requests.AddNewAdminRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginAdminRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewAdminResponse;
import com.synergystudy.synergystudy.dtos.response.LoginAdminResponse;
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
    AdminServiceImpl AdminServiceImpl;

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

}

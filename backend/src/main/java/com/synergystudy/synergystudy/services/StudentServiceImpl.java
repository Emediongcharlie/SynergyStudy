package com.synergystudy.synergystudy.services;

import org.springframework.stereotype.Service;

import com.synergystudy.synergystudy.dtos.requests.AddNewStudentRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginStudentRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewStudentResponse;
import com.synergystudy.synergystudy.dtos.response.LoginStudentResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Override
    public AddNewStudentResponse registerStudent(AddNewStudentRequest addNewStudentRequest){
        return null;
     }

    @Override
    public LoginStudentResponse loginInstructor(LoginStudentRequest loginStudentRequest){
        return null;
    }

}

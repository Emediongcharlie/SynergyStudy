package com.synergystudy.synergystudy.services;


import com.synergystudy.synergystudy.dtos.requests.AddNewStudentRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginStudentRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewStudentResponse;
import com.synergystudy.synergystudy.dtos.response.LoginStudentResponse;

public interface StudentService {

    AddNewStudentResponse registerStudent(AddNewStudentRequest addNewStudentRequest);
    LoginStudentResponse loginInstructor(LoginStudentRequest loginStudentRequest);

}

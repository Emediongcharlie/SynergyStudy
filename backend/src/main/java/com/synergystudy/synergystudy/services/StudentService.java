package com.synergystudy.synergystudy.services;


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

public interface StudentService {

    AddNewStudentResponse registerStudent(AddNewStudentRequest addNewStudentRequest);
    LoginStudentResponse loginInstructor(LoginStudentRequest loginStudentRequest);
    RegisterCourseResponse registerCourse(RegisterCourseRequest registerCourseRequest);
    CancelCourseResponse cancelCourse(CancelCourseRequest cancelCourseRequest);
    GetNotificationResponse getNotification(GetNotifictaionRequest getNotificationRequest);
    SearchCourseResponse searchCourseById(SearchCourseRequest searchCourseRequest);
    SearchCourseResponse searchCourseByTitle(SearchCourseRequest searchCourseRequest);



}

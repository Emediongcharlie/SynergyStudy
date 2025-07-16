package com.synergystudy.synergystudy.services;

import com.synergystudy.synergystudy.dtos.requests.AddNewInstructorRequest;
import com.synergystudy.synergystudy.dtos.requests.CreateCourseRequest;
import com.synergystudy.synergystudy.dtos.requests.DeleteCourseRequest;
import com.synergystudy.synergystudy.dtos.requests.DiscontinueAStudentRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginInstructorRequest;
import com.synergystudy.synergystudy.dtos.requests.UpdateCourseRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewInstructorResponse;
import com.synergystudy.synergystudy.dtos.response.CreateCourseResponse;
import com.synergystudy.synergystudy.dtos.response.DeleteCourseResponse;
import com.synergystudy.synergystudy.dtos.response.DiscontinueAStudentResponse;
import com.synergystudy.synergystudy.dtos.response.LoginInstructorResponse;
import com.synergystudy.synergystudy.dtos.response.UpdateCourseResponse;

public interface InstructorService {

    AddNewInstructorResponse registerInstructor(AddNewInstructorRequest addNewInstructorRequest);
    LoginInstructorResponse loginInstructor(LoginInstructorRequest loginInstructorRequest);
    CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest);
    DeleteCourseResponse deleteCourse(DeleteCourseRequest deleteCourseRequest);
    DiscontinueAStudentResponse discontinueStudent(DiscontinueAStudentRequest discontinueAStudentRequest);
    UpdateCourseResponse updateCourse(UpdateCourseRequest updateCourseRequest);

}

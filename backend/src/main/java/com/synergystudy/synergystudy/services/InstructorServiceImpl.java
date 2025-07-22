package com.synergystudy.synergystudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synergystudy.synergystudy.data.models.Course;
import com.synergystudy.synergystudy.data.models.Instructor;
import com.synergystudy.synergystudy.data.repositories.CourseRepo;
import com.synergystudy.synergystudy.data.repositories.InstructorRepo;
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


@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    MailService mailService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    Instructor instructor = new Instructor();
    Course course = new Course();

    @Override
    public AddNewInstructorResponse registerInstructor(AddNewInstructorRequest addNewInstructorRequest){
        instructor.setFirstName(addNewInstructorRequest.getFirstName());
        instructor.setLastName(addNewInstructorRequest.getLastName());
        instructor.setEmail(addNewInstructorRequest.getEmail());
        instructor.setPassword(passwordEncoder.encode(addNewInstructorRequest.getPassword()));
        instructor.setCourses(addNewInstructorRequest.getCourse());
        instructorRepo.save(instructor);

        mailService.sendRegistrationEmail(addNewInstructorRequest.getEmail());

        AddNewInstructorResponse response = new AddNewInstructorResponse();
        response.setFirstName(instructor.getFirstName());
        response.setLastName(instructor.getLastName());
        response.setEmail(instructor.getEmail());
        response.setPassword(instructor.getPassword());
        response.setCourse(instructor.getCourses());
        response.setMessage("Successfully registered Instructor with name" + instructor.getFirstName());

        return response;
    }

    @Override
    public LoginInstructorResponse loginInstructor(LoginInstructorRequest loginInstructorRequest) {

    Instructor instructor = instructorRepo.findByEmail(loginInstructorRequest.getEmail())
        .orElseThrow(() -> new RuntimeException("Email not found"));

    if (!instructor.getPassword().equals(loginInstructorRequest.getPassword())) {
        throw new RuntimeException("Incorrect email or password");
    }

    LoginInstructorResponse response = new LoginInstructorResponse();
    response.setFirstName(instructor.getFirstName());
    response.setMessage("Successfully logged in " + instructor.getFirstName());

    return response;
}


    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest){
        
        course.setTitle(createCourseRequest.getCourse().getTitle());
        course.setDescription(createCourseRequest.getCourse().getDescription());
        course.setDuration(createCourseRequest.getCourse().getDuration());
        course.setInstructor(createCourseRequest.getCourse().getInstructor());
        courseRepo.save(course);

        CreateCourseResponse createCourseResponse = new CreateCourseResponse();
        createCourseResponse.setTitle(course.getTitle());
        createCourseResponse.setMessage("Course with title" + course.getTitle() + "created successfully");
        
        return createCourseResponse;
    }

    @Override
    public DeleteCourseResponse deleteCourse(DeleteCourseRequest deleteCourseRequest){

        Course course = courseRepo.findById(deleteCourseRequest.getId())
        .orElseThrow(() -> new RuntimeException("Id not found"));

        courseRepo.delete(course);

        DeleteCourseResponse deleteCourseResponse = new DeleteCourseResponse();
        deleteCourseResponse.setMessage("Course deleted successfuly");

        return deleteCourseResponse;
    }

    @Override
    public DiscontinueAStudentResponse discontinueStudent(DiscontinueAStudentRequest discontinueAStudentRequest){
        return null;
    }

    @Override
    public UpdateCourseResponse updateCourse(UpdateCourseRequest updateCourseRequest){

        Course course = courseRepo.findById(updateCourseRequest.getId())
        .orElseThrow(() -> new RuntimeException("Id not found"));

        course.setTitle(updateCourseRequest.getCourse().getTitle());
        course.setDescription(updateCourseRequest.getCourse().getDescription());
        course.setDuration(updateCourseRequest.getCourse().getDuration());
        course.setInstructor(updateCourseRequest.getCourse().getInstructor());
        courseRepo.save(course);

        UpdateCourseResponse updateCourseResponse = new UpdateCourseResponse();
        updateCourseResponse.setId(course.getId());
        updateCourseResponse.setMessage("Course with title" + course.getTitle() + "updated successfully");
        
        return updateCourseResponse;
    }

}

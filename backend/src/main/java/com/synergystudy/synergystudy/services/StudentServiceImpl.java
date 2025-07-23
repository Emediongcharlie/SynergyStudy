package com.synergystudy.synergystudy.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synergystudy.synergystudy.data.models.Course;

import com.synergystudy.synergystudy.data.models.Student;
import com.synergystudy.synergystudy.data.repositories.CourseRepo;
import com.synergystudy.synergystudy.data.repositories.StudentRepo;
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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    MailService mailService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    Student student = new Student();

    @Override
    public AddNewStudentResponse registerStudent(AddNewStudentRequest addNewStudentRequest){

        student.setFirstName(addNewStudentRequest.getFirstName());
        student.setLastName(addNewStudentRequest.getLastName());
        student.setEmail(addNewStudentRequest.getEmail());
        student.setPhoneNumber(addNewStudentRequest.getPhoneNumber());
        student.setPassword(passwordEncoder.encode(addNewStudentRequest.getPassword()));
        studentRepo.save(student);

        mailService.sendRegistrationEmail(addNewStudentRequest.getEmail());

        AddNewStudentResponse response = new AddNewStudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setPassword(student.getPassword());
        response.setPhoneNumber(student.getPhoneNumber());
        response.setMessage("Successfully registered Instructor with name" + student.getFirstName());

        return response;
     }

    @Override
    public LoginStudentResponse loginStudent(LoginStudentRequest loginStudentRequest){

        findByEmail(loginStudentRequest.getEmail());

    if (!student.getPassword().equals(loginStudentRequest.getPassword())) {
        throw new RuntimeException("Incorrect email or password");
    }

    LoginStudentResponse response = new LoginStudentResponse();
    response.setFirstName(student.getFirstName());
    response.setMessage("Successfully logged in " + student.getFirstName());

    return response;
    }

    public Student findByEmail(String email) {
    return studentRepo.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Student not found"));
    }


    @Override
public RegisterCourseResponse registerCourse(RegisterCourseRequest registerCourseRequest) {
    
    Student student = studentRepo.findByEmail(registerCourseRequest.getEmail())
        .orElseThrow(() -> new RuntimeException("Student not found"));

    Course course = courseRepo.findByTitle(registerCourseRequest.getTitle())
        .orElseThrow(() -> new RuntimeException("Course not found"));

    if (student.getCourses().contains(course)) {
        throw new RuntimeException("Already registered for this course");
    }

    student.getCourses().add(course);
    studentRepo.save(student);

    mailService.sendCourseRegistrationEmail(student.getEmail(), course.getTitle());

    RegisterCourseResponse response = new RegisterCourseResponse();
    response.setId(course.getId());
    response.setMessage("Successfully registered for " + course.getTitle() + " course");
    response.setRegisteredAt(LocalDateTime.now());

    return response;
}


    @Override
    public CancelCourseResponse cancelCourse(CancelCourseRequest cancelCourseRequest) {
    
    Course course = courseRepo.findById(cancelCourseRequest.getId())
        .orElseThrow(() -> new RuntimeException("Course not found"));

    Student student = studentRepo.findByEmail(cancelCourseRequest.getEmail())
        .orElseThrow(() -> new RuntimeException("Student not found"));

    if (!student.getCourses().contains(course)) {
        throw new RuntimeException("Student is not registered for this course");
    }

    student.getCourses().remove(course);
    studentRepo.save(student);

    CancelCourseResponse response = new CancelCourseResponse();
    response.setId(course.getId());
    response.setMessage("Successfully canceled registration for " + course.getTitle());

    return response;
}


    @Override
    public GetNotificationResponse getNotification(GetNotifictaionRequest getNotificationRequest){
        return notificationService.notifyUser(getNotificationRequest.getEmail(), getNotificationRequest.getMessage());
    }

    @Override
    public SearchCourseResponse searchCourseById(SearchCourseRequest searchCourseRequest) {
        Course course = courseRepo.findById(searchCourseRequest.getId())
            .orElseThrow(() -> new RuntimeException("Course not found"));

        SearchCourseResponse response = new SearchCourseResponse();
        response.setId(course.getId());
        response.setMessage("Course " + course.getId() + " found");

        return response;
}

    @Override
    public SearchCourseResponse searchCourseByTitle(SearchCourseRequest searchCourseRequest){
        Course course = courseRepo.findByTitle(searchCourseRequest.getTltle())
            .orElseThrow(() -> new RuntimeException("Course not found"));

        SearchCourseResponse response = new SearchCourseResponse();
        response.setId(course.getId());
        response.setTitle(course.getTitle());
        response.setMessage("Course with " + course.getTitle() + " found");

        return response;
    }

    public Course findByTitle(String title){
        return courseRepo.findByTitle(title)
        .orElseThrow(() -> new RuntimeException("Title not found"));
    }

    public Course findById(Long id){
        return courseRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("ID not found"));
    }

}

package com.synergystudy.synergystudy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synergystudy.synergystudy.data.models.Admin;
import com.synergystudy.synergystudy.data.models.Course;
import com.synergystudy.synergystudy.data.models.Instructor;
import com.synergystudy.synergystudy.data.models.Student;
import com.synergystudy.synergystudy.data.repositories.AdminRepo;
import com.synergystudy.synergystudy.data.repositories.CourseRepo;
import com.synergystudy.synergystudy.data.repositories.InstructorRepo;
import com.synergystudy.synergystudy.data.repositories.StudentRepo;
import com.synergystudy.synergystudy.dtos.requests.AddNewAdminRequest;
import com.synergystudy.synergystudy.dtos.requests.DeleteCourseRequest;
import com.synergystudy.synergystudy.dtos.requests.FindInstructorRequest;
import com.synergystudy.synergystudy.dtos.requests.FindStudentRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginAdminRequest;
import com.synergystudy.synergystudy.dtos.requests.PromoteCourseRequest;
import com.synergystudy.synergystudy.dtos.requests.RemoveInstructorRequest;
import com.synergystudy.synergystudy.dtos.requests.ValidateInstructorRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewAdminResponse;
import com.synergystudy.synergystudy.dtos.response.DeleteCourseResponse;
import com.synergystudy.synergystudy.dtos.response.FindInstructorResponse;
import com.synergystudy.synergystudy.dtos.response.FindStudentResponse;
import com.synergystudy.synergystudy.dtos.response.LoginAdminResponse;
import com.synergystudy.synergystudy.dtos.response.PromoteCourseResponse;
import com.synergystudy.synergystudy.dtos.response.RemoveInstructorResponse;
import com.synergystudy.synergystudy.dtos.response.ValidateInstructorResponse;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;
    @Autowired
    InstructorRepo instructorRepo;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    MailService mailService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    Admin admin = new Admin();

    @Override
    public AddNewAdminResponse registerAdmin(AddNewAdminRequest addNewAdminRequest){

        admin.setFirstName(addNewAdminRequest.getFirstName());
        admin.setLastName(addNewAdminRequest.getLastName());
        admin.setEmail(addNewAdminRequest.getEmail());
        admin.setPassword(passwordEncoder.encode(addNewAdminRequest.getPassword()));
        adminRepo.save(admin);

        // mailService.sendRegistrationEmail(addNewAdminRequest.getEmail());

        AddNewAdminResponse response = new AddNewAdminResponse();
        response.setId(admin.getId());
        response.setFirstName(admin.getFirstName());
        response.setLastName(admin.getLastName());
        response.setEmail(admin.getEmail());
        response.setPassword(passwordEncoder.encode(admin.getPassword()));
        response.setMessage("Successfully registered Instructor with name" + admin.getFirstName());

        return response;
    }
    @Override
    public LoginAdminResponse loginAdmin(LoginAdminRequest loginAdminRequest){
        Admin admin = adminRepo.findByEmail(loginAdminRequest.getEmail())
        .orElseThrow(() -> new RuntimeException("Email not found"));

    // if (!admin.getPassword().equals(loginAdminRequest.getPassword())) {
    //     throw new RuntimeException("Incorrect email or password");
    // }

    LoginAdminResponse response = new LoginAdminResponse();
    response.setFirstName(admin.getFirstName());
    response.setMessage("Successfully logged in " + admin.getFirstName());

    return response;
    }

    public RemoveInstructorResponse findInstructor(RemoveInstructorRequest request){
        Instructor instructor = instructorRepo.findById(request.getId())
        .orElseThrow(() -> new RuntimeException("Instructor not found"));

        instructorRepo.delete(instructor);

        RemoveInstructorResponse response = new RemoveInstructorResponse();
        response.setId(instructor.getId());
        response.setMessage("Instructor deleted");

        return response;
        
    }

    public FindInstructorResponse findInstructor(FindInstructorRequest request){
        Instructor instructor = instructorRepo.findById(request.getId())
        .orElseThrow(() -> new RuntimeException("Instructor not found"));

        FindInstructorResponse response = new FindInstructorResponse();
        response.setId(instructor.getId());
        response.setFirstName(instructor.getFirstName());
        response.setLastName(instructor.getLastName());
        response.setEmail(instructor.getEmail());
        response.setMessage("Instructor found");

        return response;
        
    }

    public FindStudentResponse findStudent(FindStudentRequest request){
        Student student = studentRepo.findById(request.getId())
        .orElseThrow(() -> new RuntimeException("Student not found"));

        FindStudentResponse response = new FindStudentResponse();
        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setMessage("Instructor found");

        return response; 
    }

    public DeleteCourseResponse findInstructor(DeleteCourseRequest request){
        Course course = courseRepo.findById(request.getId())
        .orElseThrow(() -> new RuntimeException("Instructor not found"));

        courseRepo.delete(course);

        DeleteCourseResponse response = new DeleteCourseResponse();
        response.setId(course.getId());
        response.setMessage("Course deleted");

        return response;    
    }

    public ValidateInstructorResponse validateInstructor(ValidateInstructorRequest request){
        return null;
    }

    public PromoteCourseResponse promoteCourse(PromoteCourseRequest request) {
    
    if (request == null || request.getId() == null) {
        throw new IllegalArgumentException("Course ID must be provided");
    }

    Course course = courseRepo.findById(request.getId())
        .orElseThrow(() -> new RuntimeException("Course not found"));

    course.setPromoted(true);
    courseRepo.save(course); 

    PromoteCourseResponse response = new PromoteCourseResponse();
    response.setId(course.getId());
    response.setMessage("Course successfully promoted");

    return response;
}



}

package com.synergystudy.synergystudy.services;

import org.springframework.stereotype.Service;

import com.synergystudy.synergystudy.dtos.requests.AddNewAdminRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginAdminRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewAdminResponse;
import com.synergystudy.synergystudy.dtos.response.LoginAdminResponse;

@Service
public interface AdminService {

    AddNewAdminResponse registerAdmin(AddNewAdminRequest addNewAdminRequest);
    LoginAdminResponse loginAdmin(LoginAdminRequest loginAdminRequest);

}

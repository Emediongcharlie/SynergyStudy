package com.synergystudy.synergystudy.services;

import org.springframework.stereotype.Service;

import com.synergystudy.synergystudy.dtos.requests.AddNewAdminRequest;
import com.synergystudy.synergystudy.dtos.requests.LoginAdminRequest;
import com.synergystudy.synergystudy.dtos.response.AddNewAdminResponse;
import com.synergystudy.synergystudy.dtos.response.LoginAdminResponse;

@Service
public class AdminServiceImpl implements AdminService {

    @Override
    public AddNewAdminResponse registerAdmin(AddNewAdminRequest addNewAdminRequest){
        return null;
    }
    @Override
    public LoginAdminResponse loginAdmin(LoginAdminRequest loginAdminRequest){
        return null;
    }
}

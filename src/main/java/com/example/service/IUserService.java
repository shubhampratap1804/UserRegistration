package com.example.service;

import com.example.dto.ForgetPasswordDTO;
import com.example.dto.LoginDTO;
import com.example.dto.RegisterDTO;
import com.example.model.UserModel;

import java.util.List;

public interface IUserService {

    List<UserModel> getAllUserRegistrationData();

    UserModel addUserRegistration(RegisterDTO registerDTO);

    String userLoginCredentials(LoginDTO loginDTO);

    String userForgetLoginCredentials(ForgetPasswordDTO forgetPasswordDTO);
}

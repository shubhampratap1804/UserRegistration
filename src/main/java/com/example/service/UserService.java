package com.example.service;

import com.example.dto.ForgetPasswordDTO;
import com.example.dto.LoginDTO;
import com.example.dto.RegisterDTO;
import com.example.exception.BusinessException;
import com.example.model.UserModel;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<UserModel> getAllUserRegistrationData() {
        return userRepository.findAll();
    }

    @Override
    public UserModel addUserRegistration(RegisterDTO registerDTO) {
        UserModel userModel = new UserModel(registerDTO);
        return userRepository.save(userModel);
    }

    @Override
    public String userLoginCredentials(LoginDTO loginDTO) {
        List<UserModel> models = userRepository.findAll();
        for (UserModel userModel: models) {
            if(userModel.geteMail().equals(loginDTO.getEMail()) && userModel.getPassword().equals(loginDTO.getPassword())) {
              return "Login is successful";
            } else {
                return "Either email or password is incorrect!";
            }
        } return null;
    }

    @Override
    public String userForgetLoginCredentials(ForgetPasswordDTO forgetPasswordDTO) {
        List<UserModel> models = userRepository.findAll();
        for (UserModel userModel: models) {
            if(userModel.geteMail().equals(forgetPasswordDTO.getEmail())){
                return "Password changed successfully!";
            } else return "Email not registered";
        }
        return null;
    }
}

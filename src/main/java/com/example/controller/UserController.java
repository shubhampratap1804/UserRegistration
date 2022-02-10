package com.example.controller;

import com.example.dto.ForgetPasswordDTO;
import com.example.dto.LoginDTO;
import com.example.dto.RegisterDTO;
import com.example.dto.ResponseDTO;
import com.example.exception.BusinessException;
import com.example.model.UserModel;
import com.example.service.IUserService;
import com.example.service.UserService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/get-users")
    public ResponseEntity<ResponseDTO> displayAllUsers(){
        List<UserModel> userModelList = userService.getAllUserRegistrationData();
        ResponseDTO responseDTO = new ResponseDTO("Displaying all users:", userModelList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/add-user")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody RegisterDTO registerDTO) {
        UserModel userModel = userService.addUserRegistration(registerDTO);
        ResponseDTO responseDTO = new ResponseDTO("User added successfully!", userModel);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@RequestBody LoginDTO loginDTO){
        String message = userService.userLoginCredentials(loginDTO);
        ResponseDTO responseDTO = new ResponseDTO(message, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }

    @PostMapping("/forget-password")
    public ResponseEntity<ResponseDTO> userForgetPassword(@RequestBody ForgetPasswordDTO forgetPasswordDTO){
        String message = userService.userForgetLoginCredentials(forgetPasswordDTO);
        ResponseDTO responseDTO = new ResponseDTO(message, "");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
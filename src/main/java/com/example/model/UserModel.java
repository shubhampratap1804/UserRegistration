package com.example.model;

import com.example.dto.RegisterDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_details")
public class UserModel {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;

    public UserModel(){}

    public UserModel(RegisterDTO registerDTO){
        this.updateUserData(registerDTO);
    }

    public void updateUserData(RegisterDTO registerDTO) {
        this.firstName = registerDTO.firstName;
        this.lastName = registerDTO.lastName;
        this.eMail = registerDTO.eMail;
        this.password = registerDTO.password;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

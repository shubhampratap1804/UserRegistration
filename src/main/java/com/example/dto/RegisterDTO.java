package com.example.dto;

import lombok.Data;

@Data
public class RegisterDTO {

    public String firstName;
    public String lastName;
    public String eMail;
    public String password;

    public RegisterDTO(String firstName, String lastName, String eMail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
    }
}

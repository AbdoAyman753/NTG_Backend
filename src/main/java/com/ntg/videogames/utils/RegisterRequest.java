package com.ntg.videogames.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String LastName;
    private String userName;
    private String email;
    private String password;
    private String profilePicture = "assets/default_profilePic.jpg";
}

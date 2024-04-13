package com.africa.semicolon.blog.dto.utility.response;

import com.africa.semicolon.blog.model.User;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AddViewToPostResponse {
    private LocalDateTime timeOfView;
    private User viewer;
}

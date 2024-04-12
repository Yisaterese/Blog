package com.africa.semicolon.blog.dto.request;

import com.africa.semicolon.blog.model.User;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
public class ViewRequest {
    private LocalDateTime timeOfView;
    private User viewer;
    @Id
    private String id;
}

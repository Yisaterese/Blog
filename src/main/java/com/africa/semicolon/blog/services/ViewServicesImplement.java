package com.africa.semicolon.blog.services;

import com.africa.semicolon.blog.model.Post;
import com.africa.semicolon.blog.model.View;
import com.africa.semicolon.blog.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServicesImplement implements ViewServices{
    @Autowired
    private ViewRepository viewRepository;
    @Override
    public List<View> findViewsByPost(Post newPost) {
        return viewRepository.findViewsBy(newPost);
    }
}

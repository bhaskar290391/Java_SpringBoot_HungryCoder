package com.practise.service;

public class VideoContentStategy implements ContentStrategy{
    @Override
    public void contentPost() {
        System.out.println("Video content strategy");
    }
}

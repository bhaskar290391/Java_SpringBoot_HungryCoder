package com.practise.service;

public class ImageContentStrategy implements  ContentStrategy{
    @Override
    public void contentPost() {
        System.out.println("Image Content startegy");
    }
}

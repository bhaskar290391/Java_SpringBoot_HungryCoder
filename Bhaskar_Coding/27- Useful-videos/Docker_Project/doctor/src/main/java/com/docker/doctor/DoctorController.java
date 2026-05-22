package com.docker.doctor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @GetMapping("/doctor")
    public String getDoctor(){
        return  "All Doctors data";
    }
}

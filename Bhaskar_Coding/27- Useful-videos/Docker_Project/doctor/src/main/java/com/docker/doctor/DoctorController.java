package com.docker.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DoctorController {

    @Autowired
    private RestTemplate template;

    @GetMapping("/doctor")
    public String getDoctor(){
        return  "All Doctors data";
    }

    @GetMapping("/patientDoctorService")
    public String getPatientService(){
       return template.getForObject("http://patient-service:8080/allPatient", String.class);
    }
}

package com.docker.patient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @GetMapping("/allPatient")
    public String getAllPatient(){
        return  "All Patient";
    }

    @GetMapping("/patientById")
    public String getPatientById(){
        return  "patient by Id";
    }
}

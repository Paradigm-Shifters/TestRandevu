package com.example.TestRandevu.api;

import com.example.TestRandevu.dao.PatientService;
import com.example.TestRandevu.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/createPatient")
    public String createPatient(@RequestBody Patient patient ) throws InterruptedException, ExecutionException {
        return patientService.savePatientDetails(patient);
    }

    @GetMapping("/getPatientDetails")
    public Patient getPatient(@RequestParam String name ) throws InterruptedException, ExecutionException {
        return patientService.getPatientDetails(name);
    }

    @PutMapping("/updatePatient")
    public String updatePatient(@RequestBody Patient patient ) throws InterruptedException, ExecutionException {
        return patientService.updatePatientDetails(patient);
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam String name){
        return patientService.deletePatient(name);
    }
}
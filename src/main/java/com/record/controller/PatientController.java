package com.record.controller;

import com.record.entity.Patient;
import com.record.service.PatientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Controller class (all api/end points )

@RestController
@RequestMapping("/patients")
public class PatientController
{
    //inject service in this
    @Autowired
    private PatientService patientService;

    //add patient data
    @PostMapping("/addPatient")
    public ResponseEntity<String> addPatient(@RequestBody Patient patient){
        System.err.println(patient);
        patientService.savePatient(patient);
        return new ResponseEntity<>("Patient added", HttpStatus.CREATED);
    }

    //get all data
    @GetMapping("/getAllData")
    public ResponseEntity<List<Patient>> getAllData(){
       List<Patient> patientList =  patientService.getAllData();
       return new ResponseEntity<>(patientList,HttpStatus.OK);
    }

    //get data by Id
    @GetMapping("/getDataById/{id}")
    public ResponseEntity<Patient> getDataById(@PathVariable("id") int id){
        Patient patientById = patientService.getById(id);
        return new ResponseEntity<>(patientById,HttpStatus.OK);
    }
}

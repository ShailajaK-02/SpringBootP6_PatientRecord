package com.record.serviceImpl;

import com.record.entity.Patient;
import com.record.repository.PatientRepository;
import com.record.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService
{
    //inject repository in this
    @Autowired
    private PatientRepository repository;

    @Override
    public String savePatient(Patient patient) {
        repository.save(patient);
        return "patient added";
    }

    @Override
    public List<Patient> getAllData() {
        List<Patient> patientList = repository.findAll();
        return patientList;
    }

    @Override
    public Patient getById(int id) {
        Patient patientbyId = repository.findById(id).orElseThrow(()->new NullPointerException("Patient not found" +id ));
        return patientbyId;
    }
}

package com.record.service;

import com.record.entity.Patient;

import java.util.List;

//service interface
public interface PatientService
{
    String savePatient(Patient patient);

    List<Patient> getAllData();

    Patient getById(int id);
}

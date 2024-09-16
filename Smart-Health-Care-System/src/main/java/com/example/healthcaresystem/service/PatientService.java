package com.example.healthcaresystem.service;

import com.example.healthcaresystem.entity.Patient;
import com.example.healthcaresystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Other methods...
}

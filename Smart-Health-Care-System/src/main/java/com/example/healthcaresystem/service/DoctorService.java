package com.example.healthcaresystem.service;

import com.example.healthcaresystem.entity.Doctor;
import com.example.healthcaresystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Optional<Doctor> getDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Other methods...
}

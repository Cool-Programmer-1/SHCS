package com.example.healthcaresystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.healthcaresystem.entity.Doctor;
import com.example.healthcaresystem.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/register")
    public ResponseEntity<Doctor> registerDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        return doctorService.getDoctorByEmail(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Other endpoints...
}

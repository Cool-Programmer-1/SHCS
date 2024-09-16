package com.example.healthcaresystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.healthcaresystem.entity.Appointment;
import com.example.healthcaresystem.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getDoctorAppointments(@PathVariable Long doctorId) {
        List<Appointment> appointments = appointmentService.getAppointmentsForDoctor(doctorId);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getPatientAppointments(@PathVariable Long patientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsForPatient(patientId);
        return ResponseEntity.ok(appointments);
    }

    // Other endpoints...
}

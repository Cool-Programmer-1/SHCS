package com.example.healthcaresystem.service;

import com.example.healthcaresystem.entity.Appointment;
import com.example.healthcaresystem.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Other methods...
}

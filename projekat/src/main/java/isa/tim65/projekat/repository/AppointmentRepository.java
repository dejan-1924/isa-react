package isa.tim65.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isa.tim65.projekat.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}

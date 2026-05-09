package com.hungrycoders.repository;

import java.util.List;
import java.util.SortedMap;import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hungrycoders.model.Appointment;

public interface AppointmentRepository extends MongoRepository<Appointment, UUID> {

	@Query("{'doctor.id': ?0}")
	List<Appointment> findByDoctorId(String doctorId, Sort sort);

	@Query("{'patient.id': ?0}")
	List<Appointment> findByPatientId(String patientId, Sort sort);

	List<Appointment> findAllByOrderByAppointmentTimeAsc();
}

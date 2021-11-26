package com.misiontic.medic_ms.repositories;
import com.misiontic.medic_ms.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientsRepository extends MongoRepository<Patient, String>{

}

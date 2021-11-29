package com.misiontic.medic_ms.repositories;

import com.misiontic.medic_ms.models.ReportEvolution;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReportEvolutionRepository extends MongoRepository<ReportEvolution, Long>
{
    List<ReportEvolution> findByidPatient(Long idPatient);
    ReportEvolution findByidPatientSingle(Long idPatient);

}

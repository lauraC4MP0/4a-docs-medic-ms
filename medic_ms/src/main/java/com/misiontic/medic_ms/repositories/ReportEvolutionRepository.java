package com.misiontic.medic_ms.repositories;

import com.misiontic.medic_ms.models.ReportEvolution;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReportEvolutionRepository extends MongoRepository<ReportEvolution, String>
{
    List<ReportEvolution> findByidPatient(String idPatient);

}

package com.misiontic.medic_ms.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.misiontic.medic_ms.exceptions.ReportEvolutionNotFoundException;
import com.misiontic.medic_ms.models.ReportEvolution;
import com.misiontic.medic_ms.repositories.ReportEvolutionRepository;

@RestController
public class ReportEvolutionController {
    private final ReportEvolutionRepository reportEvolutionRepository;

    public ReportEvolutionController(ReportEvolutionRepository reportEvolutionRepository){
        this.reportEvolutionRepository=reportEvolutionRepository;

    }

    @GetMapping("/reportEvolution/{id_patient}")
    List<ReportEvolution> getReportsEvolution(@PathVariable String id_patient){
        List<ReportEvolution> reports = reportEvolutionRepository.findById_patient(id_patient);
        if (reports == null){
            throw new ReportEvolutionNotFoundException("No se encontraron historias clínicas para el paciente "+id_patient);
        }
        return reports;
    }

    @PostMapping("/reportEvolution")
    ReportEvolution newReportEvolution(@RequestBody ReportEvolution reportEvolution){
       return reportEvolutionRepository.save(reportEvolution);
    }

}

package com.misiontic.medic_ms.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.misiontic.medic_ms.exceptions.ReportEvolutionNotFoundException;
import com.misiontic.medic_ms.models.ReportEvolution;
import com.misiontic.medic_ms.repositories.ReportEvolutionRepository;

import com.misiontic.medic_ms.exceptions.PatientNotFoundException;
import com.misiontic.medic_ms.models.Patient;
import com.misiontic.medic_ms.repositories.PatientsRepository;


@RestController
public class ReportEvolutionController {
    private final ReportEvolutionRepository reportEvolutionRepository;

    public ReportEvolutionController(ReportEvolutionRepository reportEvolutionRepository){
        this.reportEvolutionRepository  = reportEvolutionRepository;

    }

    @PostMapping("/reportEvolution")
    ReportEvolution newReportEvolution(@RequestBody ReportEvolution reportEvolution){
        return reportEvolutionRepository.save(reportEvolution);
    }

    @GetMapping("/reportEvolution/{idPatient}")
    List<ReportEvolution> getReportEvolution(@PathVariable String idPatient){
        List<ReportEvolution> reports = reportEvolutionRepository.findByidPatient(idPatient);
        if (reports == null){
            throw new ReportEvolutionNotFoundException("No se encontraron historias clínicas para el paciente "+idPatient);
        }
        return reports;
    }

}

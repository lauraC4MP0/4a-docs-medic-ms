package com.misiontic.medic_ms.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.misiontic.medic_ms.repositories.*;
import com.misiontic.medic_ms.exceptions.*;
import com.misiontic.medic_ms.models.*;
import java.time.LocalDate;

@RestController
public class ReportEvolutionController {
    private final ReportEvolutionRepository reportEvolutionRepository;
    private final PatientsRepository patientRepository;

    public ReportEvolutionController(ReportEvolutionRepository reportEvolutionRepository, PatientsRepository patientsRepository){
        this.reportEvolutionRepository  = reportEvolutionRepository;
        this.patientRepository=patientsRepository;

    }

    @PostMapping("/reportEvolution")
    ReportEvolution newReportEvolution(@RequestBody ReportEvolution reportEvolution){
        Patient patient=patientRepository.findById(reportEvolution.getIdPatient()).orElseThrow(()->new PatientNotFoundException("No existe ningún paciente con el id "+reportEvolution.getIdPatient()));
        if(patient.getIs_active()==true){
            LocalDate date=LocalDate.now();
            Integer year=date.getYear()-patient.getDateBirth().getYear();
            reportEvolution.setAge(year);
            reportEvolutionRepository.save(reportEvolution);
            return reportEvolution;
        }else{
            throw new PatientNoLongerBelongsException("El paciente "+reportEvolution.getIdPatient()+" ya no hace parte de ConsulMedic");
        }
    }

    @GetMapping("/reportEvolution/{idPatient}")
    List<ReportEvolution> getReportEvolution(@PathVariable Long idPatient){
        List<ReportEvolution> reports;
        Patient patient=patientRepository.findById(idPatient).orElseThrow(()->new PatientNotFoundException("No existe ningún paciente con el id "+idPatient));
        if(patient.getIs_active()==true){
            reports=reportEvolutionRepository.findByidPatient(idPatient);
            if(reports==null||reports.size()==0){
                throw new ReportEvolutionNotFoundException("No se encontró historia clínica para el paciente con id "+idPatient);
            }else{
                return reports;
            }
        }else{
            throw new PatientNoLongerBelongsException("El paciente "+idPatient+" ya no hace parte de ConsulMedic");
        }
    }
/*
    @GetMapping("/reportEvolution/{idPatient}")
    ReportEvolution getSingleReport(@PathVariable Long idPatient){
        Patient patient=patientRepository.findById(idPatient).orElseThrow(()->new PatientNotFoundException("No existe ningún paciente con el id "+idPatient));
        if(patient.getIs_active()==true){
            ReportEvolution report=reportEvolutionRepository.findByIdPatientSingle(idPatient);
            return report;
        }else{
            throw new PatientNoLongerBelongsException("El paciente "+idPatient+" ya no hace parte de ConsulMedic");
        }
    }*/

}

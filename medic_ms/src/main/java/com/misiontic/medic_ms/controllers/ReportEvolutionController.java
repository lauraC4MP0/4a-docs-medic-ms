package com.misiontic.medic_ms.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.misiontic.medic_ms.repositories.*;
import com.misiontic.medic_ms.exceptions.*;
import com.misiontic.medic_ms.models.ReportEvolution;
import java.time.LocalDate;

@RestController
public class ReportEvolutionController {
    private final ReportEvolutionRepository reportEvolutionRepository;
    private final PatientsRepository patientRepository;

    public ReportEvolutionController(ReportEvolutionRepository reportEvolutionRepository, PatientsRepository patientsRepository){
        this.reportEvolutionRepository  = reportEvolutionRepository;
        this.patientRepository=patientsRepository;

    }

    @GetMapping("/ReportEvolution")
    String messageRoot(){
        return "Bienvenido a ReportEvolutionMS";
    }

    @PostMapping("/reportEvolution")
    ReportEvolution newReportEvolution(@RequestBody ReportEvolution reportEvolution){
        if(patientRepository.findById(reportEvolution.getIdPatient())==null){
            throw new PatientNotFoundException("No existe ningún paciente con el id "+reportEvolution.getIdPatient());
        }else{
            if(patientRepository.findById(reportEvolution.getIdPatient()).get().getIs_active()==false){
                throw new PatientNoLongerBelongsException("El paciente ya no hace parte de ConsulMedic");
            }else{
                LocalDate date=LocalDate.now();
                Integer year=date.getYear()-patientRepository.findById(reportEvolution.getIdPatient()).get().getDateBirth().getYear();
                reportEvolution.setAge(year);
                reportEvolutionRepository.save(reportEvolution);
                return reportEvolution;
            }
        }
    }

    @GetMapping("/reportEvolution/{idPatient}")
    List<ReportEvolution> getReportEvolution(@PathVariable Long idPatient){
        List<ReportEvolution> reports;
        if(patientRepository.findById(idPatient).get()==null){
            throw new PatientNotFoundException("No existe ningún paciente con el id "+idPatient);
        }else{
            if(patientRepository.findById(idPatient).get().getIs_active()==false){
                throw new PatientNoLongerBelongsException("El paciente ya no hace parte de ConsulMedic");
            }else{
                reports=reportEvolutionRepository.findByidPatient(idPatient);
                if(reports==null||reports.size()==0){
                    throw new ReportEvolutionNotFoundException("No se encontraron historias clínicas para el paciente "+idPatient);
                }else{
                    return reports;
                }
            }
        }

    }

}

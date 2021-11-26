/*package com.misiontic.medic_ms.controllers;
import com.misiontic.medic_ms.exceptions.*;
import com.misiontic.medic_ms.models.Patient;
import com.misiontic.medic_ms.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController{
    private final PatientRepository patientRepository;
    public PatientController(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    @GetMapping("/patients/{id}")
    Patient getPatient(@PathVariable String id){
        if(patientRepository.findById(id).getIs_active()==true){
            return patientRepository.findById(id);
        }else if(patientRepository.findById(id).getIs_active()==false){
            return new PatientNoLongerBelongsException("El paciente ya no hace parte de ConsulMedic");
        }else{
            return new PatientNoFoundException("No existe ningún paciente con el id "+id);
        }
    }

    @PostMapping("/patients")
    Patient newPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }
}*/
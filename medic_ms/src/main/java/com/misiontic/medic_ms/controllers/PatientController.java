/*package com.misiontic.medic_ms.controllers;
import com.misiontic.medic_ms.exceptions.AccountNotFoundException;
import com.misiontic.medic_ms.models.Account;
import com.misiontic.medic_ms.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController{
    private final PatientRepository patientRepository;
    public PatientController(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    @GetMapping("/patients/{id}")
    Patient getPatient(@PathVariable String id){
        return patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("No existe ningún paciente con el id "+id));
    }

    @PostMapping("/patients")
    Patient newPatient(@Request)
}*/
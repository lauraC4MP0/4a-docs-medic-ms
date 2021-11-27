package com.misiontic.medic_ms.controllers;
import com.misiontic.medic_ms.exceptions.*;
import com.misiontic.medic_ms.models.Patient;
import com.misiontic.medic_ms.repositories.PatientsRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController{
    private final PatientsRepository patientRepository;
    public PatientController(PatientsRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    @GetMapping("/patients/{id}")
    Patient getPatient(@PathVariable String id){
        if(patientRepository.findById(id).get().getIs_active()==true){
            return patientRepository.findById(id).get();
        }else{
            if(patientRepository.findById(id).get().getIs_active()==false){
                throw new PatientNoLongerBelongsException("El paciente ya no hace parte de ConsulMedic");
            }else{
                throw new PatientNotFoundException("No existe ningún paciente con el id "+id);
            }
        }
    }

    @PostMapping("/patients")
    Patient newPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }
}
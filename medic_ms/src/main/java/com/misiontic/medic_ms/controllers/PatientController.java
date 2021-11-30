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
    Patient getPatient(@PathVariable Long id){
        Patient patient=patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("No existe nigún paciente con el id "+id));
        if(patient.getIs_active()==true){
            return patient;
        }else{
            throw new PatientNoLongerBelongsException("El paciente "+id+" ya no hace parte de ConsulMedic");
        }
    }

    @PostMapping("/patients")
    Patient newPatient(@RequestBody Patient patient){
        patient.setIs_active(true);
        return patientRepository.save(patient);
    }

    @PutMapping("/patients/delete/{id}")
    String deletePatient(@PathVariable Long id){
        Patient patient=patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("No existe ningún usuario con el id "+id));
        if(patient.getIs_active()==true){
            patient.setIs_active(false);
            patientRepository.save(patient);
            return "Paciente "+patient.getLastname()+" "+patient.getName()+" eliminado correctamente";
        }else{
            throw new PatientNoLongerBelongsException("El paciente "+id+" ya ha sido eliminado anteriormente");
        }
    }

    @PutMapping("/patients/update/{id}")
    Patient updatePatient(@RequestBody Patient patient){
        Patient p=patientRepository.findById(patient.getId()).orElseThrow(()->new PatientNotFoundException("No existe ningún paciente con el id"+patient.getId()));
        if(patient.getIs_active()==false){
            throw new PatientNoLongerBelongsException("El paciente ya no hace parte de ConsulMedic");
        }else{
            p.setEmail(patient.getEmail());
            p.setPhoneNumber(patient.getPhoneNumber());
            patientRepository.save(p);
            return p;
        }
    }
}
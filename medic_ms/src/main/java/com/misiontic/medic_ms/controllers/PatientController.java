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
        if(patientRepository.findById(id).get().getIs_active()==true){
            return patientRepository.findById(id).get();
        }else{
            if(patientRepository.findById(id).get().getIs_active()==false){
                throw new PatientNoLongerBelongsException("El paciente ya no hace parte de ConsulMedic");
            }
            else{
                throw new PatientNotFoundException("No existe ningún paciente con el id "+id);
            }
        }
    }

    @PostMapping("/patients")
    Patient newPatient(@RequestBody Patient patient){
        patient.setIs_active(true);
        return patientRepository.save(patient);
    }

    @DeleteMapping("/patients/delete/{id}")
    Patient deletePatient(@PathVariable Long id){
        Patient patient=patientRepository.findById(id).get();
        patient.setIs_active(false);
        patientRepository.save(patient);
        return patient;
    }

    @PutMapping("/patients/update/{id}")
    Patient updatePatient(@RequestBody Patient patient){
        if(patient.getIs_active()==false){
            throw new PatientNoLongerBelongsException("El paciente ya no hace parte de ConsulMedic");
        }else{
            Patient p=patientRepository.findById(patient.getId()).get();
            p.setEmail(patient.getEmail());
            p.setPhoneNumber(patient.getPhoneNumber());
            patientRepository.save(p);
            return p;
        }
    }
}
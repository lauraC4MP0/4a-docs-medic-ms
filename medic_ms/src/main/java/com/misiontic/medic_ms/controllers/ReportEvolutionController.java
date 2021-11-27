package misiontic.medic_ms.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.misiontic.medic_ms.exceptions.ReportEvolutionNotFoundException;
import com.misiontic.medic_ms.models.Patient;
import com.misiontic.medic_ms.models.ReportEvolution;
import com.misiontic.medic_ms.repositories.PatientsRepository;
import com.misiontic.medic_ms.repositories.ReportEvolutionRepository;

@RestController
public class ReportEvolutionController {
    private final PatientsRepository patientsRepository;
    private final ReportEvolutionRepository reportEvolutionRepository;

    public ReportEvolutionController(ReportEvolutionRepository reportEvolutionRepository,PatientsRepository patientsRepository){
        this.reportEvolutionRepository=reportEvolutionRepository;
        this.patientsRepository=patientsRepository;
    }

    @GetMapping("/reportEvolution/{id_patient}")
    List<ReportEvolution> id_patient(@PathVariable String id_patient){
        ReportEvolution id_patient = ReportEvolutionRepository.findById(id_patient).orElse(null);
        if (id_patient == null)
        throw new ReportEvolutionNotFoundException("No se encontro historia clinica:
                " + id_patient);
        return reportEvolution;
    }

    @PostMapping("/reportEvolution")
    ReportEvolution newReportEvolution(@RequestBody ReportEvolution reportEvolution){
       return reportEvolutionRepository.save(reportEvolution);
    }

}

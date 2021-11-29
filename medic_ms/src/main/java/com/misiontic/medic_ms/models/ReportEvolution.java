package com.misiontic.medic_ms.models;
import java.time.LocalDate;
//import com.misiontic.medic_ms.repositories.PatientsRepository;

public class ReportEvolution {
    private LocalDate date;
    private Long idPatient;
    private Integer age;
    private String weight;
    private String reason_for_consultation;
    private String current_illness;
    private String background;
    private String diseases;
    private String allergies;
    private String hereditary_family_history;
    private String physical_exam;
    private String medicines;
    //private PatientsRepository patientsRepository; 
    

    public ReportEvolution(Long idPatient,Integer age,String weight,String reason_for_consultation,String current_illness,String background,String diseases,String allergies,String hereditary_family_history,String physical_exam,String medicines){
        this.date=LocalDate.now();
        //this.age=date.getYear()-patientsRepository.findById(idPatient).get().getDateBirth().getYear();
        this.idPatient=idPatient;
        this.weight=weight;
        this.reason_for_consultation=reason_for_consultation;
        this.current_illness=current_illness;
        this.background=background;
        this.diseases=diseases;
        this.allergies=allergies;
        this.hereditary_family_history=hereditary_family_history;
        this.physical_exam=physical_exam;
        this.medicines=medicines;
    }

    public LocalDate getdate() {
        return date;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public Integer getage() {
        return age;
    }

    public void setAge(Integer age){
        this.age=age;
    }
    public String getweight() {
        return weight;
    }

    public String getreason_for_consultation() {
        return reason_for_consultation;
    }

    public String getcurrent_illness() {
        return current_illness;
    }

    public String getbackground() {
        return background;
    }

    public String getdiseases() {
        return diseases;
    }

    public String getallergies() {
        return allergies;
    }

    public String gethereditary_family_history() {
        return hereditary_family_history;
    }

    public String getphysical_exam() {
        return physical_exam;
    }
    
    public String getmedicines() {
        return medicines;
    }
}

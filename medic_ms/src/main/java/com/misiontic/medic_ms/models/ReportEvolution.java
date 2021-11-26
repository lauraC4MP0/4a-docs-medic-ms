package com.misiontic.medic_ms.models;
import org.springframework.data.annotation.Id;

import java.text.DateFormat;
import java.util.Date;

public class ReportEvolution {
    @Id

    private Number id_report;
    private Date date;
    private Number id_patient;
    private Number age;
    private Number weight;
    private String reason_for_consultation;
    private String current_illness;
    private String background;
    private String diseases;
    private String allergies;
    private String hereditary_family_history;
    private String physical_exam;
    private String medicines;
    

    public ReportEvolution(Number id_report, Date date,Number id_patient,Number age,Number weight,String reason_for_consultation,String current_illness,String background,String diseases,String allergies,String hereditary_family_history,String physical_exam,String medicines){
        this.id_report=id_report;
        this.date=date;
        this.id_patient=id_patient;
        this.age=age;
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

    public Number getid_report() {
        return id_report;
    }

    public Date getdate() {
        return date;
    }

    public Number getid_patient() {
        return id_patient;
    }

    public Number getage() {
        return age;
    }

    public Number getweight() {
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

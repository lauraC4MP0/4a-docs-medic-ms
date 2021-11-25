package com.misiontic.medic_ms.exceptions;

public class PatientNotFoundException extends RuntimeException
{
    public PatientNotFoundException (String message) {
        super(message);
    }
}

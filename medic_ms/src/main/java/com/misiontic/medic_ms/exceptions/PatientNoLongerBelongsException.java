package com.misiontic.medic_ms.exceptions;

public class PatientNoLongerBelongsException extends RuntimeException {
    public PatientNoLongerBelongsException(String message) {
    super(message);
    }
}
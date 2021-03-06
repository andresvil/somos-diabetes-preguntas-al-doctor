package com.example.andresvil.preguntasaldoctor;

/**
 * Created by andresvil on 3/14/16.
 */
public class Pregunta {
    private String pregunta;
    private String doctor;

    // Constructor
    public Pregunta(String pregunta, String doctor) {
        this.pregunta = pregunta;
        this.doctor = doctor;
    }

    // Getters & Setters
    public String getPregunta() {
        return pregunta;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}

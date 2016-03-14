package com.example.andresvil.preguntasaldoctor;

/**
 * Created by andresvil on 3/14/16.
 */
public class FAQ {
    private String pregunta;
    private String respuesta;

    // Constructor
    public FAQ(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    // Getters & Setters
    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}

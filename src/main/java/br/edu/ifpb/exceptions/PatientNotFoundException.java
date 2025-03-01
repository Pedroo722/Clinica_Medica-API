package br.edu.ifpb.exceptions;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException() {
        super("Paciente não encontrado!");
    }
}
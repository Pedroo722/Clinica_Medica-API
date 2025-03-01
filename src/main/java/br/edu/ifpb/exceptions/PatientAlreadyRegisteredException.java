package br.edu.ifpb.exceptions;

public class PatientAlreadyRegisteredException extends RuntimeException {
    public PatientAlreadyRegisteredException() {
        super("Paciente já registrado!");
    }
}
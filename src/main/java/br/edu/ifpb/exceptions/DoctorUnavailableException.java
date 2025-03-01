package br.edu.ifpb.exceptions;

public class DoctorUnavailableException extends RuntimeException {
    public DoctorUnavailableException() {
        super("Médico indisponível!");
    }
}
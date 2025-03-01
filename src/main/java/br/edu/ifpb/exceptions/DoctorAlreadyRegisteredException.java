package br.edu.ifpb.exceptions;

public class DoctorAlreadyRegisteredException extends RuntimeException {
    public DoctorAlreadyRegisteredException() {
        super("Médico já registrado!");
    }
}
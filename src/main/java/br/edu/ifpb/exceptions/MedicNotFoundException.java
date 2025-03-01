package br.edu.ifpb.exceptions;

public class MedicNotFoundException extends RuntimeException {
    public MedicNotFoundException() {
        super("Médico não encontrado!");
    }
}
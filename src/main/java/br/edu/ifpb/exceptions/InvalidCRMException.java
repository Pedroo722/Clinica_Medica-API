package br.edu.ifpb.exceptions;

public class InvalidCRMException extends RuntimeException {
    public InvalidCRMException() {
        super("Formeato de CRM inválido!");
    }
}
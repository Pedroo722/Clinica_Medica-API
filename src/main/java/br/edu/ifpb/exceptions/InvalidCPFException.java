package br.edu.ifpb.exceptions;

public class InvalidCPFException extends RuntimeException {
    public InvalidCPFException() {
        super("CPF inválido!");
    }
}
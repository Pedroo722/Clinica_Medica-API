package br.edu.ifpb.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Formato de email inválidas!");
    }
}
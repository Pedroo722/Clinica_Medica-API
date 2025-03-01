package br.edu.ifpb.exceptions;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException() {
        super("Acesso não autorizado!");
    }
}
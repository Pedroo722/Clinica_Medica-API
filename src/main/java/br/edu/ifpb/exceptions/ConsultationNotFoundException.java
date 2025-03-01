package br.edu.ifpb.exceptions;

public class ConsultationNotFoundException extends RuntimeException {
    public ConsultationNotFoundException() {
        super("Consulta não encontrada!");
    }
}
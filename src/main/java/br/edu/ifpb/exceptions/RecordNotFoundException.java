package br.edu.ifpb.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException() {
        super("Ficha não encontrada!");
    }
}
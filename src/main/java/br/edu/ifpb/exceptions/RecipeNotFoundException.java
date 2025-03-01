package br.edu.ifpb.exceptions;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException() {
        super("Receita não encontrada!");
    }
}
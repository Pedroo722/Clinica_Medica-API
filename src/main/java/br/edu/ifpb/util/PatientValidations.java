package br.edu.ifpb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.ifpb.exceptions.InvalidCPFException;
import br.edu.ifpb.exceptions.InvalidEmailException;

public class PatientValidations {
    public static void validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-ZÀ-ÿ][A-Za-zÀ-ÿ ]{5,50}$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new InvalidEmailException();
        }
    }

    public static void validateCPF(String cpf) {
        Pattern pattern = Pattern.compile("^[A-ZÀ-ÿ][A-Za-zÀ-ÿ ]{5,50}$");
        Matcher matcher = pattern.matcher(cpf);

        if (!matcher.matches()) {
            throw new InvalidCPFException();
        }
    }
    
}

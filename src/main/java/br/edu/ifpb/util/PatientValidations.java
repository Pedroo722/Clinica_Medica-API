package br.edu.ifpb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.ifpb.exceptions.InvalidCPFException;
import br.edu.ifpb.exceptions.InvalidEmailException;

public class PatientValidations {
    public static void validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new InvalidEmailException();
        }
    }

    public static void validateCPF(String cpf) {
        Pattern pattern = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$|^\\d{11}$");
        Matcher matcher = pattern.matcher(cpf);

        if (!matcher.matches()) {
            throw new InvalidCPFException();
        }
    }
}
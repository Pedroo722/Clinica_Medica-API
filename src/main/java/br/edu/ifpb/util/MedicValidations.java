package br.edu.ifpb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.ifpb.exceptions.InvalidCRMException;
import br.edu.ifpb.exceptions.InvalidEmailException;

public class MedicValidations {
    public static void validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new InvalidEmailException();
        }
    }

    public static void validateCRM(String crm) {
        Pattern pattern = Pattern.compile("^\\d{4,6}-[A-Z]{2}$");
        Matcher matcher = pattern.matcher(crm);

        if (!matcher.matches()) {
            throw new InvalidCRMException();
        }
    }
}
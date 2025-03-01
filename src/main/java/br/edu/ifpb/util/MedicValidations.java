package br.edu.ifpb.util;

import br.edu.ifpb.exceptions.InvalidEmailException;
import br.edu.ifpb.exceptions.InvalidCRMException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicValidations {
    public static void validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-ZÀ-ÿ][A-Za-zÀ-ÿ ]{5,50}$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new InvalidEmailException();
        }
    }

    public static void validateCRM(String crm) {
        Pattern pattern = Pattern.compile("^[A-ZÀ-ÿ][A-Za-zÀ-ÿ ]{5,50}$");
        Matcher matcher = pattern.matcher(crm);

        if (!matcher.matches()) {
            throw new InvalidCRMException();
        }
    }
}

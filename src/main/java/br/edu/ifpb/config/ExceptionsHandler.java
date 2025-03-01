package br.edu.ifpb.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.ifpb.exceptions.ConsultationNotFoundException;
import br.edu.ifpb.exceptions.DoctorAlreadyRegisteredException;
import br.edu.ifpb.exceptions.DoctorUnavailableException;
import br.edu.ifpb.exceptions.InvalidCPFException;
import br.edu.ifpb.exceptions.InvalidCRMException;
import br.edu.ifpb.exceptions.InvalidCredentialsException;
import br.edu.ifpb.exceptions.InvalidEmailException;
import br.edu.ifpb.exceptions.MedicNotFoundException;
import br.edu.ifpb.exceptions.PatientAlreadyRegisteredException;
import br.edu.ifpb.exceptions.PatientNotFoundException;
import br.edu.ifpb.exceptions.RecipeNotFoundException;
import br.edu.ifpb.exceptions.RecordNotFoundException;
import br.edu.ifpb.exceptions.UnauthorizedAccessException;

@ControllerAdvice
public class ExceptionsHandler {

    // Conflito
    @ExceptionHandler(PatientAlreadyRegisteredException.class)
    public ResponseEntity<String> handlePatientAlreadyRegistered(PatientAlreadyRegisteredException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DoctorAlreadyRegisteredException.class)
    public ResponseEntity<String> handleDoctorAlreadyRegistered(DoctorAlreadyRegisteredException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DoctorUnavailableException.class)
    public ResponseEntity<String> handleDoctorUnavailable(DoctorUnavailableException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    // Não Encontrado
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handlePatientNotFound(PatientNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MedicNotFoundException.class)
    public ResponseEntity<String> handleMedicNotFound(MedicNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConsultationNotFoundException.class)
    public ResponseEntity<String> handleConsultationNotFound(ConsultationNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(RecipeNotFoundException.class)
    public ResponseEntity<String> handleRecipeNotFound(RecipeNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> handleRecordNotFound(RecordNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Falta de autorização
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentialsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<String> handleUnauthorizedAccess(UnauthorizedAccessException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    // Formato de dado inválido
    @ExceptionHandler(InvalidCPFException.class)
    public ResponseEntity<String> handleInvalidCPF(InvalidCPFException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidCRMException.class)
    public ResponseEntity<String> handleInvalidCRM(InvalidCRMException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<String> handleInvalidEmail(InvalidEmailException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}

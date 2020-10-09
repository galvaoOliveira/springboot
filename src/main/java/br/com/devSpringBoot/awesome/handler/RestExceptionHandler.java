package br.com.devSpringBoot.awesome.handler;

import br.com.devSpringBoot.awesome.error.ErrorDetails;
import br.com.devSpringBoot.awesome.error.ResourceNotFoundDetails;
import br.com.devSpringBoot.awesome.error.ResourceNotFoundException;
import br.com.devSpringBoot.awesome.error.ValidationErrorDetails;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rfnException){
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .titulo("Resource not found")
                .detalhes(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
                                                          HttpHeaders headers,
                                                          HttpStatus status,
                                                          WebRequest request) {
        List<FieldError> fieldError = manvException.getBindingResult().getFieldErrors();
        String fields = fieldError.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldMessage =  fieldError.stream().map(FieldError::getField).collect(Collectors.joining(","));
        ValidationErrorDetails rnfDetails = ValidationErrorDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .titulo("Resource not found")
                .detalhes("Resource not found")
                .developerMessage(manvException.getClass().getName())
                .field(fields)
                .fielMessage(fieldMessage)
                .build();
        return new ResponseEntity<>(rnfDetails, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(status.value())
                .titulo("Internal Exception")
                .detalhes(ex.getClass().getName())
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity<>(errorDetails, headers, status);
    }
}

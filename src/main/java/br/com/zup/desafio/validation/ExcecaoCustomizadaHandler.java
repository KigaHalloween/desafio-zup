package br.com.zup.desafio.validation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ExcecaoCustomizadaHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponse exceptionResponse =  new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), recuperarMensagem(ex));
        return new ResponseEntity<>(exceptionResponse, Optional.ofNullable(status).orElse(HttpStatus.BAD_REQUEST));
    }

    @ResponseBody
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ExceptionResponse> handleBaseException(HttpServletRequest req, RuntimeException exception) {
        ResponseStatus responseStatusAnnotation = exception.getClass().getAnnotation(ResponseStatus.class);

        ExceptionResponse exceptionResponse =  new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return new ResponseEntity<>(exceptionResponse, Optional.ofNullable(responseStatusAnnotation.value()).orElse(HttpStatus.BAD_REQUEST));
    }

    private String recuperarMensagem(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining("<br>"));
    }
}

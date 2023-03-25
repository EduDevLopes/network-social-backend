package com.pieropan.networksocial.exception;

import feign.FeignException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity badCredentialsException(){

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Senha inválida!");
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ResponseEntity internalAuthenticationServiceException(){

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuário não encontrado!");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(){

        FieldError fieldError = new FieldError("login","login","Login já existe. Tente outro");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new DadosErroValidacao(fieldError));
    }

    @ExceptionHandler(FeignException.Forbidden.class)
    public ResponseEntity feignExceptionForbidden(){
        // implementar mensageria
        return ResponseEntity.ok().build();
    }

    private record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
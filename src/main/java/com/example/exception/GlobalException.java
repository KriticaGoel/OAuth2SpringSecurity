package com.example.exception;

import com.example.dto.ExceptionDto;
import com.example.utility.enums.ExceptionStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionDto> handleUserAlreadyExistException(UserAlreadyExistException ex){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(ex.getMessage());
        dto.setStatus(ExceptionStatus.Fail.name());

        return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dto);

    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleUsernameNotFoundException(UsernameNotFoundException ex){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(ex.getMessage());
        dto.setStatus(ExceptionStatus.Fail.name());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);

    }

    @ExceptionHandler(PasswordValidationFail.class)
    public ResponseEntity<ExceptionDto> handlePasswordValidationFail(PasswordValidationFail ex){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(ex.getMessage());
        dto.setStatus(ExceptionStatus.Fail.name());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);

    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<ExceptionDto> handleValidateException(ValidateException ex){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(ex.getMessage());
        dto.setStatus(ExceptionStatus.Fail.name());

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);

    }

    @ExceptionHandler(TokenInvalidException.class)
    public ResponseEntity<ExceptionDto> handleTokenInvalidException(TokenInvalidException ex){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(ex.getMessage());
        dto.setStatus(ExceptionStatus.Fail.name());

        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dto);

    }
}

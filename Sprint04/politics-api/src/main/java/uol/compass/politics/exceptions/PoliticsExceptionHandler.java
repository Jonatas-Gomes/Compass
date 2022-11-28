package uol.compass.politics.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class PoliticsExceptionHandler extends ResponseEntityExceptionHandler {
    private final MessageSource messageSource;

    /*public ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
        List<ErrorResponseDto> listErrorDto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorResponseDto erro = new ErrorResponseDto(e.getField(), message);
            listErrorDto.add(erro);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listErrorDto);
    }*/
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorResponseDto> listErrorDto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorResponseDto erro = new ErrorResponseDto(e.getField(), message);
            listErrorDto.add(erro);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listErrorDto);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException exception){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), "Entidade não encontrada!",exception.getCause());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity allExceptions(Exception exception){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), exception.getCause().getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    /*
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException exception){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), "Entidade não encontrada!",exception.getCause());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception, HttpHeaders headers, HttpStatus status, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), "Metodo HTTP não suportado",exception.getCause());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), "Ausência da path variable",exception.getCause());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
    */
}

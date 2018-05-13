package by.vino.mygarage.config;

import by.vino.mygarage.exception.RestException;
import by.vino.mygarage.exception.RestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;
import java.util.Objects;

@ControllerAdvice
public class MyExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    private static final String DEBUG_MESSAGE = "ERROR: %s";
    private static final int VALID_EXCEPTION_CODE = 911;

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(RestException.class)
    public ResponseEntity<RestMessage> handleRestException(RestException ex, Locale locale) {
        String errorMessage = messageSource.getMessage(ex.getCode(), null, locale);
        String error = messageSource.getMessage(ex.getCode(), null, Locale.US);
        logger.error(String.format(DEBUG_MESSAGE, error));
        return new ResponseEntity<>(new RestMessage(400, errorMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestMessage> invalidInput(MethodArgumentNotValidException ex, Locale locale) {
        BindingResult result = ex.getBindingResult();
        String errorMessage = messageSource.getMessage(
                Objects.requireNonNull(result.getAllErrors().get(0).getDefaultMessage()), null, locale);
        logger.error(errorMessage);
        return new ResponseEntity<>(new RestMessage(VALID_EXCEPTION_CODE, errorMessage), HttpStatus.BAD_REQUEST);
    }

}
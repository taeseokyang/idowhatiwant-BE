package yang.idowhatiwant.domain.text.exception;

import yang.idowhatiwant.global.config.exception.ApplicationException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static yang.idowhatiwant.domain.text.presentation.constant.ResponseMessage.TEXT_NOT_FOUND;

public class TextNotFoundException extends ApplicationException {
    public TextNotFoundException() {
        super(NOT_FOUND.value(), TEXT_NOT_FOUND.getMessage());
    }
}
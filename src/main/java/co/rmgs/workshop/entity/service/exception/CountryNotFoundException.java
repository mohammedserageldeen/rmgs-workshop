package co.rmgs.workshop.entity.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(String msg) {
        super(msg);
    }
}

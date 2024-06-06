package mmd.assignment.dpa_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SubscriberNotFoundException extends RuntimeException {
    public SubscriberNotFoundException(String message) {
        super(message);
    }
}

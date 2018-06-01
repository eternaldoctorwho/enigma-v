package server.machine;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
class EnigmaMachineException extends RuntimeException {
    EnigmaMachineException(String message) {
        super(message);
    }
}

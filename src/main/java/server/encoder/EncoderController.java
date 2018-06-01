package server.encoder;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.machine.EnigmaMachine;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class EncoderController {

    @PutMapping(path="/encode", produces=APPLICATION_JSON_UTF8_VALUE)
    public EncoderResponse encode(@RequestBody String encryptedText) {
        EncoderResponse response =  new EncoderResponse();

        EnigmaMachine machine = new EnigmaMachine();
        response.setText("encrypted: " + machine.encode(encryptedText));

        return response;
    }
}

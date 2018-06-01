package server.decoder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecoderController {

    @RequestMapping("/decode")
    public DecoderResponse decode() {
        DecoderResponse response = new DecoderResponse();
        response.setText("decoded plaintext");
        return response;
    }
}

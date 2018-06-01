package server.encoder;

import lombok.Data;

@Data
class EncoderResponse {
    private String text;
    private String error;
}

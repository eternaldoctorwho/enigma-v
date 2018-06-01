package server.decoder;

import lombok.Data;

@Data
class DecoderResponse {
    private String text;
    private String error;
}

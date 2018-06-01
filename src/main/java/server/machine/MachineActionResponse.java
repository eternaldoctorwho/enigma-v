package server.machine;

import lombok.Data;

@Data
class MachineActionResponse {
    private String status;
    private String reason;
}

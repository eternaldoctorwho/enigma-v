package server.machine;

import lombok.Data;

import java.util.Map;

@Data
class MachineDetailsResponse {

    private Map<String, Gear> gears;

    MachineDetailsResponse(EnigmaMachine machine) {
        this.setGears(machine.getGears());
    }
}

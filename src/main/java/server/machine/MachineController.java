package server.machine;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MachineController {

    private static EnigmaMachine machine = new EnigmaMachine();

    @DeleteMapping(path="/machine")
    public void clearMachine() {
        machine = new EnigmaMachine();
    }

    @GetMapping(path="/machine")
    public MachineDetailsResponse getMachine() {
        return new MachineDetailsResponse(machine);
    }

    @PostMapping(path="/gear")
    public void addGear(@RequestBody Gear gear) {
        machine.addGear(gear);
    }

    @DeleteMapping(path="/gear")
    public void deleteGear(@RequestParam String gearId) {
        machine.deleteGear(gearId);
    }

    @PutMapping(path="/arrange-gears")
    public void arrangeGears(@RequestBody List<String> gearSequence) {
        machine.arrangeGears(gearSequence);
    }

    @PostMapping(path="/codeword")
    public void setCodeword(@RequestBody String codeword) {
        machine.setCodeword(codeword);
    }
}

package server.machine;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.reactivex.Observable.fromIterable;
import static server.machine.Gear.SYMBOL_COUNT;

@Data
public class EnigmaMachine {
    private Map<String, Gear> gears = new HashMap<>();
    private String codeword = "";

    Set<String> getGearIds() {
        return gears.keySet();
    }

    Integer getGearCount() {
        return gears.size();
    }

    void addGear(Gear gear) {
        String newId = gear.getId();
        String newSymbols = gear.getSymbols();
        if (gear.getId().isEmpty()) {
            throw new EnigmaMachineException("No gear ID was given");
        } else if (newSymbols.isEmpty()) {
            throw new EnigmaMachineException("No gear symbols were given");
        } else if (newSymbols.length() != SYMBOL_COUNT) {
            throw new EnigmaMachineException("Gear symbols must be " + SYMBOL_COUNT + " characters in length");
        } else if (this.getGearIds().contains(newId)) {
            throw new EnigmaMachineException("Gear " + newId + " already exists");
        } else {
            gears.put(gear.getId(), gear);
        }
    }

    void deleteGear(String gearId) {
        if (!this.getGearIds().contains(gearId)) {
            throw new EnigmaMachineException("Gear " + gearId + " does not exist");
        } else {
            gears.remove(gearId);
        }
    }

    void arrangeGears(List<String> gearIds) {
        if (gearIds.size() != this.getGearCount()) {
            throw new EnigmaMachineException("There are " + this.getGearCount() + " gears, but " + gearIds.size() + " were given");
        } else if (fromIterable(gearIds).distinct().count().blockingGet() != gearIds.size()) {
            throw new EnigmaMachineException("Duplicates were found in the given set of gear IDs");
        } else if (!this.gears.keySet().containsAll(gearIds)) {
            throw new EnigmaMachineException("Given gears IDs do not match existing gears");
        } else {
            Map<String, Gear> sortedGears = new HashMap<>();
            gearIds.forEach(gearId -> sortedGears.put(gearId, this.gears.get(gearId)));
            this.gears = sortedGears;
        }
    }

    void setCodeword(String codeword) {
        if (codeword.length() != this.getGearCount()) {
            throw new EnigmaMachineException("Incorrect codeword length - must be " + this.getGearCount());
        } else {
            this.codeword = codeword;
            //TODO - Check that all codeword chars are in each gear.  Can the given codeword be set?
        }
    }

    public String encode(String plainText) {
        //TODO
        return "";
    }

    public String decode(String encryptedText) {
        //TODO
        return "";
    }

}

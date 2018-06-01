package server.machine;

import lombok.Data;

@Data
class Gear {
    public static final Integer SYMBOL_COUNT = 37;

    private static final Integer TOP_POINTER = 0;
    private static final Integer BOTTOM_POINTER = 10;

    private String symbols;
    private String id;
}

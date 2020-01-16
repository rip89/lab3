package com.company.entity;

public enum Location {
    KITCHEN,
    DINING_ROOM,
    BATHROOM,
    BEDROOM,
    LIVING_ROOM,
    HALL,
    STAIRWAY,
    FURNITURE;

    @Override
    public String toString() {
        switch (this) {
            case KITCHEN: return "кухня";

            case DINING_ROOM:
                return "столовая";
            case BATHROOM:
                return "ванная";
            case BEDROOM:
                return "спальня";
            case LIVING_ROOM:
                return "гостиная";
            case HALL:
                return "прихожая";
            case STAIRWAY:
                return "лестничная площадка";
            case FURNITURE:
                return "мебель";
            default: return "???";
        }
    }
}

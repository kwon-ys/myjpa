package com.kys.myjpa.rentcar;

public enum VehicleStatus {
    Free(0),
    Reserved(1),
    Rented(2),
    Broken(3),
    Fixing(4);

    private final Integer value;

    VehicleStatus(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return this.value;
    }

    public static VehicleStatus integerOf(Integer value) {
        for (VehicleStatus item : VehicleStatus.values()) {
            if (value.equals(item.getValue())) {
                return item;
            }
        }
        throw new IllegalArgumentException("Error !, VehicleStatus not a value :" + value);
    }
}

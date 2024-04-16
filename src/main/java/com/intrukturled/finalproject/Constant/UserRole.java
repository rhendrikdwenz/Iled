package com.intrukturled.finalproject.Constant;

public enum UserRole {
    ADMIN(1),
    PARTICIPANT(2),
    TRAINER(3);

    private final int id;

    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}



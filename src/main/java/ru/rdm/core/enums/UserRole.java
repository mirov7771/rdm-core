package ru.rdm.core.enums;

import lombok.Getter;

@Getter
public enum UserRole {

    CLIENT("client"),
    ADMIN("admin");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}

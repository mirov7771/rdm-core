package ru.rdm.core.enums;

import lombok.Getter;

@Getter
public enum OtpType {

    LOGIN("login");

    private final String type;

    OtpType(String type) {
        this.type = type;
    }
}

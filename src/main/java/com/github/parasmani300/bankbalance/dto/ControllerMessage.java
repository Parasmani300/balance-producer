package com.github.parasmani300.bankbalance.dto;

public class ControllerMessage {

    String message;

    public ControllerMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

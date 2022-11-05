package com.github.parasmani300.bankbalance.dto;

public class SampleDto {

    String name;
    Integer balance;
    String timestamp;

    public SampleDto(String name, Integer balance, String timestamp) {
        this.name = name;
        this.balance = balance;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

package com.pb.petriaievB.hw8;

public class WrongLoginException extends Exception {
    private String login;
    public WrongLoginException(String login) {
        this.login = login;
    }
}
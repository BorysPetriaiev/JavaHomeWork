package com.pb.petriaievB.hw8;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Пароль указан неверно!");
    }
}
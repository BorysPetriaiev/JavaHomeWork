package com.pb.petriaievB.hw8;

public class OnlineShop {
    public static void main(String[] args) {
        Auth test = new Auth();
        try {
            test.signUp();
        } catch (WrongLoginException e1) {
            System.out.println("Логин должен быть от 5 до 20 символов " +
                    "\nи состоять только из латинских букв и чисел!");
            return;
        } catch (WrongPasswordException e2) {
            System.out.println("Пароль должен быть от 5 до 20 символов " +
                    "\nи состоять только из латинских букв, чисел и подчеркивания!");
            return;
        }
        try {
            test.signIn();
        } catch (WrongLoginException e3) {
            System.out.println("Неверный логин или пароль!");
        }
    }
}
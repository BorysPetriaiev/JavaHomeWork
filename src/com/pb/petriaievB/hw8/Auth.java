package com.pb.petriaievB.hw8;
import java.util.*;
public class Auth {
    private String username;
    private String password;
    private String confirmPassword;
    HashMap<String, String> userData = new HashMap<String, String>();
    public String getUsername() {
        return username;
    }
    public  String getPassword() {
        return password;
    }
    public boolean isLatin(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }
    // регистрация
    public void signUp() throws WrongLoginException,
            WrongPasswordException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Добро пожаловать! Для начала, Вам необходимо " +
                "пройти регистрацию.");
        System.out.println("Введите логин: ");
        username = scan.nextLine();
        boolean correct_username = false;
        // проверка логина
        char[] un = getUsername().toLowerCase().toCharArray();
        if (un.length >= 5 && un.length <= 20)
            for (char ch : un) {
                if (isLatin(ch) || Character.isDigit(ch)) {
                    correct_username = true;
                } else throw new WrongLoginException(username);
            }
        else throw new WrongLoginException(username);
        System.out.println("Введите пароль: ");
        password = scan.nextLine();
        System.out.println("Повторите пароль: ");
        confirmPassword = scan.nextLine();
        boolean correct_password = false;
        // проверка пароля
        char[] pw = getPassword().toLowerCase().toCharArray();
        if ((pw.length >= 5 && pw.length <= 20)
                && confirmPassword.equals(password)) {
            for (char ch : pw) {
                if (isLatin(ch) || Character.isDigit(ch) || ch == '_') {
                    correct_password = true;
                } else throw new WrongPasswordException();
            }
        } else throw new WrongPasswordException();
        if (correct_password && correct_username) {
            userData.put(username, password);
        }
    }
    // авторизация
    public void signIn() throws WrongLoginException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Пожалуйста, войдите в учетную запись.");
        System.out.println("Введите логин: ");
        String username_in = scan.nextLine();
        System.out.println("Введите пароль: ");
        String password_in = scan.nextLine();
        if (userData.containsValue(password_in) &&
                userData.containsKey(username_in))
            System.out.println("Добро пожаловать. Снова.");
        else throw new WrongLoginException(username_in);
    }
}
package ru.itgirlschool.week10.entity;

import ru.itgirlschool.week10.exception.WrongLoginException;
import ru.itgirlschool.week10.exception.WrongLoginOrPasswordException;
import ru.itgirlschool.week10.exception.WrongPasswordException;

import java.util.HashMap;

public class Account {
    private String login;
    private String password;
    private HashMap<String, String> logAndPass;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, String> getLogAndPass() {
        return logAndPass;
    }

    public void setLogAndPass(HashMap<String, String> logAndPass) {
        this.logAndPass = logAndPass;
    }

    public void checkLogin(String login) {
        if (login != null && login.length() > 5 && login.length() < 20) {
            setLogin(login);
        } else {
            try {
                throw new WrongLoginException();
            } catch (WrongLoginException e) {
                System.out.println("Oшибка: длина логина не соответствует требованиям!");
            }
        }
    }

    public void checkPassword(String password, String password1) {
        if (password != null && password.length() > 8 && password.length() < 20 && password.equals(password1)) {
            setPassword(password);
        } else {
            try {
                throw new WrongPasswordException();
            } catch (WrongPasswordException e) {
                System.out.println("Ошибка: длина пароля не соответствует требованиям, либо подтверждение пароля не совпадает с паролем!");
            }
        }
    }

    public void checkLoginAndPassword(String login, String password) {
        HashMap<String, String> logAndPass = new HashMap<>();
        logAndPass.put(login, password);
        if (getLogAndPass().containsKey(login) && getLogAndPass().get(login).equals(logAndPass.get(login))) {
            System.out.println("Вы успешно вошли в аккаунт!");
        } else {
            try {
                throw new WrongLoginOrPasswordException();
            } catch (WrongLoginOrPasswordException e) {
                System.out.println("Ошибка: неверный логин или пароль!");
            }
        }
    }
}
package ru.itgirlschool.week10._main;

import ru.itgirlschool.week10.entity.Account;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();
        HashMap<String, String> logAndPass = new HashMap<>();
        logAndPass.put("AnkaSam", "qwerty123");
        logAndPass.put("SamSamov", "159357258");
        logAndPass.put("Persik", "IHavePaws");
        account.setLogAndPass(logAndPass);

        System.out.println("Логин должен быть больше 5 и меньше 20 символов!");
        System.out.println("Введите логин:");
        String login = sc.nextLine();
        account.checkLogin(login);
        System.out.println();
        System.out.println("Пароль должен быть больше 8 и меньше 20 символов!");
        System.out.println("Введите пароль:");
        String password = sc.nextLine();
        System.out.println("Введите подтверждение пароля:");
        String password1 = sc.nextLine();
        account.checkPassword(password, password1);
        System.out.println();
        account.checkLoginAndPassword(login, password);
    }
}
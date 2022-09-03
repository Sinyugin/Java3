package com.example.javafxchat44.server;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthService implements AuthService {

    private static class UserData {
        private String nick;
        private String login;
        private String password;

        public UserData(String nick, String login, String password) {
            this.nick = nick;
            this.login = login;
            this.password = password;
        }

        public String getNick() {
            return nick;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    private List<UserData> users;

    public InMemoryAuthService() {
//
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from auth ");
            users = new ArrayList<>();
            while (resultSet.next()) {
                String nick = resultSet.getString("nick");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                users.add(new UserData(nick, login, password));
                System.out.println(String.format("%s - %s - %s", nick, login, password )); //подсказка в консоль логина и пароля для проверки ))
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//Старая реализация проверки логина и пароля
//        users = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            users.add(new UserData("nick" + i, "login" + i, "pass" + i));
//        }
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin())
                        && password.equals(user.getPassword()))
                .findFirst()
                .map(UserData::getNick)
                .orElse(null);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Сервис аутентификации остановлен");
    }
}
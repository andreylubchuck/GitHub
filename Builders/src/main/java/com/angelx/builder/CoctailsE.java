package com.angelx.builder;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class CoctailsE {
    public static void main(String[] args) {
        Coctails coctails = new CoctailsBuilder()
                .buildName("Lemon")
                .buildIngridiens(Ingridients.Martiny)
                .buildPrice(10.1)
                .build();
        System.out.println(coctails);
    }
}

enum Ingridients {
    lemone, Tomato, Lime, Juice, Vodka, Martiny, Mint, NULL
}

class Coctails {
    String name;
    Ingridients ingridients;
    double price;

    @Override
    public String toString() {
        return name + " " + ingridients + " " + price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngridients(Ingridients ingridients) {
        this.ingridients = ingridients;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

class CoctailsBuilder {


    String nameb;
    Ingridients ingridientsb = Ingridients.Martiny;
    double priceb = 12;

    CoctailsBuilder buildName(String nameb) {
        this.nameb = nameb;
        return this;
    }

    CoctailsBuilder buildIngridiens(Ingridients ingridientsb) {
        this.ingridientsb = ingridientsb;
        return this;
    }

    CoctailsBuilder buildPrice(Double priceb) {
        this.priceb = priceb;
        return this;
    }

    Coctails build() {
        Connection connection = null;
        String query = "SELECT name FROM menu";


        try {
            connection = DriverManager.getConnection(ConnectToDatabase.URL, ConnectToDatabase.USERNAME, ConnectToDatabase.PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            while (resultSet.next()) {
               String nameb1 = resultSet.getString("name");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        Coctails coctails = new Coctails();
        coctails.setName(nameb);
        coctails.setIngridients(ingridientsb);
        coctails.setPrice(priceb);
        System.out.println(nameb);
        return coctails;
    }
}
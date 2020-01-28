package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("JDBC");
        Airport airport = new Airport( "vardas", "Adresas", "Kaunas");
        String query = "insert into sb_airports (biz_name, address, city)" +
                "values (?,?,?)";
        String url = "jdbc:mysql://localhost:3306/airports";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, airport.getBiz_name());
            preparedStatement.setString(2, airport.getAddress());
            preparedStatement.setString(3, airport.getCity());
            preparedStatement.executeUpdate();

            System.out.println("Pavyko iterpti nauja irasa");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida kuriant nauja irasa");
            e.printStackTrace();
        }
        String query2 = "select * from sb_airports";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query2);
            ResultSet resultSet = preparedStatement.executeQuery(query2);
            List<Airport> airports = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("biz_id");
                String bizName = resultSet.getString("biz_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                airports.add(new Airport(id, bizName, address, city));
            }
            preparedStatement.close();
            connection.close();
            System.out.println("Pavyko atlikti paieska");
            System.out.println(airports);
        } catch (SQLException e) {
            System.out.println("Ivyko klaida atliekant paieska");
            e.printStackTrace();
        }

    }
}

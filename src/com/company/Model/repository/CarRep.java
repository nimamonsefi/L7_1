package com.company.Model.repository;

import com.company.Model.entity.CarEnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarRep implements AutoCloseable{

    private Connection connection;
    private PreparedStatement preparedStatement;

    public CarRep() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nimamonsefi","myjava123");
        connection.setAutoCommit(false);
    }

    public void insert(CarEnt carEnt) throws Exception{
        preparedStatement = connection.prepareStatement("INSERT INTO car(id, name, model, year, color) VALUES (?,?,?,?,?)");
        preparedStatement.setLong(1,carEnt.getId());
        preparedStatement.setString(2,carEnt.getName());
        preparedStatement.setString(3,carEnt.getModel());
        preparedStatement.setLong(4,carEnt.getYear());
        preparedStatement.setString(5,carEnt.getColor());
        preparedStatement.executeUpdate();
    }

    public void update(CarEnt carEnt) throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE car SET name=?, model=?, year=?, color=? WHERE id=?");
        preparedStatement.setString(1,carEnt.getName());
        preparedStatement.setString(2,carEnt.getModel());
        preparedStatement.setLong(3,carEnt.getYear());
        preparedStatement.setString(4,carEnt.getColor());
        preparedStatement.setLong(5,carEnt.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("DELETE FROM car WHERE id=?");
        preparedStatement.setLong(1,id);
        preparedStatement.executeUpdate();
    }

    public List<CarEnt> select() throws Exception{
        preparedStatement = connection.prepareStatement("SELECT * FROM car");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CarEnt> carlist = new ArrayList<>();
        while (resultSet.next()){
            CarEnt carEnt = new CarEnt();
            carEnt.setId(resultSet.getLong("id"));
            carEnt.setName(resultSet.getString("name"));
            carEnt.setModel(resultSet.getString("model"));
            carEnt.setYear(resultSet.getInt("year"));
            carEnt.setColor(resultSet.getString("color"));
            carlist.add(carEnt);
        }
        return carlist;
    }

    public void commit() throws Exception{
        connection.commit();
    }

    public void rollback() throws Exception{
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
     preparedStatement.close();
     connection.close();
    }
}

package com.example.football;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Stack;

public class HelloApplication extends Application {
    private static Stage stg;
    public static Connection dbConnection;
    private static Stack<String> previous = new Stack<String>();

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        primaryStage.setTitle("Login!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeScene(String current, String next) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(next));
        stg.setTitle(next); //home
        stg.getScene().setRoot(root);
        previous.push(current);
    }

    public void goToBack() throws IOException {
        if (!previous.empty()) {
            String top = previous.pop();
            Parent root = FXMLLoader.load(getClass().getResource(top));
            stg.setTitle(top); //home
            stg.getScene().setRoot(root);
        }
    }

    public Connection getDbConnection(){
        return dbConnection;
    }

    public static void main(String[] args) {
        dbConnection = getConnection();
        launch();
    }

    public static Connection getConnection(){
        try {
            String driver =  "com.mysql.cj.jdbc.Driver";
            String databaseurl = "jdbc:mysql://localhost:3306/football?serverTimezone=Asia/Dhaka";
            String username = "root";
            String password = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseurl, username, password);
            System.out.println("Database Connected");
            return conn;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
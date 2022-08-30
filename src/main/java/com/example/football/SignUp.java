package com.example.football;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class SignUp implements Initializable {

    private String current="SignUp.fxml";
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextField email;
    @FXML
    private ComboBox usertype;
    @FXML
    private Button signUp;
    @FXML
    private Button Back;
    @FXML
    private Button Logout;
    @FXML
    private Button Home;
    @FXML
    private Label dispaly;

    HelloApplication h = new HelloApplication();

    ObservableList<String> list = FXCollections.observableArrayList("Guest", "Admin");

    @FXML
    protected void onSignUpButtonClick() throws IOException{
        if (username.getText().toString().isEmpty()){
            dispaly.setText("Username can not be empty.");
        }
        else if(password.getText().toString().isEmpty()){
            dispaly.setText("Password can not be empty.");
        }
        else if(!password.getText().toString().equals(confirmPassword.getText().toString())){
            dispaly.setText("Passwords did not match");
        }
        else{
            Connection conn = h.getDbConnection();
            ResultSet rs = null;
            PreparedStatement pst = null;
            boolean isAdmin = false;

            String sql = "insert into user(username,password,email,isadmin) values(?,?,?,?)";

            try{
                dispaly.setText("");
                pst = conn.prepareStatement(sql);
                pst.setString(1, username.getText().toString());
                pst.setString(2, password.getText().toString());
                pst.setString(3, email.getText().toString());
                if (usertype.getValue().toString().equals("Admin")){
                    isAdmin = true;
                }
                pst.setBoolean(4, isAdmin);

                pst.execute();
                JOptionPane.showMessageDialog(null, "SignUp Successful!");
                h.changeScene(current, "Login.fxml");

            } catch (Exception e){
                dispaly.setText("Signup Error!");
                System.out.println(e);
            }
        }
    }

    @FXML
    protected void onHomeButtonCLick() throws IOException {
        h.changeScene(current,"Home.fxml");
    }
    @FXML
    protected void onLogoutButtonCLick() throws IOException {
        h.changeScene(current,"logout.fxml");
    }
    @FXML
    protected void onBackButtonCLick() throws IOException {
        h.goToBack();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usertype.setItems(list);
        usertype.setValue("Guest");
    }
}

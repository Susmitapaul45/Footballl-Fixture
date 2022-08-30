package com.example.football;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Login implements Initializable {
    HelloApplication h = new HelloApplication();
    Connection conn = h.getDbConnection();
    ResultSet rs = null;
    PreparedStatement pst = null;

    private String current = "login.fxml";
    @FXML
    private Button login;
    @FXML
    private Label loginLabel;
    @FXML
    private TextField username;
    @FXML
    private PasswordField pass;
    @FXML
    private ComboBox userType;
    @FXML
    private Button SignUp;
    @FXML
    private Label NotRegistered;

    private static boolean isAdmin;

    ObservableList<String> list = FXCollections.observableArrayList("Guest", "Admin");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userType.setItems(list);
        userType.setValue("Guest");
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {

        String sql = "SELECT * from user where username = ? and password = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, username.getText().toString());
            pst.setString(2, pass.getText().toString());

            rs = pst.executeQuery();
            if (rs.next()){
                loginLabel.setText("LogIn Successfull!");
                isAdmin = rs.getBoolean(5);

                if (isAdmin && userType.getValue().toString().equals("Admin")) {
                    h.changeScene(current, "Admin.fxml");
                }
                else if (!isAdmin && userType.getValue().toString().equals("Guest")) {
                    h.changeScene(current, "Home.fxml");
                } else {
                    loginLabel.setText("User type does not match.");
                }
            } else {
                loginLabel.setText("Invalid username or password");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    protected void onSignUpButtonClick() throws IOException {
        h.changeScene(current, "SignUp.fxml");
    }

}

package com.example.football;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable{

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

    private static boolean isAdmin;

    ObservableList<String> list = FXCollections.observableArrayList("Guest", "Admin");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userType.setItems(list);
        userType.setValue("Guest");
    }

    public boolean isAdmin(){
        return this.isAdmin;
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        if (userType.getValue().toString().equals("Guest") && username.getText().toString().equals("Susmita") && pass.getText().toString().equals("123")) {
            this.isAdmin = false;
            loginLabel.setText("LogIn Successfull");
            HelloApplication h = new HelloApplication();
            h.changeScene(current,"Home.fxml");

        } else if (userType.getValue().toString().equals("Admin") && username.getText().toString().equals("Admin") && pass.getText().toString().equals("123")) {
            this.isAdmin = true;
            loginLabel.setText("LogIn Successfull");
            HelloApplication h = new HelloApplication();
            h.changeScene(current,"Home.fxml");

        } else if (username.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
            loginLabel.setText("Please input information");
        } else {
            loginLabel.setText("Invalid username or password");
        }

    }
}

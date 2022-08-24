package com.example.football;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Logout {
 @FXML
    private Button logout;

 @FXML
    protected void onLogoutButtonClick() throws IOException {
     HelloApplication h = new HelloApplication();
     h.changeScene("logout.fxml","Login.fxml");
 }
}

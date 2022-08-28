package com.example.football;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ScheduleNewMatch implements Initializable {
    @FXML
    private ComboBox groupSelector;
    @FXML
    private ComboBox teamSelector1;
    @FXML
    private ComboBox teamSelector2;
    @FXML
    private Button home;
    @FXML
    private Button back;
    @FXML
    private Button logout;
    @FXML
    private Button confirm;
    @FXML
    private Label display;
    @FXML
    private DatePicker date;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

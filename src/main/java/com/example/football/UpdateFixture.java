package com.example.football;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class UpdateFixture {
    private String current = "UpdateFixture.fxml";

    @FXML
    private TableView<UpdateFixture> table;

    @FXML
    private TableColumn<UpdateFixture, String> PlayerName;
    @FXML
    private TableColumn<UpdateFixture, Integer> matchPlayed;
    @FXML
    private TableColumn<UpdateFixture, Integer> MaximumGoal;
    @FXML
    private TableColumn<UpdateFixture, Integer> points;
    @FXML
    private Button Home;
    @FXML
    private Button Logout;

    @FXML
    private Button Back;



    @FXML
    protected void onHomeButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"Home.fxml");
    }
    @FXML
    protected void onLogoutButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.changeScene(current,"logout.fxml");
    }
    @FXML
    protected void onBackButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.goToBack();
    }
}

package com.example.football;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Final implements Initializable {
    private String current = "Final.fxml";
    @FXML
    private TableView<GroupSTG> table;

    @FXML
    private TableColumn<GroupSTG, String> teamName1;
    @FXML
    private TableColumn<GroupSTG, String> teamName2;
    @FXML
    private TableColumn<GroupSTG, String>date;
    @FXML
    private TableColumn<GroupSTG, String>time;

    @FXML
    private Button Home;
    @FXML
    private Button Logout;
    @FXML
    private Button Back;

    ObservableList<GroupSTG> list = FXCollections.observableArrayList(
            new GroupSTG("TBD", "TBD", "18 December,2022","1:00 AM")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        teamName1.setCellValueFactory(new PropertyValueFactory<GroupSTG, String>("teamName1"));
        teamName2.setCellValueFactory(new PropertyValueFactory<GroupSTG, String>("teamName2"));
        date.setCellValueFactory(new PropertyValueFactory<GroupSTG, String>("date"));
        time.setCellValueFactory(new PropertyValueFactory<GroupSTG, String>("time"));

        table.setItems(list);
    }

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

    public void OnBackButtonClick(ActionEvent event) throws IOException {
        HelloApplication h = new HelloApplication();
        h.goToBack();
    }
}

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

public class GroupStage implements Initializable {

    private String current = "GroupStage.fxml";
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
            new GroupSTG("South Korea", "Chilly", "20 November,2022","10:00 PM"),
            new GroupSTG("Ecuador", "Senegal", "21 November,2022","7:00 PM"),
            new GroupSTG("England", "Iran", "22 November,2022","1:00 AM"),
            new GroupSTG("USA", "Wales", "23 November,2022","4:00 PM"),
            new GroupSTG("Argentina", "Saudi Arabia", "24 November,2022","7:00 PM"),
            new GroupSTG("Denmark", "Tunisia", "25 November,2022","1:00 AM"),
            new GroupSTG("Mexico", "Poland", "26 November,2022","10:00 PM"),
            new GroupSTG("France", "Australia", "24 November,2022","7:00 PM"),
            new GroupSTG("Morocco", "Croatia", "25 November,2022","1:00 AM"),
            new GroupSTG("Germany", "Japan", "26 November,2022","4:00 PM"),
            new GroupSTG("Spain", "Chilly", "27 November,2022","7:00 PM"),
            new GroupSTG("Belgium", "Canada", "28 November,2022","10:00 PM"),
            new GroupSTG("Switzerland", "Cameroon", "29 November,2022","1:00 PM"),
            new GroupSTG("Brazil", "Serbia", "30 November,2022","4:00 PM"),
            new GroupSTG("Portugal", "Ghana", "1 December,2022","7:00 PM"),
            new GroupSTG("Uruguay", "South Korea", "2 December,2022","1:00 PM")


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

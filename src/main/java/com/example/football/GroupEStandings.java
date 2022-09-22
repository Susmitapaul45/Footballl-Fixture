package com.example.football;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GroupEStandings implements Initializable {
    private String current = "GroupEStandings.fxml";
    @FXML
    private TableView<GroupStandingsData> table;

    @FXML
    private TableColumn<GroupStandingsData, String> name;
    @FXML
    private TableColumn<GroupStandingsData, Integer> matchPlayed;
    @FXML
    private TableColumn<GroupStandingsData, Integer> won;
    @FXML
    private TableColumn<GroupStandingsData, Integer> lose;
    @FXML
    private TableColumn<GroupStandingsData, Integer> draw;
    @FXML
    private TableColumn<GroupStandingsData, Integer> points;
    @FXML
    private Button Home;
    @FXML
    private Button Logout;
    @FXML
    private Button Back;
//    ObservableList<GroupStandingsData> list = FXCollections.observableArrayList(
//            new GroupStandingsData("Mexico", 3, 3, 0, 0, 9),
//            new GroupStandingsData("Brazil", 2, 2, 0, 0, 10),
//            new GroupStandingsData("Japan", 3, 0, 3, 1, 3),
//            new GroupStandingsData("Portugal", 6, 4, 2, 0, 8)
//    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, String>("teamName"));
        matchPlayed.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("matchPlayed"));
        won.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("won"));
        lose.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("lose"));
        draw.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("draw"));
        points.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("points"));

        CurrentStanding c = new CurrentStanding();
        table.setItems(c.getStandings("GroupE"));
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
    @FXML
    protected void onBackButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.goToBack();
    }


}

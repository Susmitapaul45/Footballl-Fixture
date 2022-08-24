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

public class GroupAStandings implements Initializable {

    private String current = "GroupAStandings.fxml";

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

    ObservableList<GroupStandingsData> list = FXCollections.observableArrayList(
            new GroupStandingsData("Uruguay", 0, 0, 0, 0, 0),
            new GroupStandingsData("Brazil", 0, 0, 0, 0, 0),
            new GroupStandingsData("Chin", 0, 0, 0, 0, 0),
            new GroupStandingsData("Italy", 0, 0, 0, 0, 0)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Login l = new Login();
        if (l.isAdmin()) {
            name.setEditable(true);
            matchPlayed.setEditable(true);
            won.setEditable(true);
            lose.setEditable(true);
            draw.setEditable(true);
            points.setEditable(true);
        } else{
            name.setEditable(false);
            matchPlayed.setEditable(false);
            won.setEditable(false);
            lose.setEditable(false);
            draw.setEditable(false);
            points.setEditable(false);
        }

        name.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, String>("teamName"));
        matchPlayed.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("matchPlayed"));
        won.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("won"));
        lose.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("lose"));
        draw.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("draw"));
        points.setCellValueFactory(new PropertyValueFactory<GroupStandingsData, Integer>("points"));
        table.setEditable(true);
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

    @FXML
    protected void onBackButtonCLick() throws IOException {
        HelloApplication h = new HelloApplication();
        h.goToBack();
    }
}

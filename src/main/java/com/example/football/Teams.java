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

public class Teams implements Initializable {

    private String current = "Teams.fxml";
    @FXML
    private TableView<TeamsData> table;

    @FXML
    private TableColumn<TeamsData, String> TeamName;
    @FXML
    private TableColumn<TeamsData, String> CoachName;
    @FXML
    private TableColumn<TeamsData, Integer>FIFARanking;
    @FXML
    private TableColumn<TeamsData, Integer>Trophies;

    @FXML
    private Button Home;
    @FXML
    private Button Logout;
    @FXML
    private Button Back;

    ObservableList<TeamsData> list = FXCollections.observableArrayList(
      new TeamsData("Argentina","Lionel Scallion",3,2),
      new TeamsData("Brazil","Adenor Leonardo Bacchi",1,5),
      new TeamsData("Qatar","Felix Sanchez Bas",49,0),
      new TeamsData("Germany","Hansi Flick",3,2),
      new TeamsData("France","Didier Deschamps",5,2),
      new TeamsData("Spain"," Luis Enrique",8,1)

    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TeamName.setCellValueFactory(new PropertyValueFactory<TeamsData, String>("TeamName"));
        CoachName.setCellValueFactory(new PropertyValueFactory<TeamsData, String>("CoachName"));
        FIFARanking.setCellValueFactory(new PropertyValueFactory<TeamsData, Integer>("FIFARanking"));
        Trophies.setCellValueFactory(new PropertyValueFactory<TeamsData, Integer>("Trophies"));


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

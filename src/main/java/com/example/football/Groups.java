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

public class Groups implements Initializable {

    private String current = "Groups.fxml";
    @FXML
    private TableView<GroupsData> table;

    @FXML
    private TableColumn<GroupsData, String> GroupA;
    @FXML
    private TableColumn<GroupsData, String> GroupB;
    @FXML
    private TableColumn<GroupsData, String>GroupC;
    @FXML
    private TableColumn<GroupsData, String>GroupD;
    @FXML
    private TableColumn<GroupsData, String>GroupE;
    @FXML
    private TableColumn<GroupsData, String>GroupF;
    @FXML
    private TableColumn<GroupsData, String>GroupG;
    @FXML
    private TableColumn<GroupsData, String>GroupH;

    @FXML
    private Button Home;
    @FXML
    private Button Logout;
    @FXML
    private Button Back;

    ObservableList<GroupsData> list = FXCollections.observableArrayList(

            new GroupsData("Qatar","England","Argentina","France","Spain","Belgium","Brazil","Portugal"),
            new GroupsData("Ecuador","Iran","Saudi Arabia","Australia","Cost Rica","Canada","Serbia","Ghana"),
            new GroupsData("Senegal","USA","Mexico","Denmark","Germany","Morocco","Switzerland","Uruguay"),
            new GroupsData("Netherlands","Wales","Poland","Tunisia","Japan","Croatia","Cameron","Korea")


    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GroupA.setCellValueFactory(new PropertyValueFactory<GroupsData, String>("GroupA"));
        GroupB.setCellValueFactory(new PropertyValueFactory<GroupsData, String>("GroupB"));
        GroupC.setCellValueFactory(new PropertyValueFactory<GroupsData, String>("GroupC"));
        GroupD.setCellValueFactory(new PropertyValueFactory<GroupsData, String>("GroupD"));
        GroupE.setCellValueFactory(new PropertyValueFactory<GroupsData, String>("GroupE"));
        GroupF.setCellValueFactory(new PropertyValueFactory<GroupsData, String>("GroupF"));
        GroupG.setCellValueFactory(new PropertyValueFactory<GroupsData, String>("GroupG"));
        GroupH.setCellValueFactory(new PropertyValueFactory<GroupsData, String>("GroupH"));


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

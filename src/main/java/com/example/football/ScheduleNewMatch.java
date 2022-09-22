package com.example.football;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScheduleNewMatch implements Initializable {

    private String current = "ScheduleNewMatch.fxml";
    HelloApplication h = new HelloApplication();
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
    private TextField time;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList( "GroupA", "GroupB","GroupC","GroupD","GroupE","GroupF","GroupG","GroupH");
        groupSelector.setItems(list);
        groupSelector.setValue(list.get(0));
        teamSelector1.setItems(getGroupATeams());
        teamSelector2.setItems(getGroupATeams());
        teamSelector1.setValue(getGroupATeams().get(0));
        teamSelector2.setValue(getGroupATeams().get(1));
        date.setValue(LocalDate.now());
    }

    @FXML
    protected void onConfirmButtonClick(){

        if(!isValidTime(time.getText().toString())){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Invalid input");
            errorAlert.setContentText("Please input a valid time in 00:00 to 23:59 range");
            errorAlert.showAndWait();
            return;
        }

        try{
            Connection conn = h.getDbConnection();
            ResultSet rs = null;
            PreparedStatement pst = null;

            String sql = "insert into schedule(date,group_name,team1,team2,time) values(?,?,?,?,?)";

            java.util.Date newDate = java.util.Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDate = new java.sql.Date(newDate.getTime());

            pst = conn.prepareStatement(sql);
            pst.setDate(1, sqlDate);
            pst.setString(2, groupSelector.getValue().toString());
            pst.setString(3, teamSelector1.getValue().toString());
            pst.setString(4, teamSelector2.getValue().toString());
            pst.setString(5, time.getText().toString());

            pst.execute();
            JOptionPane.showMessageDialog(null, "A Match scheduled Successful!");
            h.changeScene(current, "MatchSchedule.fxml");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private boolean isValidTime(String t){
        String regex = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$";

        Pattern p = Pattern.compile(regex);
        if (t == null){
            return false;
        }
        Matcher m = p.matcher(t);

        return m.matches();
    }

    @FXML
    protected void onGroupSelectorChange() {
//        teamSelector1.setItems(getAllTeams());
//        teamSelector2.setItems(getAllTeams());
//        teamSelector1.setValue(getAllTeams().get(0));
//        teamSelector2.setValue(getAllTeams().get(1));

       if(groupSelector.getValue().toString().equals("GroupA")){
            teamSelector1.setItems(getGroupATeams());
            teamSelector2.setItems(getGroupATeams());
            teamSelector1.setValue(getGroupATeams().get(0));
            teamSelector2.setValue(getGroupATeams().get(1));
        }
        else if(groupSelector.getValue().toString().equals("GroupB")){
            teamSelector1.setItems(getGroupBTeams());
            teamSelector2.setItems(getGroupBTeams());
            teamSelector1.setValue(getGroupBTeams().get(0));
            teamSelector2.setValue(getGroupBTeams().get(1));
        }
        else if(groupSelector.getValue().toString().equals("GroupC")){
            teamSelector1.setItems(getGroupCTeams());
            teamSelector2.setItems(getGroupCTeams());
            teamSelector1.setValue(getGroupCTeams().get(0));
            teamSelector2.setValue(getGroupCTeams().get(1));
        }
        else if(groupSelector.getValue().toString().equals("GroupD")){
            teamSelector1.setItems(getGroupDTeams());
            teamSelector2.setItems(getGroupDTeams());
            teamSelector1.setValue(getGroupDTeams().get(0));
            teamSelector2.setValue(getGroupDTeams().get(1));
        }
        else if(groupSelector.getValue().toString().equals("GroupE")){
            teamSelector1.setItems(getGroupETeams());
            teamSelector2.setItems(getGroupETeams());
            teamSelector1.setValue(getGroupETeams().get(0));
            teamSelector2.setValue(getGroupETeams().get(1));
        }
        else if(groupSelector.getValue().toString().equals("GroupF")){
            teamSelector1.setItems(getGroupFTeams());
            teamSelector2.setItems(getGroupFTeams());
            teamSelector1.setValue(getGroupFTeams().get(0));
            teamSelector2.setValue(getGroupFTeams().get(1));
        }
        else if(groupSelector.getValue().toString().equals("GroupG")){
            teamSelector1.setItems(getGroupGTeams());
            teamSelector2.setItems(getGroupGTeams());
            teamSelector1.setValue(getGroupGTeams().get(0));
            teamSelector2.setValue(getGroupGTeams().get(1));
        }
        else if(groupSelector.getValue().toString().equals("GroupH")){
            teamSelector1.setItems(getGroupHTeams());
            teamSelector2.setItems(getGroupHTeams());
            teamSelector1.setValue(getGroupHTeams().get(0));
            teamSelector2.setValue(getGroupHTeams().get(1));
        }
    }

    private ObservableList<String> getAllTeams(){
        ObservableList<String> t = FXCollections.observableArrayList("Qatar", "Ecuador", "Senegal", "Netherlands",
                "England", "Iran", "USA", "Wales",
                "Argentina", "Saudi Arabia", "Mexico", "Poland",
                "France", "Australia", "Denmark", "Tunisia",
                "Spain", "Costa Rica", "Germany", "Japan",
                "Belgium", "Canada", "Morcocco", "Croatia",
                "Serbia", "Switzerland", "Cameroon", "Brazil",
                "South Korea", "Portugal", "Ghana", "Uruguay"
        );
        return t;
    }

    private ObservableList<String> getGroupATeams(){
        ObservableList<String> t = FXCollections.observableArrayList("Qatar", "Ecuador", "Senegal", "Netherlands");
        return t;
    }

    private ObservableList<String> getGroupBTeams(){
        ObservableList<String> t = FXCollections.observableArrayList("England", "Iran", "USA", "Wales");
        return t;
    }
    private ObservableList<String> getGroupCTeams(){
        ObservableList<String> t = FXCollections.observableArrayList("Argentina", "Saudi Arabia", "Mexico", "Poland");
        return t;
    }
    private ObservableList<String> getGroupDTeams(){
        ObservableList<String> t = FXCollections.observableArrayList("France", "Australia", "Denmark", "Tunisia");
        return t;
    }
    private ObservableList<String> getGroupETeams(){
        ObservableList<String> t = FXCollections.observableArrayList("Spain", "Costa Rica", "Germany", "Japan");
        return t;
    }
    private ObservableList<String> getGroupFTeams(){
        ObservableList<String> t = FXCollections.observableArrayList("Belgium", "Canada", "Morcocco", "Croatia");
        return t;
    }
    private ObservableList<String> getGroupGTeams(){
        ObservableList<String> t = FXCollections.observableArrayList("Serbia", "Switzerland", "Cameroon", "Brazil");
        return t;
    }
    private ObservableList<String> getGroupHTeams(){
        ObservableList<String> t = FXCollections.observableArrayList("South Korea", "Portugal", "Ghana", "Uruguay");
        return t;
    }

    @FXML
    protected void onHomeButtonClick() throws IOException{
        h.changeScene(current, "Home.fxml");
    }
    @FXML
    protected void  onBackButtonClick() throws IOException{
        h.goToBack();

    }
    @FXML
    protected void onLogoutButtonClick() throws IOException{
        h.changeScene(current,"Logout.fxml");
    }


}

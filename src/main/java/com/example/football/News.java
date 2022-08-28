package com.example.football;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;



public class News {

    private String current = "News.fxml";
    @FXML
    private Button Home;
    @FXML
    private Button Logout;
    @FXML
    private Button Back;
    @FXML
    private Hyperlink hyperlink1;
    @FXML
    private Hyperlink hyperlink2;
    @FXML
    private Hyperlink hyperlink3;
    @FXML
    private Hyperlink hyperlink4;
    @FXML
    private Hyperlink hyperlink5;
    @FXML
    private Hyperlink hyperlink6;



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
    @FXML
    void openLink1(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("link clicked!");
        Desktop Desktop = null;
        Desktop.getDesktop().browse(new URI("http://eurasiantimes.com/first-eurofighter-typhoon-handed-over-to-qatar-will-guard/"));
    }
    @FXML
    void openLink2(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("link clicked!");
       Desktop Desktop = null;
        Desktop.getDesktop().browse(new URI("https://www.thedailystar.net/sports/football/news/brazil-play-ghana-tunisia-pre-world-cup-friendlies-3099046"));
    }
    @FXML
    void openLink3(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("link clicked!");
        Desktop Desktop = null;
        Desktop.getDesktop().browse(new URI("https://bdnews24.com/sport/flwlpigcow"));
    }
    @FXML
    void openLink4(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("link clicked!");
        Desktop Desktop = null;
        Desktop.getDesktop().browse(new URI("https://www.theguardian.com/sport/the-nightwatchman/2022/aug/19/joy-falling-love-farm-italy-england-cricket-world-cup"));
    }
    @FXML
    void openLink5(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("link clicked!");
        Desktop Desktop = null;
        Desktop.getDesktop().browse(new URI("https://www.football-espana.net/2022/08/18/sevilla-forward-suffers-devastating-injury-and-ends-world-cup-hopes"));
    }
    @FXML
    void openLink6(ActionEvent event) throws URISyntaxException, IOException {
        System.out.println("link clicked!");
        Desktop Desktop = null;
        Desktop.getDesktop().browse(new URI("https://thepeninsulaqatar.com/article/20/08/2022/fifa-releases-second-official-soundtrack-for-qatar-2022"));
    }

}

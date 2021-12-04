package Scenes;

import java.awt.Color;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.Pos;

public class About {
    Stage primaryStage;
    VBox gridAbout = new VBox();
    public Scene scene = new Scene(gridAbout, 800, 600);
    public Button btnReturn = new Button("Voltar ao menu principal");

    public About(Stage primaryStage) {
        this.primaryStage = primaryStage;
        SetAbout();
    }

    private void SetAbout() {

        scene.getStylesheets().add("Assets/Styles/about.css");
        gridAbout.getStyleClass().add("imgback");
        // gridAbout.setStyle("-fx-padding: 15; -fx-background: black");
        gridAbout.setSpacing(5);
        gridAbout.setAlignment(Pos.CENTER);

        String path2 = "Assets/Video/memedance.mp4";
        Media videomedia2 = new Media(Paths.get(path2).toUri().toString());
        MediaPlayer player = new MediaPlayer(videomedia2);
        MediaView mediaView2 = new MediaView(player);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();

        HBox rowMedia = new HBox();
        rowMedia.getChildren().add(mediaView2);
        rowMedia.setAlignment(Pos.CENTER);

        Label title = new Label();
        title.setText("Sobre os devs");
        HBox rowTitle = new HBox();
        rowTitle.getChildren().add(title);
        rowTitle.setStyle("-fx-background: rgba(45, 255, 55, 0);");
        title.setFont(Font.font("castellar", 20));
        title.setStyle("-fx-text-fill: rgb(255, 255, 0);");
        rowTitle.getStyleClass().add("aboutbordtitle");
        rowTitle.setAlignment(Pos.CENTER);       
        
        Label AboutDevs = new Label("Somos 3 alunos (Elias Lima, Mathaus Puff e Pedro Henrique) do Instituto de Ensino UNA, e criamos esse grupo com o objetivo de realizar um trabalho que nos foi dado durante o semestre. Estamos cursando 'GTI' e 'SI' no segundo semestre, e fomos desafiados com um trabalho que tem por objetivo criar um jogo de perguntas com personagens e deve possuir uma maior interatividade com o jogador. O trabalho precisa ser feito com um documento que envolve todos os processos do programa e deve ser desenvolvido na linguagem de 'Java'.");
        HBox lineLabel = new HBox();
        lineLabel.getChildren().add(AboutDevs);
        AboutDevs.setFont(Font.font("arial", 15));
        AboutDevs.setWrapText(true);
        AboutDevs.setStyle("-fx-text-fill: rgb(255, 255, 255); -fx-padding: 100;");

        VBox btnRow = new VBox();
        btnRow.getChildren().addAll(btnReturn);
        btnRow.setAlignment(Pos.BOTTOM_CENTER);

        // Adiciona todos os controles ao Grid
        gridAbout.getChildren().addAll(rowTitle, lineLabel, rowMedia, btnRow );
    }

}

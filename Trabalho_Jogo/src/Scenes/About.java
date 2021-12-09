package Scenes;

import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class About {
    Stage primaryStage;
    VBox gridAbout = new VBox();
    public Scene scene = new Scene(gridAbout, 800, 600);
    public Button btnReturn = new Button("Voltar ao menu principal");

    public MediaPlayer aboutMedia;
    public MediaView mediaViewTwo;

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
        mediaViewTwo = new MediaView(player);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();

        HBox rowMediaTwo = new HBox();
        rowMediaTwo.getChildren().add(mediaViewTwo);
        rowMediaTwo.setAlignment(Pos.CENTER);

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

        String aboutsound = "Assets/Music/dubstep.wav";
        Media aboutMusic = new Media(Paths.get(aboutsound).toUri().toString());
        aboutMedia = new MediaPlayer(aboutMusic);
        aboutMedia.setVolume(0.1);

        aboutMedia.setOnEndOfMedia(new Runnable() {
            public void run() {
                aboutMedia.seek(Duration.ZERO);
            }
        });

        // Adiciona todos os controles ao Grid
        gridAbout.getChildren().addAll(rowTitle, lineLabel, rowMediaTwo, btnRow );
    }

}

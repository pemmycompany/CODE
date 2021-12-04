package Scenes;

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
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.geometry.Pos;

public class ScoreBoard {
    // Criando um estágio
    Stage primaryStage;
    VBox gridScoreBoard = new VBox();
    public Scene scene = new Scene(gridScoreBoard, 800, 600);
    public Button btnReturn = new Button("Voltar ao menu principal");

    public MediaPlayer media;
    ProgressBar p1HealthBar, p2HealthBar;

    public ScoreBoard(Stage primaryStage, ProgressBar p1HealthBar, ProgressBar p2HealthBar) {
        this.primaryStage = primaryStage;
        this.p1HealthBar = p1HealthBar;
        this.p2HealthBar = p2HealthBar;
        SetScore();
    }

    private void SetScore() {
        scene.getStylesheets().add("/Assets/Styles/podium.css");
        // Adiciona padding (margem interior) no painel de 15px
        gridScoreBoard.setStyle("-fx-padding: 15;");
        gridScoreBoard.setAlignment(Pos.CENTER);
        gridScoreBoard.getStyleClass().add("imgpodiumcreate");
       

        Text title = new Text();
        title.setText("Placar aqui");

        // Adiciona todos os controles ao Grid
        gridScoreBoard.getChildren().addAll(title, p1HealthBar, p2HealthBar, btnReturn);

        String sound = "Assets/Music/backgroundpodium.wav";
        Media MenuMusic = new Media(Paths.get(sound).toUri().toString());
        media = new MediaPlayer(MenuMusic);
        media.setVolume(0.20);

        media.setOnEndOfMedia(new Runnable() {
            public void run() {
                media.seek(Duration.ZERO);
                media.play();
            }
        });
    }
}

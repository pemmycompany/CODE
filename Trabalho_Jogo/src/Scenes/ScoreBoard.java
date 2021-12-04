package Scenes;

import java.nio.file.Paths;

import Components.Player;
import Components.User;
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

    Player player1, player2;
    User user1, user2;

    public MediaPlayer media;
    ProgressBar p1HealthBar, p2HealthBar;

    public ScoreBoard(Stage primaryStage, ProgressBar p1HealthBar, ProgressBar p2HealthBar) {
        this.primaryStage = primaryStage;
        this.p1HealthBar = p1HealthBar;
        this.p2HealthBar = p2HealthBar;
    }

    public void setScore(User u1, User u2, Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.user1 = u1;
        this.user2 = u2;

        scene.getStylesheets().add("/Assets/Styles/podium.css");
        // Adiciona padding (margem interior) no painel de 15px
        gridScoreBoard.setStyle("-fx-padding: 15;");
        gridScoreBoard.setAlignment(Pos.CENTER);
        gridScoreBoard.getStyleClass().add("imgpodiumcreate");
        
        Text p1Name = new Text(user1.getName());
        Text p2Name = new Text(user2.getName());
        Text p1Player = new Text(player1.getName());
        Text p2Player = new Text(player2.getName());
        Text p1Health = new Text(Float.toString(player1.getHealth()));
        Text p2Health = new Text(Float.toString(player2.getHealth()));
        
        p1Name.getStyleClass().add("playerPodiumBorderOne");
        p2Name.getStyleClass().add("playerPodiumBorderTwo");

        VBox leftCol = new VBox();
        leftCol.setAlignment(Pos.CENTER);
        leftCol.getChildren().addAll(p1Name, p1Player, p1HealthBar, p1Health);
       

        VBox rightCol = new VBox();
        rightCol.setAlignment(Pos.CENTER);
        rightCol.getChildren().addAll(p2Name, p2Player, p2HealthBar, p2Health);

        HBox board = new HBox(leftCol, rightCol);
        board.setPrefWidth(600);  
        board.setSpacing(500);   
        
        // Adiciona todos os controles ao Grid
        gridScoreBoard.getChildren().addAll(board, btnReturn);

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

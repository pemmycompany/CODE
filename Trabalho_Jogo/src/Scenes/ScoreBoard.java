package Scenes;

import java.nio.file.Paths;

import Components.Player;
import Components.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        gridScoreBoard.setAlignment(Pos.TOP_CENTER);
        gridScoreBoard.getStyleClass().add("imgpodiumcreate");

        Text p1Name = new Text(user1.getName());
        Text p2Name = new Text(user2.getName());
        Text p1Player = new Text(player1.getName());
        Text p2Player = new Text(player2.getName());
        Text p1Health = new Text(Float.toString(player1.getHealth()));
        Text p2Health = new Text(Float.toString(player2.getHealth()));

        p1Name.setStyle("-fx-text-fill: rgb(255, 255, 255)");
        p1Name.setFont(Font.font("arial", 20));
        p1Name.setFill(Color.rgb(22, 28, 202));

        p1Player.setFill(Color.rgb(22, 28, 202));
        p1Player.setFont(Font.font("arial", 15));

        p1Health.setStyle("-fx-text-fill: rgb(255, 255, 255)");
        p1Health.setFont(Font.font("arial", 20));
        p1Health.setFill(Color.rgb(22, 28, 202));
        

        p2Name.setStyle("-fx-text-fill: rgb(255, 255, 255)");
        p2Name.setFont(Font.font("arial", 20));
        p2Name.setFill(Color.rgb(183, 21, 21));

        p2Player.setFill(Color.rgb(183, 21, 21));
        p2Player.setFont(Font.font("arial", 15));

        p2Health.setStyle("-fx-text-fill: rgb(255, 255, 255)");
        p2Health.setFont(Font.font("arial", 20));
        p2Health.setFill(Color.rgb(183, 21, 21));

        p1HealthBar.getStyleClass().add("blue-podiumBar");
        p2HealthBar.getStyleClass().add("red-podiumBar");
        HBox btnBox = new HBox();
        btnBox.getChildren().add(btnReturn);
        btnBox.setAlignment(Pos.BOTTOM_CENTER);

        VBox leftCol = new VBox();
        leftCol.setAlignment(Pos.CENTER);
        leftCol.getChildren().addAll(p1Name, p1Player, p1HealthBar, p1Health);

        VBox rightCol = new VBox();
        rightCol.setAlignment(Pos.CENTER);
        rightCol.getChildren().addAll(p2Name, p2Player, p2HealthBar, p2Health);

        HBox board = new HBox(leftCol, rightCol);
        board.setPrefWidth(600);
        board.setSpacing(300);
        board.setPadding(new Insets(20));

        // Adiciona todos os controles ao Grid
        gridScoreBoard.getChildren().addAll(board, btnBox);

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

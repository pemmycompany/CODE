package Scenes;

import java.nio.file.Paths;
import java.util.ArrayList;
import Components.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Game {
    // Criando um estágio
    Stage primaryStage;
    VBox gridGame = new VBox(5);
    public Scene scene = new Scene(gridGame, 800, 600, Color.GRAY);
    public Button btnReturn = new Button("Voltar");

    public MediaPlayer media;

    public Game(Stage primaryStage) {
        this.primaryStage = primaryStage;
        SetGame();
    }

    private void SetGame() {

        String sound = "Assets/Music/Game.wav";
        Media MenuMusic = new Media(Paths.get(sound).toUri().toString());
        media = new MediaPlayer(MenuMusic);

        media.setOnEndOfMedia(new Runnable() {
            public void run() {
                media.seek(Duration.ZERO);
            }
        });

        Label teste = new Label("Funcionou!");
        gridGame.getChildren().add(teste);

    }
}
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.geometry.Pos;

public class Tutorial {
    // Criando um estágio
    Stage primaryStage;
    VBox gridTutorial = new VBox();

    String text = """
            Cada personagem tem um nome, que vai ser utilizado para fazer referencia durante o jogo,  e um tempo de vida que inicia em 100%
            Cada pergunta tem um enunciado e uma lista de alternativas.
            Cada pergunta tem apenas 1 resposta correta, caso o jogador erre, o mesmo perde 5% de sua total. A cada segundo que o jogador demora para responder, o mesmo perde 2% de sua vida total;

            O jogo foi criado para apenas 2 jogadores
            Cada jogador deve efetuar seu cadastro com um nome, apelido, e-mail e telefone antes de iniciar o jogo.
            Antes de dar start, cada player deve escolher um personagem, que vai ser seu jogador virtual no game.
            Ao final do jogo, o jogador que tiver menos unidade de vida perde.""";
    public Scene scene = new Scene(gridTutorial, 800, 600);
    public Button btnReturn = new Button("Voltar ao menu principal");

    public MediaPlayer tutorialMedia;

    public Tutorial(Stage primaryStage) {
        this.primaryStage = primaryStage;
        SetTutorial();
    }

    private void SetTutorial() {
        scene.getStylesheets().add("/Assets/Styles/Tutorial.css");
        // Adiciona padding (margem interior) no painel de 15px
        gridTutorial.setStyle("-fx-padding: 15;");
        gridTutorial.setAlignment(Pos.CENTER);
        gridTutorial.getStyleClass().add("imgtutorialback");
        gridTutorial.setSpacing(10);

        String sound = "Assets/Music/Tutorial.wav";
        Media MenuMusic = new Media(Paths.get(sound).toUri().toString());
        tutorialMedia = new MediaPlayer(MenuMusic);

        tutorialMedia.setOnEndOfMedia(new Runnable() {
            public void run() {
                tutorialMedia.seek(Duration.ZERO);
            }
        });

        Label lblTutorial = new Label(text);

        HBox tutorialBox = new HBox();
        tutorialBox.getChildren().add(lblTutorial);
        lblTutorial.setFont(Font.font("arial", 16));
        lblTutorial.setWrapText(true);
        lblTutorial.setStyle("-fx-text-fill: rgb(255, 255, 255);");
        tutorialBox.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);"
        +"-fx-padding: 40;"
        + "-fx-border-style: solid inside;"
        + "-fx-radius: 50;"
        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;" + "-fx-border-color: white;");
        // Adiciona todos os controles ao Grid
        gridTutorial.getChildren().addAll(tutorialBox, btnReturn);
    }
}

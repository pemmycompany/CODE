package Scenes;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Menu {

    Stage primaryStage;
    VBox gridMenu = new VBox();
    public Scene scene = new Scene(gridMenu, 800, 600);
    // Criando botões para navegação no menu//
    public Button btnStart = new Button("Novo Jogo");
    public Button btnAbout = new Button("Sobre");
    public Button btnTutorial = new Button("Como Jogar");
    public Button btnQuit = new Button("Encerrar");

    public MediaPlayer media;

    public Menu(Stage primaryStage) {
        this.primaryStage = primaryStage;
        SetMenu();
    }

    private void SetMenu() {

        // Adiciona padding (margem interior) no painel de 15px
        gridMenu.setStyle("-fx-padding: 15; -fx-maring: 30");
        gridMenu.setAlignment(Pos.CENTER);
        gridMenu.setSpacing(5);

        // Instancia um novo Text e adiciona seu conteúdo
        Label title = new Label();
        title.setText("Bem-vindo ao Jogo da UNA!");
        title.setStyle("-fx-font: 24 arial;");
        title.setPadding(new Insets(15));

        title.setLineSpacing(20.0);

        btnStart.setPrefWidth(100);
        btnAbout.setPrefWidth(100);
        btnTutorial.setPrefWidth(100);
        btnQuit.setPrefWidth(100);

        // Adiciona todos os controles ao Grid
        gridMenu.getChildren().addAll(title, btnStart, btnAbout, btnTutorial, btnQuit);

        String sound = "Assets/Music/menumusic.wav";
        Media MenuMusic = new Media(Paths.get(sound).toUri().toString());
        media = new MediaPlayer(MenuMusic);
        
        media.setOnEndOfMedia(new Runnable() {
            public void run() {
                media.seek(Duration.ZERO);
            }
        });

    }
}
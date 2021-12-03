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
        // Adiciona padding (margem interior) no painel de 15px
        gridAbout.setStyle("-fx-padding: 15; -fx-background: black");
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
        title.setFont(Font.font("castellar", 20));
        title.setStyle("-fx-text-fill: rgb(132, 30, 2);");
        rowTitle.setAlignment(Pos.CENTER);       
        

        Label AboutDevs = new Label("Criado por Pedro Henrique, Elias Lima e Mathaus Puff.\nSe trata de um trabalho final da faculdade com o intuito de aprender e desenvolver programas orientado a objetos.\nTivemos nossas dificuldades ao criarmos o jogo, mas com o trabalho em equipe conseguimos solucionar os problemas.");
        HBox lineLabel = new HBox();
        lineLabel.getChildren().add(AboutDevs);
        AboutDevs.setFont(Font.font("Calibri", 18));
        AboutDevs.setWrapText(true);
        AboutDevs.setStyle("-fx-text-fill: rgb(22, 28, 202); -fx-padding: 100;");

        VBox btnRow = new VBox();
        btnRow.getChildren().addAll(btnReturn);
        btnRow.setAlignment(Pos.BOTTOM_CENTER);
        btnRow.setSpacing(5);

        // Adiciona todos os controles ao Grid
        gridAbout.getChildren().addAll(rowTitle, lineLabel, rowMedia, btnRow );
    }

}

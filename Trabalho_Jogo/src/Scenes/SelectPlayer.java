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

public class SelectPlayer {

    Stage primaryStage;
    VBox gridGame = new VBox(5);
    public Scene scene = new Scene(gridGame, 800, 600, Color.GRAY);
    public Button btnReturn = new Button("Voltar");

    ArrayList<Player> Players = new ArrayList<Player>();

    Label lblP1 = new Label("Jogador_1");
    Label lblP2 = new Label("Jogador_2");

    public SelectPlayer(Stage primaryStage) {
        this.primaryStage = primaryStage;
        setPlayer();

        Players.add(new Player("VanishMan", new String[] { "Invisibilidade", "Super Visão", "Lentidão" }, true,
                100.0f));
        Players.add(new Player("DeterGente", new String[] { "Detêm qualquer gente",
                "Perde mais vida ao errar consecutivamente ", "Pode retirar uma alternativa" }, true,
                105.0f));
        Players.add(new Player("Lysoform",
                new String[] { "Agilidade", "Ganha 2 de vida a cada acerto",
                        "perde 2.5 de vida a cada erro" },
                true,
                100.0f));
        Players.add(new Player("MrMúsculo", new String[] { "Super Força", "Remove toda a Gordura", "Barato" },
                true, 150.0f));
        Players.add(new Player("PinhoSol", new String[] { "Radiante", "Sanitário", "Retarda qualquer inseto" },
                true, 100.0f));
    }

    void setPlayer() {
        primaryStage.setTitle("Cadastro dos Jogadores");

        // Adiciona padding (margem interior) no painel de 15px
        gridGame.setStyle("-fx-padding: 80;");
        gridGame.setAlignment(Pos.CENTER);

        // Jogador 1 vs Jogador 2_______________________________________________________
        lblP1.setFont(Font.font("Calibri", 25));
        lblP1.setStyle("-fx-text-fill: rgb(22, 28, 202);");

        lblP2.setFont(Font.font("Calibri", 25));
        lblP2.setStyle("-fx-text-fill: rgb(183, 21, 21);");

        Label lblVS = new Label(" VS ");
        lblVS.setFont(Font.font("Calibri", 17));
        HBox vsRow = new HBox();
        vsRow.getChildren().addAll(lblP1, lblVS, lblP2);
        vsRow.setPadding(new Insets(20));
        vsRow.setAlignment(Pos.TOP_CENTER);

        HBox playersRow = new HBox();
        playersRow.getChildren().addAll(lblP1, lblVS, lblP2);
        playersRow.setAlignment(Pos.CENTER);

        // VanishMan_____________________
        Image vanishManIMG = new Image(getClass().getResource("/Assets/IMG/VanishMan.jpg").toString());
        ImageView vanishMan = new ImageView(vanishManIMG);
        vanishMan.setFitWidth(100);
        vanishMan.setPreserveRatio(true);
        vanishMan.setSmooth(true);
        vanishMan.setCache(true);
        vanishMan.setStyle("-fx-padding: 10;" + "-fx-border-style: solid outside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;" + "-fx-border-radius: 5;"
                + "-fx-border-color: blue;");

        // DeterGente_____________________
        Image DeterGentIMG = new Image(getClass().getResource("/Assets/IMG/DeterGente.jpg").toString());
        ImageView DeterGente = new ImageView(DeterGentIMG);
        DeterGente.setFitWidth(100);
        DeterGente.setPreserveRatio(true);
        DeterGente.setSmooth(true);
        DeterGente.setCache(true);

        // LysoForm_____________________
        Image LysoFormIMG = new Image(getClass().getResource("/Assets/IMG/Lysoform.jpg").toString());
        ImageView LysoForm = new ImageView(LysoFormIMG);
        LysoForm.setFitWidth(100);
        LysoForm.setPreserveRatio(true);
        LysoForm.setSmooth(true);
        LysoForm.setCache(true);

        // MrMusculo_____________________
        Image MrMusculoIMG = new Image(getClass().getResource("/Assets/IMG/MrMusculo.jpg").toString());
        ImageView MrMusculo = new ImageView(MrMusculoIMG);
        MrMusculo.setFitWidth(100);
        MrMusculo.setPreserveRatio(true);
        MrMusculo.setSmooth(true);
        MrMusculo.setCache(true);

        // PinhoSol_____________________
        Image PinhoSolIMG = new Image(getClass().getResource("/Assets/IMG/PinhoSol.jpg").toString());
        ImageView PinhoSol = new ImageView(PinhoSolIMG);
        PinhoSol.setFitWidth(100);
        PinhoSol.setPreserveRatio(true);
        PinhoSol.setSmooth(true);
        PinhoSol.setCache(true);

        // Colocando a imagem horizontalmente da linha 1
        HBox row1 = new HBox();
        row1.setSpacing(10);
        row1.setAlignment(Pos.CENTER);
        row1.getChildren().addAll(vanishMan, DeterGente, LysoForm);

        // Colocando a imagem horizontalmente da linha 2
        HBox row2 = new HBox();
        row2.setSpacing(10);
        row2.setAlignment(Pos.CENTER);
        row2.getChildren().addAll(MrMusculo, PinhoSol);

        HBox panels = new HBox();
        VBox sideMenu = new VBox();
        VBox images = new VBox();

        Label lblPlayerName = new Label("Nome: VanishMan");
        lblPlayerName.setFont(Font.font("Calibri", 15));

        Label lblSkills = new Label("Habilidades: Limpar");
        lblSkills.setFont(Font.font("Calibri", 15));

        Label lblHealth = new Label("Vida: 100");
        lblHealth.setFont(Font.font("Calibri", 15));

        sideMenu.getChildren().addAll(lblPlayerName, lblSkills, lblHealth);
        sideMenu.setSpacing(10);
        sideMenu.setAlignment(Pos.CENTER);
        sideMenu.setStyle("-fx-background-color: rgb(195, 195, 195); -fx-padding: 70;");

        images.getChildren().addAll(row1, row2);

        Button btnSubmit = new Button("Salvar");
        btnSubmit.setPrefWidth(100);
        btnSubmit.setPrefHeight(40);
        btnSubmit.setFont(Font.font("Calibri", 16));

        btnReturn.setPrefHeight(40);
        btnReturn.setFont(Font.font("Calibri", 16));

        HBox btnRow = new HBox();
        btnRow.getChildren().addAll(btnReturn, btnSubmit);
        btnRow.setAlignment(Pos.BOTTOM_CENTER);
        btnRow.setSpacing(10);

        panels.getChildren().addAll(sideMenu, images);
        panels.setSpacing(10);
        panels.setAlignment(Pos.CENTER);

        gridGame.getChildren().addAll(playersRow, panels, btnRow);


    }

    public void activate() {
        lblP1.setText(Menu.GetUser(1).getName());
        lblP2.setText(Menu.GetUser(2).getName());
    }

}
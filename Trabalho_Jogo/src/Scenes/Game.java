package Scenes;

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
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Game {
    // Criando um estágio
    Stage primaryStage;
    VBox gridGame = new VBox(5);
    public Scene scene = new Scene(gridGame, 800, 600);
    public Button btnReturn = new Button("Voltar");

    User User_01;
    User User_02;

    ArrayList<Player> Players = new ArrayList<Player>();

    public Game(Stage primaryStage) {
        this.primaryStage = primaryStage;
        scene.getStylesheets().addAll(this.getClass().getResource("/Assets/Styles/style.css").toExternalForm());
        SetGame();

        Player VanishMan = new Player("VanishMan", new String[] { "Invisibilidade", "Super Visão", "Lentidão" }, true,
                100.0f);
        Player DeterGente = new Player("DeterGente", new String[] { "Detêm qualquer gente",
                "Perde mais vida ao errar consecutivamente ", "Pode retirar uma alternativa" }, true, 105.0f);
        Player Lysoform = new Player("Lysoform",
                new String[] { "Agilidade", "Ganha 2 de vida a cada acerto", "perde 2.5 de vida a cada erro" }, true,
                100.0f);
        Player MrMusculo = new Player("MrMúsculo", new String[] { "Super Força", "Remove toda a Gordura", "Barato" },
                true, 150.0f);
        Player PinhoSol = new Player("PinhoSol", new String[] { "Radiante", "Sanitário", "Retarda qualquer inseto" },
                true, 100.0f);
    }

    private void SetGame() {
        primaryStage.setTitle("Cadastro dos Jogadores");
        // Adiciona padding (margem interior) no painel de 15px
        gridGame.setStyle("-fx-padding: 80;");
        gridGame.setAlignment(Pos.CENTER);

        SetPlayersRegister();
    }

    private void SetPlayersRegister() {

        // Jogador 1 vs Jogador 2_______________________________________________________
        Label lblP1 = new Label("Jogador_1");
        lblP1.setFont(Font.font("Calibri", 25));
        lblP1.setStyle("-fx-text-fill: rgb(22, 28, 202);");

        Label lblP2 = new Label("Jogador_2");
        lblP2.setFont(Font.font("Calibri", 25));
        lblP2.setStyle("-fx-text-fill: rgb(183, 21, 21);");

        Label lblVS = new Label(" VS ");
        lblVS.setFont(Font.font("Calibri", 17));
        HBox vsRow = new HBox();
        vsRow.getChildren().addAll(lblP1, lblVS, lblP2);
        vsRow.setPadding(new Insets(20));
        vsRow.setAlignment(Pos.TOP_CENTER);

        // Titulo_________________________________________________________
        Text title = new Text("Quem vai ser o Jogador 1?");
        title.setFont(Font.font("Calibri", FontWeight.BOLD, 20));

        title.setText("Jogador 1, selecione seu Personagem...");

        // Nome_______________________________________________________
        Label lblName = new Label("Nome");
        lblName.setFont(Font.font("Calibri", 15));
        HBox nameRow = new HBox();
        nameRow.getChildren().add(lblName);
        nameRow.setAlignment(Pos.CENTER_LEFT);
        TextField txtName = new TextField();

        // Apelido_______________________________________________________
        Label lblNickname = new Label("Apelido");
        lblNickname.setFont(Font.font("Calibri", 15));
        HBox nickRow = new HBox();
        nickRow.getChildren().add(lblNickname);
        nickRow.setAlignment(Pos.CENTER_LEFT);
        TextField txtNickname = new TextField();

        // Telefone_______________________________________________________
        Label lblPhone = new Label("Telefone");
        lblPhone.setFont(Font.font("Calibri", 15));
        HBox phoneRow = new HBox();
        phoneRow.getChildren().add(lblPhone);
        phoneRow.setAlignment(Pos.CENTER_LEFT);
        TextField txtPhone = new TextField();

        // Email_______________________________________________________
        Label lblEmail = new Label("E-mail");
        lblEmail.setFont(Font.font("Calibri", 15));
        HBox emailRow = new HBox();
        emailRow.getChildren().add(lblEmail);
        emailRow.setAlignment(Pos.CENTER_LEFT);
        TextField txtEmail = new TextField();

        // Erro_________________________________________________________
        Label lblError = new Label("Preencha todos os campos!");
        lblError.setFont(Font.font("Calibri", 15));
        lblError.setStyle("-fx-text-fill: red;");

        // Botões_______________________________________________________
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

        // Adiciona todos os controles ao Grid
        gridGame.getChildren().addAll(vsRow, title, nameRow, txtName, nickRow, txtNickname, phoneRow, txtPhone,
                emailRow, txtEmail, btnRow);

        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean selectPlayer = false;

                if (!lblError.getText().isEmpty()) {
                    gridGame.getChildren().remove(lblError);
                }

                if (txtName.getText().isEmpty() || txtNickname.getText().isEmpty() || txtPhone.getText().isEmpty()
                        || txtEmail.getText().isEmpty()) {

                    gridGame.getChildren().add(10, lblError);
                    return;
                } else {
                    if (User_01 == null) {
                        User_01 = new User(txtName.getText(), txtNickname.getText(), txtPhone.getText(),
                                txtEmail.getText());
                        lblP1.setText(txtNickname.getText());
                    } else {
                        User_02 = new User(txtName.getText(), txtNickname.getText(), txtPhone.getText(),
                                txtEmail.getText());
                        lblP2.setText(txtNickname.getText());

                        selectPlayer = true;
                    }
                    txtName.setText("");
                    txtNickname.setText("");
                    txtPhone.setText("");
                    txtEmail.setText("");
                    title.setText("Quem vai ser o Jogador 2?");

                    if (selectPlayer) {
                        gridGame.getChildren().removeAll(nameRow, txtName, nickRow, txtNickname, phoneRow, txtPhone,
                                emailRow, txtEmail, btnRow);

                    
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

                        //Colocando a imagem horizontalmente da linha 1
                        HBox row1 = new HBox();
                        row1.setSpacing(10);
                        row1.setAlignment(Pos.CENTER);
                        row1.getChildren().addAll(vanishMan, DeterGente,LysoForm);

                        //Colocando a imagem horizontalmente da linha 2
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

                        panels.getChildren().addAll(sideMenu, images);
                        panels.setSpacing(10);
                        panels.setAlignment(Pos.CENTER);

                        gridGame.getChildren().addAll(panels);

                    }
                }
            }
        });
    }
}
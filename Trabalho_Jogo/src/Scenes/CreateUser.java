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

public class CreateUser {

    Stage primaryStage;
    VBox gridGame = new VBox(5);
    public Scene scene = new Scene(gridGame, 800, 600, Color.GRAY);
    public Button btnReturn = new Button("Voltar");
    SelectPlayer selectPlayer;

    User User_01;
    User User_02;

    Label lblP1 = new Label("Jogador_1");
    Label lblP2 = new Label("Jogador_2");
    Label title = new Label("Quem vai ser o Jogador 1?");

    boolean isFirstPlayer = false;

    public CreateUser(Stage primaryStage, SelectPlayer selectPlayer) {
        this.primaryStage = primaryStage;
        this.selectPlayer = selectPlayer;
        SetCreateUser();
    }

    public void ResetForm() {
        lblP1.setText("Jogador_1");
        lblP2.setText("Jogador_2");
        isFirstPlayer = true;
        title.setText("Quem vai ser o Jogador 1?");

        User_01 = null;
        User_02 = null;
    }

    private void SetCreateUser() {

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

        // Titulo_________________________________________________________
        title.setFont(Font.font("Calibri", FontWeight.BOLD, 20));

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

                        Menu.SetUser(1, User_01);
                        lblP1.setText(txtNickname.getText());
                    } else {
                        User_02 = new User(txtName.getText(), txtNickname.getText(), txtPhone.getText(),
                                txtEmail.getText());
                        lblP2.setText(txtNickname.getText());

                        Menu.SetUser(2, User_02);

                        isFirstPlayer = true;
                        selectPlayer.activate();
                        primaryStage.setScene(selectPlayer.scene);
                    }
                    txtName.setText("");
                    txtNickname.setText("");
                    txtPhone.setText("");
                    txtEmail.setText("");
                    title.setText("Quem vai ser o Jogador 2?");
                }
            }
        });

    }
}
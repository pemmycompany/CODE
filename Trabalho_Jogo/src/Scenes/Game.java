package Scenes;

import java.awt.Color;

import javax.swing.GrayFilter;

import Components.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Game {
    // Criando um estágio
    Stage primaryStage;
    VBox gridGame = new VBox(5);
    public Scene scene = new Scene(gridGame, 500, 400);
    public Button btnReturn = new Button("Voltar");

    Player Player_01;
    Player Player_02;

    public Game(Stage primaryStage) {
        this.primaryStage = primaryStage;
        SetGame();
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
        Text title = new Text();
        title.setText("Quem sera o Jogador 1?");
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
        gridGame.getChildren().addAll(vsRow, title, nameRow, txtName, nickRow, txtNickname, phoneRow, txtPhone, emailRow,
                txtEmail, btnRow);

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
                    if(Player_01 == null){
                        Player_01 = new Player(txtName.getText(), txtNickname.getText(), txtPhone.getText(), txtEmail.getText());
                        lblP1.setText(txtNickname.getText());
                    }
                    else{
                        Player_02 = new Player(txtName.getText(), txtNickname.getText(), txtPhone.getText(), txtEmail.getText());
                        lblP2.setText(txtNickname.getText());
                    }
                    txtName.setText("");
                    txtNickname.setText("");
                    txtPhone.setText("");
                    txtEmail.setText("");
                    title.setText("Quem sera o Jogador 2?");
                }
            }
        });
    }

    /*
     * Text text = new Text();
     * 
     * text.setText("Welcome to Portal"); text.setFont(Font.font("Calibri",
     * FontWeight.BOLD, FontPosture.REGULAR, 20));
     * primaryStage.setTitle("JavaFX Login"); Label name = new Label("UserName2");
     * Label pass = new Label("Password"); TextField tf1 = new TextField();
     * PasswordField tf2 = new PasswordField(); Button Submit = new
     * Button("Submit");
     * 
     * root.addRow(1, text); root.setVgap(10); root.addRow(2, name, tf1);
     * root.setVgap(10); root.addRow(3, pass, tf2); root.setVgap(10); root.addRow(4,
     * Submit); root.setVgap(10);
     * 
     * 
     * primaryStage.setScene(scene); primaryStage.show();
     * 
     * 
     * // Button Events and Menu events here String s[]= new String[1]; Text t = new
     * Text();
     * 
     * Submit.setOnAction(new EventHandler<ActionEvent>() {
     * 
     * @Override public void handle(ActionEvent event) {
     * 
     * if (tf1.getText().isEmpty()) { if (t.getText().isEmpty() == false) {
     * root.getChildren().remove(t); }
     * t.setText("Form Error! Please enter your name"); root.addRow(5, t); return; }
     * if (tf2.getText().isEmpty()) { if (t.getText().isEmpty() == false) {
     * root.getChildren().remove(t); }
     * t.setText("Form Error! Please enter your password"); root.addRow(6, t);
     * return; } if (t.getText().isEmpty() == false) { root.getChildren().remove(t);
     * } t.setText("Registration Successful!" + " Welcome " + tf1.getText());
     * root.addRow(7, t); } });
     */
}
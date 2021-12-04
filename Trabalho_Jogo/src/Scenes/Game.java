package Scenes;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Components.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
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
import java.util.ResourceBundle;

public class Game {
        // Criando um estágio
        Stage primaryStage;
        VBox gridGame = new VBox(5);
        public Scene scene = new Scene(gridGame, 800, 600);
        public Button btnReturn = new Button("Voltar");
        public Button btnNext = new Button("Proxima");
        HBox btnRow;
        Label playerTurn;

        ProgressBar p1HealthBar;
        ProgressBar p2HealthBar;

        public MediaPlayer media;
        ArrayList<Question> questions;

        QuestionScene currentScene;
        int userTurn;
        public boolean isCorrect = false;
        public User user_1 = new User("Jogador 1", "", "", ""), user_2 = new User("Jogador 2", "", "", "");
        public Player player_1, player_2;

        public Game(Stage primaryStage) {
                scene.getStylesheets().add("Assets/Styles/selectPlayer.css");
                this.primaryStage = primaryStage;
                gridGame.setStyle("-fx-background-color: gray");
                gridGame.getStyleClass().add("gameimgback");
                gridGame.setAlignment(Pos.CENTER);

                questions = new ArrayList<Question>(Arrays.asList(
                                new Question("Ao definir chaves ________ e _____, voce garante que a integridade dos dados de uma tabela sera mantida.",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("primarias, exclusivas", false),
                                                                new Option("primarias, secundarias", false),
                                                                new Option("primarias, estrangeiras", true),
                                                                new Option("estrangeiras, exclusivas", false)))),

                                new Question("As Caixas de Entidade sao tracadas em um ERD em que formato?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Hardboxe", false),
                                                                new Option("Losangos", false),
                                                                new Option("Retangulos", false),
                                                                new Option("Softboxes ", true)))),

                                new Question("As Entidades de Intersecao estao na extremidade ______ do relacionamento 1:M (Pai:Filho) recem-criado.",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Pai", false),
                                                                new Option("Filho", true),
                                                                new Option("Unica", false),
                                                                new Option("Interrompida", false)))),

                                new Question("Uma coluna ou uma combinacao de colunas em uma tabela que se refere a uma chave primaria na mesma ou em outra tabela.",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Chave Estrangeira", true),
                                                                new Option("Chave Primaria", false),
                                                                new Option("Chave Candidata", false),
                                                                new Option("Superchave", false)))),

                                new Question("A Engenharia _______ e o processo de criacao de um modelo conceitual ou logico extraindo as informacoes de uma fonte de dados existente.",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("De Destino", false),
                                                                new Option("Reversa", false),
                                                                new Option("Direta", true),
                                                                new Option("De Cima para Baixo", false)))),

                                new Question("Os metodos String equals e compareTo realizam funcoes semelhantes e diferem no tipo de retorno. Verdadeiro ou falso?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Verdade ", true),
                                                                new Option("Falso", false)))),

                                new Question("Qual das alternativas a seguir instancia uma String de nome name para o Oracle?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("String name;", false),
                                                                new Option("String Oracle='name';", false),
                                                                new Option("String name='name';", false),
                                                                new Option("String name='Oracle';", true)))),

                                new Question("Qual das seguintes alternativas poderia ser um motivo para lancar uma excecao?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Voce tem um erro fatal no programa.",
                                                                                false),
                                                                new Option("Voce encontrou um Erro de Derramamento de Pilha",
                                                                                false),
                                                                new Option("Tornar a interface do usuario mais dificil de navegar.",
                                                                                false),
                                                                new Option("Evitar que as excecoes interrompam sem programa.",
                                                                                true)))),

                                new Question("As variaveis estaticas publicas nao podem ter o valor redefinido por outras classes. Verdadeiro ou falso?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Verdade", false),
                                                                new Option("Falso ", true)))),

                                new Question("Qual das alternativas a seguir presume a maneira adequada de definir o tamanho da variavel publica da superclasse igual a cinco de dentro da subclasse?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("super.length(5)", false),
                                                                new Option("super.length = 5 ", true))))

                ));
        }

        Question getRandomQuestion() {
                int rand = new Random().nextInt(questions.size() - 1);
                return questions.get(rand);
        }

        public void SetGame() {

                String sound = "Assets/Music/Game.wav";
                Media MenuMusic = new Media(Paths.get(sound).toUri().toString());
                media = new MediaPlayer(MenuMusic);

                media.setOnEndOfMedia(new Runnable() {
                        public void run() {
                                media.seek(Duration.ZERO);
                        }
                });

                btnNext.setOnAction(e -> {
                        NextQuestion();
                });

                HBox Header = new HBox();
                VBox leftCol = new VBox();
                VBox rightCol = new VBox();
                Header.setPrefWidth(600);
                Header.setAlignment(Pos.CENTER);
                Header.setSpacing(100);
                leftCol.setAlignment(Pos.CENTER_LEFT);
                rightCol.setAlignment(Pos.CENTER_RIGHT);

                DropShadow lightShadow = new DropShadow();
                lightShadow.setOffsetY(3.0f);
                lightShadow.setColor(Color.color(0.4f, 0.4f, 0.4f));

                Label titleVs = new Label("VS");
                titleVs.setEffect(lightShadow);
                titleVs.setStyle("-fx-text-fill: rgb(223, 186, 35)");
                titleVs.setFont(Font.font("castellar", 50));
                Label user1Name = new Label(user_1.getName());
                Label user2Name = new Label(user_2.getName());

                user1Name.setFont(Font.font("Calibri", 25));
                user1Name.setStyle("-fx-text-fill: rgb(31, 42, 178); -fx-padding: 3");
                user2Name.setFont(Font.font("Calibri", 25));
                user2Name.setStyle("-fx-text-fill: rgb(173, 39, 39); -fx-padding: 3");

                Label player1Name = new Label(player_1.getName());
                Label player2Name = new Label(player_2.getName());

                player1Name.setFont(Font.font("Calibri", 20));
                player1Name.setStyle("-fx-text-fill: rgb(31, 42, 160); -fx-padding: 2");
                player2Name.setFont(Font.font("Calibri", 20));
                player2Name.setStyle("-fx-text-fill: rgb(160, 39, 39); -fx-padding: 2");

                p1HealthBar = new ProgressBar(1);
                p2HealthBar = new ProgressBar(1);

                p1HealthBar.getStyleClass().add("blue-bar");
                p1HealthBar.setPrefHeight(30);
                p1HealthBar.setPrefWidth(200);
                p2HealthBar.getStyleClass().add("red-bar");
                p2HealthBar.setRotate(180);
                p2HealthBar.setPrefWidth(200);
                p2HealthBar.setPrefHeight(30);

                leftCol.getChildren().addAll(user1Name, player1Name, p1HealthBar);
                rightCol.getChildren().addAll(user2Name, player2Name, p2HealthBar);

                Header.getChildren().addAll(leftCol, titleVs, rightCol);

                userTurn = new Random().nextInt(3) + 1;
                User firstUser = (userTurn == 1 ? user_1 : user_2);

                playerTurn = new Label("Jogador '" + firstUser.getName() + "', responda:");
                playerTurn.setFont(Font.font("Calibri", 25));
                playerTurn.setStyle("-fx-text-fill: white; -fx-padding: 20");

                btnRow = new HBox();
                btnRow.getChildren().addAll(btnReturn);

                gridGame.getChildren().addAll(Header, playerTurn, btnRow);
                btnRow.setAlignment(Pos.CENTER);
                btnRow.setSpacing(10);

                NextQuestion();
        }

        void NextQuestion() {
                if (currentScene != null) {
                        gridGame.getChildren().remove(currentScene.gridGame);
                }

                userTurn = (userTurn == 1 ? 2 : 1);
                playerTurn.setText("Jogador '" + (userTurn == 1 ? user_1 : user_2).getName() + "', responda:");

                Question currentQuestion = getRandomQuestion();
                currentScene = new QuestionScene(this, currentQuestion);
                currentScene.SetQuestion();
                btnRow.getChildren().remove(btnNext);

                gridGame.getChildren().add(gridGame.getChildren().size() - 1, currentScene.gridGame);
        }

        public void Reset() {
                gridGame.getChildren().clear();
        }

        public void Answer(Question currentQuestion, QuestionScene questionScene) {
                Player currentPlayer = userTurn == 1 ? player_1 : player_2;
                if (!isCorrect) {
                        currentPlayer.takeHealth(currentPlayer.getTotalHealth() * 0.05f);
                        if(userTurn == 1){
                                p1HealthBar.setProgress(currentPlayer.getHealth()/currentPlayer.getTotalHealth());
                        }
                        else{
                                p2HealthBar.setProgress(currentPlayer.getHealth()/currentPlayer.getTotalHealth());
                        }
                }

                questions.remove(questions.get(questions.indexOf(currentQuestion)));
                btnRow.getChildren().add(btnNext);
        }
}
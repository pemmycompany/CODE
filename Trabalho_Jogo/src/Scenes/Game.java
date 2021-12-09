package Scenes;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Components.Option;
import Components.Player;
import Components.Question;
import Components.QuestionScene;
import Components.User;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game {
        // Criando um estágio
        Stage primaryStage;
        VBox gridGame = new VBox(5);
        public Scene scene = new Scene(gridGame, 800, 600);
        public Button btnReturn = new Button("Voltar");
        public Button btnNext = new Button("Proxima");
        Button btnStop = new Button("Parar Jogo");
        public Button btnConfirmStop = new Button("Sim");
        public Button btnDenyStop = new Button("Negar");
        HBox btnRow;
        Label playerTurn;

        public Stage stopStage = new Stage();

        public ProgressBar p1HealthBar;
        public ProgressBar p2HealthBar;

        boolean isAnswering = false;
        boolean acceptedStop = false;

        public MediaPlayer gameMedia;
        ArrayList<Question> questions;

        QuestionScene currentScene;
        int userTurn;
        public boolean isCorrect = false;
        public User user_1 = new User("Jogador 1", "", "", ""), user_2 = new User("Jogador 2", "", "", "");
        public Player player_1 = new Player("", new String[] { "" }, true, 100),
                        player_2 = new Player("", new String[] { "" }, true, 100);

        public Game(Stage primaryStage) {

                scene.getStylesheets().add("Assets/Styles/selectPlayer.css");
                this.primaryStage = primaryStage;
                gridGame.setStyle("-fx-background-color: gray");
                gridGame.getStyleClass().add("gameimgback");
                gridGame.setAlignment(Pos.CENTER);

                ResetQuestions();
        }

        Question getRandomQuestion() {
                if (questions.size() > 0) {
                        int rand = new Random().nextInt(questions.size());
                        return questions.get(rand);
                } else {
                        return null;
                }
        }

        public void SetGame() {

                String sound = "Assets/Music/Game.wav";
                Media MenuMusic = new Media(Paths.get(sound).toUri().toString());
                gameMedia = new MediaPlayer(MenuMusic);

                gameMedia.setOnEndOfMedia(new Runnable() {
                        public void run() {
                                gameMedia.seek(Duration.ZERO);
                        }
                });

                btnNext.setOnAction(e -> {
                        if (questions.size() > 0 && player_1.getHealth() > 0 && player_2.getHealth() > 0) {
                                NextQuestion();
                        } else {
                                finishGame();
                        }
                });

                btnStop.setOnAction(e -> {
                        RequestStop();
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
                Label user1Name = new Label(user_1.getNickName());
                Label user2Name = new Label(user_2.getNickName());

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

                playerTurn = new Label("Jogador '" + firstUser.getNickName() + "', responda:");
                playerTurn.setFont(Font.font("Calibri", 25));
                playerTurn.setStyle("-fx-text-fill: white; -fx-padding: 20");

                btnRow = new HBox();
                btnRow.getChildren().addAll(btnReturn);

                gridGame.getChildren().addAll(btnStop, Header, playerTurn, btnRow);
                btnRow.setAlignment(Pos.CENTER);
                btnRow.setSpacing(10);

                NextQuestion();
        }

        void NextQuestion() {
                userTurn = (userTurn == 1 ? 2 : 1);
                playerTurn.setText("Jogador '" + (userTurn == 1 ? user_1 : user_2).getNickName() + "', responda:");
                Player currentPlayer = (userTurn == 1 ? player_1 : player_2);
                ProgressBar currentPlayerBar = (userTurn == 1 ? p1HealthBar : p2HealthBar);
                btnNext.setDisable(true);
                if (currentScene != null) {
                        gridGame.getChildren().remove(currentScene.gridGame);
                }


                Question currentQuestion = getRandomQuestion();
                currentScene = new QuestionScene(this, currentQuestion);
                currentScene.SetQuestion();
                btnRow.getChildren().remove(btnNext);

                gridGame.getChildren().add(gridGame.getChildren().size() - 1, currentScene.gridGame);

                isAnswering = true;

                Task<Void> takeHealthOverTime = new Task<Void>() {
                        @Override
                        public Void call() throws InterruptedException {
                                while (isAnswering) {
                                        currentPlayer.takeHealth(currentPlayer.getTotalHealth() * 0.02f);
                                        currentPlayerBar.setProgress(
                                                        currentPlayer.getHealth() / currentPlayer.getTotalHealth());

                                        Thread.sleep(1000);
                                }
                                return null;
                        }
                };

                Thread healthTaker = new Thread(takeHealthOverTime);
                healthTaker.setDaemon(true);
                healthTaker.start();
        }

        public void Answer(Question currentQuestion, QuestionScene questionScene) {
                isAnswering = false;
                Player currentPlayer = userTurn == 1 ? player_1 : player_2;
                if (currentPlayer.getHealth() == 0) {
                        finishGame();
                        return;
                }

                if (!isCorrect) {
                        currentPlayer.takeHealth(currentPlayer.getTotalHealth() * 0.05f);
                        if (userTurn == 1) {
                                p1HealthBar.setProgress(currentPlayer.getHealth() / currentPlayer.getTotalHealth());
                        } else {
                                p2HealthBar.setProgress(currentPlayer.getHealth() / currentPlayer.getTotalHealth());
                        }
                }

                questions.remove(questions.get(questions.indexOf(currentQuestion)));
                btnRow.getChildren().add(btnNext);
        }

        public void RequestStop() {
                btnReturn.setDisable(true);
                btnNext.setDisable(true);
                isAnswering = false;
                User oponentUser = (userTurn == 2 ? user_1 : user_2);

                VBox grid = new VBox(5);
                grid.setAlignment(Pos.CENTER);
                Label lblConfirm = new Label(
                                "Jogador '" + oponentUser.getNickName()
                                                + "', deseja encerrar o jogo?");

                HBox btnRow = new HBox();
                btnRow.setAlignment(Pos.CENTER);
                btnRow.setSpacing(10);
                btnRow.getChildren().addAll(btnDenyStop, btnConfirmStop);

                grid.getChildren().addAll(lblConfirm, btnRow);

                p1HealthBar.setProgress(player_1.getHealth() / player_1.getTotalHealth());
                p2HealthBar.setProgress(player_2.getHealth() / player_2.getTotalHealth());

                stopStage.setTitle("Pedido de parada");
                stopStage.setScene(new Scene(grid, 400, 150));
                stopStage.show();
        }

        public void DenyStop() {
                Player currentPlayer = userTurn == 1 ? player_1 : player_2;
                Player oponentPlayer = userTurn == 2 ? player_1 : player_2;

                float takenHealth = currentPlayer.getTotalHealth() * 0.15f;
                currentPlayer.takeHealth(takenHealth);
                oponentPlayer.giveHealth(takenHealth);
                p1HealthBar.setProgress(player_1.getHealth() / player_1.getTotalHealth());
                p2HealthBar.setProgress(player_2.getHealth() / player_2.getTotalHealth());
        }

        public void ResetGame() {
                if (btnRow != null) {
                        btnRow.getChildren().clear();
                }
                ResetQuestions();
                gridGame.getChildren().clear();
                btnReturn.setDisable(false);
                btnNext.setDisable(false);
        }

        public void finishGame() {
                isAnswering = false;
                btnConfirmStop.fire();
        }

        public void ResetQuestions() {
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
                                                                new Option(
                                                                                "Superchave",
                                                                                false)))),

                                new Question("A Engenharia _______ e o processo de criacao de um modelo conceitual ou logico extraindo as informacoes de uma fonte de dados existente.",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("De Destino", false),
                                                                new Option("Reversa",
                                                                                false),
                                                                new Option("Direta",
                                                                                true),
                                                                new Option("De Cima para Baixo", false)))),

                                new Question("Os metodos String equals e compareTo realizam funcoes semelhantes e diferem no tipo de retorno. Verdadeiro ou falso?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Verdade ", true),
                                                                new Option("Falso",
                                                                                false)))),

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
                                                                new Option("Verdade",
                                                                                false),
                                                                new Option("Falso ",
                                                                                true)))),

                                new Question("Qual das alternativas a seguir presume a maneira adequada de definir o tamanho da variavel publica da superclasse igual a cinco de dentro da subclasse?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option(
                                                                                "super.length(5)",
                                                                                false),
                                                                new Option("super.length = 5 ", true))))

                ));
        }
}

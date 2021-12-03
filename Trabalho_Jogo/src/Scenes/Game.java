package Scenes;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

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

        public MediaPlayer media;
        Question[] questions;

        public User user_1 = new User("", "", "", ""), user_2;

        public Game(Stage primaryStage) {
                scene.getStylesheets().add("Assets/Styles/selectPlayer.css");
                this.primaryStage = primaryStage;
                gridGame.setStyle("-fx-background-color: black");
                gridGame.setAlignment(Pos.CENTER);

                questions = new Question[] {
                                new Question("Ao definir chaves ________ e _____, você garante que a integridade dos dados de uma tabela será mantida.",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("primárias, exclusivas", false),
                                                                new Option("primárias, secundárias", false),
                                                                new Option("primárias, estrangeiras", true),
                                                                new Option("estrangeiras, exclusivas", false)))),

                                new Question("As Caixas de Entidade são traçadas em um ERD em que formato?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Hardboxe", false),
                                                                new Option("Losangos", false),
                                                                new Option("Retângulos", false),
                                                                new Option("Softboxes ", true)))),

                                new Question("As Entidades de Interseção estão na extremidade ______ do relacionamento 1:M (Pai:Filho) recém-criado.",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Pai", false),
                                                                new Option("Filho", true),
                                                                new Option("Única", false),
                                                                new Option("Interrompida", false)))),

                                new Question("Uma coluna ou uma combinação de colunas em uma tabela que se refere a uma chave primária na mesma ou em outra tabela.",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Chave Estrangeira", true),
                                                                new Option("Chave Primária", false),
                                                                new Option("Chave Candidata", false),
                                                                new Option("Superchave", false)))),

                                new Question("A Engenharia _______ é o processo de criação de um modelo conceitual ou lógico extraindo as informações de uma fonte de dados existente.",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("De Destino", false),
                                                                new Option("Reversa", false),
                                                                new Option("Direta", true),
                                                                new Option("De Cima para Baixo", false)))),

                                new Question("Os métodos String equals e compareTo realizam funções semelhantes e diferem no tipo de retorno. Verdadeiro ou falso?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Verdade ", true),
                                                                new Option("Falso", false)))),

                                new Question("Qual das opções a seguir instancia uma String de nome name para o Oracle?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("String name;", false),
                                                                new Option("String Oracle='name';", false),
                                                                new Option("String name='name';", false),
                                                                new Option("String name='Oracle';", true)))),

                                new Question("Qual das seguintes opções poderia ser um motivo para lançar uma exceção?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Você tem um erro fatal no programa.",
                                                                                false),
                                                                new Option("Você encontrou um Erro de Derramamento de Pilha",
                                                                                false),
                                                                new Option("Tornar a interface do usuário mais difícil de navegar.",
                                                                                false),
                                                                new Option("Evitar que as exceções interrompam sem programa.",
                                                                                true)))),

                                new Question("As variáveis estáticas públicas não podem ter o valor redefinido por outras classes. Verdadeiro ou falso?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("Verdade", false),
                                                                new Option("Falso ", true)))),

                                new Question("Qual das opções a seguir é a maneira adequada de definir o tamanho da variável pública da superclasse igual a cinco de dentro da subclasse?",
                                                new ArrayList<Option>(Arrays.asList(
                                                                new Option("super.length(5)", false),
                                                                new Option("super.length = 5 ", true))))

                };
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

                Label playerTurn = new Label("Jogador '" + user_1.getName() + "', responda:");
                playerTurn.setFont(Font.font("Calibri", 25));
                playerTurn.setStyle("-fx-text-fill: white; -fx-padding: 20");

                QuestionScene question = new QuestionScene(primaryStage, questions[1]);
                gridGame.getChildren().addAll(playerTurn, question.gridGame);
        }
}
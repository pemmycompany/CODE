package Components;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import Components.*;
import Scenes.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

public class QuestionScene {
    // Criando um estágio
    Game game;
    public VBox gridGame = new VBox(5);
    public Scene scene = new Scene(gridGame, 800, 600);
    Question sceneQuestion;
    int selectedOption;
    boolean chosed = false;
    boolean isCorrect;
    boolean confirmed = false;
    QuestionScene thisScene = this;

    public QuestionScene(Game game, Question sceneQuestion) {
        this.game = game;
        this.sceneQuestion = sceneQuestion;
        gridGame.setStyle("-fx-background-color: rgba(0,0,0,0.4)");
        gridGame.setPadding(new Insets(10));
        gridGame.setAlignment(Pos.CENTER);
        gridGame.setSpacing(20);
    }

    public void SetQuestion() {
        isCorrect = false;
        String[] optionsPrefix = new String[] { "A) ", "B) ", "C) ", "D) ", "E) " };

        var onEnter = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (!chosed)
                    ((Text) e.getTarget()).setFill(Color.rgb(29, 138, 242));// rgb(0, 180, 17)
            }
        };

        var onExit = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (!chosed)
                    ((Text) e.getTarget()).setFill(Color.rgb(128, 181, 217));
            }
        };

        var onClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if (chosed)
                    return;

                Text target = ((Text) e.getTarget());
                selectedOption = Integer.parseInt(target.getId());

                Parent root;
                try {
                    VBox grid = new VBox(5);
                    grid.setAlignment(Pos.CENTER);
                    Label lblConfirm = new Label(
                            "Tem certeza que deseja marcar a alternativa '" +
                                    optionsPrefix[selectedOption] + "'?");

                    HBox btnRow = new HBox();
                    btnRow.setAlignment(Pos.CENTER);
                    btnRow.setSpacing(10);
                    Button btnConfirm = new Button("Sim");
                    Button btnCancel = new Button("Cancelar");
                    btnRow.getChildren().addAll(btnCancel, btnConfirm);

                    grid.getChildren().addAll(lblConfirm, btnRow);

                    Stage stage = new Stage();
                    stage.setTitle("Aviso");
                    stage.setScene(new Scene(grid, 400, 150));
                    stage.show();

                    btnConfirm.setOnAction(ev -> {
                        isCorrect = sceneQuestion.getOptions().get(selectedOption).isAnswer();
                        game.isCorrect = isCorrect;
                        game.Answer(sceneQuestion, thisScene);
                        stage.close();
                        
                        if (isCorrect) {
                            target.setFill(Color.rgb(0, 180, 17));
                        } else {
                            target.setFill(Color.rgb(200, 23, 23));
                        }
                        confirmed = true;
                        chosed = true;

                        VBox feedbackGrid = new VBox(5);
                        feedbackGrid.setAlignment(Pos.CENTER);
                        Text lblFeedback = new Text(
                                isCorrect ? "Parabens! Resposta Correta!" : "Resposta incorreta.");
                        lblFeedback.setFont(Font.font("Calibri", 23));
                        lblFeedback.setFill(Color.rgb(73, 160, 204));

                        Text fbQuestion = new Text(sceneQuestion.getText());
                        fbQuestion.setFont(Font.font("Calibri", 15));
                        fbQuestion.setFill(Color.rgb(42, 95, 122));
                        fbQuestion.setWrappingWidth(400);

                        Option correctOption = sceneQuestion.getOptions().stream()
                                .filter(op -> op.isAnswer())
                                .findAny()
                                .orElse(null);

                        Label correctAnswer = new Label("Resposta Correta:");
                        Label fbCorrectOption = new Label(
                                optionsPrefix[sceneQuestion.getOptions().indexOf(correctOption)] +
                                        correctOption.getText());
                        fbCorrectOption.setWrapText(true);
                        fbCorrectOption.setStyle("-fx-text-fill: rgb(24, 146, 35)");

                        Button btnOk = new Button("Ok");

                        feedbackGrid.getChildren().add(lblFeedback);
                        if (!isCorrect) {
                            feedbackGrid.getChildren().addAll(fbQuestion, correctAnswer, fbCorrectOption);
                        }
                        feedbackGrid.getChildren().add(btnOk);

                        Stage feedbackStage = new Stage();
                        feedbackStage.setTitle(isCorrect ? "Parabens!" : "Que pena...");
                        feedbackStage.setScene(new Scene(feedbackGrid, 500, 150));
                        feedbackStage.show();

                        btnOk.setOnAction(eve -> {
                            feedbackStage.close();
                        });
                    });

                    btnCancel.setOnAction(ev -> {
                        confirmed = false;
                        stage.close();
                    });
                } catch (/* IOException */Exception ex) {
                    ex.printStackTrace();
                }

                if (!confirmed) {
                    return;
                }
            }
        };

        HBox questionBox = new HBox();
        Text question = new Text(sceneQuestion.getText());
        questionBox.setAlignment(Pos.CENTER);
        question.setWrappingWidth(600);
        question.setFont(Font.font("Calibri", 23));
        question.setFill(Color.rgb(73, 160, 204));
        questionBox.getChildren().addAll(question);

        gridGame.getChildren().add(questionBox);

        for (Option option : sceneQuestion.getOptions()) {
            var i = sceneQuestion.getOptions().indexOf(option);

            Text lblOption = new Text(optionsPrefix[i] + option.getText());
            lblOption.setFont(Font.font("Calibri", 20));
            lblOption.setFill(Color.rgb(128, 181, 217));
            lblOption.setId(Integer.toString(i));
            lblOption.setOnMouseClicked(onClick);
            lblOption.setOnMouseEntered(onEnter);
            lblOption.setOnMouseExited(onExit);
            lblOption.getStyleClass().add("option");

            gridGame.getChildren().add(lblOption);
        }
    }
}
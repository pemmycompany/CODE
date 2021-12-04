package Components;

import java.nio.file.Paths;
import java.util.ArrayList;
import Components.*;
import Scenes.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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

                chosed = true;

                isCorrect = sceneQuestion.getOptions().get(selectedOption).isAnswer();
                if (isCorrect) {
                    target.setFill(Color.rgb(0, 180, 17));
                } else {
                    target.setFill(Color.rgb(200, 23, 23));
                }
                game.isCorrect = isCorrect;
                game.Answer(sceneQuestion, thisScene);
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

        String[] optionsPrefix = new String[] { "A) ", "B) ", "C) ", "D) ", "E) " };

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
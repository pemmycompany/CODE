package Components;

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
    Stage primaryStage;
    public VBox gridGame = new VBox(5);
    public Scene scene = new Scene(gridGame, 800, 600);
    Question sceneQuestion;
    int selectedOption;
    boolean chosed = false;

    public QuestionScene(Stage primaryStage, Question sceneQuestion) {
        this.primaryStage = primaryStage;
        this.sceneQuestion = sceneQuestion;
        gridGame.setStyle("-fx-background-color: black");
        gridGame.setAlignment(Pos.CENTER);
        gridGame.setSpacing(20);
        SetScene();
    }

    private void SetScene() {
        Label question = new Label(sceneQuestion.getText());
        question.setWrapText(true);
        question.setFont(Font.font("Calibri", 23));
        question.setStyle("-fx-text-fill: rgb(73, 160, 204); -fx-padding: 50");

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
                if (chosed) return;
                Text target = ((Text) e.getTarget());
                selectedOption = Integer.parseInt(target.getId());

                chosed = true;

                if (sceneQuestion.getOptions().get(selectedOption).isAnswer()) {
                    target.setFill(Color.rgb(0, 180, 17));
                } else {
                    target.setFill(Color.rgb(200, 23, 23));
                }
            }
        };

        gridGame.getChildren().add(question);

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
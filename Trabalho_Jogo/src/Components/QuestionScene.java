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

    public QuestionScene(Stage primaryStage, Question sceneQuestion) {
        this.primaryStage = primaryStage;
        this.sceneQuestion = sceneQuestion;
        gridGame.setStyle("-fx-background-color: black");
        SetScene();
    }

    private void SetScene() {
        Label question = new Label(sceneQuestion.getText());
        question.setFont(Font.font("Calibri", 25));
        question.setStyle("-fx-text-fill: rgb(73, 160, 204);");
        gridGame.getChildren().add(question);

        String[] optionsPrefix = new String[]{"A) ", "B) ", "C) ", "D) ", "E) "};

        for (Option option : sceneQuestion.getOptions()) {
            var i = sceneQuestion.getOptions().indexOf(option);

            Label lblOption = new Label(optionsPrefix[i] + option.getText());
            lblOption.setFont(Font.font("Calibri", 25));
            lblOption.setStyle("-fx-text-fill: rgb(197, 227, 242)");
            lblOption.setId(Integer.toString(i));

            gridGame.getChildren().add(lblOption);
        }
    }
}
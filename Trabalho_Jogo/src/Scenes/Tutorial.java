package Scenes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.Pos;

public class Tutorial {
    // Criando um estágio
    Stage primaryStage;
    VBox gridTutorial = new VBox();
    public Scene scene = new Scene(gridTutorial, 500, 300);
    public Button btnReturn = new Button("Voltar ao menu principal");

    public Tutorial(Stage primaryStage) {
        this.primaryStage = primaryStage;
        SetTutorial();
    }

    private void SetTutorial() {
        // Adiciona padding (margem interior) no painel de 15px
        gridTutorial.setStyle("-fx-padding: 15;");
        gridTutorial.setAlignment(Pos.CENTER);

        Text title = new Text();
        title.setText("TESTE");

        // Adiciona todos os controles ao Grid
        gridTutorial.getChildren().addAll(title, btnReturn);

    }

}

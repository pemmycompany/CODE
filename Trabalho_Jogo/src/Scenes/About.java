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

public class About {
    Stage primaryStage;
    VBox gridAbout = new VBox();
    public Scene scene = new Scene(gridAbout, 500, 300);

    public Button btnReturn = new Button("Voltar ao menu principal");

    public About(Stage primaryStage) {
        this.primaryStage = primaryStage;
        SetAbout();
    }

    public void SetAbout() {
            // Adiciona padding (margem interior) no painel de 15px
            gridAbout.setStyle("-fx-padding: 15;");
            gridAbout.setAlignment(Pos.CENTER);
    
            Text title = new Text();
            title.setText("TESTE");
    
            // Adiciona todos os controles ao Grid
            gridAbout.getChildren().addAll(title, btnReturn);
    }
    


    
}

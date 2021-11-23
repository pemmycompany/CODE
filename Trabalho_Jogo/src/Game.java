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

public class Game {
    // Criando um estágio
    Stage primaryStage;
    VBox gridGame = new VBox();
    public Scene scene = new Scene(gridGame, 500, 300);

    public Button Return = new Button("Voltar ao menu principal");

    public Game(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    void SetGame() {
        // Adiciona padding (margem interior) no painel de 15px
        gridGame.setStyle("-fx-padding: 15;");
        gridGame.setAlignment(Pos.CENTER);

        // Instancia um novo Text e adiciona seu conteúdo
        Text title = new Text();
        title.setText("O jogo aqui");

        // Adiciona todos os controles ao Grid
        gridGame.getChildren().addAll(title, Return);
    }
}
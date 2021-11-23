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

public class Menu {

    Stage primaryStage;
    VBox gridMenu = new VBox();
    public Scene scene = new Scene(gridMenu, 500, 300);
    //Criando botões para navegação no menu//
    public Button Start = new Button("Novo Jogo");
    public Button About = new Button("Sobre");
    public Button Tutorial = new Button("Como Jogar");
    public Button Quit = new Button("Encerrar");

    public Menu(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    void SetMenu() {

        // Adiciona padding (margem interior) no painel de 15px
        gridMenu.setStyle("-fx-padding: 15;");
        gridMenu.setAlignment(Pos.CENTER);

        // Instancia um novo Text e adiciona seu conteúdo
        Text title = new Text();
        title.setText("Bem-vindo ao Jogo da UNA!");

        //Adiciona todos os controles ao Grid
        gridMenu.getChildren().addAll(title, Start, About, Tutorial, Quit);
    }
}
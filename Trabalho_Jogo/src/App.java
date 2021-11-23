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

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Cria um novo grid
        VBox gridGame = new VBox();
        //Criando a classe
        Menu menu = new Menu(primaryStage);
        Game game = new Game(primaryStage);
        //Chama o método da classe
        game.SetGame();
        menu.SetMenu();

        //Atribui função para iniciar o jogo no botão Start da classe menu
        menu.Start.setOnAction(e -> primaryStage.setScene(game.scene));
        //Atribui função para voltar ao menu botão Return da classe game
        game.Return.setOnAction(e -> primaryStage.setScene(menu.scene));
        
        //Define um título para o menu
        primaryStage.setTitle("Jogo da UNA");
        // Iniciar - define a primeira Cena e a exibe
        primaryStage.setScene(menu.scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

import Scenes.Game;
import Scenes.Menu;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.application.Platform;
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
import Scenes.*;

public class App extends Application {

    // Criando a classe
    Menu menu;
    Game game;
    Tutorial tutorial;
    About about;

    @Override
    public void start(Stage primaryStage) throws Exception {
        music();

        // Cria um novo grid
        VBox gridGame = new VBox();
        // Instanciando as Cenas principais
        menu = new Menu(primaryStage);
        game = new Game(primaryStage);
        tutorial = new Tutorial(primaryStage);
        about = new About(primaryStage);

        // Atribuindo função aos botões do Menu
        setButtons(primaryStage);

        // Define um título para o menu
        primaryStage.setTitle("Jogo da UNA");
        // Iniciar - define a primeira Cena e a exibe
        primaryStage.setScene(menu.scene);
        primaryStage.show();
    }

    MediaPlayer mediaPlayer;
    public void music(){
        String sound = "src/Assets/Music/freshing-your-eye-1789.mp3";
        Media MenuMusic = new Media(Paths.get(sound).toUri().toString());
        mediaPlayer = new MediaPlayer(MenuMusic);
        mediaPlayer.play();
    }


    void setButtons(Stage primaryStage) {
        menu.btnStart.setOnAction(e -> primaryStage.setScene(game.scene));
        game.btnReturn.setOnAction(e -> primaryStage.setScene(menu.scene));
        menu.btnTutorial.setOnAction(e -> primaryStage.setScene(tutorial.scene));
        tutorial.btnReturn.setOnAction(e -> primaryStage.setScene(menu.scene));
        menu.btnAbout.setOnAction(e -> primaryStage.setScene(about.scene));
        about.btnReturn.setOnAction(e -> primaryStage.setScene(menu.scene));

        menu.btnQuit.setOnAction(e -> Platform.exit());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

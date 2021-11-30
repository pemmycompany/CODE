import Scenes.Game;
import Scenes.Menu;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.geometry.Pos;

import java.io.IOException;
import java.nio.file.Paths;

import Components.User;
import Scenes.*;

public class App extends Application {

    // Criando a classe
    Menu menu;
    Game game;
    Tutorial tutorial;
    About about;
    CreateUser createUser;
    SelectPlayer selectPlayer;
    MenuAnimation animation;



    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cria um novo grid
        VBox gridGame = new VBox();
        // Instanciando as Cenas principais
        animation = new MenuAnimation(primaryStage);
        menu = new Menu(primaryStage, animation);
        game = new Game(primaryStage);
        tutorial = new Tutorial(primaryStage);
        about = new About(primaryStage);
        
        

        selectPlayer = new SelectPlayer(primaryStage);
        createUser = new CreateUser(primaryStage, selectPlayer);

        // Atribuindo função aos botões do Menu
        setButtons(primaryStage);
        // Define um título para o menu
        primaryStage.setTitle("Jogo da UNA");
        // Iniciar - define a primeira Cena e a exibe
        primaryStage.setScene(menu.scene);
        primaryStage.show();
        menu.media.setStartTime(Duration.seconds(3));
        menu.media.play();
    }


    void setButtons(Stage primaryStage) {
        menu.btnStart.setOnAction(e -> {
            primaryStage.setScene(createUser.scene);
        });

        game.btnReturn.setOnAction(e -> {
            primaryStage.setScene(menu.scene);
            game.media.stop();
            menu.media.play();
            menu.media.seek(Duration.millis(3000));
        });
        menu.btnTutorial.setOnAction(e -> {
            primaryStage.setScene(tutorial.scene);
            menu.media.stop();
            tutorial.media.play();
        });
        tutorial.btnReturn.setOnAction(e -> {
            primaryStage.setScene(menu.scene);
            tutorial.media.stop();
            menu.media.play();
            menu.media.seek(Duration.millis(3000));
        });
        menu.btnAbout.setOnAction(e -> primaryStage.setScene(about.scene));
        about.btnReturn.setOnAction(e -> primaryStage.setScene(menu.scene));
        createUser.btnReturn.setOnAction(e -> primaryStage.setScene(menu.scene));
        selectPlayer.btnReturn.setOnAction(e -> primaryStage.setScene(createUser.scene));

        menu.btnQuit.setOnAction(e -> Platform.exit());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

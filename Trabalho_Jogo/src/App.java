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
import java.util.ArrayList;
import java.util.Arrays;

import Components.Option;
import Components.Player;
import Components.Question;
import Components.QuestionScene;
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
    Easter_egg easter_egg;
    ScoreBoard scoreBoard;
    Stage primaryStage;

    /*
     * User user_1, user_2;
     * Player player_1, player_2;
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        // Instanciando as Cenas principais
        animation = new MenuAnimation(primaryStage);
        menu = new Menu(primaryStage, animation);
        game = new Game(primaryStage);
        tutorial = new Tutorial(primaryStage);
        about = new About(primaryStage);
        easter_egg = new Easter_egg(primaryStage);

        selectPlayer = new SelectPlayer(primaryStage);
        createUser = new CreateUser(primaryStage, selectPlayer);

        // Atribuindo função aos botões do Menu
        setButtons(primaryStage);
        // Define um título para o menu
        primaryStage.setTitle("Ultimate Una Quiz");
        // Iniciar - define a primeira Cena e a exibe

        primaryStage.setScene(menu.scene);
        primaryStage.show();
        menu.mediamenu.setStartTime(Duration.seconds(3));
        menu.mediamenu.play();
    }

    void setButtons(Stage primaryStage) {
        menu.btnStart.setOnAction(e -> {
            game.player_1 = new Player("VanishMan", new String[] { "" }, true, 100f);
            game.player_2 = new Player("DeterGente", new String[] { "" }, true, 100f);
            game.ResetGame();
            game.SetGame();
            primaryStage.setScene(game.scene);
        });

        game.btnReturn.setOnAction(e -> {
            primaryStage.setScene(menu.scene);
            game.Reset();
            game.media.stop();
            menu.mediamenu.play();
            menu.mediamenu.seek(Duration.millis(3000));
        });
        menu.btnTutorial.setOnAction(e -> {
            primaryStage.setScene(tutorial.scene);
            menu.mediamenu.stop();
            tutorial.media.play();
        });
        tutorial.btnReturn.setOnAction(e -> {
            primaryStage.setScene(menu.scene);
            tutorial.media.stop();
            menu.mediamenu.play();
            menu.mediamenu.seek(Duration.millis(3000));
        });
        menu.btnAbout.setOnAction(e -> primaryStage.setScene(about.scene));
        about.btnReturn.setOnAction(e -> primaryStage.setScene(menu.scene));
        createUser.btnReturn.setOnAction(e -> {
            primaryStage.setScene(menu.scene);
            createUser.ResetForm();

        });
        selectPlayer.btnReturn.setOnAction(e -> {
            primaryStage.setScene(createUser.scene);
            selectPlayer.ResetForm();
            createUser.ResetForm();
        });

        animation.btnEgg.setOnAction(e -> {
            primaryStage.setScene(easter_egg.scene);
            menu.mediamenu.stop();
            easter_egg.media.play();
        });
        easter_egg.btnReturn.setOnAction(e -> {
            primaryStage.setScene(menu.scene);
            easter_egg.media.stop();
            menu.mediamenu.play();
            menu.mediamenu.seek(Duration.millis(3000));
        });

        selectPlayer.btnStart.setOnAction(e -> {
            game.user_1 = createUser.User_01;
            game.user_2 = createUser.User_02;
            game.player_1 = selectPlayer.Players.get(selectPlayer.user01_PlayerID);
            game.player_2 = selectPlayer.Players.get(selectPlayer.user02_PlayerID);
            game.SetGame();
            primaryStage.setScene(game.scene);
            menu.mediamenu.stop();
            game.media.play();
        });

        game.btnConfirmStop.setOnAction(e -> {
            scoreBoard = new ScoreBoard(primaryStage, game.p1HealthBar, game.p2HealthBar);
            scoreBoard.setScore(game.user_1, game.user_2, game.player_1, game.player_2);
            game.stopStage.close();
            primaryStage.setScene(scoreBoard.scene);
            game.media.stop();
            menu.mediamenu.stop();
            scoreBoard.media.play();

            scoreBoard.btnReturn.setOnAction(ev -> {
                game.ResetGame();
                primaryStage.setScene(menu.scene);
                scoreBoard.media.stop();
                menu.mediamenu.play();
            });
        });

        game.btnDenyStop.setOnAction(e -> {
            game.DenyStop();
            scoreBoard = new ScoreBoard(primaryStage, game.p1HealthBar, game.p2HealthBar);
            scoreBoard.setScore(game.user_1, game.user_2, game.player_1, game.player_2);
            game.stopStage.close();
            primaryStage.setScene(scoreBoard.scene);
            game.media.stop();
            menu.mediamenu.stop();
            scoreBoard.media.play();

            scoreBoard.btnReturn.setOnAction(ev -> {
                game.ResetGame();
                primaryStage.setScene(menu.scene);
                scoreBoard.media.stop();
                menu.mediamenu.play();
            });
        });

        menu.btnQuit.setOnAction(e -> Platform.exit());
    }

    public static void main(String[] args) {
        launch(args);
    }
}

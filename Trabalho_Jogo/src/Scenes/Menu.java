package Scenes;

import java.nio.file.Paths;

import Components.User;
import Scenes.MenuAnimation;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.media.Media;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Menu {

    public static User user_01;
    public static User user_02;

    public static void SetUser(int number, User user) {
        if (number == 1) {
            user_01 = user;
        }
        else{
            user_02 = user;
        }
    }

    public static User GetUser(int number) {
        if (number == 1) {
            return user_01;
        }
        else{
            return user_02;
        }
    }

    // Criando variáveis para o rgb do Backgrauond
    int R = 16;
    int G = 16;
    int B = 16;

    int[] firstColor = new int[] { 20, 21, 40 };
    int[] secondColor = new int[] { 22, 28, 119 };

    boolean finishedFirst = false;

    Stage primaryStage;
    public VBox gridMenu = new VBox();
    public Scene scene = new Scene(gridMenu, 800, 600, Color.rgb(firstColor[0], firstColor[1], firstColor[2]));

    // Criando botões para navegação no menu//
    public Button btnStart = new Button("Novo Jogo");
    public Button btnAbout = new Button("Sobre");
    public Button btnTutorial = new Button("Como Jogar");
    public Button btnQuit = new Button("Encerrar");

    public MediaPlayer media;
    private MenuAnimation menuAnimation;
    

    public Menu(Stage primaryStage, MenuAnimation menuAnimation) {
        this.primaryStage = primaryStage;
        this.menuAnimation = menuAnimation;

        SetMenu();
    }

    private void SetMenu() {

        // Adiciona padding (margem interior) no painel de 15px
        gridMenu.setStyle("-fx-padding: 15; -fx-maring: 30;");
        gridMenu.setAlignment(Pos.CENTER);
        gridMenu.setSpacing(5);
        gridMenu.setBackground(null);

        // Instancia um novo Text e adiciona seu conteúdo
        DropShadow darkshadow = new DropShadow();
        darkshadow.setOffsetY(3.0f);
        darkshadow.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Label title = new Label();

        title.setStyle("-fx-font: 24 castellar; -fx-text-fill: white");
        title.setEffect(darkshadow);
        title.setCache(true);
        title.setText("100 PERGUNTA");
        title.setFont(Font.font(null, FontWeight.BOLD, 32));
        title.setPadding(new Insets(15));

        title.setLineSpacing(20.0);

        btnStart.setPrefWidth(100);
        btnAbout.setPrefWidth(100);
        btnTutorial.setPrefWidth(100);
        btnQuit.setPrefWidth(100);

        // Adiciona todos os controles ao Grid
        gridMenu.getChildren().addAll(title, btnStart, btnAbout, btnTutorial, btnQuit, menuAnimation.btnEgg, menuAnimation.circle, menuAnimation.circle3);

        String sound = "Assets/Music/Menu.wav";
        Media MenuMusic = new Media(Paths.get(sound).toUri().toString());
        media = new MediaPlayer(MenuMusic);

        media.setOnEndOfMedia(new Runnable() {
            public void run() {
                media.seek(Duration.ZERO);
                media.play();
            }
        });

        // Função para troca de cor no fundo
        PauseTransition pause = new PauseTransition(Duration.millis(20));

        pause.setOnFinished(event -> {
            gridMenu.setStyle("-fx-base: rgb(" + R + "," + G + "," + B + ")");
            if (!finishedFirst)
                finishedFirst = changeColor(firstColor);// rgb(76, 58, 142)

            if (finishedFirst) {
                var completed = changeColor(secondColor);// rgb(125, 62, 107)
                if (completed)
                    finishedFirst = false;
            }

            primaryStage.setTitle(Integer.toString(G));
            pause.play();
        });
        pause.play();
    }

    boolean changeColor(int[] target) {
        R += (R > target[0] ? -1 : 1);
        G += (G > target[1] ? -1 : 1);
        B += (B > target[2] ? -1 : 1);

        return isBetween(R, target[0] - 1, target[0] + 1)
                && isBetween(G, target[1] - 1, target[1] + 1)
                && isBetween(B, target[2] - 1, target[2] + 1);
    }

    boolean isBetween(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
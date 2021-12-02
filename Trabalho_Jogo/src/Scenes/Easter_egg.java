package Scenes;

import java.io.File;
import java.nio.file.Paths;
import java.security.PublicKey;

import javax.xml.crypto.dsig.TransformService;

import Components.User;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.Media;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Easter_egg {

    Stage primaryStage;
    VBox gridEaster_egg = new VBox();
    public Scene scene = new Scene(gridEaster_egg, 800, 600);
    public Button btnReturn = new Button("Voltar");

    public MediaPlayer media;

    public Easter_egg(Stage primarystage){
        this.primaryStage = primarystage;
        setEaster_egg();
    }

    public void setEaster_egg(){

        // Adiciona padding (margem interior) no painel de 15px
        gridEaster_egg.setStyle("-fx-padding: 15;");
        gridEaster_egg.setAlignment(Pos.CENTER);

        // Adicionando video para o grid
        //getClass().getResource("/Assets/IMG/DeterGente.jpg").toString()
        String path = "Assets/Video/Funny.mp4";

        Media videomedia = new Media(Paths.get(path).toUri().toString());

        // Media videoMedia = new Media(getClass().getResource("/Assets/Video/Funny.mp4").toString());
        
        MediaPlayer player = new MediaPlayer(videomedia);

        MediaView mediaView = new MediaView(player);

        player.setCycleCount(MediaPlayer.INDEFINITE);

        player.play();

         // Adiciona todos os controles ao Grid
        gridEaster_egg.getChildren().addAll(mediaView, btnReturn);

        String sound = "Assets/Music/steveDano.wav";
        Media eggmMedia = new Media(Paths.get(sound).toUri().toString());
        media = new MediaPlayer(eggmMedia);

        media.setOnEndOfMedia(new Runnable() {
            public void run() {
                media.seek(Duration.ZERO);
            }
        });

        



    }
    
    
}

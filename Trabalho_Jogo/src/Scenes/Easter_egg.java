package Scenes;

import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Easter_egg {

    Stage primaryStage;
    VBox gridEaster_egg = new VBox();
    public Scene scene = new Scene(gridEaster_egg, 800, 600);
    public Button btnReturn = new Button("Voltar");

    public MediaPlayer easterMedia;
    public MediaPlayer player;
    public MediaView mediaView;

    public Easter_egg(Stage primarystage){
        this.primaryStage = primarystage;
        setEaster_egg();
    }

    public void setEaster_egg(){
        scene.getStylesheets().add("Assets/Styles/about.css");

        // Adiciona padding (margem interior) no painel de 15px
        gridEaster_egg.setStyle("-fx-padding: 15;");
        gridEaster_egg.setAlignment(Pos.CENTER);
        gridEaster_egg.setSpacing(10);

        // Adicionando video para o grid
        String path = "Assets/Video/Funny.mp4";
        Media videomedia = new Media(Paths.get(path).toUri().toString());
        player = new MediaPlayer(videomedia);
        mediaView = new MediaView(player);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        
        HBox rowMedia = new HBox(); 
        rowMedia.getChildren().add(mediaView);
        rowMedia.setAlignment(Pos.CENTER);

        HBox rowbtn = new HBox(); 
        rowbtn.getChildren().add(btnReturn);
        rowbtn.setAlignment(Pos.BOTTOM_CENTER);

         // Adiciona todos os controles ao Grid
        gridEaster_egg.getChildren().addAll(rowMedia, rowbtn);
        gridEaster_egg.getStyleClass().add("imgbackegg");

        String sound = "Assets/Music/steveDano.wav";
        Media eggmMedia = new Media(Paths.get(sound).toUri().toString());
        easterMedia = new MediaPlayer(eggmMedia);

        easterMedia.setOnEndOfMedia(new Runnable() {
            public void run() {
                easterMedia.seek(Duration.ZERO);
            }
        });

        



    }
    
    
}

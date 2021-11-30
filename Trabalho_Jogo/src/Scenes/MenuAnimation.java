package Scenes;

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

public class MenuAnimation {

    public Button btnEgg = new Button("?");
    public Circle circle = new Circle();
    public Circle circle3 = new Circle();
    // public Circle circle3Circle = new Circle();

    public MenuAnimation(Stage primarStage){
        setMenuAnimation();
    }

    public void setMenuAnimation(){

       //Circulo um Preto
        circle.setFill(Color.BLACK);
        circle.setRadius(6);

        final Duration SecondsOne = Duration.millis(2000);
        final Duration SecondsTwo = Duration.millis(2000);

        FadeTransition ft = new FadeTransition(SecondsTwo);
        ft.setFromValue(1.0f);
        ft.setToValue(0.3f);
        ft.setCycleCount(2);
        // ft.setAutoReverse(true);

        TranslateTransition transition = new TranslateTransition(SecondsOne);
        transition.setDuration(Duration.seconds(1));
        transition.setFromX(-100f);
        transition.setToX(100);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(circle);
        transition.play();

        RotateTransition rt = new RotateTransition(SecondsTwo);
        rt.setByAngle(-100f);
        rt.setCycleCount(2);

        ScaleTransition st = new ScaleTransition(SecondsOne);
        st.setByX(1.5f);
        st.setByY(1.5f);
        st.setCycleCount(2);

        Circle circle2 = new Circle(180);
        circle2.setFill(Color.WHITE);
        circle2.setLayoutX(0);
        circle2.setLayoutY(-100);

        PathTransition pl = new PathTransition();
        pl.setNode(circle);
        pl.setPath(circle2);
        pl.setDuration(Duration.seconds(1));
        pl.setCycleCount(Animation.INDEFINITE);
        pl.play();

      
        //Circulo dois Branco

        circle3.setFill(Color.WHITE);
        circle3.setRadius(6);

        final Duration SecondsThree = Duration.millis(2000);
        final Duration SecondsFour = Duration.millis(2000);

        FadeTransition ft3 = new FadeTransition(SecondsFour);
        ft3.setFromValue(1.0f);
        ft3.setToValue(0.3f);
        ft3.setCycleCount(2);
        // ft3.setAutoReverse(true);

        TranslateTransition transition2 = new TranslateTransition(SecondsThree);
        transition2.setDuration(Duration.seconds(1));
        transition2.setFromX(-100f);
        transition2.setToX(100);
        transition2.setCycleCount(Animation.INDEFINITE);
        transition2.setNode(circle3);
        transition2.play();

        RotateTransition rt3 = new RotateTransition(SecondsFour);
        rt3.setByAngle(-100f);
        rt3.setCycleCount(2);
        rt3.setAutoReverse(true);

        ScaleTransition st3 = new ScaleTransition(SecondsThree);
        st3.setByX(1.5f);
        st3.setByY(1.5f);
        st3.setCycleCount(2);

        Circle circle4 = new Circle(180);
        circle4.setFill(Color.WHITE);
        circle4.setLayoutX(0);
        circle4.setLayoutY(-100);
        circle4.setNodeOrientation(null);

        PathTransition pl3 = new PathTransition();
        pl3.setNode(circle3);
        pl3.setPath(circle4);
        pl3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pl3.setDuration(Duration.seconds(1));
        pl3.setCycleCount(Animation.INDEFINITE);
        pl3.play();



        // Retangulo
        Rectangle rectangle = new Rectangle(250, 250);
        rectangle.setLayoutX(-115);
        rectangle.setLayoutY(-200);

        final Duration SecondsFive = Duration.millis(2000);
        final Duration SecondsSix = Duration.millis(2000);

        FadeTransition ft2 = new FadeTransition(SecondsSix);
        ft2.setFromValue(1.0f);
        ft2.setToValue(0.3f);
        ft2.setCycleCount(2);
        ft2.setAutoReverse(true);

        TranslateTransition transition3 = new TranslateTransition(SecondsFive);
        transition3.setDuration(Duration.seconds(5));
        transition3.setFromX(0f);
        transition3.setToX(100);
        transition3.setCycleCount(Animation.INDEFINITE);
        transition3.setNode(btnEgg);
        transition3.play();

        RotateTransition rt2 = new RotateTransition(SecondsSix);
        rt2.setByAngle(-100f);
        rt2.setCycleCount(1);

        ScaleTransition st2 = new ScaleTransition(SecondsFive);
        st2.setByX(1.5f);
        st2.setByY(1.5f);
        st2.setCycleCount(1);

        PathTransition pl2 = new PathTransition();
        pl2.setNode(btnEgg);
        pl2.setPath(rectangle);
        pl2.setDuration(Duration.seconds(8));
        pl2.setCycleCount(Animation.INDEFINITE);
        pl2.play(); 


    }
    
}

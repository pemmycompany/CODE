package Scenes;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuAnimation {

    public Button btnEgg = new Button("?");
    public Circle blackCircle = new Circle();
    public Circle whiteCircle = new Circle();
    // public Circle circle3Circle = new Circle();

    public MenuAnimation(Stage primarStage){
        setMenuAnimation();
    }

    public void setMenuAnimation(){

       //Circulo um Preto
       blackCircle.setFill(Color.BLACK);
       blackCircle.setRadius(6);

        final Duration SecondsOne = Duration.millis(2000);
        final Duration SecondsTwo = Duration.millis(2000);

        FadeTransition fadeTrans = new FadeTransition(SecondsTwo);
        fadeTrans.setFromValue(1.0f);
        fadeTrans.setToValue(0.3f);
        fadeTrans.setCycleCount(2);
        // fadeTrans.setAutoReverse(true);

        TranslateTransition transition = new TranslateTransition(SecondsOne);
        transition.setDuration(Duration.seconds(1));
        transition.setFromX(-100f);
        transition.setToX(100);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.setNode(blackCircle);
        transition.play();
        //Rotação do Circulo
        RotateTransition rotTrans = new RotateTransition(SecondsTwo);
        rotTrans.setByAngle(-100f);
        rotTrans.setCycleCount(2);
        //Tamanho da rotação do Circulo
        ScaleTransition scalTrans = new ScaleTransition(SecondsOne);
        scalTrans.setByX(1.5f);
        scalTrans.setByY(1.5f);
        scalTrans.setCycleCount(2);
        
        Circle modelCircle = new Circle(250);
        modelCircle.setFill(Color.WHITE);
        modelCircle.setLayoutX(0);
        modelCircle.setLayoutY(-100);

        PathTransition patTrans = new PathTransition();
        patTrans.setNode(blackCircle);
        patTrans.setPath(modelCircle);
        patTrans.setDuration(Duration.seconds(1));
        patTrans.setCycleCount(Animation.INDEFINITE);
        patTrans.play();

      
        //Circulo dois Branco

        whiteCircle.setFill(Color.WHITE);
        whiteCircle.setRadius(6);

        final Duration SecondsThree = Duration.millis(2000);
        final Duration SecondsFour = Duration.millis(2000);

        FadeTransition fadeTrans3 = new FadeTransition(SecondsFour);
        fadeTrans3.setFromValue(1.0f);
        fadeTrans3.setToValue(0.3f);
        fadeTrans3.setCycleCount(2);
        // ft3.setAutoReverse(true);

        TranslateTransition transition2 = new TranslateTransition(SecondsThree);
        transition2.setDuration(Duration.seconds(1));
        transition2.setFromX(-100f);
        transition2.setToX(100);
        transition2.setCycleCount(Animation.INDEFINITE);
        transition2.setNode(whiteCircle);
        transition2.play();

        RotateTransition rotTrans3 = new RotateTransition(SecondsFour);
        rotTrans3.setByAngle(-100f);
        rotTrans3.setCycleCount(2);
        rotTrans3.setAutoReverse(true);

        ScaleTransition scalTrans3 = new ScaleTransition(SecondsThree);
        scalTrans3.setByX(1.5f);
        scalTrans3.setByY(1.5f);
        scalTrans3.setCycleCount(2);

        Circle modelCircle1 = new Circle(250);
        modelCircle1.setFill(Color.WHITE);
        modelCircle1.setLayoutX(0);
        modelCircle1.setLayoutY(-100);
        modelCircle1.setNodeOrientation(null);

        PathTransition patTrans3 = new PathTransition();
        patTrans3.setNode(whiteCircle);
        patTrans3.setPath(modelCircle1);
        patTrans3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        patTrans3.setDuration(Duration.seconds(1));
        patTrans3.setCycleCount(Animation.INDEFINITE);
        patTrans3.play();



        // Cria eixo em formato de Retangulo para o movimento do ícone do EasterEgg
        Rectangle rectangle = new Rectangle(200, 150);
        rectangle.setLayoutX(-90);
        rectangle.setLayoutY(-133);

        final Duration SecondsFive = Duration.millis(2000);
        final Duration SecondsSix = Duration.millis(2000);

        FadeTransition fadeTrans2 = new FadeTransition(SecondsSix);
        fadeTrans2.setFromValue(1.0f);
        fadeTrans2.setToValue(0.3f);
        fadeTrans2.setCycleCount(2);
        fadeTrans2.setAutoReverse(true);

        TranslateTransition transition3 = new TranslateTransition(SecondsFive);
        transition3.setDuration(Duration.seconds(5));
        transition3.setFromX(0f);
        transition3.setToX(100);
        transition3.setCycleCount(Animation.INDEFINITE);
        transition3.setNode(btnEgg);
        transition3.play();

        RotateTransition rotTrans2 = new RotateTransition(SecondsSix);
        rotTrans2.setByAngle(-100f);
        rotTrans2.setCycleCount(1);

        ScaleTransition scalTrans2 = new ScaleTransition(SecondsFive);
        scalTrans2.setByX(1.5f);
        scalTrans2.setByY(1.5f);
        scalTrans2.setCycleCount(1);

        PathTransition patTrans2 = new PathTransition();
        patTrans2.setNode(btnEgg);
        patTrans2.setPath(rectangle);
        patTrans2.setDuration(Duration.seconds(8));
        patTrans2.setCycleCount(Animation.INDEFINITE);
        patTrans2.play(); 


    }
    
}

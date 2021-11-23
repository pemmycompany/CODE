import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Cria o painel Raiz
        GridPane root = new GridPane();
        //Adiciona uma Cena nesse painel, com tamanho de 500x300
        Scene scene = new Scene(root, 500, 300);

        //Adiciona padding (margem interior) no painel de 15px
        root.setStyle("-fx-padding: 15;");

        //Instancia um novo Text e adiciona seu conteúdo
        Text title = new Text();
        title.setText("Bem-vindo ao Jogo da UNA!");

        Button Start = new Button("Novo Jogo");




        //adiciona uma nova linha no grid, contendo somente o title
        root.addRow(1, title);
        root.setVgap(10);
        root.addRow(2, Start);
        root.setVgap(10);


        //Iniciar - chamar após setar todos os controles
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        /* Text text = new Text();

        text.setText("Welcome to Portal");
        text.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.REGULAR, 20));
        primaryStage.setTitle("JavaFX Login");
        Label name = new Label("UserName2");
        Label pass = new Label("Password");
        TextField tf1 = new TextField();
        PasswordField tf2 = new PasswordField();
        Button Submit = new Button("Submit");

        root.addRow(1, text);
        root.setVgap(10);
        root.addRow(2, name, tf1);
        root.setVgap(10);
        root.addRow(3, pass, tf2);
        root.setVgap(10);
        root.addRow(4, Submit);
        root.setVgap(10);
     
        
        primaryStage.setScene(scene);
        primaryStage.show();


        // Button Events and Menu events here
        String s[]= new String[1];
        Text t = new Text();
        
        Submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (tf1.getText().isEmpty()) {
                    if (t.getText().isEmpty() == false) {
                        root.getChildren().remove(t);
                    }
                    t.setText("Form Error! Please enter your name");
                    root.addRow(5, t);
                    return;
                }
                if (tf2.getText().isEmpty()) {
                    if (t.getText().isEmpty() == false) {
                        root.getChildren().remove(t);
                    }
                    t.setText("Form Error! Please enter your password");
                    root.addRow(6, t);
                    return;
                }
                if (t.getText().isEmpty() == false) {
                    root.getChildren().remove(t);
                }
                t.setText("Registration Successful!" + " Welcome " + tf1.getText());
                root.addRow(7, t);
            }
        }); */
    } 
    public static void main(String[] args) {
        launch(args);
    }
}


package Scenes;

import java.nio.file.Paths;
import java.util.ArrayList;

import Components.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class SelectPlayer {

        Stage primaryStage;
        VBox gridGame = new VBox(5);
        public Scene scene = new Scene(gridGame, 800, 600, Color.GRAY);
        public Button btnReturn = new Button("Voltar");

        ArrayList<Player> Players = new ArrayList<Player>();

        Label lblP1 = new Label("Jogador_1");
        Label lblP2 = new Label("Jogador_2");

        Label lblPlayerName = new Label("-");
        Label lblSkills = new Label("-");
        Label lblHealth = new Label("-");

        Player user01_Player;
        Player user02_Player;

        public SelectPlayer(Stage primaryStage) {
                scene.getStylesheets().add("Assets/Styles/selectPlayer.css");

                this.primaryStage = primaryStage;
                setPlayer();

                Players.add(new Player("VanishMan", new String[] { "Invisibilidade", "Super Visão", "Lentidão" }, true,
                                100.0f));
                Players.add(new Player("DeterGente", new String[] { "Detêm qualquer gente",
                                "Perde mais vida ao errar consecutivamente ", "Pode retirar uma alternativa" }, true,
                                105.0f));
                Players.add(new Player("Lysoform",
                                new String[] { "Agilidade", "Ganha 2 de vida a cada acerto",
                                                "perde 2.5 de vida a cada erro" },
                                true,
                                100.0f));
                Players.add(new Player("MrMúsculo", new String[] { "Super Força", "Remove toda a Gordura", "Barato" },
                                true, 150.0f));
                Players.add(new Player("PinhoSol", new String[] { "Radiante", "Sanitário", "Retarda qualquer inseto" },
                                true, 100.0f));
        }

        void setPlayer() {
                primaryStage.setTitle("Cadastro dos Jogadores");

                // Adiciona padding (margem interior) no painel de 15px
                gridGame.setStyle("-fx-padding: 80;");
                gridGame.setAlignment(Pos.CENTER);

                // Jogador 1 vs Jogador 2_______________________________________________________
                lblP1.setFont(Font.font("Calibri", 25));
                lblP1.setStyle("-fx-text-fill: rgb(22, 28, 202);");

                lblP2.setFont(Font.font("Calibri", 25));
                lblP2.setStyle("-fx-text-fill: rgb(183, 21, 21);");

                Label lblVS = new Label(" VS ");
                lblVS.setFont(Font.font("Calibri", 17));
                HBox vsRow = new HBox();
                vsRow.getChildren().addAll(lblP1, lblVS, lblP2);
                vsRow.setPadding(new Insets(20));
                vsRow.setAlignment(Pos.TOP_CENTER);

                HBox playersRow = new HBox();
                playersRow.getChildren().addAll(lblP1, lblVS, lblP2);
                playersRow.setAlignment(Pos.CENTER);

                // VanishMan_____________________
                Image vanishManIMG = new Image(getClass().getResource("/Assets/IMG/VanishMan.jpg").toString());
                ImageView vanishMan = new ImageView(vanishManIMG);
                vanishMan.setFitWidth(100);
                vanishMan.setPreserveRatio(true);
                vanishMan.setSmooth(true);
                vanishMan.setCache(true);
                VBox vanishManBox = new VBox();
                vanishManBox.getChildren().add(vanishMan);
                vanishManBox.getStyleClass().add("playerIMG");
                vanishManBox.setId("0");

                /* vanishMan.getStyleClass().add("playerIMG"); */

                // DeterGente_____________________
                Image DeterGentIMG = new Image(getClass().getResource("/Assets/IMG/DeterGente.jpg").toString());
                ImageView DeterGente = new ImageView(DeterGentIMG);
                DeterGente.setFitWidth(100);
                DeterGente.setPreserveRatio(true);
                DeterGente.setSmooth(true);
                DeterGente.setCache(true);
                VBox deterGenteManBox = new VBox();
                deterGenteManBox.getChildren().add(DeterGente);
                deterGenteManBox.getStyleClass().add("playerIMG");
                deterGenteManBox.setId("1");

                // LysoForm_____________________
                Image LysoFormIMG = new Image(getClass().getResource("/Assets/IMG/Lysoform.jpg").toString());
                ImageView LysoForm = new ImageView(LysoFormIMG);
                LysoForm.setFitWidth(100);
                LysoForm.setPreserveRatio(true);
                LysoForm.setSmooth(true);
                LysoForm.setCache(true);
                VBox lysoFormBox = new VBox();
                lysoFormBox.getChildren().add(LysoForm);
                lysoFormBox.getStyleClass().add("playerIMG");
                lysoFormBox.setId("2");

                // MrMusculo_____________________
                Image MrMusculoIMG = new Image(getClass().getResource("/Assets/IMG/MrMusculo.jpg").toString());
                ImageView MrMusculo = new ImageView(MrMusculoIMG);
                MrMusculo.setFitWidth(100);
                MrMusculo.setPreserveRatio(true);
                MrMusculo.setSmooth(true);
                MrMusculo.setCache(true);
                VBox mrMusculoBox = new VBox();
                mrMusculoBox.getChildren().add(MrMusculo);
                mrMusculoBox.getStyleClass().add("playerIMG");
                mrMusculoBox.setId("3");

                // PinhoSol_____________________
                Image PinhoSolIMG = new Image(getClass().getResource("/Assets/IMG/PinhoSol.jpg").toString());
                ImageView PinhoSol = new ImageView(PinhoSolIMG);
                PinhoSol.setFitWidth(100);
                PinhoSol.setPreserveRatio(true);
                PinhoSol.setSmooth(true);
                PinhoSol.setCache(true);
                VBox pinhoSolBox = new VBox();
                pinhoSolBox.getChildren().add(PinhoSol);
                pinhoSolBox.getStyleClass().add("playerIMG");
                pinhoSolBox.setId("4");

                // Colocando a imagem horizontalmente da linha 1
                HBox row1 = new HBox();
                row1.setSpacing(10);
                row1.setAlignment(Pos.CENTER);
                row1.getChildren().addAll(vanishManBox, deterGenteManBox, lysoFormBox);

                // Colocando a imagem horizontalmente da linha 2
                HBox row2 = new HBox();
                row2.setSpacing(10);
                row2.setAlignment(Pos.CENTER);
                row2.getChildren().addAll(mrMusculoBox, pinhoSolBox);

                HBox panels = new HBox();
                VBox sideMenu = new VBox();
                VBox images = new VBox();

                Label nameLabel = new Label("Nome: ");
                nameLabel.setFont(Font.font("Calibri", 15));
                nameLabel.getStyleClass().add("fieldLabel");
                lblPlayerName.setFont(Font.font("Calibri", 15));
                lblPlayerName.setWrapText(true);

                Label skillsLabel = new Label("Habilidades: ");
                skillsLabel.setFont(Font.font("Calibri", 15));
                skillsLabel.getStyleClass().add("fieldLabel");
                lblSkills.setFont(Font.font("Calibri", 15));
                lblSkills.setWrapText(true);

                Label healthLabel = new Label("Vida: ");
                healthLabel.setFont(Font.font("Calibri", 15));
                healthLabel.getStyleClass().add("fieldLabel");
                lblHealth.setFont(Font.font("Calibri", 15));
                lblSkills.setWrapText(true);

                sideMenu.getChildren().addAll(nameLabel, lblPlayerName,skillsLabel, lblSkills,healthLabel, lblHealth);
                sideMenu.setSpacing(10);
                sideMenu.setAlignment(Pos.CENTER_LEFT);
                sideMenu.setStyle("-fx-background-color: rgb(195, 195, 195); -fx-padding: 70;");

                images.getChildren().addAll(row1, row2);

                Button btnSubmit = new Button("Salvar");
                btnSubmit.setPrefWidth(100);
                btnSubmit.setPrefHeight(40);
                btnSubmit.setFont(Font.font("Calibri", 16));

                btnReturn.setPrefHeight(40);
                btnReturn.setFont(Font.font("Calibri", 16));

                HBox btnRow = new HBox();
                btnRow.getChildren().addAll(btnReturn, btnSubmit);
                btnRow.setAlignment(Pos.BOTTOM_CENTER);
                btnRow.setSpacing(10);

                panels.getChildren().addAll(sideMenu, images);
                panels.setSpacing(10);
                panels.setAlignment(Pos.CENTER);

                gridGame.getChildren().addAll(playersRow, panels, btnRow);

                var hoverOn = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                                setHoveredPlayer(((VBox) e.getTarget()).getId());
                        }
                };

                /* var hoverOut = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                                resetHoveredPlayer(((VBox) e.getTarget()).getId());
                        }
                }; */

                var onClick = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                                setSelectedPlayer(((VBox) e.getTarget()).getId());
                        }
                };

                vanishManBox.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                //vanishManBox.addEventHandler(MouseEvent.MOUSE_EXITED,hoverOut);
                vanishManBox.addEventHandler(MouseEvent.MOUSE_CLICKED,onClick);

                deterGenteManBox.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                //deterGenteManBox.addEventHandler(MouseEvent.MOUSE_EXITED,hoverOut);
                deterGenteManBox.addEventHandler(MouseEvent.MOUSE_CLICKED,onClick);

                lysoFormBox.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                //lysoFormBox.addEventHandler(MouseEvent.MOUSE_EXITED,hoverOut);
                lysoFormBox.addEventHandler(MouseEvent.MOUSE_CLICKED,onClick);

                mrMusculoBox.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                //mrMusculoBox.addEventHandler(MouseEvent.MOUSE_EXITED,hoverOut);
                mrMusculoBox.addEventHandler(MouseEvent.MOUSE_CLICKED,onClick);

                pinhoSolBox.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                //pinhoSolBox.addEventHandler(MouseEvent.MOUSE_EXITED,hoverOut);
                pinhoSolBox.addEventHandler(MouseEvent.MOUSE_CLICKED,onClick);



        }

        public void activate() {
                lblP1.setText(Menu.GetUser(1).getName());
                lblP2.setText(Menu.GetUser(2).getName());
        }

        void setHoveredPlayer(String _id) {
                var id = Integer.parseInt(_id);
                var player = Players.get(id);

                lblPlayerName.setText(player.getName());
                String skills = "";
                for (String skill : player.getSkills()) {
                        skills += skill + ", ";
                }
                lblSkills.setText(skills.substring(0,skills.length() - 2) + ".");
                lblHealth.setText(Float.toString(player.getHealth()));
        }

        /* void resetHoveredPlayer(String _id) {
                var id = Integer.parseInt(_id);
                var player = Players.get(id);
                lblPlayerName.setText("-");
                lblSkills.setText("-");
                lblHealth.setText("-");
        } */

        void setSelectedPlayer(String _id) {
                var id = Integer.parseInt(_id);
        }
}
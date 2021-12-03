package Scenes;

import java.nio.file.Paths;
import java.util.ArrayList;

import Components.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Node;
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
        public Scene scene = new Scene(gridGame, 800, 600);
        public Button btnReturn = new Button("Voltar");

        public ArrayList<Player> Players = new ArrayList<Player>();

        Label lblP1 = new Label("Jogador_1");
        Label lblP2 = new Label("Jogador_2");
        Label lblSel1 = new Label("Personagem_1");
        Label lblSel2 = new Label("Personagem_2");
        Label lblSelectionTurn = new Label("Escolha o personagem do jogador 1");

        Label lblPlayerName = new Label("-");
        Label lblSkills = new Label("-");
        Label lblHealth = new Label("-");
        HBox panels = new HBox();
        VBox lastSelected;

        public Button btnStart = new Button("Selecionar");
        Button btnSubmit = new Button("Selecionar");

        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox btnRow = new HBox();

        public int user01_PlayerID;
        public int user02_PlayerID;

        public int currentPlayer = 1;

        public SelectPlayer(Stage primaryStage) {
                scene.getStylesheets().add("Assets/Styles/selectPlayer.css");

                this.primaryStage = primaryStage;
                setPlayer();

                Players.add(new Player("VanishMan", new String[] { "Invisibilidade", "Super Visao", "Lentidao" }, true,
                                100.0f));
                Players.add(new Player("DeterGente & 'P'", new String[] { "Detêm qualquer gente",
                                "Perde mais vida ao errar consecutivamente ", "Pode retirar uma alternativa" }, true,
                                105.0f));
                Players.add(new Player("Lysoformador",
                                new String[] { "Agilidade", "Ganha 2 de vida a cada acerto",
                                                "perde 2.5 de vida a cada erro" },
                                true,
                                100.0f));
                Players.add(new Player("MrMusculoso", new String[] { "Super Forte", "Remove toda a Gordura", "Barato" },
                                true, 150.0f));
                Players.add(new Player("PinhoSolar",
                                new String[] { "Radiante", "Sanitario", "Retarda qualquer inseto" },
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

                lblSel1.setFont(Font.font("Calibri", 15));
                lblSel1.setStyle("-fx-text-fill: rgb(175, 19, 19); -fx-padding: 3");

                lblSel2.setFont(Font.font("Calibri", 15));
                lblSel2.setStyle("-fx-text-fill: rgb(20, 25, 195); -fx-padding: 3");

                lblSelectionTurn.setFont(Font.font("Calibri", 30));

                Label lblVS = new Label(" VS ");
                lblVS.setFont(Font.font("Calibri", 17));
                HBox vsRow = new HBox();
                vsRow.getChildren().addAll(lblP1, lblVS, lblP2);
                vsRow.setPadding(new Insets(20));
                vsRow.setAlignment(Pos.TOP_CENTER);

                HBox playersRow = new HBox();
                playersRow.getChildren().addAll(lblP1, lblVS, lblP2);
                playersRow.setAlignment(Pos.CENTER);

                HBox selectedRow = new HBox();
                selectedRow.getChildren().addAll(lblSel1, lblSel2);
                selectedRow.setAlignment(Pos.CENTER);

                HBox turnRow = new HBox();
                turnRow.getChildren().addAll(lblSelectionTurn);
                turnRow.setAlignment(Pos.CENTER);

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
                vanishMan.setId("0");
                vanishManBox.setId("b0");

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
                DeterGente.setId("1");
                deterGenteManBox.setId("b1");

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
                LysoForm.setId("2");
                lysoFormBox.setId("b2");

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
                MrMusculo.setId("3");
                mrMusculoBox.setId("b3");

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
                PinhoSol.setId("4");
                pinhoSolBox.setId("b4");

                // Colocando a imagem horizontalmente da linha 1
                row1.setSpacing(10);
                row1.setAlignment(Pos.CENTER);
                row1.getChildren().addAll(vanishManBox, deterGenteManBox, lysoFormBox);

                // Colocando a imagem horizontalmente da linha 2
                row2.setSpacing(10);
                row2.setAlignment(Pos.CENTER);
                row2.getChildren().addAll(mrMusculoBox, pinhoSolBox);

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

                sideMenu.getChildren().addAll(nameLabel, lblPlayerName, skillsLabel, lblSkills, healthLabel, lblHealth);
                sideMenu.setSpacing(10);
                sideMenu.setAlignment(Pos.CENTER_LEFT);
                sideMenu.setStyle("-fx-background-color: rgb(195, 195, 195); -fx-padding: 70;");

                images.getChildren().addAll(row1, row2);

                btnSubmit.setPrefWidth(100);
                btnSubmit.setPrefHeight(40);
                btnSubmit.setFont(Font.font("Calibri", 16));
                btnSubmit.setOnAction(e -> Submit());

                btnStart.setPrefWidth(100);
                btnStart.setPrefHeight(40);
                btnStart.setFont(Font.font("Calibri", 16));

                btnReturn.setPrefHeight(40);
                btnReturn.setFont(Font.font("Calibri", 16));

                btnRow.getChildren().addAll(btnReturn, btnSubmit);
                btnRow.setAlignment(Pos.BOTTOM_CENTER);
                btnRow.setSpacing(10);

                panels.getChildren().addAll(sideMenu, images);
                panels.setSpacing(10);
                panels.setAlignment(Pos.CENTER);

                gridGame.getChildren().addAll(playersRow, selectedRow, turnRow, panels, btnRow);

                var hoverOn = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                                /* setHoveredPlayer(((VBox) e.getTarget())); */
                                setHoveredPlayer(((ImageView) e.getTarget()));
                        }
                };

                var hoverOut = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                                /* resetHoveredPlayer(((VBox) e.getTarget()).getId()); */
                                resetHoveredPlayer(((ImageView) e.getTarget()).getId());
                        }
                };

                var onClick = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                                /* setSelectedPlayer(((VBox) e.getTarget())); */
                                setSelectedPlayer(((ImageView) e.getTarget()));
                        }
                };
                // vanishManBox
                vanishMan.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                vanishMan.addEventHandler(MouseEvent.MOUSE_EXITED, hoverOut);
                vanishMan.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);

                // deterGenteManBox
                DeterGente.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                DeterGente.addEventHandler(MouseEvent.MOUSE_EXITED, hoverOut);
                DeterGente.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);

                // lysoFormBox
                LysoForm.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                LysoForm.addEventHandler(MouseEvent.MOUSE_EXITED, hoverOut);
                LysoForm.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);

                // mrMusculoBox
                MrMusculo.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                MrMusculo.addEventHandler(MouseEvent.MOUSE_EXITED, hoverOut);
                MrMusculo.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);

                // pinhoSolBox
                PinhoSol.addEventHandler(MouseEvent.MOUSE_ENTERED, hoverOn);
                PinhoSol.addEventHandler(MouseEvent.MOUSE_EXITED, hoverOut);
                PinhoSol.addEventHandler(MouseEvent.MOUSE_CLICKED, onClick);
        }

        public void activate() {
                lblP1.setText(Menu.GetUser(1).getName());
                lblP2.setText(Menu.GetUser(2).getName());
        }

        void setHoveredPlayer(ImageView hovered) {
                var id = Integer.parseInt(hovered.getId());
                var player = Players.get(id);

                if (hovered.getStyleClass().contains("selectedIMG")) {
                        return;
                }

                lblPlayerName.setText(player.getName());
                String skills = "";
                for (String skill : player.getSkills()) {
                        skills += skill + ", ";
                }
                lblSkills.setText(skills.substring(0, skills.length() - 2) + ".");
                lblHealth.setText(Float.toString(player.getHealth()));
        }

        void resetHoveredPlayer(String _id) {
                var id = Integer.parseInt(_id);
        }

        void setSelectedPlayer(ImageView hovered) {
                var id = Integer.parseInt(hovered.getId());
                var player = Players.get(id);

                if (!player.getStatus())
                        return;

                if (lastSelected != null) {
                        lastSelected.getStyleClass().remove("pickedIMG");
                        lastSelected.getStyleClass().add("playerIMG");
                }

                VBox hovBox = (VBox) scene.lookup("#b" + id);
                hovBox.getStyleClass().remove("playerIMG");
                hovBox.getStyleClass().add("pickedIMG");
                lastSelected = hovBox;

                if (currentPlayer == 1) {
                        user01_PlayerID = id;
                } else {
                        user02_PlayerID = id;
                }
        }

        void Submit() {
                int id;
                if (currentPlayer == 1) {
                        id = user01_PlayerID;
                        lblSel1.setText(Players.get(id).getName());
                        lblSelectionTurn.setText("Escolha o personagem do jogador 2");
                } else {
                        id = user02_PlayerID;
                        lblSel2.setText(Players.get(id).getName());
                }

                Players.get(id).setStatus(false);

                VBox hovBox = (VBox) scene.lookup("#b" + id);
                hovBox.getStyleClass().remove("pickedIMG");
                hovBox.getStyleClass().add("selectedIMG");

                if (currentPlayer == 2){
                        btnRow.getChildren().remove(btnSubmit);
                        btnRow.getChildren().add(btnStart);
                }

                currentPlayer = 2;
        }

        public void ResetForm() {
                lblP1.setText("Jogador_1");
                lblP2.setText("Jogador_2");
                lblSel1.setText("Personagem_1");
                lblSel2.setText("Personagem_2");
                lblSelectionTurn.setText("Escolha o personagem do jogador 1");
                lblPlayerName.setText("-");
                lblSkills.setText("-");
                lblHealth.setText("-");
                user01_PlayerID = 0;
                user02_PlayerID = 0;
                currentPlayer = 1;

                for (Node player : row1.getChildren()) {
                        ((VBox) player).getStyleClass().remove("pickedIMG");
                        ((VBox) player).getStyleClass().remove("selectedIMG");
                        ((VBox) player).getStyleClass().add("playerIMG");
                }
                for (Node player : row2.getChildren()) {
                        ((VBox) player).getStyleClass().remove("pickedIMG");
                        ((VBox) player).getStyleClass().remove("selectedIMG");
                        ((VBox) player).getStyleClass().add("playerIMG");
                }
        }
}
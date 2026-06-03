package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {
  private int compteurRouge = 0;
  private int compteurVert = 0;
  private int compteurBleu = 0;

  private Label labelCompteurs;

  @Override
  public void start(Stage primaryStage) {
    BorderPane root = new BorderPane();

    Button btnRouge = new Button("Rouge");
    btnRouge.setId("btn-rouge");
    btnRouge.setStyle(
        "-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6;");

    Button btnVert = new Button("Vert");
    btnVert.setId("btn-vert");
    btnVert.setStyle(
        "-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6;");

    Button btnBleu = new Button("Bleu");
    btnBleu.setId("btn-bleu");
    btnBleu.setStyle(
        "-fx-background-color: #2980b9; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6;");

    HBox barreBoutons = new HBox(10, btnRouge, btnVert, btnBleu);
    barreBoutons.setPadding(new Insets(10));
    root.setTop(barreBoutons);

    Pane zone = new Pane();
    zone.setId("zone");
    zone.setMinSize(300, 200);
    root.setCenter(zone);

    labelCompteurs = new Label();
    labelCompteurs.setId("compteurs");
    labelCompteurs.setMaxWidth(Double.MAX_VALUE);
    labelCompteurs.setAlignment(Pos.CENTER);
    labelCompteurs.setPadding(new Insets(10));
    actualiserLabel();
    root.setBottom(labelCompteurs);

    btnRouge.setOnAction(
        event -> {
          zone.setStyle("-fx-background-color: red;");
          compteurRouge++;
          actualiserLabel();
        });

    btnVert.setOnAction(
        event -> {
          zone.setStyle("-fx-background-color: green;");
          compteurVert++;
          actualiserLabel();
        });

    btnBleu.setOnAction(
        event -> {
          zone.setStyle("-fx-background-color: blue;");
          compteurBleu++;
          actualiserLabel();
        });

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void actualiserLabel() {
    labelCompteurs.setText(
        "Rouge: " + compteurRouge + "  Vert: " + compteurVert + "  Bleu: " + compteurBleu);
  }

  public static void main(String[] args) {
    launch(args);
  }
}

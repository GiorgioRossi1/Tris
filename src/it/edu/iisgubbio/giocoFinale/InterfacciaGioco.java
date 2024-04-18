package it.edu.iisgubbio.giocoFinale;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.AudioClip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InterfacciaGioco extends Application{
		
		GridPane griglia = new GridPane();
		Pane grigliaInserita = new Pane();
		Label lTitolo = new Label("TRIS");
		Label lGiocatoreSingolo = new Label("VS computer");
		Label lDueGiocatori = new Label("VS altro giocatore");
		Label lNomi = new Label("Rossi Giorgio, Luchetti Simone, Menichetti Lorenzo");
		Button bGioca = new Button("Gioca");
		Button bGiocatoreSingolo = new Button("seleziona");
		Button bDueGiocatori = new Button("seleziona");
		Image i = new Image(getClass().getResourceAsStream("logo.png"));
	    ImageView iw = new ImageView(i);
		
		
		public void start(Stage finestra) {
			//griglia.setGridLinesVisible(true);
			griglia.setAlignment(Pos.CENTER);
			AudioClip musica = new AudioClip(getClass().getResource("kahoot.mp3").toString());
			musica.cycleCountProperty();
			musica.setCycleCount(20);
			musica.play();
		        iw.setFitWidth(700);
		        iw.setFitHeight(700);
			griglia.add(lTitolo, 3, 0);
			griglia.add(lNomi, 3, 1);
			griglia.add(bGioca, 3, 3);
			griglia.add(iw, 3, 2);
			
		
			
			lTitolo.getStyleClass().add("tris");
			lNomi.getStyleClass().add("titolo");
			bGioca.getStyleClass().add("bottone");
			griglia.getStyleClass().add("sfondo");
		
			bGioca.setMaxWidth(200);
			ColumnConstraints Prima = new ColumnConstraints();
			Prima.setHalignment(HPos.CENTER);
			ColumnConstraints Seconda = new ColumnConstraints();
			Seconda.setHalignment(HPos.CENTER);
			ColumnConstraints Terza = new ColumnConstraints();
			Terza.setHalignment(HPos.CENTER);
			ColumnConstraints Quarta = new ColumnConstraints();
			Quarta.setHalignment(HPos.CENTER);
			ColumnConstraints Quinta = new ColumnConstraints();
			Quinta.setHalignment(HPos.CENTER);
			ColumnConstraints Sesta = new ColumnConstraints();
			Sesta.setHalignment(HPos.CENTER);
			ColumnConstraints Settima = new ColumnConstraints();
			Settima.setHalignment(HPos.CENTER);
			RowConstraints vincoliRiga0 = new RowConstraints();
			vincoliRiga0.setValignment(VPos.CENTER);
			RowConstraints vincoliRiga1 = new RowConstraints();
			vincoliRiga1.setValignment(VPos.CENTER);
			RowConstraints vincoliRiga2 = new RowConstraints();
			vincoliRiga2.setValignment(VPos.CENTER);
			RowConstraints vincoliRiga3 = new RowConstraints();
			vincoliRiga3.setValignment(VPos.CENTER);
			RowConstraints vincoliRiga4 = new RowConstraints();
			vincoliRiga4.setValignment(VPos.CENTER);
			RowConstraints vincoliRiga5 = new RowConstraints();
			vincoliRiga5.setValignment(VPos.CENTER);
			griglia.getColumnConstraints().addAll(Prima);
			griglia.getColumnConstraints().addAll(Seconda);
			griglia.getColumnConstraints().addAll(Terza);
			griglia.getColumnConstraints().addAll(Quarta);
			griglia.getColumnConstraints().addAll(Quinta);
			griglia.getColumnConstraints().addAll(Sesta);
			griglia.getColumnConstraints().addAll(Settima);
			griglia.getRowConstraints().addAll(vincoliRiga0);
			griglia.getRowConstraints().addAll(vincoliRiga1);
			griglia.getRowConstraints().addAll(vincoliRiga2);		
			griglia.getRowConstraints().addAll(vincoliRiga3);			
			griglia.getRowConstraints().addAll(vincoliRiga4);		
			griglia.getRowConstraints().addAll(vincoliRiga5);			
			
			
			
			bGioca.setMaxWidth(300);
			
			bGiocatoreSingolo.setOnAction(e ->singolo());
			bDueGiocatori.setOnAction(e ->multiplayer());
			bGioca.setOnAction(e ->gioca());
			
			
			griglia.setPadding(new Insets(5, 5, 5, 5));
			griglia.setHgap(30); 
			griglia.setVgap(30);
			griglia.setPrefHeight(970);
			griglia.setPrefWidth(300);
			Scene scena = new Scene(griglia);
			finestra.setTitle("tris");
			finestra.setScene(scena);
			finestra.show();
			scena.getStylesheets().add("it/edu/iisgubbio/giocoFinale/Stile.css");
			}
		public void gioca() {
//			lTitolo.setVisible(false);
//			lNomi.setVisible(false);
//			bGioca.setVisible(false);
//			iw.setVisible(false);
			griglia.getChildren().remove(lTitolo);
			griglia.getChildren().remove(lNomi);
			griglia.getChildren().remove(bGioca);
			griglia.getChildren().remove(iw);
			griglia.setGridLinesVisible(true);;
			griglia.add(lGiocatoreSingolo, 3, 0);
			griglia.add(lDueGiocatori, 3, 3);
			griglia.add(bGiocatoreSingolo, 2, 1);
			griglia.add(bDueGiocatori, 2, 4);
			Image i = new Image(getClass().getResourceAsStream("1.jpg"));
		    ImageView si = new ImageView(i);
		    BorderPane nome1 = new BorderPane(si);
		    Image i2 = new Image(getClass().getResourceAsStream("2.jpg"));
		    ImageView mu = new ImageView(i2);
		    BorderPane nome2 = new BorderPane(mu);
		    BorderPane nome3 = new BorderPane(iw);
		    griglia.add(nome1, 3,1);
		    griglia.add(nome2, 3, 4);
		    griglia.add(nome3, 3, 6);
		    griglia.add(grigliaInserita,0,3);
			lDueGiocatori.getStyleClass().add("label2");
			lGiocatoreSingolo.getStyleClass().add("label2");
			bDueGiocatori.getStyleClass().add("bottone");
			bGiocatoreSingolo.getStyleClass().add("bottone");
			si.setFitWidth(200);
			si.setFitHeight(200);
		    mu.setFitHeight(200);
		    mu.setFitWidth(200);
		    iw.setFitHeight(300);
		    iw.setFitWidth(300);
			nome1.getStyleClass().add("img");
			nome2.getStyleClass().add("img");

		}
		public void singolo() {
			
		}
		public void multiplayer() {
			
		}
	
	public static void main(String args[]){
		launch();
	}
}

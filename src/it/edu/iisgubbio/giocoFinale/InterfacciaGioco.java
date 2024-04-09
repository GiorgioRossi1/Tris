package it.edu.iisgubbio.giocoFinale;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class InterfacciaGioco extends Application{
		
		GridPane griglia = new GridPane();
		Label lTitolo = new Label("TRIS");
		Label lNomi = new Label("Rossi Giorgio, Luchetti Simone, Menichetti Lorenzo");
		Button bGioca = new Button("Gioca");
		
		
		public void start(Stage finestra) {
			 Image i = new Image(getClass().getResourceAsStream("logo.png"));
		        ImageView iw = new ImageView(i);
		        iw.setFitWidth(700);
		        iw.setFitHeight(700);
			griglia.add(lTitolo, 0, 0);
			griglia.add(lNomi, 0, 1);
			griglia.add(bGioca, 0, 3);
			griglia.add(iw, 0, 2);
			lTitolo.getStyleClass().add("tris");
			lNomi.getStyleClass().add("titolo");
			bGioca.getStyleClass().add("bottone");
			griglia.getStyleClass().add("sfondo");
			bGioca.setMaxWidth(200);
			ColumnConstraints vincoliSecondaColonna = new ColumnConstraints();
			vincoliSecondaColonna.setHalignment(HPos.CENTER);
			griglia.getColumnConstraints().addAll(vincoliSecondaColonna);
			bGioca.setMaxWidth(300);
			
			
			griglia.setPadding(new Insets(5, 5, 5, 5));
			griglia.setHgap(15); 
			griglia.setVgap(15);
			Scene scena = new Scene(griglia);
			finestra.setTitle("tris");
			finestra.setScene(scena);
			finestra.show();
			scena.getStylesheets().add("it/edu/iisgubbio/giocoFinale/Stile.css");
			}
	
	public static void main(String args[]){
		launch();
	}
}

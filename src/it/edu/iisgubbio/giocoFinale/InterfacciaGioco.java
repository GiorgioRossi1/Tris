package it.edu.iisgubbio.giocoFinale;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
			griglia.add(lTitolo, 0, 0)
			;
		}
	
	public static void main(String args[]){
		launch();
	}
}

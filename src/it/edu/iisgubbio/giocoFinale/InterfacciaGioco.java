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
	Label lGiocatoreSingolo = new Label("giocatore singolo");
	Label lDueGiocatori = new Label("multiplayer");
	Label lNomi = new Label("Rossi Giorgio, Luchetti Simone, Menichetti Lorenzo");
	Button bGioca = new Button("Gioca");
	Button bGiocatoreSingolo = new Button("seleziona");
	Button bDueGiocatori = new Button("seleziona");
	Image i = new Image(getClass().getResourceAsStream("logo.png"));
	ImageView iw = new ImageView(i);


	public void start(Stage finestra) {

		iw.setFitWidth(700);
		iw.setFitHeight(700);
		griglia.add(lTitolo, 0, 0);
		griglia.add(lNomi, 0, 1);
		griglia.add(bGioca, 0, 3);
		griglia.add(iw, 0, 2);
		griglia.add(lGiocatoreSingolo, 0, 0);
		griglia.add(lDueGiocatori, 1, 0);
		griglia.add(bGiocatoreSingolo, 1, 1);
		griglia.add(bDueGiocatori, 2, 1);

		lTitolo.getStyleClass().add("tris");
		lNomi.getStyleClass().add("titolo");
		bGioca.getStyleClass().add("bottone");
		griglia.getStyleClass().add("sfondo");
		bGioca.setMaxWidth(200);
		ColumnConstraints vincoliSecondaColonna = new ColumnConstraints();
		vincoliSecondaColonna.setHalignment(HPos.CENTER);
		griglia.getColumnConstraints().addAll(vincoliSecondaColonna);
		bGioca.setMaxWidth(300);

		bGiocatoreSingolo.setOnAction(e ->singolo());
		bDueGiocatori.setOnAction(e ->multiplayer());
		bGioca.setOnAction(e ->gioca());


		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(15);
		Scene scena = new Scene(griglia);
		finestra.setTitle("tris");
		finestra.setScene(scena);
		finestra.show();
		scena.getStylesheets().add("it/edu/iisgubbio/giocoFinale/Stile.css");
	}
	public void gioca() {
		lTitolo.setVisible(false);
		lNomi.setVisible(false);
		bGioca.setVisible(false);
		iw.setVisible(false);
	}
	public void singolo() {

	}
	public void multiplayer() {

	}

	public static void main(String args[]){
		launch();
	}
}

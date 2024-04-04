package it.edu.iisgubbio.giocoFinale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Tris extends Application{
	
	final int LARGHEZZA_AREA_GIOCO = 500;
	final int ALTEZZA_AREA_GIOCO = 500;
	final int DISTANZA_DAL_BORDO = 20;
	Pane quadro = new Pane();
	Line rete1 = new Line();
	Line rete2 = new Line();
	Line rete3 = new Line();
	Line rete4 = new Line();
	boolean menu = true;
	double numeroCasuale = 0;

	

	public void start(Stage finestra) throws Exception {
		
		Pane quadro = new Pane();
		quadro.setPrefSize(LARGHEZZA_AREA_GIOCO, ALTEZZA_AREA_GIOCO);
		quadro.getChildren().add(rete1);
		rete1.setStartX(LARGHEZZA_AREA_GIOCO / 3);
		rete1.setStartY(DISTANZA_DAL_BORDO);
		rete1.setEndX(LARGHEZZA_AREA_GIOCO / 3);
		rete1.setEndY(ALTEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		quadro.getChildren().add(rete2);
		rete2.setStartX(LARGHEZZA_AREA_GIOCO / 3 + LARGHEZZA_AREA_GIOCO / 3);
		rete2.setStartY(DISTANZA_DAL_BORDO);
		rete2.setEndX(LARGHEZZA_AREA_GIOCO / 3 + LARGHEZZA_AREA_GIOCO / 3);
		rete2.setEndY(ALTEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		quadro.getChildren().add(rete3);
		rete3.setStartX(DISTANZA_DAL_BORDO);
		rete3.setStartY(ALTEZZA_AREA_GIOCO / 3);
		rete3.setEndX(LARGHEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete3.setEndY(ALTEZZA_AREA_GIOCO / 3);
		quadro.getChildren().add(rete4);
		rete4.setStartX(DISTANZA_DAL_BORDO);
		rete4.setStartY(ALTEZZA_AREA_GIOCO / 3 + ALTEZZA_AREA_GIOCO / 3);
		rete4.setEndX(LARGHEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete4.setEndY(ALTEZZA_AREA_GIOCO / 3 + ALTEZZA_AREA_GIOCO / 3);

		Scene scene = new Scene(quadro);
		finestra.setTitle("PONG"); 
		finestra.setScene(scene);
		finestra.show();
		scene.getStylesheets().add("it/edu/iisgubbio/animazioni/Stile.css");
		




	}
	

	

	public static void main(String args[]){
		launch();
	}
}
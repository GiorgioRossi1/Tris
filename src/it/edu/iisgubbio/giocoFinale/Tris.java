package it.edu.iisgubbio.giocoFinale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
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
	boolean primoQuadrante = true;

	

	public void start(Stage finestra) throws Exception {
		
		
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
		scene.setOnMouseClicked(e -> pigiato(e));





	}
	
	public void pigiato(MouseEvent evento) {
		
		int xClick = (int) evento.getSceneX();
		int yClick = (int) evento.getSceneY();
		if(primoQuadrante = true && xClick > DISTANZA_DAL_BORDO && xClick < LARGHEZZA_AREA_GIOCO / 3 && yClick > DISTANZA_DAL_BORDO && yClick < ALTEZZA_AREA_GIOCO / 3) {
			Line LineaCroce1 = new Line();
			Line LineaCroce2 = new Line();
			quadro.getChildren().add(LineaCroce1);
			quadro.getChildren().add(LineaCroce2);
			LineaCroce1.setStartX(DISTANZA_DAL_BORDO + 20);
			LineaCroce1.setStartY(DISTANZA_DAL_BORDO + 20);
			LineaCroce1.setEndX(LARGHEZZA_AREA_GIOCO / 3 - 20);
			LineaCroce1.setEndY(ALTEZZA_AREA_GIOCO / 3 - 20);
			LineaCroce2.setStartX(LARGHEZZA_AREA_GIOCO / 3 - 20);
			LineaCroce2.setStartY(DISTANZA_DAL_BORDO + 20);
			LineaCroce2.setEndX(DISTANZA_DAL_BORDO + 20);
			LineaCroce2.setEndY(ALTEZZA_AREA_GIOCO / 3 - 20);
			primoQuadrante = false;
		}
		

	}
	
	

	

	public static void main(String args[]){
		launch();
	}
}
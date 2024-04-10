package it.edu.iisgubbio.giocoFinale;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Tris extends Application{
	
	Button matriceBottoni[][] = new Button[3][3];
	char matriceChar[][] = new char[3][3];
	final int LARGHEZZA_AREA_GIOCO = 500;
	final int ALTEZZA_AREA_GIOCO = 500;
	final int DISTANZA_DAL_BORDO = 0;
	Pane quadro = new Pane();
	Line rete1 = new Line();
	Line rete2 = new Line();
	Line rete3 = new Line();
	Line rete4 = new Line();
	boolean primoQuadrante = true;
	double estrarreGiocatore = Math.random();
	boolean turno = false;
	/*
	boolean menu = true;
	double numeroCasuale = 0;
	GridPane griglia = new GridPane();
	Label lTitolo = new Label("TRIS");
	Label lNomi = new Label("Rossi Giorgio, Luchetti Simone, Menichetti Lorenzo");
	Button bGioca = new Button("Gioca");
	*/
	

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
		
		for(int  i = 0; i < 3; i++) {
			for(int i2 = 0; i2 < 3; i2++) {
				matriceBottoni[i][i2] = new Button();
				matriceChar[i][i2] = '-';
				quadro.getChildren().add(matriceBottoni[i][i2]);
				matriceBottoni[i][i2].setMinHeight(160);
				matriceBottoni[i][i2].setMinWidth(160);
				matriceBottoni[i][i2].setLayoutX(i * 165 + 4.5);
				matriceBottoni[i][i2].setLayoutY(i2 * 165 + 4.5);
				matriceBottoni[i][i2].setOnAction(e -> premuto(e));

			}
		}		
		

		if(estrarreGiocatore > 0.5) {
			turno = true;
		} else {
			turno = false;
		}	
		
		/*
		 Image i = new Image(getClass().getResourceAsStream("logo.png"));
	        ImageView iw = new ImageView(i);
	        iw.setFitWidth(900);
	        iw.setFitHeight(900);
		griglia.add(lTitolo, 0, 0);
		griglia.add(lNomi, 0, 1);
		griglia.add(bGioca, 0, 3);
		griglia.add(iw, 0, 2);
		*/
		

		Scene scene = new Scene(quadro);
		finestra.setTitle("TRIS"); 
		finestra.setScene(scene);
		finestra.show();





	}

	
	public void premuto(Event e) {
		int xMatrice;
		int yMatrice;
		Button id = (Button)e.getSource();
		xMatrice = (int)id.getLayoutX()/165;
		yMatrice = (int)id.getLayoutY()/165;
		if(turno) {
			turno = false;
			matriceChar[xMatrice][yMatrice] = 'x';
			id.setText("x");
			id.setDisable(true);
		} else {
			turno = true;
			matriceChar[xMatrice][yMatrice] = 'o';
			id.setText("o");
			id.setDisable(true);
		}
		
		if(matriceChar[0][0] == 'x' && matriceChar[1][0] == 'x' && matriceChar[2][0] == 'x') {
			System.out.println("vinto x");
		}			
		if(matriceChar[0][0] == 'o' && matriceChar[1][0] == 'o' && matriceChar[2][0] == 'o') {
			System.out.println("vinto o");
		}
		if(matriceChar[0][1] == 'x' && matriceChar[1][1] == 'x' && matriceChar[2][1] == 'x') {
			System.out.println("vinto x");
		}
		if(matriceChar[0][1] == 'o' && matriceChar[1][1] == 'o' && matriceChar[2][1] == 'o') {
			System.out.println("vinto o");
		}
		if(matriceChar[0][2] == 'x' && matriceChar[1][2] == 'x' && matriceChar[2][2] == 'x') {
			System.out.println("vinto x");
		}
		if(matriceChar[0][2] == 'o' && matriceChar[1][2] == 'o' && matriceChar[2][2] == 'o') {
			System.out.println("vinto o");
		}
		if(matriceChar[0][0] == 'x' && matriceChar[0][1] == 'x' && matriceChar[0][2] == 'x') {
			System.out.println("vinto x");
		}
		if(matriceChar[0][0] == 'o' && matriceChar[0][1] == 'o' && matriceChar[0][2] == 'o') {
			System.out.println("vinto o");
		}
		if(matriceChar[1][0] == 'x' && matriceChar[1][1] == 'x' && matriceChar[1][2] == 'x') {
			System.out.println("vinto x");
		}
		if(matriceChar[1][0] == 'o' && matriceChar[1][1] == 'o' && matriceChar[1][2] == 'o') {
			System.out.println("vinto o");
		}
		if(matriceChar[2][0] == 'x' && matriceChar[2][1] == 'x' && matriceChar[2][2] == 'x') {
			System.out.println("vinto x");
		}
		if(matriceChar[2][0] == 'o' && matriceChar[2][1] == 'o' && matriceChar[2][2] == 'o') {
			System.out.println("vinto o");
		}
		if(matriceChar[0][0] == 'x' && matriceChar[1][1] == 'x' && matriceChar[2][2] == 'x') {
			System.out.println("vinto x");
		}
		if(matriceChar[0][0] == 'o' && matriceChar[1][1] == 'o' && matriceChar[2][2] == 'o') {
			System.out.println("vinto o");
		}
		if(matriceChar[2][0] == 'x' && matriceChar[1][1] == 'x' && matriceChar[0][2] == 'x') {
			System.out.println("vinto x");
		}
		if(matriceChar[2][0] == 'o' && matriceChar[1][1] == 'o' && matriceChar[0][2] == 'o') {
			System.out.println("vinto o");
		}
		
	}

	

	public static void main(String args[]){
		launch();
	}
}
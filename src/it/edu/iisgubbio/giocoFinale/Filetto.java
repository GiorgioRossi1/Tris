package it.edu.iisgubbio.giocoFinale;


import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Filetto extends Application{

	//oggetti necessari alla creazione dell'interfaccia e del programma
	Slider sSelettoreDifficolta = new Slider(1, 3 ,1);
	private Stage finestra;
	Pane quadroMenu = new Pane();
	Pane quadroImpostazioni = new Pane();
	Pane quadroIntermedio = new Pane();
	Pane quadro;
	Pane quadroGioco = new Pane();
	private Scene sMenu = new Scene(quadroMenu, 600, 600);
	private Scene sGioco = new Scene(quadroGioco, 600, 600);
	private Scene sImpostazioni = new Scene(quadroImpostazioni, 600, 600);
	int difficolta = 0;
	int mosse;
	int nCountdown = 3;
	Button matriceBottoni[][] = new Button[3][3];
	char matriceChar[][] = new char[3][3];
	boolean turno = false;
	boolean vinto = false;
	boolean turnoIa = false;
	boolean fatto = false;
	boolean rematch = false;
	boolean ia = false;
	double numeroCasuale = 0;
	Button pFattoImpostazioni = new Button("Fatto");
	Button pOmbraFattoImpostazioni = new Button();
	Button pEsciImpostazioni = new Button("x");
	Button pRematch;
	Button pRematchOmbra;
	Button pEsciVinto;
	Button pEsciVintoOmbra;
	Timeline timelineTurno;
	Timeline timelineIa;
	Timeline timelineImpostazioniDifficolta;
	Timeline timelineCountDown;
	int raggioX = 0;
	int raggioO = 0;
	int vittorieX = 0;
	int vittorieO = 0;
	Label lTurnoX = new Label("Tocca a X");
	Label lTurnoO = new Label("Tocca a O");
	Label lVinto = new Label("");
	Circle cerchioTurnoX = new Circle();
	Circle cerchioTurnoO = new Circle();
	Circle bordoCerchioTurno1 = new Circle();
	Circle bordoCerchioTurno2 = new Circle();
	Label lDifficoltaImpostazioni = new Label("");
	Label lCountdown;
	Line lineaVittoria0002;
	Line lineaVittoria1012;
	Line lineaVittoria2022;
	Line lineaVittoria0020;
	Line lineaVittoria0121;
	Line lineaVittoria0222;
	Line lineaVittoria0022;
	Line lineaVittoria2002;
	//fine oggetti necessari alla creazione dell'interfaccia e del programma


	public void start(Stage finestraPrimaria) throws Exception {
		finestra = finestraPrimaria;

		//Schermata menu iniziale

		Button pGiocaVsAmico = new Button("PLAY VS FRIEND");
		Button pGiocaVsBot = new Button("PLAY VS BOT");
		Button pEsci = new Button("QUIT");
		Button pGiocaVsAmicoOmbra = new Button();
		Button pGiocaVsBotOmbra= new Button();
		Button pEsciOmbra = new Button();
		sMenu.getStylesheets().add("it/edu/iisgubbio/giocoFinale/Stile.css");


		final int LARGHEZZA_BOTTONI_INIZIALI = 200;
		final int ALTEZZA_BOTTONI_INIZIALI = 50;
		Image logo = new Image(getClass().getResourceAsStream("logo.png"));
		ImageView vediLogo = new ImageView(logo);
		quadroMenu.getChildren().add(vediLogo);
		quadroMenu.getChildren().add(pGiocaVsAmicoOmbra);
		quadroMenu.getChildren().add(pGiocaVsBotOmbra);
		quadroMenu.getChildren().add(pEsciOmbra);
		quadroMenu.getChildren().add(pGiocaVsAmico);
		quadroMenu.getChildren().add(pGiocaVsBot);
		quadroMenu.getChildren().add(pEsci);
		quadroMenu.setId("sfondoTitolo");

		pGiocaVsAmico.setLayoutX(185);
		pGiocaVsAmico.setLayoutY(390);
		pGiocaVsAmico.setMinHeight(ALTEZZA_BOTTONI_INIZIALI);
		pGiocaVsAmico.setMinWidth(LARGHEZZA_BOTTONI_INIZIALI);
		pGiocaVsAmico.setId("bottoniIniziali");
		pGiocaVsAmico.setOnAction(e -> cambioScenaMenuGioco(sGioco));
		pGiocaVsAmicoOmbra.setLayoutX(190);
		pGiocaVsAmicoOmbra.setLayoutY(395);
		pGiocaVsAmicoOmbra.setMinHeight(ALTEZZA_BOTTONI_INIZIALI);
		pGiocaVsAmicoOmbra.setMinWidth(LARGHEZZA_BOTTONI_INIZIALI);
		pGiocaVsAmicoOmbra.setId("bottoniInizialiOmbra");
		pGiocaVsAmicoOmbra.setOnAction(e -> cambioScenaMenuGioco(sGioco));


		pGiocaVsBot.setLayoutX(185);
		pGiocaVsBot.setLayoutY(460);
		pGiocaVsBot.setMinHeight(ALTEZZA_BOTTONI_INIZIALI);
		pGiocaVsBot.setMinWidth(LARGHEZZA_BOTTONI_INIZIALI);
		pGiocaVsBot.setId("bottoniIniziali");
		pGiocaVsBot.setOnAction(e -> cambioScenaMenuImpostazioni(sImpostazioni));
		pGiocaVsBotOmbra.setLayoutX(190);
		pGiocaVsBotOmbra.setLayoutY(465);
		pGiocaVsBotOmbra.setMinHeight(ALTEZZA_BOTTONI_INIZIALI);
		pGiocaVsBotOmbra.setMinWidth(LARGHEZZA_BOTTONI_INIZIALI);
		pGiocaVsBotOmbra.setId("bottoniInizialiOmbra");
		pGiocaVsBotOmbra.setOnAction(e -> cambioScenaMenuImpostazioni(sImpostazioni));


		pEsci.setLayoutX(185);
		pEsci.setLayoutY(530);
		pEsci.setMinHeight(ALTEZZA_BOTTONI_INIZIALI);
		pEsci.setMinWidth(LARGHEZZA_BOTTONI_INIZIALI);
		pEsci.setId("bottoniIniziali");
		pEsci.setOnAction(e -> chiudiGioco());

		pEsciOmbra.setLayoutX(190);
		pEsciOmbra.setLayoutY(535);
		pEsciOmbra.setMinHeight(ALTEZZA_BOTTONI_INIZIALI);
		pEsciOmbra.setMinWidth(LARGHEZZA_BOTTONI_INIZIALI);
		pEsciOmbra.setId("bottoniInizialiOmbra");
		pEsciOmbra.setOnAction(e -> chiudiGioco());


		vediLogo.setLayoutX(87);  
		vediLogo.setPreserveRatio(true);
		vediLogo.setFitHeight(400);
		vediLogo.setFitWidth(400);

		//fine schermata menu iniziale


		//inizio schermata gioco


		final int LARGHEZZA_AREA_GIOCO = 500;
		final int ALTEZZA_AREA_GIOCO = 500;
		final int DISTANZA_DAL_BORDO = 5;
		quadro = new Pane();
		Line rete1 = new Line();
		Line rete2 = new Line();
		Line rete3 = new Line();
		Line rete4 = new Line();
		lineaVittoria0002 = new Line();
		lineaVittoria1012 = new Line();
		lineaVittoria2022 = new Line();
		lineaVittoria0020 = new Line();
		lineaVittoria0121 = new Line();
		lineaVittoria0222 = new Line();
		lineaVittoria0022 = new Line();
		lineaVittoria2002 = new Line();
		double estrarreGiocatore = Math.random();
		double estrarreIa = Math.random();
		Label lContaPuntiX = new Label();
		Label lContaPuntiO = new Label();
		pRematch = new Button("Rematch");
		pRematchOmbra = new Button();
		pEsciVinto = new Button("Menu");
		pEsciVintoOmbra = new Button();

		quadroGioco.getChildren().add(pEsciVintoOmbra);
		pEsciVintoOmbra.setId("bottoneRematchFineOmbraGioco");
		pEsciVintoOmbra.setLayoutX(235);
		pEsciVintoOmbra.setLayoutY(355);
		pEsciVintoOmbra.setPrefSize(125, 60);
		pEsciVintoOmbra.setOnAction(e -> cambioScenaGiocoMenu(sGioco));

		quadroGioco.getChildren().add(pEsciVinto);
		pEsciVinto.setId("bottoneRematchFineGioco");
		pEsciVinto.setLayoutX(230);
		pEsciVinto.setLayoutY(350);
		pEsciVinto.setPrefSize(125, 60);
		pEsciVinto.setOnAction(e -> cambioScenaGiocoMenu(sGioco));


		quadroGioco.getChildren().add(pRematchOmbra);
		pRematchOmbra.setId("bottoneRematchFineOmbraGioco");
		pRematchOmbra.setLayoutX(235);
		pRematchOmbra.setLayoutY(455);
		pRematchOmbra.setPrefSize(125, 60);
		pRematchOmbra.setOnAction(e -> cambioScenaGiocoMenu(sGioco));


		quadroGioco.getChildren().add(pRematch);
		pRematch.setId("bottoneRematchFineGioco");
		pRematch.setLayoutX(230);
		pRematch.setLayoutY(450);
		pRematch.setPrefSize(125, 60);
		pRematch.setOnAction(e -> rinnovaSchermata(sGioco));


		quadroGioco.getChildren().add(lVinto);
		lVinto.setLayoutX(50);
		lVinto.setLayoutY(150);

		sGioco.getStylesheets().add("it/edu/iisgubbio/giocoFinale/Stile.css");
		Button pEsciGioco = new Button("x");


		quadroGioco.getChildren().add(quadro);
		quadro.setLayoutX(50);
		quadro.setLayoutY(50);
		quadroGioco.setId("sfondoGioco");
		quadro.setId("sfondoGioco");
		quadroGioco.setPrefSize(600, 600);
		quadroGioco.setPadding(new Insets(50, 50, 50, 50));


		quadro.setPrefSize(LARGHEZZA_AREA_GIOCO, ALTEZZA_AREA_GIOCO);
		rete1.setStartX(LARGHEZZA_AREA_GIOCO / 3);
		rete1.setStartY(DISTANZA_DAL_BORDO);
		rete1.setEndX(LARGHEZZA_AREA_GIOCO / 3);
		rete1.setEndY(ALTEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete1.setId("lineeDiMezzo");
		rete2.setStartX(LARGHEZZA_AREA_GIOCO / 3 + LARGHEZZA_AREA_GIOCO / 3);
		rete2.setStartY(DISTANZA_DAL_BORDO);
		rete2.setEndX(LARGHEZZA_AREA_GIOCO / 3 + LARGHEZZA_AREA_GIOCO / 3);
		rete2.setEndY(ALTEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete2.setId("lineeDiMezzo");
		rete3.setStartX(DISTANZA_DAL_BORDO);
		rete3.setStartY(ALTEZZA_AREA_GIOCO / 3);
		rete3.setEndX(LARGHEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete3.setEndY(ALTEZZA_AREA_GIOCO / 3);
		rete3.setId("lineeDiMezzo");
		rete4.setStartX(DISTANZA_DAL_BORDO);
		rete4.setStartY(ALTEZZA_AREA_GIOCO / 3 + ALTEZZA_AREA_GIOCO / 3);
		rete4.setEndX(LARGHEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete4.setEndY(ALTEZZA_AREA_GIOCO / 3 + ALTEZZA_AREA_GIOCO / 3);
		rete4.setId("lineeDiMezzo");

		//creazione scacchiera di bottoni tramite ciclo for

		for(int  i = 0; i < 3; i++) {
			for(int i2 = 0; i2 < 3; i2++) {
				matriceBottoni[i][i2] = new Button();
				matriceChar[i][i2] = '-';
				quadro.getChildren().add(matriceBottoni[i][i2]);
				matriceBottoni[i][i2].setLayoutX(i * 168);
				matriceBottoni[i][i2].setLayoutY(i2 * 168);
				matriceBottoni[i][i2].setOnAction(e -> controPlayer(e));
				matriceBottoni[i][i2].setId("bottoniMosse");
			}
		}

		//estrazione prima lettera tra O e X a giocare
		if(estrarreGiocatore > 0.5) {
			turno = true;
		}


		//estrazione primo giocatore tra pc e user a giocare
		if(estrarreIa > 0.5) {
			turnoIa = true;
		}	


		quadro.getChildren().add(rete1);
		quadro.getChildren().add(rete2);
		quadro.getChildren().add(rete3);
		quadro.getChildren().add(rete4);
		quadro.getChildren().add(bordoCerchioTurno1);
		quadro.getChildren().add(bordoCerchioTurno2);
		quadro.getChildren().add(cerchioTurnoO);
		quadro.getChildren().add(cerchioTurnoX);
		quadro.getChildren().add(lTurnoO);
		quadro.getChildren().add(lTurnoX);

		//creazione linee vittoria

		quadro.getChildren().add(lineaVittoria0002);
		lineaVittoria0002.setStartX(LARGHEZZA_AREA_GIOCO / 6);
		lineaVittoria0002.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria0002.setEndX(LARGHEZZA_AREA_GIOCO / 6);
		lineaVittoria0002.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 50);
		lineaVittoria0002.setId("lineeDiVittoria");
		lineaVittoria0002.setVisible(false);

		quadro.getChildren().add(lineaVittoria1012);
		lineaVittoria1012.setStartX(LARGHEZZA_AREA_GIOCO / 6 + LARGHEZZA_AREA_GIOCO / 6 + LARGHEZZA_AREA_GIOCO / 6 + 2.5);
		lineaVittoria1012.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria1012.setEndX(LARGHEZZA_AREA_GIOCO / 6 + LARGHEZZA_AREA_GIOCO / 6 + LARGHEZZA_AREA_GIOCO / 6 + 2.5);
		lineaVittoria1012.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 50);
		lineaVittoria1012.setId("lineeDiVittoria");
		lineaVittoria1012.setVisible(false);

		quadro.getChildren().add(lineaVittoria2022);
		lineaVittoria2022.setStartX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5);
		lineaVittoria2022.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria2022.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5);
		lineaVittoria2022.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 50);
		lineaVittoria2022.setId("lineeDiVittoria");
		lineaVittoria2022.setVisible(false);

		quadro.getChildren().add(lineaVittoria0020);
		lineaVittoria0020.setStartX(LARGHEZZA_AREA_GIOCO / 6 - 30);
		lineaVittoria0020.setStartY(ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0020.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5 + 30);
		lineaVittoria0020.setEndY(ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0020.setId("lineeDiVittoria");
		lineaVittoria0020.setVisible(false);

		quadro.getChildren().add(lineaVittoria0121);
		lineaVittoria0121.setStartX(LARGHEZZA_AREA_GIOCO / 6 - 30);
		lineaVittoria0121.setStartY(ALTEZZA_AREA_GIOCO / 6 + ALTEZZA_AREA_GIOCO / 6 + ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0121.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5 + 30);
		lineaVittoria0121.setEndY(ALTEZZA_AREA_GIOCO / 6 + ALTEZZA_AREA_GIOCO / 6 + ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0121.setId("lineeDiVittoria");
		lineaVittoria0121.setVisible(false);

		quadro.getChildren().add(lineaVittoria0222);
		lineaVittoria0222.setStartX(LARGHEZZA_AREA_GIOCO / 6 - 30);
		lineaVittoria0222.setStartY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0222.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5 + 30);
		lineaVittoria0222.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0222.setId("lineeDiVittoria");
		lineaVittoria0222.setVisible(false);

		quadro.getChildren().add(lineaVittoria0022);
		lineaVittoria0022.setStartX(LARGHEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria0022.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria0022.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 30);
		lineaVittoria0022.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 30);
		lineaVittoria0022.setId("lineeDiVittoria");
		lineaVittoria0022.setVisible(false);

		quadro.getChildren().add(lineaVittoria2002);
		lineaVittoria2002.setStartX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 25);
		lineaVittoria2002.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria2002.setEndX(LARGHEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria2002.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 25);
		lineaVittoria2002.setId("lineeDiVittoria");
		lineaVittoria2002.setVisible(false);

		//creazione countdown per inizio partita

		lCountdown = new Label();
		quadro.getChildren().add(lCountdown);
		lCountdown.setLayoutX(195);
		lCountdown.setLayoutY(107.5);
		lCountdown.setId("labelCountdown");

		lTurnoX.setLayoutX(180);
		lTurnoX.setLayoutY(-35);
		lTurnoO.setLayoutX(180);
		lTurnoO.setLayoutY(500);
		lTurnoX.setId("labelTurno");
		lTurnoO.setId("labelTurno");

		quadro.getChildren().add(lContaPuntiX);
		lContaPuntiX.setLayoutX(-16);
		lContaPuntiX.setLayoutY(-40);
		lContaPuntiX.setId("labelContaPuntiGioco");
		lContaPuntiX.setText("" + vittorieX);

		quadro.getChildren().add(lContaPuntiO);
		lContaPuntiO.setLayoutX(484);
		lContaPuntiO.setLayoutY(461);
		lContaPuntiO.setId("labelContaPuntiGioco");
		lContaPuntiO.setText("" + vittorieO);


		quadro.getChildren().add(pEsciGioco);
		pEsciGioco.setLayoutX(495);
		pEsciGioco.setLayoutY(-45);
		pEsciGioco.setMinWidth(50); 
		pEsciGioco.setMinHeight(50);
		pEsciGioco.setId("bottoneEsci");
		pEsciGioco.setOnAction(e -> cambioScenaGiocoMenu(sGioco));


		bordoCerchioTurno1.setCenterX(250);
		bordoCerchioTurno1.setCenterY(-175);
		bordoCerchioTurno2.setCenterX(250);
		bordoCerchioTurno2.setCenterY(675);
		bordoCerchioTurno1.setRadius(0);
		bordoCerchioTurno2.setRadius(0);
		bordoCerchioTurno1.setId("sottoBordoCerchioTurno");
		bordoCerchioTurno2.setId("sottoBordoCerchioTurno");
		cerchioTurnoX.setCenterX(250);
		cerchioTurnoX.setCenterY(-175);
		cerchioTurnoX.setRadius(0);
		cerchioTurnoX.setId("cerchioTurnoX");
		cerchioTurnoO.setCenterX(250);
		cerchioTurnoO.setCenterY(675);
		cerchioTurnoO.setRadius(0);
		cerchioTurnoO.setId("cerchioTurnoO");
		lTurnoO.setVisible(false);
		lTurnoX.setVisible(false);

		Image iContaPuntiX = new Image(getClass().getResourceAsStream("contaPuntiX.png"));
		ImageView vediIContaPuntiX = new ImageView(iContaPuntiX);
		Image iContaPuntiO = new Image(getClass().getResourceAsStream("contaPuntiO.png"));
		ImageView vediIContaPuntiO = new ImageView(iContaPuntiO);
		quadro.getChildren().add(vediIContaPuntiX);
		vediIContaPuntiX.setLayoutX(-50);
		vediIContaPuntiX.setLayoutY(-50);
		vediIContaPuntiX.setPreserveRatio(true);
		vediIContaPuntiX.setFitHeight(100);

		quadro.getChildren().add(vediIContaPuntiO);
		vediIContaPuntiO.setLayoutX(450);
		vediIContaPuntiO.setLayoutY(450);
		vediIContaPuntiO.setPreserveRatio(true);
		vediIContaPuntiO.setFitHeight(100);


		//timeline per designare animazione del pallino che deve apparire in base al turno
		timelineTurno = new Timeline(new KeyFrame(
				Duration.millis(3),
				x -> aggiornaTimerTurnoGrafica()));
		timelineTurno.setCycleCount(Timeline.INDEFINITE);

		//timeline per selezione casuale del punto dove piazzare la mossa
		timelineIa = new Timeline(new KeyFrame(
				Duration.seconds(4),
				x -> aggiornaTimerIa()));
		timelineIa.setCycleCount(1);

		//fine schermata gioco

		//schermata impostazioni

		Image IutenteControAi = new Image(getClass().getResourceAsStream("utenteControAi.png"));
		ImageView vediUtenteControAi = new ImageView(IutenteControAi);
		Rectangle rPannello = new Rectangle(325, 500);
		Rectangle rSottoSlider = new Rectangle(235, 30);
		Rectangle rOmbraPannello = new Rectangle(325, 500);
		quadroImpostazioni.getChildren().add(rOmbraPannello);
		quadroImpostazioni.getChildren().add(rPannello);
		quadroImpostazioni.getChildren().add(vediUtenteControAi);

		quadroImpostazioni.getChildren().add(pEsciImpostazioni);
		quadroImpostazioni.getChildren().add(rSottoSlider);
		quadroImpostazioni.getChildren().add(sSelettoreDifficolta);
		quadroImpostazioni.getChildren().add(lDifficoltaImpostazioni);
		quadroImpostazioni.getChildren().add(pOmbraFattoImpostazioni);
		quadroImpostazioni.getChildren().add(pFattoImpostazioni);

		vediUtenteControAi.setLayoutX(185);
		vediUtenteControAi.setLayoutY(55);  
		vediUtenteControAi.setPreserveRatio(true);
		vediUtenteControAi.setFitHeight(230);
		vediUtenteControAi.setFitWidth(230);

		pFattoImpostazioni.setLayoutX(260);
		pFattoImpostazioni.setLayoutY(450);
		pFattoImpostazioni.setId("bottoneFattoImpostazioni");
		pFattoImpostazioni.setMinHeight(40);
		pFattoImpostazioni.setMinWidth(80);
		pFattoImpostazioni.setOnAction(e -> cambioScenaImpostazioniGiocoIa(sImpostazioni));
		pFattoImpostazioni.setDisable(true);

		pOmbraFattoImpostazioni.setLayoutX(265);
		pOmbraFattoImpostazioni.setLayoutY(455);
		pOmbraFattoImpostazioni.setId("ombraBottoneFattoImpostazioni");
		pOmbraFattoImpostazioni.setMinHeight(40);
		pOmbraFattoImpostazioni.setMinWidth(80);
		pOmbraFattoImpostazioni.setDisable(true);


		lDifficoltaImpostazioni.setLayoutX(225);
		lDifficoltaImpostazioni.setLayoutY(360);
		lDifficoltaImpostazioni.setMinHeight(40);
		lDifficoltaImpostazioni.setMinWidth(150);
		lDifficoltaImpostazioni.setId("labelDifficoltaImpostazioni");

		//slider necessario alla realizzazione di un selettore di difficolta

		rSottoSlider.setLayoutX(182.5);
		rSottoSlider.setLayoutY(271.5);
		rSottoSlider.setArcWidth(30); 
		rSottoSlider.setArcHeight(30);
		rSottoSlider.setId("sottoSlider");

		sSelettoreDifficolta.setLayoutX(185);
		sSelettoreDifficolta.setLayoutY(270);
		sSelettoreDifficolta.setMajorTickUnit(1);
		sSelettoreDifficolta.setMinorTickCount(0);
		sSelettoreDifficolta.setSnapToTicks(true);

		pEsciImpostazioni.setLayoutX(445);
		pEsciImpostazioni.setLayoutY(45);
		pEsciImpostazioni.setMinWidth(40); 
		pEsciImpostazioni.setMinHeight(40);
		pEsciImpostazioni.setId("bottoneEsci");
		pEsciImpostazioni.setOnAction(e -> cambioScenaImpostazioniMenu(sMenu));


		rPannello.setId("pannelloImpostazioni");
		rPannello.setLayoutX(137.5);
		rPannello.setLayoutY(50);
		rPannello.setArcWidth(50.0); 
		rPannello.setArcHeight(50.0);
		rPannello.setId("pannelloImpostazioni");

		rOmbraPannello.setLayoutX(147.5);
		rOmbraPannello.setLayoutY(60);
		rOmbraPannello.setArcWidth(50.0); 
		rOmbraPannello.setArcHeight(50.0);
		rOmbraPannello.setId("ombraPannelloImpostazioni");

		quadroImpostazioni.setId("sfondoTitolo");
		sImpostazioni.getStylesheets().add("it/edu/iisgubbio/giocoFinale/Stile.css");


		//fine schermata impostazioni

		finestra.setTitle("FILETTO");
		finestra.setScene(sMenu);
		finestra.show();
		sMenu.getStylesheets().add("it/edu/iisgubbio/giocoFinale/Stile.css");
		sGioco.getStylesheets().add("it/edu/iisgubbio/giocoFinale/Stile.css");


	}

	//necessario a definire le variabili che devono mutare quando si passa dal menu al gioco
	public void cambioScenaMenuGioco(Scene Scena2) {
		mosse = 9;
		quadroGioco.setVisible(true);
		if(!rematch) {
			timelineCountDown = new Timeline(new KeyFrame(
					Duration.seconds(1),
					x -> aggiornaTimerCountDown()));
			timelineCountDown.setCycleCount(4);
			timelineCountDown.play();
			finestra.setScene(sGioco);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadroGioco);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
			finestra.setOpacity(0.2);
			quadroGioco.setDisable(true);
			if(turnoIa && ia) {
				quadroGioco.setDisable(true);
				timelineIa.play();
			}
			if(ia) {
				timelineIa.play();
			}
		}
		if(rematch) {
			rinnovaSchermata(Scena2);
		}
	}	

	//collegato al tasto esci, serve a chiudere rapidamente il gioco 
	public void chiudiGioco() {
		System.exit(0);
	}

	//necessario a definire le variabili che devono mutare quando si passa dal menu alle impostazioni dell'ai
	public void cambioScenaMenuImpostazioni(Scene Scena3) {
		timelineImpostazioniDifficolta = new Timeline(new KeyFrame(
				Duration.millis(1),
				x -> aggiornaTimerImpostazioniDifficolta()));
		timelineImpostazioniDifficolta.setCycleCount(Timeline.INDEFINITE);
		finestra.setScene(sImpostazioni);
		timelineImpostazioniDifficolta.play();
		TranslateTransition transizioneSottoSopra = new TranslateTransition (Duration.seconds(0.3), quadroImpostazioni);
		transizioneSottoSopra.setFromY(600);
		transizioneSottoSopra.setToY(0);
		transizioneSottoSopra.play();
	}

	//necessario a definire le variabili che devono mutare quando si passa dalle impostazioni dell'ai al menu
	public void cambioScenaImpostazioniMenu(Scene Scena2) {
		timelineImpostazioniDifficolta.stop();
		finestra.setScene(sMenu);
		FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadroMenu);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1.0);
		fadeTransition.play();
	}

	//necessario a definire le variabili che devono mutare quando si passa dal gioco al menu
	public void cambioScenaGiocoMenu(Scene Scena2) {
		vittorieX = 0;
		vittorieO = 0;
		quadroGioco.setVisible(false);
		timelineTurno.stop();
		rematch = true;
		finestra.setScene(sMenu);
		FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadroMenu);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1.0);
		fadeTransition.play();
	}

	//necessario a definire le variabili che devono mutare quando si passa dalle impostazioni dell'ai al gioco con ai
	public void cambioScenaImpostazioniGiocoIa(Scene Scena1) {
		mosse = 9;
		ia = true;
		quadroGioco.setVisible(true);
		if(!rematch) {
			timelineCountDown = new Timeline(new KeyFrame(
					Duration.seconds(1),
					x -> aggiornaTimerCountDown()));
			timelineCountDown.setCycleCount(4);
			timelineCountDown.play();
			finestra.setScene(sGioco);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadroGioco);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
			finestra.setOpacity(0.2);		}
		if(rematch) {
			rinnovaSchermata(Scena1);
		}		
		if(turnoIa) {
			quadroGioco.setDisable(true);
			timelineIa.play();
		}
	}

	//necessario a rinnovare la schermata andando a svuotare il pane e rinserendo gli oggetti
	public void rinnovaSchermata(Scene Scena1) {

		quadroGioco.getChildren().remove(quadro);
		final int LARGHEZZA_AREA_GIOCO = 500;
		final int ALTEZZA_AREA_GIOCO = 500;
		final int DISTANZA_DAL_BORDO = 5;
		quadro = new Pane();
		Line rete1 = new Line();
		Line rete2 = new Line();
		Line rete3 = new Line();
		Line rete4 = new Line();
		lineaVittoria0002 = new Line();
		lineaVittoria1012 = new Line();
		lineaVittoria2022 = new Line();
		lineaVittoria0020 = new Line();
		lineaVittoria0121 = new Line();
		lineaVittoria0222 = new Line();
		lineaVittoria0022 = new Line();
		lineaVittoria2002 = new Line();
		double estrarreGiocatore = Math.random();
		double estrarreIa = Math.random();
		Label lContaPuntiX = new Label();
		Label lContaPuntiO = new Label();
		pRematch = new Button("Rematch");
		pRematchOmbra = new Button();
		pEsciVinto = new Button("Menu");
		pEsciVintoOmbra = new Button();

		quadroGioco.getChildren().add(pEsciVintoOmbra);
		pEsciVintoOmbra.setId("bottoneRematchFineOmbraGioco");
		pEsciVintoOmbra.setLayoutX(235);
		pEsciVintoOmbra.setLayoutY(355);
		pEsciVintoOmbra.setPrefSize(125, 60);
		pEsciVintoOmbra.setOnAction(e -> cambioScenaGiocoMenu(sGioco));

		quadroGioco.getChildren().add(pEsciVinto);
		pEsciVinto.setId("bottoneRematchFineGioco");
		pEsciVinto.setLayoutX(230);
		pEsciVinto.setLayoutY(350);
		pEsciVinto.setPrefSize(125, 60);
		pEsciVinto.setOnAction(e -> cambioScenaGiocoMenu(sGioco));


		sGioco.getStylesheets().add("it/edu/iisgubbio/giocoFinale/Stile.css");
		Image iContaPuntiX = new Image(getClass().getResourceAsStream("contaPuntiX.png"));
		ImageView vediIContaPuntiX = new ImageView(iContaPuntiX);
		Image iContaPuntiO = new Image(getClass().getResourceAsStream("contaPuntiO.png"));
		ImageView vediIContaPuntiO = new ImageView(iContaPuntiO);
		Button pEsciGioco = new Button("x");


		quadroGioco.getChildren().add(quadro);
		quadro.setLayoutX(50);
		quadro.setLayoutY(50);
		quadroGioco.setId("sfondoGioco");
		quadro.setId("sfondoGioco");
		quadroGioco.setPrefSize(600, 600);
		quadroGioco.setPadding(new Insets(50, 50, 50, 50));


		quadro.setPrefSize(LARGHEZZA_AREA_GIOCO, ALTEZZA_AREA_GIOCO);
		rete1.setStartX(LARGHEZZA_AREA_GIOCO / 3);
		rete1.setStartY(DISTANZA_DAL_BORDO);
		rete1.setEndX(LARGHEZZA_AREA_GIOCO / 3);
		rete1.setEndY(ALTEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete1.setId("lineeDiMezzo");
		rete2.setStartX(LARGHEZZA_AREA_GIOCO / 3 + LARGHEZZA_AREA_GIOCO / 3);
		rete2.setStartY(DISTANZA_DAL_BORDO);
		rete2.setEndX(LARGHEZZA_AREA_GIOCO / 3 + LARGHEZZA_AREA_GIOCO / 3);
		rete2.setEndY(ALTEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete2.setId("lineeDiMezzo");
		rete3.setStartX(DISTANZA_DAL_BORDO);
		rete3.setStartY(ALTEZZA_AREA_GIOCO / 3);
		rete3.setEndX(LARGHEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete3.setEndY(ALTEZZA_AREA_GIOCO / 3);
		rete3.setId("lineeDiMezzo");
		rete4.setStartX(DISTANZA_DAL_BORDO);
		rete4.setStartY(ALTEZZA_AREA_GIOCO / 3 + ALTEZZA_AREA_GIOCO / 3);
		rete4.setEndX(LARGHEZZA_AREA_GIOCO - DISTANZA_DAL_BORDO);
		rete4.setEndY(ALTEZZA_AREA_GIOCO / 3 + ALTEZZA_AREA_GIOCO / 3);
		rete4.setId("lineeDiMezzo");

		for(int  i = 0; i < 3; i++) {
			for(int i2 = 0; i2 < 3; i2++) {
				matriceBottoni[i][i2] = new Button();
				matriceChar[i][i2] = '-';
				quadro.getChildren().add(matriceBottoni[i][i2]);
				matriceBottoni[i][i2].setLayoutX(i * 168);
				matriceBottoni[i][i2].setLayoutY(i2 * 168);
				matriceBottoni[i][i2].setOnAction(e -> controPlayer(e));
				matriceBottoni[i][i2].setId("bottoniMosse");
			}
		}


		if(estrarreGiocatore > 0.5) {
			turno = true;
		}

		if(estrarreIa > 0.5) {
			turnoIa = true;
		}	

		quadro.getChildren().add(rete1);
		quadro.getChildren().add(rete2);
		quadro.getChildren().add(rete3);
		quadro.getChildren().add(rete4);
		quadro.getChildren().add(bordoCerchioTurno1);
		quadro.getChildren().add(bordoCerchioTurno2);
		quadro.getChildren().add(cerchioTurnoO);
		quadro.getChildren().add(cerchioTurnoX);
		quadro.getChildren().add(lTurnoO);
		quadro.getChildren().add(lTurnoX);

		quadro.getChildren().add(lineaVittoria0002);
		lineaVittoria0002.setStartX(LARGHEZZA_AREA_GIOCO / 6);
		lineaVittoria0002.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria0002.setEndX(LARGHEZZA_AREA_GIOCO / 6);
		lineaVittoria0002.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 50);
		lineaVittoria0002.setId("lineeDiVittoria");
		lineaVittoria0002.setVisible(false);

		quadro.getChildren().add(lineaVittoria1012);
		lineaVittoria1012.setStartX(LARGHEZZA_AREA_GIOCO / 6 + LARGHEZZA_AREA_GIOCO / 6 + LARGHEZZA_AREA_GIOCO / 6 + 2.5);
		lineaVittoria1012.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria1012.setEndX(LARGHEZZA_AREA_GIOCO / 6 + LARGHEZZA_AREA_GIOCO / 6 + LARGHEZZA_AREA_GIOCO / 6 + 2.5);
		lineaVittoria1012.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 50);
		lineaVittoria1012.setId("lineeDiVittoria");
		lineaVittoria1012.setVisible(false);

		quadro.getChildren().add(lineaVittoria2022);
		lineaVittoria2022.setStartX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5);
		lineaVittoria2022.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria2022.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5);
		lineaVittoria2022.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 50);
		lineaVittoria2022.setId("lineeDiVittoria");
		lineaVittoria2022.setVisible(false);

		quadro.getChildren().add(lineaVittoria0020);
		lineaVittoria0020.setStartX(LARGHEZZA_AREA_GIOCO / 6 - 30);
		lineaVittoria0020.setStartY(ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0020.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5 + 30);
		lineaVittoria0020.setEndY(ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0020.setId("lineeDiVittoria");
		lineaVittoria0020.setVisible(false);

		quadro.getChildren().add(lineaVittoria0121);
		lineaVittoria0121.setStartX(LARGHEZZA_AREA_GIOCO / 6 - 30);
		lineaVittoria0121.setStartY(ALTEZZA_AREA_GIOCO / 6 + ALTEZZA_AREA_GIOCO / 6 + ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0121.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5 + 30);
		lineaVittoria0121.setEndY(ALTEZZA_AREA_GIOCO / 6 + ALTEZZA_AREA_GIOCO / 6 + ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0121.setId("lineeDiVittoria");
		lineaVittoria0121.setVisible(false);

		quadro.getChildren().add(lineaVittoria0222);
		lineaVittoria0222.setStartX(LARGHEZZA_AREA_GIOCO / 6 - 30);
		lineaVittoria0222.setStartY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0222.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 2.5 + 30);
		lineaVittoria0222.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 10);
		lineaVittoria0222.setId("lineeDiVittoria");
		lineaVittoria0222.setVisible(false);

		quadro.getChildren().add(lineaVittoria0022);
		lineaVittoria0022.setStartX(LARGHEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria0022.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria0022.setEndX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 30);
		lineaVittoria0022.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 30);
		lineaVittoria0022.setId("lineeDiVittoria");
		lineaVittoria0022.setVisible(false);

		quadro.getChildren().add(lineaVittoria2002);
		lineaVittoria2002.setStartX(LARGHEZZA_AREA_GIOCO - LARGHEZZA_AREA_GIOCO / 6 + 25);
		lineaVittoria2002.setStartY(ALTEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria2002.setEndX(LARGHEZZA_AREA_GIOCO / 6 - 25);
		lineaVittoria2002.setEndY(ALTEZZA_AREA_GIOCO - ALTEZZA_AREA_GIOCO / 6 + 25);
		lineaVittoria2002.setId("lineeDiVittoria");
		lineaVittoria2002.setVisible(false);

		lCountdown = new Label();
		quadro.getChildren().add(lCountdown);
		lCountdown.setLayoutX(200);
		lCountdown.setLayoutY(107.5);
		lCountdown.setId("labelCountdown");

		lTurnoX.setLayoutX(180);
		lTurnoX.setLayoutY(-35);
		lTurnoO.setLayoutX(180);
		lTurnoO.setLayoutY(500);
		lTurnoX.setId("labelTurno");
		lTurnoO.setId("labelTurno");

		quadro.getChildren().add(vediIContaPuntiX);
		vediIContaPuntiX.setLayoutX(-50);
		vediIContaPuntiX.setLayoutY(-50);
		vediIContaPuntiX.setPreserveRatio(true);
		vediIContaPuntiX.setFitHeight(100);

		quadro.getChildren().add(lContaPuntiX);
		lContaPuntiX.setLayoutX(-16);
		lContaPuntiX.setLayoutY(-40);
		lContaPuntiX.setId("labelContaPuntiGioco");
		lContaPuntiX.setText("" + vittorieX);


		quadro.getChildren().add(vediIContaPuntiO);
		vediIContaPuntiO.setLayoutX(450);
		vediIContaPuntiO.setLayoutY(450);
		vediIContaPuntiO.setPreserveRatio(true);
		vediIContaPuntiO.setFitHeight(100);

		quadro.getChildren().add(lContaPuntiO);
		lContaPuntiO.setLayoutX(484);
		lContaPuntiO.setLayoutY(461);
		lContaPuntiO.setId("labelContaPuntiGioco");
		lContaPuntiO.setText("" + vittorieO);


		quadro.getChildren().add(pEsciGioco);
		pEsciGioco.setLayoutX(495);
		pEsciGioco.setLayoutY(-45);
		pEsciGioco.setMinWidth(50); 
		pEsciGioco.setMinHeight(50);
		pEsciGioco.setId("bottoneEsci");
		pEsciGioco.setOnAction(e -> cambioScenaGiocoMenu(sGioco));


		bordoCerchioTurno1.setCenterX(250);
		bordoCerchioTurno1.setCenterY(-175);
		bordoCerchioTurno2.setCenterX(250);
		bordoCerchioTurno2.setCenterY(675);
		bordoCerchioTurno1.setRadius(0);
		bordoCerchioTurno2.setRadius(0);
		bordoCerchioTurno1.setId("sottoBordoCerchioTurno");
		bordoCerchioTurno2.setId("sottoBordoCerchioTurno");
		cerchioTurnoX.setCenterX(250);
		cerchioTurnoX.setCenterY(-175);
		cerchioTurnoX.setRadius(0);
		cerchioTurnoX.setId("cerchioTurnoX");
		cerchioTurnoO.setCenterX(250);
		cerchioTurnoO.setCenterY(675);
		cerchioTurnoO.setRadius(0);
		cerchioTurnoO.setId("cerchioTurnoO");
		lTurnoO.setVisible(false);
		lTurnoX.setVisible(false);


		quadro.setVisible(true);
		timelineCountDown = new Timeline(new KeyFrame(
				Duration.seconds(1),
				x -> aggiornaTimerCountDown()));
		timelineCountDown.setCycleCount(4);
		timelineCountDown.play();
		finestra.setScene(sGioco);
		FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadroGioco);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1.0);
		fadeTransition.play();
		finestra.setOpacity(0.2);
		quadroGioco.setDisable(true);
		vinto = false;
		rematch = true;
		mosse = 9;
		if(!turnoIa && ia) {
			quadroGioco.setDisable(true);
		}
	}

	//necessario a garantire una continuità durante la selezione della difficolta nelle impostazioni
	public void aggiornaTimerImpostazioniDifficolta() {
		if(sSelettoreDifficolta.getValue() == 1) {
			lDifficoltaImpostazioni.setText("FACILE");
		}
		if(sSelettoreDifficolta.getValue() == 2) {
			lDifficoltaImpostazioni.setText("MEDIO");
		}
		if(sSelettoreDifficolta.getValue() == 3) {
			lDifficoltaImpostazioni.setText("DIFFICILE");
		}
		if(pFattoImpostazioni.isPressed()) {
			difficolta = (int) sSelettoreDifficolta.getValue();
		}
	}

	//necessario a definire le azioni che il timer deve fare dopo il lasso di tempo indicato
	public void aggiornaTimerCountDown() {
		lCountdown.setVisible(true);
		lCountdown.setText("" + nCountdown);
		nCountdown--;
		if(nCountdown == -1) {
			finestra.setOpacity(1);
			quadroGioco.setDisable(false);
			timelineTurno.play();
			lCountdown.setVisible(false);
			nCountdown = 3;
		}
	}

	//necessario a definire le azioni che il timer deve fare dopo il lasso di tempo indicato, per far comparire il pallino del turno
	public void aggiornaTimerTurnoGrafica() {
		if(turno && raggioX != 205) {
			if(turno && raggioX == 150) {
				lTurnoX.setVisible(true);
			}
			if(raggioO != 0) {
				raggioO--;
				bordoCerchioTurno2.setRadius(raggioO);
				cerchioTurnoO.setRadius(raggioO);
			}
			raggioX++;
			bordoCerchioTurno1.setRadius(raggioX + 5);
			cerchioTurnoX.setRadius(raggioX);

		} 
		if(!turno && raggioO != 205) {
			if(!turno && raggioO == 150) {
				lTurnoO.setVisible(true);
			}
			if(raggioX != 0) {
				raggioX--;
				bordoCerchioTurno1.setRadius(raggioX);
				cerchioTurnoX.setRadius(raggioX);
			}
			raggioO++;
			bordoCerchioTurno2.setRadius(raggioO + 5);
			cerchioTurnoO.setRadius(raggioO);

		}

	}

	//necessario a definire le azioni che si devono effetuare alla pressione del tasto
	public void controPlayer(Event e) {
		mosse--;
		int xMatrice;
		int yMatrice;
		Button id = (Button)e.getSource();
		xMatrice = (int)id.getLayoutX()/165;
		yMatrice = (int)id.getLayoutY()/165;
		if(!turnoIa && ia) {
			quadroGioco.setDisable(true);
		}
		if(turno) {
			lTurnoX.setVisible(false);
			turno = false;
			matriceChar[xMatrice][yMatrice] = 'x';
			id.setText("x");
			id.setDisable(true);
			turnoIa = true;
		} else {
			lTurnoO.setVisible(false);
			turno = true;
			matriceChar[xMatrice][yMatrice] = 'o';
			id.setText("o");
			id.setDisable(true);
			turnoIa = true;
		}

		if(matriceChar[0][0] == 'x' && matriceChar[1][0] == 'x' && matriceChar[2][0] == 'x') {
			vinto = true;
			lineaVittoria0020.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0020);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}			
		if(matriceChar[0][0] == 'o' && matriceChar[1][0] == 'o' && matriceChar[2][0] == 'o') {
			vinto = true;
			lineaVittoria0020.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0020);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][1] == 'x' && matriceChar[1][1] == 'x' && matriceChar[2][1] == 'x') {
			vinto = true;
			lineaVittoria0121.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0121);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][1] == 'o' && matriceChar[1][1] == 'o' && matriceChar[2][1] == 'o') {
			vinto = true;
			lineaVittoria0121.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0121);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][2] == 'x' && matriceChar[1][2] == 'x' && matriceChar[2][2] == 'x') {
			vinto = true;
			lineaVittoria0222.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0222);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][2] == 'o' && matriceChar[1][2] == 'o' && matriceChar[2][2] == 'o') {
			vinto = true;
			lineaVittoria0222.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0222);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][0] == 'x' && matriceChar[0][1] == 'x' && matriceChar[0][2] == 'x') {
			vinto = true;
			lineaVittoria0002.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0002);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][0] == 'o' && matriceChar[0][1] == 'o' && matriceChar[0][2] == 'o') {
			vinto = true;
			lineaVittoria0002.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0002);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[1][0] == 'x' && matriceChar[1][1] == 'x' && matriceChar[1][2] == 'x') {
			vinto = true;
			lineaVittoria1012.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria1012);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[1][0] == 'o' && matriceChar[1][1] == 'o' && matriceChar[1][2] == 'o') {
			vinto = true;
			lineaVittoria1012.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria1012);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[2][0] == 'x' && matriceChar[2][1] == 'x' && matriceChar[2][2] == 'x') {
			vinto = true;
			lineaVittoria2022.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria2022);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[2][0] == 'o' && matriceChar[2][1] == 'o' && matriceChar[2][2] == 'o') {
			vinto = true;
			lineaVittoria2022.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria2022);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][0] == 'x' && matriceChar[1][1] == 'x' && matriceChar[2][2] == 'x') {
			vinto = true;
			lineaVittoria0022.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0022);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();

		}
		if(matriceChar[0][0] == 'o' && matriceChar[1][1] == 'o' && matriceChar[2][2] == 'o') {
			vinto = true;
			lineaVittoria0022.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0022);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[2][0] == 'x' && matriceChar[1][1] == 'x' && matriceChar[0][2] == 'x') {
			vinto = true;
			lineaVittoria2002.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria2002);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[2][0] == 'o' && matriceChar[1][1] == 'o' && matriceChar[0][2] == 'o') {
			vinto = true;
			lineaVittoria2002.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria2002);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}

		if(vinto && !turno) {
			timelineIa.stop();
			timelineTurno.stop();
			quadro.setDisable(true);
			quadroGioco.setDisable(false);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadro);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0);
			fadeTransition.play();
			lVinto.setText("HA VINTO X!");
			lVinto.setId("labelVintoX");
			vittorieX++;
			ia = false;
		} 
		if(vinto && turno) {
			timelineIa.stop();
			timelineTurno.stop();
			quadro.setDisable(true);
			quadroGioco.setDisable(false);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadro);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0);
			fadeTransition.play();
			lVinto.setId("labelVintoO");
			lVinto.setText("HA VINTO O!");
			vittorieO++;
			ia = false;

		} 
		if(!vinto && mosse == 0) {
			timelineIa.stop();
			timelineTurno.stop();
			quadro.setDisable(true);
			quadroGioco.setDisable(false);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadro);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0);
			fadeTransition.play();
			lVinto.setText("  PAREGGIO!");
			lVinto.setId("labelPareggio");
		}
		if(ia) {
			mosse--;
			timelineIa.play();
		}
	}
	//necessario a definire le azioni che l'ia deve fare
	public void aggiornaTimerIa() {
		int xMossaIa;
		int yMossaIa;
		//il computer tramite un ciclo while e la funzione random applica le mosse casualmente
		if(difficolta == 1) {
			while(turnoIa && !vinto) {
				if(turnoIa && turno) {
					xMossaIa = (int) (Math.random()*3);
					yMossaIa = (int) (Math.random()*3);
					if(matriceChar[xMossaIa][yMossaIa] == '-') {
						matriceChar[xMossaIa][yMossaIa] = 'x';
						matriceBottoni[xMossaIa][yMossaIa].setText("x");
						matriceBottoni[xMossaIa][yMossaIa].setDisable(true);
						turnoIa = false;
						turno = false;
						lTurnoX.setVisible(false);
						quadroGioco.setId("sfondoTurnoO");
					}
				}

				if(turnoIa && !turno) {
					xMossaIa = (int) (Math.random()*3);
					yMossaIa = (int) (Math.random()*3);
					if(matriceChar[xMossaIa][yMossaIa] == '-') {
						matriceChar[xMossaIa][yMossaIa] = 'o';
						matriceBottoni[xMossaIa][yMossaIa].setText("o");
						matriceBottoni[xMossaIa][yMossaIa].setDisable(true);
						turnoIa = false;
						turno = true;
						lTurnoO.setVisible(false);
						quadroGioco.setId("sfondoTurnoX");
					}
				}
			}
		}

		if(matriceChar[0][0] == 'x' && matriceChar[1][0] == 'x' && matriceChar[2][0] == 'x') {
			vinto = true;
			lineaVittoria0020.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0020);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}			
		if(matriceChar[0][0] == 'o' && matriceChar[1][0] == 'o' && matriceChar[2][0] == 'o') {
			vinto = true;
			lineaVittoria0020.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0020);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][1] == 'x' && matriceChar[1][1] == 'x' && matriceChar[2][1] == 'x') {
			vinto = true;
			lineaVittoria0121.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0121);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][1] == 'o' && matriceChar[1][1] == 'o' && matriceChar[2][1] == 'o') {
			vinto = true;
			lineaVittoria0121.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0121);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][2] == 'x' && matriceChar[1][2] == 'x' && matriceChar[2][2] == 'x') {
			vinto = true;
			lineaVittoria0222.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0222);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][2] == 'o' && matriceChar[1][2] == 'o' && matriceChar[2][2] == 'o') {
			vinto = true;
			lineaVittoria0222.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0222);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][0] == 'x' && matriceChar[0][1] == 'x' && matriceChar[0][2] == 'x') {
			vinto = true;
			lineaVittoria0002.setVisible(true);	
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0002);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][0] == 'o' && matriceChar[0][1] == 'o' && matriceChar[0][2] == 'o') {
			vinto = true;
			lineaVittoria0002.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0002);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[1][0] == 'x' && matriceChar[1][1] == 'x' && matriceChar[1][2] == 'x') {
			vinto = true;
			lineaVittoria1012.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria1012);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[1][0] == 'o' && matriceChar[1][1] == 'o' && matriceChar[1][2] == 'o') {
			vinto = true;
			lineaVittoria1012.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria1012);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[2][0] == 'x' && matriceChar[2][1] == 'x' && matriceChar[2][2] == 'x') {
			vinto = true;
			lineaVittoria2022.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria2022);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[2][0] == 'o' && matriceChar[2][1] == 'o' && matriceChar[2][2] == 'o') {
			vinto = true;
			lineaVittoria2022.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria2022);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[0][0] == 'x' && matriceChar[1][1] == 'x' && matriceChar[2][2] == 'x') {
			vinto = true;
			lineaVittoria0022.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0022);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();

		}
		if(matriceChar[0][0] == 'o' && matriceChar[1][1] == 'o' && matriceChar[2][2] == 'o') {
			vinto = true;
			lineaVittoria0022.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria0022);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[2][0] == 'x' && matriceChar[1][1] == 'x' && matriceChar[0][2] == 'x') {
			vinto = true;
			lineaVittoria2002.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria2002);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}
		if(matriceChar[2][0] == 'o' && matriceChar[1][1] == 'o' && matriceChar[0][2] == 'o') {
			vinto = true;
			lineaVittoria2002.setVisible(true);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(1), lineaVittoria2002);
			fadeTransition.setFromValue(0);
			fadeTransition.setToValue(1.0);
			fadeTransition.play();
		}

		//definizione delle condizioni di vincita o pareggio
		if(vinto && !turno) {
			timelineIa.stop();
			timelineTurno.stop();
			quadro.setVisible(false);
			quadroGioco.setDisable(false);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadro);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0);
			fadeTransition.play();
			lVinto.setText("HA VINTO IA!");
			lVinto.setId("labelVintoX");
			vittorieX++;
		}
		if(vinto && turno) {
			timelineIa.stop();
			timelineTurno.stop();
			quadro.setVisible(false);
			quadroGioco.setDisable(false);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadro);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0);
			fadeTransition.play();
			lVinto.setId("labelVintoO");
			lVinto.setText("HA VINTO IA!");
			vittorieO++;
		} 

		if(!vinto && mosse == 0) {
			timelineIa.stop();
			timelineTurno.stop();
			quadro.setVisible(false);
			quadroGioco.setDisable(false);
			FadeTransition fadeTransition = new FadeTransition (Duration.seconds(2), quadro);
			fadeTransition.setFromValue(1.0);
			fadeTransition.setToValue(0);
			fadeTransition.play();
			lVinto.setText("  PAREGGIO!");
			lVinto.setId("labelPareggio");
		}
		quadroGioco.setDisable(false);
		timelineIa.stop();
	}	

	public static void main(String args[]){
		launch();
	}
}
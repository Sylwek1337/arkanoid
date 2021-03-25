package pl.kielce.tu.arkanoid;
	
import com.sun.prism.Graphics;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;


public class Main extends Application implements EventHandler<KeyEvent>{

	public static final String APP_NAME = "Arkanoid";
	
	Ball ball;
	Shelf shelf;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle(APP_NAME);
		primaryStage.setMaximized(true);
		primaryStage.setResizable(false);
		
		Values.gameState = GameState.MENU;
		
		GraphicsSystem.width = Screen.getPrimary().getBounds().getWidth();
		GraphicsSystem.height = Screen.getPrimary().getBounds().getHeight();
		
		Canvas canvas  = new Canvas(GraphicsSystem.width, GraphicsSystem.height);
		GraphicsContext context = canvas.getGraphicsContext2D();
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e->run(context)));
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		Scene scene = new Scene(new StackPane(canvas));
		
		scene.setOnKeyPressed(this);
		scene.setOnKeyReleased(event -> {
			switch(event.getCode()) {
			case LEFT:
				Values.leftKeyPressed = false;
				break;
			case RIGHT:
				Values.rightKeyPressed = false;
				break;
			default:
				break;
			}
		});
		
		primaryStage.setScene(scene);
		
		ball = new Ball(GraphicsSystem.width/2 - 10, GraphicsSystem.height *0.8, 20, 3, -3);
		GraphicsSystem.ball = ball;
		EventSystem.ball = ball;
		
		shelf = new Shelf(GraphicsSystem.width/2 -100, GraphicsSystem.height*0.9, 200, 7);
		GraphicsSystem.shelf = shelf;
		EventSystem.shelf = shelf;
		
		primaryStage.show();
		timeline.play(); 
	}
	
	private void run(GraphicsContext context) {
		GraphicsSystem.setBackground(context);
		
		switch(Values.gameState) {
		case GAME:
			GraphicsSystem.showGame(context);
			GraphicsSystem.showBall(context);
			EventSystem.moveBall();
			GraphicsSystem.showShelf(context);
			EventSystem.moveShelf(context);
			break;
		case HIGHSCORES:
			break;
		case MENU:
			GraphicsSystem.showMenu(context);
			break;
		case SETTINGS:
			GraphicsSystem.showSettings(context);
			break;
		case QUIT:
			Platform.exit();
			break;
		default:
			break;
		}
	}

	@Override
	public void handle(KeyEvent event) {
		switch(Values.gameState) {
		case GAME:
			EventSystem.handleGameEvent(event);
			break;
		case HIGHSCORES:
			break;
		case MENU:
			EventSystem.handleMenuEvent(event);
			break;
		case QUIT:
			break;
		case SETTINGS:
			EventSystem.handleSettingsEvent(event);
			break;
		default:
			break;
		
		}
		
		if(Values.newGame) {
			Values.gameStarted = false;
			Values.newGame = false;
			ball = new Ball(GraphicsSystem.width/2 - 10, GraphicsSystem.height *0.8, 20, 3, -3);
			GraphicsSystem.ball = ball;
			EventSystem.ball = ball;
			shelf = new Shelf(GraphicsSystem.width/2 -100, GraphicsSystem.height*0.9, 200, 7);
			GraphicsSystem.shelf = shelf;
			EventSystem.shelf = shelf;
		}
		
	}
}

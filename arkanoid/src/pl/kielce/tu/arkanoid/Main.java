package pl.kielce.tu.arkanoid;
	
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
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle(APP_NAME);
		primaryStage.setMaximized(true);
		primaryStage.setResizable(false);
		
		Values.gameState = GameState.MENU;
		
		GraphicsRenderer.width = Screen.getPrimary().getBounds().getWidth();
		GraphicsRenderer.height = Screen.getPrimary().getBounds().getHeight();
		
		Canvas canvas  = new Canvas(GraphicsRenderer.width, GraphicsRenderer.height);
		GraphicsContext context = canvas.getGraphicsContext2D();
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e->run(context)));
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		Scene scene = new Scene(new StackPane(canvas));
		scene.setOnKeyPressed(this);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		timeline.play(); 
	}
	
	private void run(GraphicsContext context) {
		GraphicsRenderer.setBackground(context);
		
		switch(Values.gameState) {
		case GAME:
			showGame(context);
			break;
		case HIGHSCORES:
			break;
		case MENU:
			GraphicsRenderer.showMenu(context);
			break;
		case SETTINGS:
			GraphicsRenderer.showSettings(context);
			break;
		case QUIT:
			Platform.exit();
			break;
		default:
			break;
		}
	}

	
	private void showGame(GraphicsContext context) {
		
	}
	
	@Override
	public void handle(KeyEvent event) {
		switch(Values.gameState) {
		case GAME:
			break;
		case HIGHSCORES:
			break;
		case MENU:
			EventHandle.handleMenuEvent(event);
			break;
		case QUIT:
			break;
		case SETTINGS:
			EventHandle.handleSettingsEvent(event);
			break;
		default:
			break;
		
		}
		
	}
}

package pl.kielce.tu.arkanoid;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EventHandle {
	
	public static void handleMenuEvent(KeyEvent event) {
		if(event.getCode() == KeyCode.DOWN) {
			if(Values.currentMenuOption < 3) Values.currentMenuOption++;
		}
		else if(event.getCode() == KeyCode.UP) {
			if(Values.currentMenuOption >0) Values.currentMenuOption--;
		}
		else if(event.getCode() == KeyCode.ENTER) {
			if(Values.currentMenuOption == 0) Values.gameState = GameState.GAME; 
			if(Values.currentMenuOption == 1) Values.gameState = GameState.SETTINGS; 
			if(Values.currentMenuOption == 2) Values.gameState = GameState.HIGHSCORES; 
			if(Values.currentMenuOption == 3) Values.gameState = GameState.QUIT; 
		}
	}

	public static void handleSettingsEvent(KeyEvent event) {
		if(event.getCode() == KeyCode.DOWN) {
			if(Values.currentSettingsOption < 1) Values.currentSettingsOption++;
		}
		else if(event.getCode() == KeyCode.UP) {
			if(Values.currentSettingsOption > 0) Values.currentSettingsOption--;
		}
		
		switch(Values.currentSettingsOption) {
		case 0:
			if(event.getCode() == KeyCode.RIGHT) {
				if(Values.currentDifficultyLevel < 2) Values.currentDifficultyLevel++;
			}
			if(event.getCode() == KeyCode.LEFT) {
				if(Values.currentDifficultyLevel > 0) Values.currentDifficultyLevel--;
			}
			break;
		case 1:
			if(event.getCode() == KeyCode.RIGHT) Values.soundEnabled = true;
			else if(event.getCode() == KeyCode.LEFT) Values.soundEnabled = false;
			break;
			
		default:
			break;
		}
	}
}

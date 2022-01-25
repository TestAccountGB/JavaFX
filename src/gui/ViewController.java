package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class ViewController {

	// Precisamos criar atributos para cada elemento do SceneBuilder
	@FXML
	private Circle circle;
	private double y;
	private double x;
	private static final int i = 5;
	
	@FXML
	// Quando apertar o botao UP...
	public void onActionButtonUp() {
		circle.setCenterY(y -= i);
	}

	@FXML
	// Quando apertar o botao DOWN...
	public void onActionButtonDown() {
		circle.setCenterY(y += i);
	}

	@FXML
	// Quando apertar o botao RIGHT...
	public void onActionButtonRight() {
		circle.setCenterX(x += i);
	}

	@FXML
	// Quando apertar o botao LEFT...
	public void onActionButtonLeft() {
		circle.setCenterX(x -= i);
	}
	
	@FXML
	// Quando apertar o botao DONT...
	public void onActionButtonDont() {
		Alerts.showAlert("I SAID DONT", null, "NOW YOUR DICK IS SMALLER", AlertType.WARNING, null);
	}
	
	@FXML
	public void onKeyPressedButton(KeyEvent key) {
		//Para descobrir o retorno dos metodos, voce pode conferir aqui:
		//https://openjfx.io/javadoc/11/javafx.graphics/javafx/scene/Node.html
		
		switch (key.getCode()) {
		case UP:
			onActionButtonUp();
			break;
		case DOWN:
			onActionButtonDown();
			break;
		case LEFT:
			onActionButtonLeft();
			break;
		case RIGHT:
			onActionButtonRight();
			break;
		default:
			break;
			//Ou seja, vamos mover pelas setinhas tambem
			//Obs.: Para isso funcionar voce deve deixar os botoes com a propriedade "Focus Traversable" desativado e ativar
			//A do circulo, pois vamos estar "selecionando" ele :)
		}
	}

}

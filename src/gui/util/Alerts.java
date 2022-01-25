package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Alerts {
	
	//Alerta sao tipo um stage, mas apenas para mostrar uma mensagem e sair
	public static void showAlert(String title, String header, String content, AlertType type, Image image) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		if(image != null) {
			Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
			//Como falei antes, o alert e praticamente um stage, entao podemos fazer um upcast para Stage e assim podemos
			//Alterar algumas propriedades, como o icone...
			stage.getIcons().add(image);
		}
		alert.show();
	}
	
}

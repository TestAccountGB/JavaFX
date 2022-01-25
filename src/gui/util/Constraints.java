package gui.util;

import javafx.scene.control.TextField;

public class Constraints { //Constraints = Restricoes

	public static void setTextFieldInteger(TextField txt) {
		//O TextField tem um listener que e executado toda vez que algum caractere e inserido
		txt.textProperty().addListener((obs, oldValue, newValue) -> {//A regex em questao precisa desses tres argumentos:
			//obs (Observable), valorAntigo (String), valorNovo (String).
			if (newValue != null && !newValue.matches("\\d*")) {
				//Ou seja, se o usuario colocar algo diferente de um digito ele vai retornar ao valor antigo
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}
	
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
				//Ou seja, so aceitamos digitos, e pode ocorrer de haver um ponto depois do digito e depois do ponto, ele aceita
				//Qualquer quantidade de digitos, mas essa ocorrencia so ocorre uma vez ou nenhuma (?)
				txt.setText(oldValue);
			}
		});
	}
	
}

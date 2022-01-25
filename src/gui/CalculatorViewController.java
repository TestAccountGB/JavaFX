package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorViewController implements Initializable {
	//Essa interface nos permite implementar um metodo (initialize), que e executado quando o Controller e instanciado.
	//O controller e instaciado quando o fxml e carregado, ou seja, bem no comeco

	@FXML
	private TextField firstNumber;
	@FXML
	private TextField lastNumber;
	@FXML
	private Label label;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(firstNumber);
		Constraints.setTextFieldDouble(lastNumber);
	}

	@FXML
	public void onActionButtonSum() {
		try {
			double firstNumberDouble = Double.parseDouble(firstNumber.getText());
			double lastNumberDouble = Double.parseDouble(lastNumber.getText());

			label.setText(String.format("%.2f", firstNumberDouble + lastNumberDouble));
		} catch (Exception e) {
			Alerts.showAlert("Error", null, "Error: " + e.getMessage(), AlertType.ERROR, null);
		}
	}

}

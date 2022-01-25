package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ComboBox extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/gui/ComboBoxView.fxml"));
		
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.getIcons().add(new Image("icone.png"));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

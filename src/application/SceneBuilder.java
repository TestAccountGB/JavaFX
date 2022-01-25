package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SceneBuilder extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		//O SceneBuilder trabalha com arquivos .fxml, o que e? Ele e baseado na liguagem "xml" mas feito para funcionar
		//Com o JavaFX. Para comecar a trabalhar com ele vamos criar um documento fxml, assim: New -> Other -> JavaFX ->
		//New FXML Document. E depois clicar o botao direito nele e na opcao "Open with SceneBuilder", agora como usar
		//O SceneBuilder nao vou explicar, entao procure um tutorial aleatorio no YT xD.
		
		//O que eu vou explicar, e como se comunicar com ele pelo java, para cada arquivo .fxml que criar tem que ter uma
		//Classe "controladora", para fazer acoes e etc. Como boa pratica crie a classe com o nome do arquivo .fxml e
		//"Controller" no final
		
		//Vamos usar esse metodo para carregar o arquivo fxml...
		Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));
		//Vamos usar o Parent pois ele e o mais generico possivel
		
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.getIcons().add(new Image("icone.png"));
		stage.setTitle("Crazy Circle");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Initial extends Application {
	//Obs.: Para acompanhar esse projeto, precisa instalar os seguintes itens (Eclipse):
	//JavaFX da gluon - https://gluonhq.com/products/javafx
	//SceneBuilder da gluon - https://gluonhq.com/products/scene-builder
	//Plug-in do eclipse - E(fx)clipse no marketplace do proprio eclipse
	
	//Primeiramente va em Window -> Preferences -> JavaFX e colocar o executavel do SceneBuilder;
	//Depois crie uma biblioteca no eclipse com os arquivos que esta no download do JavaFX da gluon, na pasta "lib";
	//E pronto.
	
	//Para criar um projeto JavaFX va em New -> Other -> JavaFX -> JavaFX Project. E depois de criar o projeto adicione a
	//Biblioteca que criou
	//Obs.: Apague a classe de modulo
	
	//E por ultimo adiciona das configuracoes de Run (Cliclando o botao direito na classe que tem o metodo main
	//-> Run As -> Run Configuration) -> Arguments e depois na caixa de "VM arguments" adicone a seguinte linha:
	//--module-path (Caminho do javaFX gluon, exemplo: C:\temp\javafx\lib ) --add-modules=javafx.fxml,javafx.controls
	
	//Antes de comecar a escrever um codiguin com uma interface grafica, vamos primeiramente explicar o conceito do
	//JavaFX, temos primeiramente o
	//Stage: Que pode se comparar a uma peca de teatro, onde a gente tem o palco, onde acontecem as cenas da peca.
	//Scene: Basicamente a cena citada anteriomente, mas para realmente entender esse conceito, vou citar o famoso
	//"Minecraft", onde na tela inicial temos a cena com seus botoes, mas quando a gente aperta por exemplo, no botao
	//"Options", vamos para outra cena, onde tem outros botoes.
	//Node: Basicamente os botoes, textos, formas geometricas e etc.
	
	//Resumindo: Stage e aonde as scenes acontecem, e as cenas guardam nodes onde dependendo do caso "controla" a
	//Cena
	
	@Override
	public void start(Stage stage) {
		//Com o projeto criado, vai perceber que a classe "Initial" extende "Application", que nos obriga a sobrescrever o
		//Metodo "start", onde claramente, a nossa applicacao de JavaFX vai comecar
		try {
			Group root = new Group();
			//O que e esse group? E um node root. Um node root significa um node que gerencia outros nodes, normalmente
			//Esses nodes sao classes genericas dos nodes que vamos usar. O node "Group" e o mais generico, por isso escolhi
			//Ele, caso queira ver a hierarquia dos nodes, pode ver nesse link:
			//https://docs.oracle.com/javase/8/javafx/api/overview-tree.html
			
			//E assim podemos criar varios nodes para colocar no root, como um texto:
			Text text = new Text(); //Obs.: Tenha a certeza que essas classes estao sendo importadas do package "javafx"
			
			//Podemos alterar MUITAS propriedades...
			text.setText("Hello World");
			text.setFont(Font.font("Arial", 30));//Para entender como usar a maioria dos metodos, recomendo pesquisar
			//Conforme sua necessidade, caso precise mudar a fonte, pesquise algo como:
			//"how to change the font of text javafx", pesquise preferencialmente em ingles
			
			text.setFill(Color.BLACK);//Mudando a cor
			
			text.setX(120);
			text.setY(200);
			
			//E agora depois de acabar, podemos adicionar ao root...
			root.getChildren().add(text);
			
			//Agora que temos pelo menos um node, podemos colocar em uma Scene...
			Scene scene = new Scene(root, 400, 400);//Os dois ultimos argumentos e a resolucao
			
			//Podemos alterar propiedades da Scene...
			scene.setFill(Color.LIGHTSTEELBLUE);
			
			//Depois de criar uma Scene, podemos colocar ela no Stage...
			stage.setScene(scene);
			
			//Podemos alterar propiedades do stage tambem...
			stage.setFullScreen(true);
			stage.setFullScreenExitHint("APERTE A TECLA 's' PARA SAIR DO FULLSCREEN");
			stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("s"));
			
			//E depois mostrar...
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//No nosso metodo main vamos apenas usar esse metodo...
		launch(args);
		
		//Nossa classe tem esse metodo pois ela ta extendendo "Application"
	}
}

package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import model.entities.Person;

public class ComboBoxController implements Initializable {

	@FXML
	private ComboBox<Person> comboBoxPerson;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Person> personList = Person.database();
		ObservableList<Person> obsPersonList = FXCollections.observableList(personList);
		//Estamos usando o FXCollections apenas para converter uma lista para uma lista observavel, que e uma lista focada
		//No JavaFX
		comboBoxPerson.setItems(obsPersonList);
		//Agora vamos colocar essa lista no ComboBox
		
		Callback<ListView<Person>, ListCell<Person>> callback = (ListView<Person> lv) -> new ListCell<Person>() {
			//Callback serve para a gente "filtrar" uma lista, aqui a gente so vai usar a ListCell
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);//Temos que usar isso pois ele ainda tem uma logica para colocar o item no
				//ComboBox
				if (item != null) {
					if (item.getAge() > 30) {//Se for maior que trinta anos vou pintar de vermelho, por que? Porque eu posso :>
						setText(empty ? "" : item.getName());
						setTextFill(Color.RED);
					} else {
						setText(empty ? "" : item.getName());
						setTextFill(Color.BLACK);
					}
					//Assim vamos apenas mostrar o nome, se a gente nao filtrar ele vai mostrar o toString da classe, mas entao
					//Por que nao mudar o toString? Porque mudar apenas para usar em uma situacao nao e muito recomendado
				}
			}
		};
		//Providing a custom cell factory allows for complete customization of the rendering of items in the ComboBox.
		comboBoxPerson.setCellFactory(callback);
		comboBoxPerson.setButtonCell(callback.call(null));
		//setButtonCell serve para setar o que vai ser mostrado quando algo for selecionado, usando o call do callback,
		//Apenas vai retornar a ListCell do Callback, e como nossa ListCell apenas tem o nome das pessoas, quando a gente
		//Selecionar algo no ComboBox vai apenas mostrar o nome
	}
	
	@FXML
	public void onActionComboBoxPerson() {
		//Esse e o comando para retornar o elemento escolhido da ComboBox
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}
	
	@FXML
	public void onActionButtonGetAll() {
		for(Person person : comboBoxPerson.getItems()) {//Assim ele retorna a lista
			System.out.println(person);
		}
	}
	
}

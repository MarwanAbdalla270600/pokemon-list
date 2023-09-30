package fhtw.pokemon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    public TextField txt_name;
    @FXML
    public TextField txt_level;
    @FXML
    public TextField txt_hp;
    @FXML
    public TextField txt_xp;
    @FXML
    public Button btn_add;
    @FXML
    public Button btn_remove;
    @FXML
    public Button btn_clear;
    @FXML
    public ListView<Pokemon> pokemon_list;
    @FXML
    public TextArea txt_log;

    @FXML
    public void initialize() {
        pokemon_list.setItems(Pokemon.getPokemons());
        txt_log.appendText("This is the FXML view\n");
    }
    @FXML
    public void add() {
        try {
            Pokemon.addPokemon(new Pokemon(txt_name.getText(), Integer.parseInt(txt_level.getText()), Integer.parseInt(txt_hp.getText()), Integer.parseInt(txt_xp.getText())));
            txt_log.appendText("ADD ");
        } catch (NumberFormatException nfe) {
            txt_log.appendText("Invalid Input\n");
        }
    }

    @FXML
    public void remove() {
        try {
            Pokemon.removePokemon(pokemon_list.getSelectionModel().getSelectedIndex());
            txt_log.appendText("REMOVE ");
        } catch (IndexOutOfBoundsException ioobe) {
            txt_log.appendText("Select pokemon before removing\n");
        }
    }

    @FXML
    public void clear() {
        if (Pokemon.getPokemons().isEmpty()) {
            txt_log.appendText("List is empty\n");
        } else {
            txt_log.appendText("CLEAR ");
            Pokemon.removeAllPokemon();
        }
    }

}
package fhtw.pokemon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {

    public final boolean useFxml = true;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPane = new BorderPane();
        VBox outerVBox = new VBox();
        VBox leftVBox = new VBox();
        ListView<Pokemon> pokemon_list = new ListView<>();
        TextArea txt_log = new TextArea();
        txt_log.setWrapText(true);
        txt_log.appendText("This is NOT the FXML View\n");
        TextField txt_name = new TextField();
        TextField txt_level = new TextField();
        TextField txt_hp = new TextField();
        TextField txt_xp = new TextField();
        Button btn_add = new Button("add");
        Button btn_remove = new Button("remove");
        Button btn_clear = new Button("clear");

        outerVBox.getChildren().addAll(txt_log, borderPane);
        borderPane.setLeft(leftVBox);
        leftVBox.getChildren().addAll(txt_name, txt_level, txt_hp, txt_xp, btn_add, btn_remove, btn_clear);
        borderPane.setCenter(pokemon_list);

        btn_add.setPrefWidth(200);
        btn_remove.setPrefWidth(200);
        btn_clear.setPrefWidth(200);
        leftVBox.setSpacing(10);
        leftVBox.setPadding(new Insets(0, 10, 10, 0));
        outerVBox.setSpacing(10);
        outerVBox.setPadding(new Insets(10));
        txt_name.setPromptText("name");
        txt_level.setPromptText("level");
        txt_hp.setPromptText("health-points");
        txt_xp.setPromptText("experience-points");

        pokemon_list.setItems(Pokemon.getPokemons());

        btn_add.setOnAction(event -> {
            try {
                Pokemon.addPokemon(new Pokemon(txt_name.getText(), Integer.parseInt(txt_level.getText()), Integer.parseInt(txt_hp.getText()), Integer.parseInt(txt_xp.getText())));
                txt_log.appendText("ADD ");
            } catch (NumberFormatException nfe) {
                txt_log.appendText("Invalid Input\n");
            }
        });
        btn_remove.setOnAction(event -> {
            try {
                Pokemon.removePokemon(pokemon_list.getSelectionModel().getSelectedIndex());
                txt_log.appendText("REMOVE ");
            } catch (IndexOutOfBoundsException ioobe) {
                txt_log.appendText("Select pokemon before removing\n");
            }
        });
        btn_clear.setOnAction(event -> {
            if (Pokemon.getPokemons().isEmpty()) {
                txt_log.appendText("List is empty\n");
            } else {
                txt_log.appendText("CLEAR ");
                Pokemon.removeAllPokemon();
            }
        });

        Scene scene;
        if (useFxml) {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Parent root = loader.load();
            scene = new Scene(root);
        } else {
            scene = new Scene(outerVBox);
        }

        stage.setTitle("My Pokemon");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
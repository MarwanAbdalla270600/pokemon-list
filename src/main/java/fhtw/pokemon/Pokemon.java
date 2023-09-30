package fhtw.pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Pokemon {

    String name;
    int level;
    int hp;
    int xp;
    private static final ObservableList<Pokemon> list = FXCollections.observableArrayList();

    static {
        addPokemon(new Pokemon("Pikatchu", 7, 100, 300));
        addPokemon(new Pokemon("Bisasam", 2, 80, 200));
        addPokemon(new Pokemon("Glumanda", 3, 55, 400));
        addPokemon(new Pokemon("Smogmog", 10, 63, 100));
        addPokemon(new Pokemon("Gengar", 12, 20, 500));
    }
    public Pokemon(String name, int level, int hp, int xp) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.xp = xp;
    }

    public static ObservableList<Pokemon> getPokemons() {
        return list;
    }

    public static void addPokemon(Pokemon pokemon) {
        list.add(pokemon);
    }

    public static void removePokemon(int index) {
        list.remove(index);
    }

    public static void removeAllPokemon() {
        list.clear();
    }

    @Override
    public String toString() {
        return name+"[lvl: " + level + ",  hp: " + hp + ",  xp:" + xp + "]";
    }
}

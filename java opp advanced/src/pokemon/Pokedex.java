package pokemon;

import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
	
	ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>();
	
	@Override
	public void listPokemon() {
		for(Pokemon pokemon : this.myPokemons) {
			System.out.println("nombre: " + pokemon.getName());
		}
	}
	@Override
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon pokemon = super.createPokemon(name, health, type);
		this.myPokemons.add(pokemon);
		return pokemon;
		
	}
	
	

}

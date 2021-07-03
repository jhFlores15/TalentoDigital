package pokemon;

public abstract class AbstractPokemon implements PokemonInterface {
	
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon pokemon = new Pokemon(name,health,type);
		return pokemon;
	}
	
	public String pokemonInfo(Pokemon pokemon) {
		return "detalles pokemon: nombre->"+pokemon.getName() + " vida->" + pokemon.getHealth() + " tipo->" + pokemon.getType();
	}
	
}
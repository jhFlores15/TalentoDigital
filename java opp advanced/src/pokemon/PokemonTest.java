package pokemon;

public class PokemonTest {
	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();

		Pokemon bulb = pokedex.createPokemon("Bulbasaur", 100, "Hierba");
		Pokemon charm = pokedex.createPokemon("Charmander", 90, "Fuego");
		pokedex.listPokemon();

		bulb.attackPokemon(charm);
		
		System.out.println(pokedex.pokemonInfo(bulb));
		System.out.println(pokedex.pokemonInfo(charm));
		
		Pokedex pokedex2 = new Pokedex();
		
		Pokemon bulb2 = pokedex2.createPokemon("Bulbasaur", 100, "Hierba");
		pokedex2.listPokemon();
		
		System.out.println(pokedex2.pokemonInfo(bulb2));
	}
	
}

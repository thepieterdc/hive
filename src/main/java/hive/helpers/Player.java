package hive.helpers;

import hive.data.Players;
import hive.interfaces.Representable;
import javafx.scene.paint.Color;

/**
 * Represents a player playing the game.
 * <p>
 * Created at 25/03/16 18:06
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class Player implements Representable {
	private final Color color;
	private final char id;
	private final String name;

	private static final String[] firstnames = {
			"Bob",
			"Robert",
			"Rick",
			"Morty",
			"Carl",
			"Sheldon",
			"Severus",
			"Albus",
			"Harry",
			"Ron",
			"Hermione",
			"Sebastian",
			"Juliette",
			"Reuben",
			"Peter",
			"Flower",
			"Michael",
			"Dean",
			"Oliver",
			"Frodo",
			"Bilbo",
			"Gandalf",
			"Legolas",
			"Gimli",
			"Boromir",
			"Smaug",
			"Robert",
			"Isaac",
			"Abraham",
			"Thorin",
			"Fili",
			"Kili",
			"Balin",
			"Dwalin",
			"Oin",
			"Gloin",
			"Dori",
			"Nori",
			"Ori",
			"Bifur",
			"Bofur",
			"Bombur"
	};

	private static final String[] adjectives = {
			"the Destroyer",
			"the Boss",
			"the Precious",
			"the Last",
			"the First",
			"the Doctor",
			"the Bad Wolf",
			"the Master",
			"the Forgotten",
			"the Conqueror",
			"the Denier",
			"the Paralyzed",
			"the Paralyzer",
			"the Indigenous",
			"the Genius",
			"the Plebeian",
			"the Colorful",
			"the KL-35",
			"the Omnipotent",
			"the Impotent",
			"the One",
			"the Second",
			"the Dragon Master",
			"the Hobbit",
			"the George",
			"the Dull",
			"the Magician",
			"the Deceiver",
			"the Deceived",
			"the Drunk",
			"the Exterminator",
			"the Girl Who Waited",
			"the Roman",
			"the Impossible",
			"the K9",
			"the Queen",
			"the Ant",
			"the Beetle",
			"the Spider",
			"the Grasshopper",
			"the Oakenshield"
	};

	/**
	 * Player constructor.
	 *
	 * @param i   the identifier
	 * @param col the colour
	 */
	public Player(char i, Color col) {
		this(i, col, String.valueOf(i));
	}

	/**
	 * Player constructor.
	 *
	 * @param i   the identifier
	 * @param col the colour
	 * @param n   the player name
	 */
	public Player(char i, Color col, String n) {
		this.color = col;
		this.id = i;
		this.name = n;
	}

	/**
	 * Player constructor.
	 *
	 * @param p the Players entry
	 * @param n the player name
	 */
	public Player(Players p, String n) {
		this(p.player().id(), p.player().color(), n);
	}

	/**
	 * @return the colour
	 */
	public Color color() {
		return this.color;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Player && this.id == ((Player) obj).id() && this.color.equals(((Player) obj).color()) && this.name.equals(((Player) obj).name());
	}

	@Override
	public int hashCode() {
		return this.id + this.color.hashCode() + this.name.hashCode();
	}

	/**
	 * @return the identifier
	 */
	public char id() {
		return this.id;
	}

	/**
	 * @return the player name
	 */
	public String name() {
		return this.name;
	}

	/**
	 * @return a random adjective for the first/second player
	 */
	public static String randomAdjective() {
		return adjectives[(int) (adjectives.length * Math.random() - 1)];
	}

	/**
	 * @return a random firstname for the second player
	 */
	public static String randomFirstName() {
		return firstnames[(int) (firstnames.length * Math.random() - 1)];
	}

	@Override
	public String representation() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Player[color=" + this.color + ", id=" + this.id + ", name=" + this.name + ']';
	}
}

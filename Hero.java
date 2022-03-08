///////////////////////////////////////////////////////////////////////////////
// Title:              Hero
// Files:              Monster.java
// Quarter:            CSE 8B Spring 2021
//
// Author:             Jonathan Tran
// Email:              jot002@ucsd.edu
// Instructor's Name:  Professor Allos
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Creates one instance of Hero to be used throughout the entire program. The
 * instance of Hero will be used to fight the monsters 
 *
 * Bugs: None known
 *
 * @author   Jonathan Tran
 */
public class Hero {
	private static final String ATTACK_FORMAT = "%s attacks %s, causing %d damage.";

	private String name;
	private int damage;
	private int health;
	private int speed;

	private static Hero hero_instance;


	/**
     * 	A private constructor that can only be used within this class. This
	 * 	constructor should only be called once throughout the entire program.
	 * 	Do NOT overload this constructor. This is the only constructor in this
	 * 	class. Do NOT change this constructor.
     */
	private Hero() {}

	/**
     * 	Get the name attribute of the hero
     *
     * 	@return the name of the hero
     */
	public String getName() {
		return this.name;
	}

	/**
     * 	Get the damage attribute of the hero
     *
     * 	@return the damage of the hero
     */
	public int getDamage() {
		return this.damage;
	}

	/**
     * 	Get the health attribute of the hero
     *
     * 	@return the health of the hero
     */
	public int getHealth() {
		return this.health;
	}

	/**
     * 	Get the speed attribute of the hero
     *
     * 	@return the speed of the hero
     */
	public int getSpeed() {
		return this.speed;
	}

	/**
     * 	set the name attribute of the hero
     *
     * 	@param name the name of the hero
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * 	set the damage attribute of the hero
     *
     * 	@param damage the name of the hero
     */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
     * 	set the health attribute of the hero
     *
     * 	@param health the name of the hero
     */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
     * 	set the speed attribute of the hero
     *
     * 	@param speed the name of the hero
     */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
     *  Sets the name, damage, health, and speed of the hero to the given 
	 *  parameters
     *
	 *  @param name - the name of the hero
	 *  @param damage - the hero's damage
	 *  @param health - the hero's health
	 *  @param speed - the hero's speed
     */
	public void setFields(String name, int damage, int health, int speed) {
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.speed = speed;
	}

	/**
     *  initializes the hero instance if it is null, then returns it
     *
	 *  @return the singleton Hero instance
     */
	public static Hero getInstance() {
		// initializes hero_instance if it is null
		if (hero_instance == null) {
			hero_instance = new Hero();
		}
		
		return hero_instance;
	}

	/**
     *  Makes the input monster lose health based on the hero_instance's 
	 * damage
     *
	 *  @param monster - monster that will be attacked by the hero_instance
	 *  @return - message informing how much damage the hero_instance 
	 * did to the monster
     */
	public String attack(Monster monster) {
		// get the hero_instance's damage
		int totalDam = hero_instance.getDamage();
		monster.receiveDamage(totalDam);
		return String.format(ATTACK_FORMAT, this.name, monster.getName(),
			 totalDam);
	}

	/**
     *  the hero gains the stats of the item
	 * 
     *  @param item - the item that the hero will equip
	 *  @return message indicating what the hero equipped
     */
	public String equipItem(Item item) {
		// adds the item stats to the hero
		this.health += item.getHealth();
		this.damage += item.getDamage();
		this.speed += item.getSpeed();
		
		return hero_instance.getName() + " received " + item.getName();
	}

	/**
     *  checks to see if the hero is faster than the input monster
	 * 
     *  @param monster - the monster that will be compared to the hero
	 *  @return true if the hero is fastere, false if not
     */
	public boolean isFasterThan(Monster monster) {
		// checks to see if the hero is faster than the monster
		if (hero_instance.getSpeed() > monster.getSpeed()) {
			return true;
		}
		return false;
	}

	/**
     *  checks to see if the hero is still alive
	 * 
	 *  @return true if the hero is alive, false if not
     */
	public boolean isStillAlive() {
		if (hero_instance.getHealth() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
     *  the heero will lose health equal to the input damage
	 * 
     *  @param damage - damage inflicted onto the hero
     */
	public void receiveDamage(int damage) {
		this.health = this.health - damage;
	}

	/**
     * 	Retrives name, damage, health and speed  of the hero in a formatted
	 * 	string.
     *
     * 	@return a string representation of the stats of the hero.
     */
	public String getStats() {
		return String.format("\t%s - damage: %d, health: %d, speed: %d", 
			this.name, this.damage, this.health, this.speed);
	}
	
}
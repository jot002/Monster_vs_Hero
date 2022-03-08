///////////////////////////////////////////////////////////////////////////////
// Title:              Monster
// Files:              Hero.java
// Quarter:            CSE 8B Spring 2021
//
// Author:             Jonathan Tran
// Email:              jot002@ucsd.edu
// Instructor's Name:  Professor Allos
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Creates a Monster object that has a name, roarSound, damage, health, and 
 * speed. This class is used to define the monster and have the monster
 * do certain things or check the stats of it.
 * 
 *
 * Bugs: None known
 *
 * @author   Jonathan Tran
 */
public class Monster {
	private static final String ATTACK_FORMAT = "%s attacks %s, causing %d damage.";
	private String name;
	private String roarSound;
	private int damage;
	private int health;
	private int speed;

	private static int anger = 1;

	/**
     * Constructor used to initialize the member variables
     *
     * @param name - the name of the monster
	 * @param roarSound -  the sound of the monster's roar
	 * @param damage - the damage of the monster
	 * @param health - the health of the monster
	 * @param speed - the speed of the monster
     */
	public Monster(String name, String roarSound, int damage, int health, 
					int speed) {
		this.name = name;
		this.roarSound = roarSound;
		this.damage = damage;
		this.health = health;
		this.speed = speed;
	}

	/**
     * 	Get the speed attribute of the monster
     *
     * 	@return the speed of the monster
     */
	public int getSpeed() {
		return this.speed;
	}


	/**
     * 	Get the name attribute of the monster
     *
     * 	@return the name of the monster
     */
	public String getName() {
		return this.name;
	}

	/**
     * 	Get the health attribute of the monster
     *
     * 	@return the health of the monster
     */
	public int getHealth() {
		return this.health;
	}

	/**
	 * 	Get the damage attribute of the monster
	 *
	 * 	@return the damage of the monster
	 */
	public int getDamage() {
		return this.damage;
	}

	/**
     * 	Get the anger attribute of the Monster class
     *
     * 	@return the anger of the Monster class
     */
	public static int getAnger() {
		return anger;
	}

	/**
     * 	Set the anger attribute of the Monster class
     *
     * 	@param anger anger of the Monster class
     */
	public static void setAnger(int anger) {
		Monster.anger = anger;
	}

	/**
     *  Causes the input hero to losee health equal to the monster's damage
	 *  times its anger
     *
     * 	@param hero hero from Hero.java
	 *  @return a message indicating how much damage the monster inflicted 
	 * onto the hero
     */
	public String attack(Hero hero) {
		// gets the total damagee of the monster
		int totalDamage = this.damage * this.getAnger();
		// has the hero receive the damage
		hero.receiveDamage(totalDamage);
		return String.format(ATTACK_FORMAT, this.name,
				 hero.getName(), totalDamage);
	}


	/**
     *  Shows what the monster roars
     *
	 *  @return the roarSound string with the monster name
     */
	public String roar() {
		return this.name + ": " + this.roarSound;
	}


	/**
     *  Checks if the monster is still alive and increases the anger if it is
	 *  not
     *
	 *  @return true if the monster is alive, false if not
     */
	public boolean isStillAlive() {
		// checks if the mosnter's health is greater than 0
		if (this.health > 0) {
			return true;
		}
		else {
			// increases the anger if it is dead
			anger = anger + 1;
			return false;
		}
	}


	/**
     *  makes the monster lose health based on the damage received
     *
	 *  @param damaage - how much the monster was hit for
     */
	public void receiveDamage(int damage) {
		this.health = this.health - damage;
	}

	/**
     * 	Retrives name, damage, health and speed  of the monster in a formatted
	 * 	string.
     *
     * 	@return a string representation of the stats of the monster.
     */
	public String getStats() {
		return String.format("\t%s - damage: %d, health: %d, speed: %d", 
			this.name, this.damage, this.health, this.speed);
	}
}
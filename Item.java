///////////////////////////////////////////////////////////////////////////////
// Title:              Item
// Files:              None
// Quarter:            CSE 8B Spring 2021
//
// Author:             Jonathan Tran
// Email:              jot002@ucsd.edu
// Instructor's Name:  Professor Allos
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Creates items and its stats to be used in other files such as Tower.java.
 *
 * Bugs: None known
 *
 * @author   Jonathan Tran
 */
public class Item{

	private String name;
	private int damage;
	private int health;
	private int speed;

	/* 
	*	itemList and itemStats are used in pairs. For example, the first item
	* 	"Small Knife" has stats {2, 0, 0} (damage = 2, health = 0, speed = 0),
	* 	corresponding to the first row of the itemStats. for itemStats, first
	* 	column is damage, second column is health, and third column is speed.
	*/
	private static final String[] itemList = {"Small Knife",
											"Wooden Shield",
											"Booster",
											"Knight Sword",
											"HP Potion",
											"Ninja Suit",
											"Platinum Shield",
											"Thunder Hammer",
											"Treasure"};
	private static final int[][] itemStats = {{2, 0, 0},
											{0, 4, 0},
											{0, 0, 2},
											{4, 0, -1},
											{0, 6, 0},
											{1, 2, 2},
											{0, 10, -1},
											{6, 0, 0},
											{0, 0, 0}};

	/**
     * Constructor used to initialize the member variable name and get the
	 * damage, health, and speed of the item
     *
     * @param name - the name of the item
     */
	public Item(String name) {
		int thirdElem = 2;
		this.name = name;
		int itemIndex = -1;
		// checks if the item name is in the itemList
		for (int index = 0; index < itemList.length; index++) {
			if (itemList[index].equals(name)) {
				itemIndex = index;
			}
		}
		// if the input name is not an item, the stats will be 0
		if (itemIndex == -1) {
			this.damage = 0;
			this.health = 0;
			this.speed = 0;
		}
		// if it is an item, set the stats to its corresponding places
		else {
			this.damage = itemStats[itemIndex][0];
			this.health = itemStats[itemIndex][1];
			this.speed = itemStats[itemIndex][thirdElem];
		}
	}

	/**
     * 	Get the damage attribute of the item
     *
     * 	@return the damage of the item
     */
	public int getDamage() {
		return this.damage;
	}

	/**
     * 	Get the health attribute of the item
     *
     * 	@return the health of the item
     */
	public int getHealth() {
		return this.health;
	}

	/**
     * 	Get the speed attribute of the item
     *
     * 	@return the speed of the item
     */
	public int getSpeed() {
		return this.speed;
	}

	/**
     * 	Get the name attribute of the item
     *
     * 	@return the name of the item
     */
	public String getName() {
		return this.name;
	}

}
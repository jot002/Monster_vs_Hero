/**
 * Creates a representation of a tower filled with a monster and item on 
 * each level. It is represented by arrays. 
 *
 * Bugs: None known
 *
 * @author   Jonathan Tran
 */
public class Tower {
	private static final String FORMAT = "\nLevel %d: %s encounters %s\n";

	private int height;
	private Monster[] monsterEachLevel;
	private Item[] itemEachLevel;

	/**
     * Constructor used to initialize the member variables height to height
	 * and monsterEachLevel and itemEachLevel to empty arrays of lenght height
     *
     * @param height - the height of the tower
     */
	public Tower(int height) {
		// sets height to 1 if input height is less than 1
		if (height < 1) {
			this.height = 1;
		}
		else {
			this.height = height;
		}
		// sets monsterEachLevel to an empty array of length height
		if (monsterEachLevel == null) {
			monsterEachLevel = new Monster[height];
		}
		else {
			monsterEachLevel = new Monster[height];
		}
		// sets itemEachLevel to an empty array of length height
		if (itemEachLevel == null) {
			itemEachLevel = new Item[height];
		}
		else {
			itemEachLevel = new Item[height];
		}
	}

	/**
     * 	Set a monster and item to a level of the tower
     *
     * 	@param level level of the tower
	 *  @param monster monster to be put into the tower at the level
	 *  @param level item to be put into the tower at the level
     */
	public void setOneLevel(int level, Monster monster, Item item) {
		this.monsterEachLevel[level] = monster;
		this.itemEachLevel[level] = item;
	}	

	/**
     * 	Get the height attribute of the tower
     *
     * 	@return the height of the tower
     */
	public int getHeight() {
		return this.height;
	}

	/**
     * 	Get the monster instance at the given tower level
     * 
	 *  @param level the level to choose the monster
     * 	@return the monster instance at the given tower level
     */
	public Monster getMonsterAtLevel(int level) {
		return this.monsterEachLevel[level];
	}

	/**
     * 	Get the item instance at the given tower level
     * 
	 *  @param level the level to choose the item
     * 	@return the item instance at the given tower level
     */
	public Item getItemAtLevel(int level) {
		return this.itemEachLevel[level];
	}

	/**
     * 	Set up the tower attributes with some arbitrary monsters and items.
     * 
     * 	@return the item instance at the given tower level
     */
	public static Tower setUpTower() {
		Tower tower = new Tower(5);

		Monster slime = new Monster("slime", "Zizizi", 1, 4, 1);
		Monster nightBat = new Monster("nightBat", "Urhnnnn", 2, 7, 5);
		Monster ghost = new Monster("ghost", "WinWin", 4, 6, 3);
		Monster zombie = new Monster("zombie", "Rueeeee", 3, 10, 2);
		Monster dragon = new Monster("dragon", "Ahshhhh", 6, 20, 7);

		tower.setOneLevel(0, slime, new Item("Ninja Suit"));
		tower.setOneLevel(1, nightBat, new Item("HP Potion"));
		tower.setOneLevel(2, ghost, new Item("Platinum Shield"));
		tower.setOneLevel(3, zombie, new Item("Thunder Hammer"));
		tower.setOneLevel(4, dragon, new Item("Treasure"));

		return tower;
	}
	
	
	//  used to test more methods 
	/**
     * 	Set up the tower attributes with some arbitrary monsters and items.
     * 
     * 	@return the item instance at the given tower level
     */
	public static Tower setUpTower2() {
		Tower tower2 = new Tower(2);

		Monster slime = new Monster("slime", "Zizizi", 20, 4, 2);
		Monster nightBat = new Monster("nightBat", "Urhnnnn", 2, 7, 5);

		tower2.setOneLevel(0, slime, new Item("Small Knife"));
		tower2.setOneLevel(1, nightBat, new Item("Big Sword"));
	
		return tower2;
	}

	//  used to test more methods 
	/**
     * 	Set up the tower attributes with some arbitrary monsters and items.
     * 
     * 	@return the item instance at the given tower level
     */
	public static Tower setUpTower3() {
		Tower tower3 = new Tower(1);

		Monster Sonic = new Monster("slime", "Zizizi", 11, 4, 3);

		tower3.setOneLevel(0, Sonic, new Item("Small Knife"));

		return tower3;
	}


	/**
     * 	A simulation of the game given the hero and the tower objects.
     * 
	 *  @param hero the hero object that plays the game
	 *  @param tower the tower object the the hero plays
	 * 	@return whether the hero beats all the monster and survived at the end
     */
	public static boolean playGame(Hero hero, Tower tower) {
		for(int i = 0; i < tower.getHeight(); i++) {

			// visit one level at the time
			Monster monster = tower.getMonsterAtLevel(i);

			// print out the stats of the hero and the monster
			System.out.printf(FORMAT, i, hero.getName(), monster.getName());
			System.out.println(monster.roar());
			System.out.println(monster.getStats());

			// start the fight
			while(true) {
				
				// hero attacks first if their speed is greater
				if(hero.getSpeed() > monster.getSpeed() ) {
					System.out.println(hero.attack(monster));
					// monster attacks if it is still alive
					if(monster.isStillAlive()) {
						System.out.println(monster.attack(hero));
						// if hero is still alive, they attack
						if(hero.isStillAlive()) {
							continue;
						} 
						// if the hero is dead
						else {
							System.out.println("Your hero died. Game Over!");
							return false;
						}
					} // if the monster is dead
					else {
						break;
					}
					// monster attacks first if its speed is greater
				} else {
					System.out.println(monster.attack(hero));
					// hero attacks if they are still alive
					if(hero.isStillAlive()) {
						System.out.println(hero.attack(monster));
						// if the monster is still alive, it attacks
						if(monster.isStillAlive()) {
							continue;
						} 
						// if the monster is dead
						else {
							break;
						}
					} //if the hero is dead
					else {
						System.out.println("Your hero died. Game Over!");
						return false;
					}
				}
			}

			// if the hero survived from the fight, grab the rewarding item
			// and equip it to gain stats.
			Item currItem = tower.getItemAtLevel(i);
			System.out.println(hero.equipItem(currItem));
		}

		// All monsters are beaten. 
		System.out.println("The hero Wins!");
		return true;
	}
}

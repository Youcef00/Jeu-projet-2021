package util.player;

public class Player {
	protected String name;
	
	protected int gold;
	protected int points;
	
	
	public Player(String name, int nbGold) {
		this.name = name;
		this.points = 0;
		this.gold = nbGold;
	}
	
	public String getName() {
		return name;
	}
	
	public int getGold() {
		return gold;
	}

	public void addGold(int nbGold) {
		gold += nbGold;
	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}
	
	

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Player)) {
			return false;
		} 
		else {
			Player other = (Player) o;
			return other.name == this.name && other.points == this.points;
		}
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", points=" + points + "]";
	}
	

}

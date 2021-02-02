package Personnage;

public class Player {
	protected String name;
	protected int points;
	
	
	public Player(String name) {
		this.name = name;
		this.points = 0;
	}
	
	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public void addPoints(int points) {
		this.points += points;
	}
	
	@Override
	public String toString() {
		return this.name;
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
	

}

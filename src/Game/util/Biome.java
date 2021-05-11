package Game.util;

public interface Biome {
	
	/**
	 * The resource getter method which returns the resource existing in the biome
	 * @return (Resource) the resource 
	 */
	public Resource resource();
	
	/**
	 * The method that return the score
	 * @return (int) the score
	 */
	public int score();
	
	@Override
	public String toString();
	
	@Override
	public boolean equals(Object o);
	
}

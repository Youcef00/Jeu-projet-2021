package Game.util;

/** Interface for Resource  */
public interface Resource {

	/**
	 * Gives loot of resource
	 * @return return loot of resource
	 */
	public int loot();

	@Override
	public boolean equals(Object o);

	@Override
	public String toString();
}

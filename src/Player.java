public enum Player
{
	Computer("X"), User("O"), Blank("");

	public final String text;

	private Player(String text)
	{
		this.text = text;
	}

	@Override

	public String toString()
	{
		return this.text;
	}

}
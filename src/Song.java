
public class Song {
	
	private final String title;
	private final String artist;
	private final int durationSeconds;
	private final int id;
	private static int idGenerator = 0;
	
	public Song(String title, String artist, int durationSeconds) {
		if (title == null || artist == null || durationSeconds <= 0) {
			throw new IllegalArgumentException("Invalid song parameters");
		}
		this.title = title;
		this.artist = artist;
		this.durationSeconds = durationSeconds;
		this.id = idGenerator++;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int getDuration() {
		return durationSeconds;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("%d: %s by %s (%d:%02d)",
				id, title, artist, durationSeconds / 60, durationSeconds % 60);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Song) {
			return this.id == ((Song) o).id;
		}
		return false;
	}
	
	public static void resetIdGenerator() {
		idGenerator = 0;
	}

}


public class SongNode {

	private Song song;
	private SongNode next;
	private SongNode prev;
	
	public SongNode(Song song) {
		if (song == null) {
			throw new IllegalArgumentException("Invalid songnode parameters");
		}
		this.song = song;
		this.next = null;
		this.prev = null;
	}
	
	public SongNode(Song song, SongNode prev, SongNode next) {
		if (song == null) {
			throw new IllegalArgumentException("Invalid songnode parameters");
		}
		this.song = song;
		this.next = next;
		this.prev = prev;
	}
	
	public Song getSong() {
		return song;
	}
	
	public SongNode getNext() {
		return next;
	}
	
	public SongNode getPrev() {
		return prev;
	}
	
	public void setNext(SongNode next) {
		this.next = next;
	}
	
	public void setPrev(SongNode prev) {
		this.prev = prev;
	}
	
}

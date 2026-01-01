
public class PlaylistManager {
	
	private SongNode head;
	private SongNode tail;
	private SongNode nowPlaying;
	private int size;
	private boolean repeatMode;
	
	public PlaylistManager() {
		head = null;
		tail = null;
		nowPlaying = null;
		size = 0;
		repeatMode = false;
	}
	
	public void addSong(Song song) {
		if (song == null) {
			throw new IllegalArgumentException("Invalid addsong parameters");
		}
		SongNode newSongNode = new SongNode(song);
		if (isEmpty()) {
			head = newSongNode;
			tail = newSongNode;
		} else {
			tail.setNext(newSongNode);
			newSongNode.setPrev(tail);
			tail = newSongNode;
		}
		size++;
	}
	
	public void addSongAt(int index, Song song) {
		if (song == null) {
			throw new IllegalArgumentException("Invalid addsongat song parameter");
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid addsongat index parameter");
		}
		SongNode newSongNode = new SongNode(song);
		if (isEmpty()) {
			head = newSongNode;
			tail = newSongNode;
		} else if (index == 0) {
			newSongNode.setNext(head);
			head.setPrev(newSongNode);
			head = newSongNode;
		} else if (index == size) {
			tail.setNext(newSongNode);
			newSongNode.setPrev(tail);
			tail = newSongNode;
		} else {
			SongNode current = head;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			SongNode prev = current.getPrev();
			newSongNode.setNext(current);
			newSongNode.setPrev(prev);
			prev.setNext(newSongNode);
			current.setPrev(newSongNode);
		}
		size++;
	}
	
	public Song removeSong(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid removesong parameters");
		}
		SongNode current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		if (current == head) {
			head = head.getNext();
			if (head != null) {
				head.setPrev(null);
			} else {
				tail = null;
			}
		} else if (current == tail) {
			tail = tail.getPrev();
			if (tail != null) {
				tail.setNext(null);
			} else {
				head = null;
			}
		} else {
			SongNode prevNode = current.getPrev();
			SongNode nextNode = current.getNext();
			prevNode.setNext(nextNode);
			nextNode.setPrev(prevNode);
		}
		if (current == nowPlaying) {
			nowPlaying = null;
		}
		size--;
		return current.getSong();
	}
	
	public Song play() {
		if (isEmpty()) {
			nowPlaying = null;
			return null;
		}
		nowPlaying = head;
		return head.getSong();
	}
	
	public Song playNext() {
		if (isEmpty() || nowPlaying == null) {
			return null;
		}
		if (nowPlaying.getNext() != null) {
			nowPlaying = nowPlaying.getNext();
			return nowPlaying.getSong();
		}
		if (repeatMode) {
			nowPlaying = head;
			return nowPlaying.getSong();
		} else {
			nowPlaying = null;
			return null;
		}
	}
	
	public Song playPrev() {
		if (isEmpty() || nowPlaying == null) {
			return null;
		}
		if (nowPlaying.getPrev() != null) {
			nowPlaying = nowPlaying.getPrev();
			return nowPlaying.getSong();
		}
		if (repeatMode) {
			nowPlaying = tail;
			return nowPlaying.getSong();
		} else {
			nowPlaying = null;
			return null;
		}
	}
	
	public Song getNowPlaying() {
		if (nowPlaying == null) {
			return null;
		}
		return nowPlaying.getSong();
	}
	
	protected SongNode getFirst() {
		return head;
	}
	
	protected SongNode getlast() {
		return tail;
	}
	
	public void clear() {
		head = null;
		tail = null;
		nowPlaying = null;
		size = 0;
		repeatMode = false;
	}
	
	@Override
	public String toString() {
		StringBuilder songString = new StringBuilder();
		songString.append("Playlist (").append(" songs:\n");
		SongNode current = head;
		int index = 1;
		while (current != null) {
			songString.append(index).append(". ").append(current.getSong().toString());
			if (current == nowPlaying) {
				songString.append(" <-- NOW PLAYING");
			}
			songString.append("\n");
			current = current.getNext();
			index++;
		}
		return songString.toString();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void setRepeatMode(boolean mode) {
		repeatMode = mode;
	}
	
	public boolean getRepeatMode() {
		return repeatMode;
	}

}

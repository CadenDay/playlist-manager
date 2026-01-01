# Playlist Manager

A doubly-linked list implementation for managing music playlists, developed for CS 300 at UW-Madison.

## Project Overview

This project implements a custom doubly-linked list data structure to manage a music playlist with bidirectional navigation. The implementation supports playlist operations like adding/removing songs, playback control (play, next, previous), and repeat mode functionality.

## Features

- **Doubly-Linked List Structure**: Custom implementation without using Java's built-in collections
- **Bidirectional Navigation**: Move forward and backward through the playlist
- **Playback Control**: Play, skip to next/previous song
- **Repeat Mode**: Optional circular playlist navigation
- **Efficient Operations**: O(1) access to both ends of the playlist

## Project Structure

- `Song.java` - Represents individual songs with title, artist, duration, and unique ID
- `SongNode.java` - Node class for the doubly-linked list structure
- `PlaylistManager.java` - Main playlist management class with list operations

## How to Run

### Prerequisites
- Java 8 or higher
- Eclipse IDE (or any Java IDE)

### Running the Project

1. Clone this repository:
```
   git clone https://github.com/CadenDay/playlist-manager.git
```

2. Open Eclipse and import the project:
   - File → Open Projects from File System
   - Select the cloned folder

3. Run the main class:
   - Right-click `Main.java`
   - Run As → Java Application

### Example Usage
```java
// Create a new playlist
PlaylistManager playlist = new PlaylistManager();

// Add songs
playlist.addSong(new Song("Bohemian Rhapsody", "Queen", 354));
playlist.addSong(new Song("Stairway to Heaven", "Led Zeppelin", 482));

// Start playback
Song current = playlist.play();  // Plays first song
current = playlist.playNext();   // Advances to next song

// Enable repeat mode
playlist.setRepeatMode(true);

// Print playlist
System.out.println(playlist.toString());
```

## Implementation Details

### Data Structure
- Custom doubly-linked list with head, tail, and nowPlaying pointers
- Each node maintains references to both previous and next nodes
- Supports O(1) insertion at both ends

### Key Operations
- `addSong(Song song)` - Adds song to end of playlist
- `addSongAt(int index, Song song)` - Inserts song at specific position
- `removeSong(int index)` - Removes and returns song at index
- `play()` - Starts playback from first song
- `playNext()` / `playPrevious()` - Navigate through playlist
- `clear()` - Removes all songs and resets state

### Error Handling
- Validates null inputs with `IllegalArgumentException`
- Validates index bounds with `IndexOutOfBoundsException`
- Defensive programming throughout

## Learning Outcomes

This project demonstrates:
- Implementation of complex data structures from scratch
- Pointer manipulation and memory management concepts
- Defensive programming and input validation
- Object-oriented design principles

## Course Information

- **Course:** COMP SCI 300 - Programming II
- **Institution:** University of Wisconsin-Madison
- **Semester:** Fall 2025

## Academic Integrity

This project was completed independently following UW-Madison's academic integrity policies. All code was written personally as part of coursework requirements.
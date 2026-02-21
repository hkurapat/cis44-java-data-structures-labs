// This is the Playlist class which manages a collection of songs by using a singly linked list
public class Playlist {
    
    // This is the Node class that represents each element in the linked list
    private static class Node {
        Song song;
        Node next;
        
        // This is the Constructor which creates a new node with a song
        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;
    
    // This is a Constructor that creates an empty playlist
    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }
    
    // This adds a song to the end of the playlist
    public void addSong(Song song) {
        Node newNode = new Node(song);
        
        // This new song becomes both head and tail if the playlist is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
            currentNode = newNode;
        } else {
          
            // link the new song to the end
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
        System.out.println("Added: " + song);
    }
    
    // This removes the first song with the given title of the song 
    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty, nothing to remove.");
            return;
        }
        
        // This checks if the song to remove is the head
        if (head.song.getTitle().equals(title)) {
            System.out.println("Removed: " + head.song);
            head = head.next;
            
            //This updates tail and currentNode if the list becomes empty
            if (head == null) {
                tail = null;
                currentNode = null;
            }
            
            size--;
            return;
        }
        
        // This searches for the song in the rest of the list
        Node current = head;
        while (current.next != null) {
            if (current.next.song.getTitle().equals(title)) {
                System.out.println("Removed: " + current.next.song);
                
                // This updates tail reference if removing the tail
                if (current.next == tail) {
                    tail = current;
                }
                
                // This removes the node by skipping it
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
        
        System.out.println("Song '" + title + "' not found in playlist.");
    }
    
    // This plays the current song and moves to the next one
    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        
        // This starts from the beginning if currentNode is null
        if (currentNode == null) {
            currentNode = head;
        }
        
        System.out.println("Now playing: " + currentNode.song);
        
        // This moves to next song. It also wraps around to head if at the end.
        currentNode = currentNode.next;
        if (currentNode == null) {
            currentNode = head;
            System.out.println("(Reached end of playlist, wrapping to start)");
        }
    }
    
    // This displays all songs in the playlist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        
        System.out.println("\n=== Current Playlist ===");
        Node current = head;
        int position = 1;
        
        while (current != null) {
            System.out.println(position + ". " + current.song);
            current = current.next;
            position++;
        }
        System.out.println("========================\n");
    }
}

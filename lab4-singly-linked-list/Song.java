// This Song class is used to store the information about each song
public class Song {
    String title;
    String artist;
    
    // This is the constructor which is used to create a new song
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    // This Gets the title of the song
    public String getTitle() {
        return title;
    }
    
    // This Gets the artist of the song
    public String getArtist() {
        return artist;
    }
    
    // This returns a string with the details of the song for displaying 
    @Override
    public String toString() {
        return "'" + title + "' by " + artist;
    }
}

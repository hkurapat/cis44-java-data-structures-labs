import java.util.Scanner;

// This is the main class and gives a menu to interact with the playlist
public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Playlist Manager!");
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Play Next");
            System.out.println("4. Display Playlist");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  //removes extra newline
    
            switch (choice) {
                case 1:
                    // This adds a new song
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;
                    
                case 2:
                    // This removes a song
                    System.out.print("Enter title of song to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    break;
                    
                case 3:
                    // This plays next song
                    playlist.playNext();
                    break;
                    
                case 4:
                    // This display all songs
                    playlist.displayPlaylist();
                    break;
                    
                case 5:
                    // This exits the program
                    System.out.println("Thanks for using Playlist Manager!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        
        scanner.close();
    }
}

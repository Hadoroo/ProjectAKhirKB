package KB.ProjectAKhirKB;

import java.util.ArrayList;
import java.util.Arrays;

public class Rekomendasi {
    public static void main(String[] args) {
        Database data = new Database();

        // Specify the genre you want to filter
        String desiredGenre = "Free to Play";

        // Print games with the specified genre
        printGamesByGenre(data, desiredGenre);
    }

    private static void printGamesByGenre(Database data, String genre) {
        System.out.println("Games with genre '" + genre + "':");

        for (Gamelist game : data.list) {
            if (containsGenre(game, genre)) {
                System.out.println(game);
            }
        }
    }

    private static boolean containsGenre(Gamelist game, String genre) {
        for (String tag : game.tags) {
            if (tag.equals(genre)) {
                return true;
            }
        }
        return false;
    }
}

class Gamelist{
    public String title;
    public String[] tags;
    
    public Gamelist(String title, String[]tags){
        this.title = title;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "title: " + title + "\ntags: " + Arrays.toString(tags) + "\n";
    }
}

class Database{
    ArrayList<Gamelist> list = new ArrayList<>();

    public Database(){
        list.add(new Gamelist("Counter-Strike 2", new String[]{"FPS", "Shooter", "Multiplayer", "Competitive", "Action"}));
        list.add(new Gamelist("Apex Legends", new String[]{"Free to Play", "Battle Royale", "Multiplayer", "Shooter", "FPS"}));
    }
    

    public Gamelist[] getGames() {
        return list.toArray(new Gamelist[0]);
    }
}

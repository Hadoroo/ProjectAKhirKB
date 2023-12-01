package KB.ProjectAKhirKB;

import java.util.ArrayList;

public class Rekomendasi {
    public static void main(String[] args) {
        System.out.println("a");
    }
}

class Gamelist{
    public String title;
    public String[] genre;
    public double rating;
    
    public Gamelist(String title, String[]genre, double rating){
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }
}

class Database{
    ArrayList<Gamelist> list = new ArrayList<>();

    public void addGame(Gamelist game) {
        list.add(game);
    }

    public Gamelist[] getGames() {
        return list.toArray(new Gamelist[0]);
    }
}




public class Gamelist {
    public String title;
    public String[] tags;

    public Gamelist(String title, String[] tags) {
        this.title = title;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return title + " (" + String.join(", ", tags) + ")";
    }
}

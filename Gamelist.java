package KB.ProjectAKhirKB;

import java.util.Arrays;

public class Gamelist {
    public String title;
    public String[] tags;

    public Gamelist(String title, String[] tags) {
        this.title = title;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nTags: " + Arrays.toString(tags) + "\n";
    }
}

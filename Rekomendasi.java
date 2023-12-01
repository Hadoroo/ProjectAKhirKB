package KB.ProjectAKhirKB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Rekomendasi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Database data = new Database();

        System.out.println("Select your desired game tags:");
        System.out.println("1. Action/Adventure");
        System.out.println("2. Open World");
        System.out.println("3. Indie");
        System.out.println("4. Story Driven");
        System.out.println("5. FPS");
        System.out.println("6. Survival");
        System.out.println("7. RPG");
        System.out.println("8. Horror");
        System.out.println("9. Co-op");
        System.out.println("10. Platformer");

        System.out.print("Enter your choices : ");

        String choice = sc.nextLine();

        String[] splitted = choice.split("[ ,.]+");

        Set<String> tagSet = new HashSet<>();

        for (String s : splitted) {
            switch (s) {
                case "1":
                    tagSet.add("Action/Adventure");
                    break;

                case "2":
                    tagSet.add("Open World");
                    break;

                case "3":
                    tagSet.add("Indie");
                    break;

                case "4":
                    tagSet.add("Story Driven");
                    break;

                case "5":
                    tagSet.add("FPS");
                    break;

                case "6":
                    tagSet.add("Survival");
                    break;

                case "7":
                    tagSet.add("RPG");
                    break;

                case "8":
                    tagSet.add("Horror");
                    break;

                case "9":
                    tagSet.add("Co-op");
                    break;

                case "10":
                    tagSet.add("Platformer");
                    break;
            }
        }

        String[] tags = tagSet.toArray(new String[0]);

        System.out.println(Arrays.toString(tags));
        System.out.println();

        printGameByTags(data, tags, 10);

        printGameByMostPlayer(data);
    }

    private static void printGameByTags(Database data, String[] tags, int limit) {
        System.out.println("Games with tags " + Arrays.toString(tags) + ":");
    
        int count = 0;
    
        for (Gamelist game : data.list) {
            if (containstags(game, tags)) {
                System.out.println(game);
                count++;
    
                if (count == limit) {
                    break;  // Stop printing after reaching the limit
                }
            }
        }
        System.out.println();
    }

    private static void printGameByMostPlayer(Database data) {
    HashMap<String, Integer> popular = new HashMap<>();

    for (List<Gamelist> userGames : data.userList) {
        for (Gamelist game : userGames) {
            String title = game.title;

            popular.put(title, popular.getOrDefault(title, 0) + 1);
        }
    }
    
    List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(popular.entrySet());
    sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

    String[] top3Games = new String[3];
    int index = 0;

    for (Map.Entry<String, Integer> entry : sortedList) {
        if (index < 3) {
            top3Games[index++] = entry.getKey();
        } else {
            break;
        }
    }


    System.out.println("Popuar Among Users:");
    popularGames(data, top3Games, 3);
    }

    private static void popularGames(Database data, String[] title, int limit) {
    
        int count = 0;
    
        for (Gamelist game : data.list) {
            if (containstitle(game, title)) {
                System.out.println(game);
                count++;
    
                if (count == limit) {
                    break;  // Stop printing after reaching the limit
                }
            }
        }
    }

    private static boolean containstags(Gamelist game, String[] tags) {
        for (String tag : tags) {
            if (Arrays.asList(game.tags).contains(tag)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containstitle(Gamelist game, String[] title) {
        for (String titles : title) {
            if (Arrays.asList(game.title).contains(titles)) {
                return true;
            }
        }
        return false;
    }
}


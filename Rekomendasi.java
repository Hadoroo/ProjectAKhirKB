package KB.ProjectAKhirKB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Rekomendasi {

    static String choice;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
            Database data = new Database();
            System.out.println("Welcome. Before You Proceed, Please Select Your Favourite Tags");
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

            choice = sc.nextLine();

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
                    
                    case "exit":
                        System.exit(0);
                    
                    default:
                        tagSet.add(s);
                }
            }

            for (String string : tagSet) {
                data.userTags.put(string, data.userTags.getOrDefault(string, 0) + 1);
            }

            // System.out.println(data.userTags);

            String[] tags = tagSet.toArray(new String[0]);

            // System.out.println(Arrays.toString(tags));
            System.out.println();

            printGameByTags(data, tags, 20);
            printGameByMostPlayer(data);

            addGames(data);

            

        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Your Library");
            System.out.println("2. Recomended Games");
            System.out.println("3. Search By Tags");
            System.out.println("4. Browse All Games");
            System.out.println("exit");
            System.out.print("Enter your choices : ");
            choice = sc.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    System.out.println("Library");
                    int count = 1;
                    for (Gamelist game : data.user) {
                        if (containstags(game, tags)) {
                            System.out.println(count + ". " + game);
                            count++;
                        }
                    }
                    System.out.println();
                    break;

                case "2":
                    recomendedGames(data);
                    break;

                case "3":
                    printAllTags(data);
                    addGames(data);
                    break;

                case "4":
                    System.out.println("Game List");
                    for (Gamelist game : data.list) {
                        System.out.println(game.toString());
                    }
                    printGameByMostPlayer(data);
                    addGames(data);
                    break;

                case "exit":
                    System.exit(0);
            
                default:
                    break;
            }
        }
        
    }

    private static void printAllTags(Database data){
        int count = 1;
        for (Map.Entry<String, Integer> tag : data.tags.entrySet()) {
            System.out.println(count + ". " + tag.getKey());
            count++;
        }

        System.out.print("Enter Your Choice (separate numbers with spaces): ");
        choice = sc.nextLine();
        System.out.println();

        String[] choiceNumbers = choice.split("[ ,.]+");

        Set<String> tagSet = new HashSet<>();
        for (String number : choiceNumbers) {
            try {
                int index = Integer.parseInt(number) - 1;
                if (index >= 0 && index < data.tags.size()) {
                    String selectedTag = (String) data.tags.keySet().toArray()[index];
                    tagSet.add(selectedTag);
                } else {
                    System.out.println("Invalid choice: " + number);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + number);
            }
        }

        for (String string : tagSet) {
                data.userTags.put(string, data.userTags.getOrDefault(string, 0) + 1);
        }
        String[] tags = tagSet.toArray(new String[0]);
        printGameByTags(data, tags);
        printGameByMostPlayer(data);
    }

    private static void recomendedGames(Database data){
        TreeMap<Integer, List<String>> tagCounts = new TreeMap<>(Collections.reverseOrder());
    
        for (Map.Entry<String, Integer> entry : data.userTags.entrySet()) {
            String tag = entry.getKey();
            int count = entry.getValue();

            tagCounts.computeIfAbsent(count, k -> new ArrayList<>()).add(tag);
        }

        String[] topTag = new String[3];
        int count = 0;
        for (Map.Entry<Integer, List<String>> entry : tagCounts.entrySet()) {
            List<String> tags = entry.getValue();

            for (String tag : tags) {
                topTag[count] = tag;
                count++;

                if (count == 3) {
                    break;
                }
            }
        }
        
        System.out.println("Because You Play Games Tagged With " + String.join(", ", topTag) + ":");
    
        for (Gamelist game : data.list) {
            if (containstags(game, topTag)) {
                System.out.println(game);
            }
        }
        System.out.println();
        printGameByMostPlayer(data);
        addGames(data);
    }

    private static void addGames(Database data){
        System.out.print("Select A Game To Add To Your Library: ");
            choice = sc.nextLine();
            String[]gameTag = {};
            for (Gamelist game : data.list) {
                if(game.title.contains(choice)){
                    gameTag = game.tags;
                    choice = game.title;
                    break;
                }    
            }

            System.out.print(choice + " Successfully Added To Your Library");
            System.out.println();

            data.user.add(new Gamelist(choice, gameTag));
            for (String string : gameTag) {
                data.userTags.put(string, data.userTags.getOrDefault(string, 0) + 1);
            }
            // System.out.println(data.user.toString());
            // System.out.println(data.userTags);
            System.out.println();
    }

    private static void printGameByTags(Database data, String[] tags, int limit) {
        System.out.println("Games with tags " + String.join(", ", tags) + ":");
    
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

     private static void printGameByTags(Database data, String[] tags) {
        System.out.println("Games with tags " + String.join(", ", tags) + ":");

        for (Gamelist game : data.list) {
            if (containstags(game, tags)) {
                System.out.println(game);
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
        System.out.println();
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
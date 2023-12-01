package KB.ProjectAKhirKB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

        String[] splitted = choice.split(" ");

        String[] tags = new String[splitted.length];

        for (int i = 0; i < splitted.length; i++) {
            switch (splitted[i]) {
                case "1":
                    tags[i] = "Action/Adventure";
                    break;

                case "2":
                    tags[i] = "Open World";
                    break;

                case "3":
                    tags[i] = "Indie";
                    break;

                case "4":
                    tags[i] = "Story Driven";
                    break;

                case "5":
                    tags[i] = "FPS";
                    break;

                case "6":
                    tags[i] = "Survival";
                    break;

                case "7":
                    tags[i] = "RPG";
                    break;

                case "8":
                    tags[i] = "Horror";
                    break;

                case "9":
                    tags[i] = "Co-op";
                    break;

                case "10":
                    tags[i] = "Platformer";
                    break;
            }
        }

        System.out.println(Arrays.toString(tags));
        System.out.println();

        printGameByTags(data, tags);
    }

    private static void printGameByTags(Database data, String[] tags) {
        System.out.println("Games with tags " + Arrays.toString(tags) + ":");

        for (Gamelist game : data.list) {
            if (containstags(game, tags)) {
                System.out.println(game);
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
}

class Gamelist {
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

class Database {
    ArrayList<Gamelist> list = new ArrayList<>();


    public Database(){
        list.add(new Gamelist("A Hat in Time", new String[]{"Platformer", "Indie", "Cute"}));
        list.add(new Gamelist("A Plague Tale: Innocence", new String[]{"Action/Adventure", "Story-Driven", "Stealth"}));
        list.add(new Gamelist("A Short Hike", new String[]{"Adventure", "Indie", "Relaxing"}));
        list.add(new Gamelist("A Way Out", new String[]{"Action/Adventure", "Co-op", "Story-Driven"}));
        list.add(new Gamelist("Alan Wake", new String[]{"Action/Adventure", "Horror", "Story-Driven"}));
        list.add(new Gamelist("Alien: Isolation", new String[]{"Horror", "Survival", "Atmospheric"}));
        list.add(new Gamelist("Amnesia: The Dark Descent", new String[]{"Horror", "Survival", "Atmospheric"}));
        list.add(new Gamelist("Animal Crossing: New Horizons", new String[]{"Life Simulation", "Social Simulation", "Relaxing"}));
        list.add(new Gamelist("Apex Legends", new String[]{"FPS", "Battle Royale", "Team-Based"}));
        list.add(new Gamelist("ARK: Survival Evolved", new String[]{"Open World", "Survival", "Crafting"}));
        list.add(new Gamelist("Astroneer", new String[]{"Survival", "Space", "Sandbox"}));
        list.add(new Gamelist("Assassin's Creed: Odyssey", new String[]{"Action/Adventure", "Open World", "Historical"}));
        list.add(new Gamelist("Assassin's Creed Valhalla", new String[]{"Action/Adventure", "Open World", "Historical"}));
        list.add(new Gamelist("Axiom Verge", new String[]{"Metroidvania", "Indie", "Pixel Art"}));
        list.add(new Gamelist("Azur Lane: Crosswave", new String[]{"Action", "RPG", "Anime"}));
        list.add(new Gamelist("Baba Is You", new String[]{"Puzzle", "Indie", "Creative"}));
        list.add(new Gamelist("Batman: Arkham City", new String[]{"Action/Adventure", "Open World", "Superhero"}));
        list.add(new Gamelist("Battlefield V", new String[]{"FPS", "Multiplayer", "War"}));
        list.add(new Gamelist("Braid", new String[]{"Puzzle", "Indie", "Time Manipulation"}));
        list.add(new Gamelist("Breath of the Wild", new String[]{"Action/Adventure", "Open World", "Exploration"}));
        list.add(new Gamelist("Brothers: A Tale of Two Sons", new String[]{"Adventure", "Indie", "Emotional"}));
        list.add(new Gamelist("Bulletstorm", new String[]{"FPS", "Action", "Sci-Fi"}));
        list.add(new Gamelist("Burnout Paradise Remastered", new String[]{"Racing", "Open World", "Arcade"}));
        list.add(new Gamelist("Celeste", new String[]{"Platformer", "Indie", "Pixel Art"}));
        list.add(new Gamelist("Cities: Skylines", new String[]{"Simulation", "City Building", "Management"}));
        list.add(new Gamelist("CivCity: Rome", new String[]{"City Building", "Simulation", "Historical"}));
        list.add(new Gamelist("Civilization VI", new String[]{"Strategy", "Turn-Based", "Historical"}));
        list.add(new Gamelist("Control", new String[]{"Action/Adventure", "Third-Person Shooter", "Supernatural"}));
        list.add(new Gamelist("Counter-Strike: Global Offensive", new String[]{"FPS", "Multiplayer", "Competitive"}));
        list.add(new Gamelist("Cuphead", new String[]{"Run and Gun", "Indie", "Difficult"}));
        list.add(new Gamelist("Dark Souls III", new String[]{"Action RPG", "Difficult", "Fantasy"}));
        list.add(new Gamelist("Days Gone", new String[]{"Action/Adventure", "Open World", "Zombie"}));
        list.add(new Gamelist("Dead by Daylight", new String[]{"Horror", "Asymmetrical Multiplayer", "Survival"}));
        list.add(new Gamelist("Dead Cells", new String[]{"Roguelike", "Metroidvania", "Action"}));
        list.add(new Gamelist("Death Stranding", new String[]{"Action/Adventure", "Open World", "Sci-Fi"}));
        list.add(new Gamelist("Destiny 2", new String[]{"FPS", "Action RPG", "Sci-Fi"}));
        list.add(new Gamelist("Devil May Cry 5", new String[]{"Action", "Hack and Slash", "Stylish"}));
        list.add(new Gamelist("Diablo III", new String[]{"Action RPG", "Hack and Slash", "Dungeon Crawler"}));
        list.add(new Gamelist("Disco Elysium", new String[]{"RPG", "Detective", "Story-Driven"}));
        list.add(new Gamelist("Dishonored 2", new String[]{"Stealth", "Action/Adventure", "Assassin"}));
        list.add(new Gamelist("Divinity: Original Sin 2", new String[]{"RPG", "Turn-Based", "Fantasy"}));
        list.add(new Gamelist("Doom Eternal", new String[]{"FPS", "Action", "Demons"}));
        list.add(new Gamelist("Dragon Age: Inquisition", new String[]{"RPG", "Action/Adventure", "Fantasy"}));
        list.add(new Gamelist("Dying Light", new String[]{"FPS", "Open World", "Zombies"}));
        list.add(new Gamelist("Dynasty Warriors 8: Xtreme Legends", new String[]{"Action", "Hack and Slash", "Historical"}));
        list.add(new Gamelist("Elite Dangerous", new String[]{"Space", "Simulation", "Open World"}));
        list.add(new Gamelist("Escape from Tarkov", new String[]{"FPS", "Survival", "Multiplayer"}));
        list.add(new Gamelist("Euro Truck Simulator 2", new String[]{"Simulation", "Driving", "Open World"}));
        list.add(new Gamelist("F.E.A.R.", new String[]{"FPS", "Horror", "Action"}));
        list.add(new Gamelist("Fallout 4", new String[]{"RPG", "Open World", "Post-Apocalyptic"}));
        list.add(new Gamelist("Far Cry 5", new String[]{"FPS", "Open World", "Action/Adventure"}));
        list.add(new Gamelist("Far Cry New Dawn", new String[]{"FPS", "Open World", "Action/Adventure"}));
        list.add(new Gamelist("Firewatch", new String[]{"Adventure", "Story-Driven", "Mystery"}));
        list.add(new Gamelist("Five Nights at Freddy's", new String[]{"Horror", "Survival", "Indie"}));
        list.add(new Gamelist("For Honor", new String[]{"Action", "Multiplayer", "Combat"}));
        list.add(new Gamelist("Fortnite", new String[]{"Battle Royale", "Third-Person Shooter", "Building"}));
        list.add(new Gamelist("Frostpunk", new String[]{"City Building", "Survival", "Steampunk"}));
        list.add(new Gamelist("Garry's Mod", new String[]{"Sandbox", "Physics", "Multiplayer"}));
        list.add(new Gamelist("Gears 5", new String[]{"Third-Person Shooter", "Action", "Sci-Fi"}));
        list.add(new Gamelist("Genshin Impact", new String[]{"Action RPG", "Open World", "Anime"}));
        list.add(new Gamelist("Ghost of Tsushima", new String[]{"Action/Adventure", "Open World", "Samurai"}));
        list.add(new Gamelist("Ghost Recon Wildlands", new String[]{"Open World", "Tactical", "Shooter"}));
        list.add(new Gamelist("Ghost Recon Breakpoint", new String[]{"Open World", "Tactical", "Shooter"}));
        list.add(new Gamelist("Ghost of Tsushima", new String[]{"Action/Adventure", "Open World", "Samurai"}));
        list.add(new Gamelist("God of War", new String[]{"Action/Adventure", "Hack and Slash", "Mythology"}));
        list.add(new Gamelist("Golf With Your Friends", new String[]{"Sports", "Multiplayer", "Mini Golf"}));
        list.add(new Gamelist("Grand Theft Auto V", new String[]{"Action/Adventure", "Open World", "Crime"}));
        list.add(new Gamelist("Graveyard Keeper", new String[]{"Simulation", "Indie", "Dark Comedy"}));
        list.add(new Gamelist("Gris", new String[]{"Platformer", "Indie", "Emotional"}));
        list.add(new Gamelist("Hades", new String[]{"Roguelike", "Action RPG", "Greek Mythology"}));
        list.add(new Gamelist("Halo: Master Chief Collection", new String[]{"FPS", "Sci-Fi", "Multiplayer"}));
        list.add(new Gamelist("Heat Signature", new String[]{"Action", "Indie", "Space"}));
        list.add(new Gamelist("Hellblade: Senua's Sacrifice", new String[]{"Action/Adventure", "Story-Driven", "Psychological Horror"}));
        list.add(new Gamelist("Her Story", new String[]{"Interactive Movie", "Mystery", "Detective"}));
        list.add(new Gamelist("Heroes of the Storm", new String[]{"MOBA", "Multiplayer", "Blizzard"}));
        list.add(new Gamelist("HOLLOW", new String[]{"Horror", "Atmospheric", "Indie"}));
        list.add(new Gamelist("Hollow Knight", new String[]{"Metroidvania", "Indie", "Atmospheric"}));
        list.add(new Gamelist("Hotline Miami", new String[]{"Action", "Indie", "Top-Down"}));
        list.add(new Gamelist("Hyper Light Drifter", new String[]{"Action RPG", "Indie", "Pixel Art"}));
        list.add(new Gamelist("Hyper Scape", new String[]{"FPS", "Battle Royale", "Cyberpunk"}));
        list.add(new Gamelist("I Am Bread", new String[]{"Simulation", "Indie", "Comedy"}));
        list.add(new Gamelist("Ibb & Obb", new String[]{"Puzzle", "Co-op", "Indie"}));
        list.add(new Gamelist("Iconoclasts", new String[]{"Action", "Platformer", "Indie"}));
        list.add(new Gamelist("INSIDE", new String[]{"Puzzle", "Platformer", "Atmospheric"}));
        list.add(new Gamelist("Into the Breach", new String[]{"Strategy", "Turn-Based", "Indie"}));
        list.add(new Gamelist("Journey", new String[]{"Adventure", "Indie", "Artistic"}));
        list.add(new Gamelist("Katana ZERO", new String[]{"Action", "Indie", "Pixel Art"}));
        list.add(new Gamelist("Kerbal Space Program", new String[]{"Simulation", "Space", "Sandbox"}));
        list.add(new Gamelist("Kentucky Route Zero", new String[]{"Adventure", "Story-Driven", "Surreal"}));
        list.add(new Gamelist("Kingdom Come: Deliverance", new String[]{"Action RPG", "Open World", "Historical"}));
        list.add(new Gamelist("Kingdom Hearts III", new String[]{"Action RPG", "Disney", "Fantasy"}));
        list.add(new Gamelist("Knights and Bikes", new String[]{"Adventure", "Indie", "Co-op"}));
        list.add(new Gamelist("Knuckle Sandwich", new String[]{"RPG", "Indie", "Surreal"}));
        list.add(new Gamelist("Kona", new String[]{"Adventure", "Mystery", "Atmospheric"}));
        list.add(new Gamelist("L.A. Noire", new String[]{"Action/Adventure", "Detective", "Open World"}));
        list.add(new Gamelist("Lakeview Cabin Collection", new String[]{"Horror", "Indie", "Pixel Graphics"}));
        list.add(new Gamelist("Last of Us Part II", new String[]{"Action/Adventure", "Story-Driven", "Post-Apocalyptic"}));
        list.add(new Gamelist("Layers of Fear", new String[]{"Horror", "Psychological", "Atmospheric"}));
        list.add(new Gamelist("Left 4 Dead 2", new String[]{"FPS", "Horror", "Co-op"}));
        list.add(new Gamelist("Legend of Grimrock 2", new String[]{"RPG", "Dungeon Crawler", "Indie"}));
        list.add(new Gamelist("LEGO Star Wars: The Skywalker Saga", new String[]{"Action/Adventure", "LEGO", "Star Wars"}));
        list.add(new Gamelist("Life is Strange", new String[]{"Adventure", "Story-Driven", "Choices Matter"}));
        list.add(new Gamelist("Limbo", new String[]{"Puzzle-Platformer", "Indie", "Atmospheric"}));
        list.add(new Gamelist("Little Nightmares", new String[]{"Horror", "Puzzle-Platformer", "Atmospheric"}));
        list.add(new Gamelist("LittleBigPlanet 3", new String[]{"Platformer", "Puzzle", "Creative"}));
        list.add(new Gamelist("Loop Hero", new String[]{"Roguelike", "Strategy", "Pixel Art"}));
        list.add(new Gamelist("Mad Max", new String[]{"Action/Adventure", "Open World", "Post-Apocalyptic"}));
        list.add(new Gamelist("Mafia III", new String[]{"Action/Adventure", "Open World", "Crime"}));
        list.add(new Gamelist("Manifold Garden", new String[]{"Puzzle", "Exploration", "Escher-like"}));
        list.add(new Gamelist("Mass Effect 2", new String[]{"RPG", "Action/Adventure", "Space"}));
        list.add(new Gamelist("Metal Gear Solid V: The Phantom Pain", new String[]{"Action/Adventure", "Open World", "Stealth"}));
        list.add(new Gamelist("Metro Exodus", new String[]{"FPS", "Survival", "Atmospheric"}));
        list.add(new Gamelist("Middle-earth: Shadow of War", new String[]{"Action/Adventure", "Open World", "Fantasy"}));
        list.add(new Gamelist("Minecraft", new String[]{"Sandbox", "Building", "Survival"}));
        list.add(new Gamelist("Mirror's Edge Catalyst", new String[]{"Action/Adventure", "Parkour", "First-Person"}));
        list.add(new Gamelist("Monster Hunter: World", new String[]{"Action RPG", "Co-op", "Fantasy"}));
        list.add(new Gamelist("Moonlighter", new String[]{"Action RPG", "Indie", "Dungeon Crawler"}));
        list.add(new Gamelist("Mortal Kombat 11", new String[]{"Fighting", "Multiplayer", "Gore"}));
        list.add(new Gamelist("Mount & Blade II: Bannerlord", new String[]{"Action RPG", "Strategy", "Medieval"}));
        list.add(new Gamelist("My Time at Portia", new String[]{"Simulation", "RPG", "Crafting"}));
        list.add(new Gamelist("Nier: Automata", new String[]{"Action RPG", "Story-Driven", "Sci-Fi"}));
        list.add(new Gamelist("Night in the Woods", new String[]{"Adventure", "Indie", "Story-Driven"}));
        list.add(new Gamelist("No Man's Sky", new String[]{"Open World", "Exploration", "Space"}));
        list.add(new Gamelist("Obduction", new String[]{"Adventure", "Puzzle", "Myst-like"}));
        list.add(new Gamelist("Octopath Traveler", new String[]{"RPG", "Turn-Based", "Pixel Art"}));
        list.add(new Gamelist("Okami HD", new String[]{"Action/Adventure", "Fantasy", "Artistic"}));
        list.add(new Gamelist("Ori and the Will of the Wisps", new String[]{"Platformer", "Metroidvania", "Beautiful"}));
        list.add(new Gamelist("Outer Wilds", new String[]{"Exploration", "Puzzle", "Mystery"}));
        list.add(new Gamelist("Outlast", new String[]{"Horror", "Survival", "First-Person"}));
        list.add(new Gamelist("Overcooked! 2", new String[]{"Co-op", "Multiplayer", "Cooking"}));
        list.add(new Gamelist("Overwatch", new String[]{"FPS", "Team-Based", "Multiplayer"}));
        list.add(new Gamelist("Oxenfree", new String[]{"Adventure", "Indie", "Supernatural"}));
        list.add(new Gamelist("Papers, Please", new String[]{"Simulation", "Puzzle", "Dystopian"}));
        list.add(new Gamelist("Path of Exile", new String[]{"Action RPG", "Hack and Slash", "Online"}));
        list.add(new Gamelist("Persona 5", new String[]{"RPG", "Turn-Based", "Story-Driven"}));
        list.add(new Gamelist("Phoenix Wright: Ace Attorney Trilogy", new String[]{"Visual Novel", "Mystery", "Courtroom Drama"}));
        list.add(new Gamelist("Phasmophobia", new String[]{"Horror", "Co-op", "Ghost Hunting"}));
        list.add(new Gamelist("Pillars of Eternity II: Deadfire", new String[]{"RPG", "Isometric", "Fantasy"}));
        list.add(new Gamelist("Planescape: Torment: Enhanced Edition", new String[]{"RPG", "Story-Driven", "Isometric"}));
        list.add(new Gamelist("Planet Zoo", new String[]{"Simulation", "Building", "Animals"}));
        list.add(new Gamelist("Portal 2", new String[]{"Puzzle", "Co-op", "First-Person"}));
        list.add(new Gamelist("Prey", new String[]{"FPS", "Action/Adventure", "Sci-Fi"}));
        list.add(new Gamelist("Psychonauts 2", new String[]{"Action/Adventure", "Platformer", "Comedy"}));
        list.add(new Gamelist("Pyre", new String[]{"Action RPG", "Sports", "Fantasy"}));
        list.add(new Gamelist("Quantum Break", new String[]{"Action/Adventure", "Time Travel", "Story-Driven"}));
        list.add(new Gamelist("Raft", new String[]{"Survival", "Open World", "Crafting"}));
        list.add(new Gamelist("Rain World", new String[]{"Platformer", "Survival", "Atmospheric"}));
        list.add(new Gamelist("Red Dead Redemption 2", new String[]{"Action/Adventure", "Open World", "Western"}));
        list.add(new Gamelist("Remnant: From the Ashes", new String[]{"Third-Person Shooter", "Action RPG", "Co-op"}));
        list.add(new Gamelist("Resident Evil 7: Biohazard", new String[]{"Horror", "Survival", "First-Person"}));
        list.add(new Gamelist("Return of the Obra Dinn", new String[]{"Puzzle", "Mystery", "Detective"}));
        list.add(new Gamelist("RimWorld", new String[]{"Simulation", "Strategy", "Colony Management"}));
        list.add(new Gamelist("Risk of Rain 2", new String[]{"Third-Person Shooter", "Roguelike", "Co-op"}));
        list.add(new Gamelist("Rocket League", new String[]{"Sports", "Racing", "Multiplayer"}));
        list.add(new Gamelist("Rust", new String[]{"Survival", "Open World", "Multiplayer"}));
        list.add(new Gamelist("Satisfactory", new String[]{"Simulation", "Building", "Open World"}));
        list.add(new Gamelist("Sea of Thieves", new String[]{"Action/Adventure", "Multiplayer", "Pirates"}));
        list.add(new Gamelist("Sekiro: Shadows Die Twice", new String[]{"Action/Adventure", "Soulslike", "Samurai"}));
        list.add(new Gamelist("Shadow of the Colossus", new String[]{"Action/Adventure", "Open World", "Atmospheric"}));
        list.add(new Gamelist("Shadow Tactics: Blades of the Shogun", new String[]{"Strategy", "Stealth", "Isometric"}));
        list.add(new Gamelist("Shovel Knight", new String[]{"Platformer", "Indie", "Retro"}));
        list.add(new Gamelist("Sid Meier's Civilization VI", new String[]{"Strategy", "Turn-Based", "Historical"}));
        list.add(new Gamelist("Slay the Spire", new String[]{"Deck-Building", "Roguelike", "Strategy"}));
        list.add(new Gamelist("Sleeping Dogs", new String[]{"Action/Adventure", "Open World", "Crime"}));
        list.add(new Gamelist("Slime Rancher", new String[]{"Simulation", "Exploration", "Cute"}));
        list.add(new Gamelist("Sonic Mania", new String[]{"Platformer", "Indie", "Retro"}));
        list.add(new Gamelist("Spelunky 2", new String[]{"Roguelike", "Platformer", "Adventure"}));
        list.add(new Gamelist("Spiritfarer", new String[]{"Adventure", "Indie", "Emotional"}));
        list.add(new Gamelist("Spore", new String[]{"Simulation", "Evolution", "Strategy"}));
        list.add(new Gamelist("Star Wars Jedi: Fallen Order", new String[]{"Action/Adventure", "Third-Person", "Star Wars"}));
        list.add(new Gamelist("Starbound", new String[]{"Sandbox", "Adventure", "Exploration"}));
        list.add(new Gamelist("Stardew Valley", new String[]{"Simulation", "Farming", "Indie"}));
        list.add(new Gamelist("StarCraft II", new String[]{"Strategy", "RTS", "Sci-Fi"}));
        list.add(new Gamelist("SteamWorld Dig 2", new String[]{"Action/Adventure", "Indie", "Metroidvania"}));
        list.add(new Gamelist("Stellaris", new String[]{"Strategy", "Space", "Grand Strategy"}));
        list.add(new Gamelist("Streets of Rage 4", new String[]{"Beat 'em up", "Multiplayer", "Co-op"}));
        list.add(new Gamelist("Subnautica", new String[]{"Survival", "Exploration", "Adventure"}));
        list.add(new Gamelist("Subnautica: Below Zero", new String[]{"Survival", "Exploration", "Adventure"}));
        list.add(new Gamelist("Super Mario Odyssey", new String[]{"Action/Adventure", "Platformer", "Family"}));
        list.add(new Gamelist("Super Meat Boy", new String[]{"Platformer", "Difficult", "Indie"}));
        list.add(new Gamelist("Super Smash Bros. Ultimate", new String[]{"Fighting", "Multiplayer", "Party"}));
        list.add(new Gamelist("Surviving Mars", new String[]{"Simulation", "Strategy", "Space"}));
        list.add(new Gamelist("Tacoma", new String[]{"Adventure", "Story-Driven", "Sci-Fi"}));
        list.add(new Gamelist("Terraria", new String[]{"Sandbox", "Adventure", "Crafting"}));
        list.add(new Gamelist("The Banner Saga", new String[]{"RPG", "Turn-Based", "Story-Driven"}));
        list.add(new Gamelist("The Binding of Isaac: Rebirth", new String[]{"Roguelike", "Indie", "Dungeon Crawler"}));
        list.add(new Gamelist("The Elder Scrolls V: Skyrim", new String[]{"Action RPG", "Open World", "Fantasy"}));
        list.add(new Gamelist("The Forest", new String[]{"Survival", "Horror", "Open World"}));
        list.add(new Gamelist("The Last of Us Part II", new String[]{"Action/Adventure", "Story-Driven", "Post-Apocalyptic"}));
        list.add(new Gamelist("The Legend of Zelda: Breath of the Wild", new String[]{"Action/Adventure", "Open World", "Exploration"}));
        list.add(new Gamelist("The Outer Worlds", new String[]{"Action RPG", "Sci-Fi", "Story-Driven"}));
        list.add(new Gamelist("The Sims 4", new String[]{"Simulation", "Life Simulation", "Building"}));
        list.add(new Gamelist("The Stanley Parable", new String[]{"Narrative", "Indie", "Comedy"}));
        list.add(new Gamelist("The Witness", new String[]{"Puzzle", "Open World", "Exploration"}));
        list.add(new Gamelist("Thimbleweed Park", new String[]{"Adventure", "Indie", "Point and Click"}));
        list.add(new Gamelist("This War of Mine", new String[]{"Simulation", "Survival", "War"}));
        list.add(new Gamelist("Tom Clancy's The Division 2", new String[]{"Action/Adventure", "Open World", "Multiplayer"}));
        list.add(new Gamelist("Torchlight II", new String[]{"Action RPG", "Hack and Slash", "Co-op"}));
        list.add(new Gamelist("Total War: Three Kingdoms", new String[]{"Strategy", "Historical", "RTS"}));
        list.add(new Gamelist("Undertale", new String[]{"RPG", "Indie", "Story-Driven"}));
        list.add(new Gamelist("Uncharted 4: A Thief's End", new String[]{"Action/Adventure", "Third-Person Shooter", "Story-Driven"}));
        list.add(new Gamelist("Uncharted: The Lost Legacy", new String[]{"Action/Adventure", "Third-Person Shooter", "Story-Driven"}));
        list.add(new Gamelist("Untitled Goose Game", new String[]{"Indie", "Puzzle", "Funny"}));
        list.add(new Gamelist("Vampire: The Masquerade - Bloodlines 2", new String[]{"RPG", "Vampire", "Story-Driven"}));
        list.add(new Gamelist("Vampyr", new String[]{"Action RPG", "Vampire", "Story-Driven"}));
        list.add(new Gamelist("Valorant", new String[]{"FPS", "Tactical", "Multiplayer"}));
        list.add(new Gamelist("Vanquish", new String[]{"Third-Person Shooter", "Action", "Sci-Fi"}));
        list.add(new Gamelist("Virginia", new String[]{"Adventure", "Mystery", "Interactive Drama"}));
        list.add(new Gamelist("Warframe", new String[]{"FPS", "Action", "Sci-Fi"}));
        list.add(new Gamelist("Watch Dogs 2", new String[]{"Action/Adventure", "Open World", "Hacking"}));
        list.add(new Gamelist("We Happy Few", new String[]{"Action/Adventure", "Survival", "Dystopian"}));
        list.add(new Gamelist("What Remains of Edith Finch", new String[]{"Adventure", "Indie", "Story-Driven"}));
        list.add(new Gamelist("Wilmot's Warehouse", new String[]{"Puzzle", "Indie", "Management"}));
        list.add(new Gamelist("Wolfenstein II: The New Colossus", new String[]{"FPS", "Action", "Alternate History"}));
        list.add(new Gamelist("Wolfenstein: The New Order", new String[]{"FPS", "Action", "Alternate History"}));
        list.add(new Gamelist("World of Warcraft", new String[]{"MMORPG", "Fantasy", "Multiplayer"}));
        list.add(new Gamelist("World War Z", new String[]{"Third-Person Shooter", "Action", "Zombies"}));
        list.add(new Gamelist("Worms W.M.D", new String[]{"Strategy", "Turn-Based", "Multiplayer"}));
        list.add(new Gamelist("XCOM 2", new String[]{"Strategy", "Turn-Based", "Sci-Fi"}));
        list.add(new Gamelist("Yakuza 0", new String[]{"Action/Adventure", "Open World", "Crime"}));
        list.add(new Gamelist("Yakuza Kiwami", new String[]{"Action/Adventure", "Open World", "Crime"}));
        list.add(new Gamelist("Yakuza Kiwami 2", new String[]{"Action/Adventure", "Open World", "Crime"}));
        list.add(new Gamelist("Yakuza: Like a Dragon", new String[]{"RPG", "Action/Adventure", "Crime"}));
        list.add(new Gamelist("Yooka-Laylee", new String[]{"Platformer", "Indie", "3D Platformer"}));
        list.add(new Gamelist("Ys VIII: Lacrimosa of Dana", new String[]{"Action RPG", "Anime", "Fantasy"}));
        list.add(new Gamelist("Zero Escape: The Nonary Games", new String[]{"Visual Novel", "Puzzle", "Mystery"}));
        list.add(new Gamelist("Zero Escape: Virtue's Last Reward", new String[]{"Visual Novel", "Puzzle", "Mystery"}));
        list.add(new Gamelist("Zero Escape: Zero Time Dilemma", new String[]{"Visual Novel", "Puzzle", "Mystery"}));
        list.add(new Gamelist("Zombie Army 4: Dead War", new String[]{"Third-Person Shooter", "Co-op", "Zombies"}));
        list.add(new Gamelist("Zoo Tycoon: Ultimate Animal Collection", new String[]{"Simulation", "Building", "Animals"}));
        list.add(new Gamelist("13 Sentinels: Aegis Rim", new String[]{"Adventure", "Visual Novel", "Sci-Fi"}));
        list.add(new Gamelist("7 Days to Die", new String[]{"Survival", "Open World", "Zombies"}));
        list.add(new Gamelist("80 Days", new String[]{"Interactive Fiction", "Indie", "Steampunk"}));
        list.add(new Gamelist("911 Operator", new String[]{"Simulation", "Strategy", "Management"}));
        list.add(new Gamelist("A Short Hike", new String[]{"Adventure", "Indie", "Relaxing"}));
        list.add(new Gamelist("A Total War Saga: TROY", new String[]{"Strategy", "Historical", "RTS"}));
        list.add(new Gamelist("Abzu", new String[]{"Adventure", "Exploration", "Underwater"}));
        list.add(new Gamelist("Ace Combat 7: Skies Unknown", new String[]{"Flight", "Action", "Combat"}));
        list.add(new Gamelist("Aion", new String[]{"MMORPG", "Fantasy", "Multiplayer"}));
        list.add(new Gamelist("Airships: Conquer the Skies", new String[]{"Indie", "Strategy", "Steampunk"}));
        list.add(new Gamelist("Alien Swarm: Reactive Drop", new String[]{"Top-Down Shooter", "Co-op", "Sci-Fi"}));
        list.add(new Gamelist("Aliens: Colonial Marines", new String[]{"FPS", "Horror", "Sci-Fi"}));
        list.add(new Gamelist("American Truck Simulator", new String[]{"Simulation", "Driving", "Open World"}));
        list.add(new Gamelist("Amnesia: Rebirth", new String[]{"Horror", "Survival", "Atmospheric"}));
        list.add(new Gamelist("Ancestors: The Humankind Odyssey", new String[]{"Action/Adventure", "Survival", "Open World"}));
        list.add(new Gamelist("Angels with Scaly Wings", new String[]{"Visual Novel", "Dragons", "Dating Sim"}));
        list.add(new Gamelist("Apex Legends", new String[]{"FPS", "Battle Royale", "Team-Based"}));
        list.add(new Gamelist("Arcanum: Of Steamworks and Magick Obscura", new String[]{"RPG", "Steampunk", "Isometric"}));
        list.add(new Gamelist("Arma 3", new String[]{"FPS", "Military", "Simulation"}));
        list.add(new Gamelist("Art of Rally", new String[]{"Racing", "Indie", "Simulation"}));
    }
}

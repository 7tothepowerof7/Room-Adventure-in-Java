import java.util.Scanner;
import java.util.Arrays;

public class RoomAdventuresinClass {

    // class variables
    private static Room currentRoom;
    private static final String[] inventory = new String[5]; // null = empty slot
    private static String status;

    // constants
    private static final String DEFAULT_STATUS =
        "Sorry, I do not understand. Valid input should be: [verb] [noun]";

    public static void main(String[] args) {
        setupGame();

        Scanner s = new Scanner(System.in);

        while (true) {
            // output current room
            System.out.println(currentRoom.toString());

            // inventory print
            System.out.print("Inventory: ");
            boolean any = false;
            for (String it : inventory) {
                if (it != null) {
                    System.out.print(it + " ");
                    any = true;
                }
            }
            if (!any) System.out.print("(empty)");
            System.out.println();

            // prompt
            System.out.print("\nWhat would you like to do? ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(DEFAULT_STATUS);
                continue;
            }

            // normalize "look at X" -> "look X"
            input = input.replaceAll("(?i)\\blook at\\b", "look");

            String[] words = input.split(" ");
            if (words.length != 2) {
                System.out.println(DEFAULT_STATUS);
                continue;
            }

            String verb = words[0].toLowerCase();
            String noun = words[1].toLowerCase();

            switch (verb) {
                case "look":
                    String[] items = currentRoom.getItems();
                    String[] desc = currentRoom.getItemDescriptions();
                    if (items != null && desc != null) {
                        boolean found = false;
                        for (int i = 0; i < items.length && i < desc.length; i++) {
                            if (items[i].equalsIgnoreCase(noun)) {
                                System.out.println(items[i] + ": " + desc[i]);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("You don't see that here.");
                        }
                    } else {
                        System.out.println("There is nothing notable here.");
                    }
                    break;

                case "go":
                    Room next = currentRoom.getExitDestination(noun);
                    if (next != null) {
                        currentRoom = next;
                        System.out.println("You go " + noun + ".");
                    } else {
                        System.out.println("You can't go that way.");
                    }
                    break;

                case "take":
                    if (currentRoom.isGrabbable(noun)) {
                        boolean added = false;
                        for (int i = 0; i < inventory.length; i++) {
                            if (inventory[i] == null) {
                                inventory[i] = noun;
                                added = true;
                                break;
                            }
                        }
                        if (added) {
                            currentRoom.removeGrabbable(noun);
                            System.out.println("You take the " + noun + ".");
                        } else {
                            System.out.println("Your inventory is full.");
                        }
                    } else {
                        System.out.println("You can't take that.");
                    }
                    break;

                case "drop":
                    boolean found = false;
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i] != null && inventory[i].equalsIgnoreCase(noun)) {
                            inventory[i] = null;
                            currentRoom.addGrabbable(noun);
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("You drop the " + noun + ".");
                    } else {
                        System.out.println("You do not have that item.");
                    }
                    break;

                case "quit":
                    System.out.println("Goodbye.");
                    s.close();
                    return;

                default:
                    System.out.println(DEFAULT_STATUS);
            }

            String verb = words[0].toLowerCase();
            String noun = words[1].toLowerCase();

switch (verb) {
    case "look" -> {
        String[] items = currentRoom.getItems();
        String[] desc = currentRoom.getItemDescriptions();
        if (items != null && desc != null) {
            for (int i = 0; i < items.length && i < desc.length; i++) {
                System.out.println(items[i] + ": " + desc[i]);
            }
        } else {
            System.out.println("There is nothing notable here.");
        }
    }

    case "go" -> {
        Room next = currentRoom.getExitDestination(noun);
        if (next != null) {
            currentRoom = next;
            System.out.println("You go " + noun + ".");
        } else {
            System.out.println("You can't go that way.");
        }
    }

    case "take" -> {
        if (currentRoom.isGrabbable(noun)) {
            boolean added = false;
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = noun;
                    added = true;
                    break;
                }
            }
            if (added) {
                currentRoom.removeGrabbable(noun);
                System.out.println("You take the " + noun + ".");
            } else {
                System.out.println("Your inventory is full.");
            }
        } else {
            System.out.println("You can't take that.");
        }
    }

    case "drop" -> {
        boolean found = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equalsIgnoreCase(noun)) {
                inventory[i] = null;
                currentRoom.addGrabbable(noun);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("You drop the " + noun + ".");
        } else {
            System.out.println("You do not have that item.");

    case "eat" -> {
            // eat requires the item to be in inventory
            boolean found = false;
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] != null && inventory[i].equalsIgnoreCase(noun)) {
                    found = true;
                    // Remove the eaten item from inventory
                    inventory[i] = null;
                    break;
                    }
                }
            if (!found) {
                System.out.println("You don't have that to eat.");
                } else {
                if ("apple".equalsIgnoreCase(noun)) {
                    System.out.println("You eat the apple. You hear a hissing noise from inside a wall.");
                } else {
                    System.out.println("You can't eat that.");
        }
    }
}
    case "quit" -> {
        System.out.println("Goodbye.");
        scanner.close();
        return;
    }

    default -> System.out.println(DEFAULT_STATUS);
        }
    }
}

    private static void setupGame() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");
        Room room4 = new Room("Room 4");

        // Room 1
        String[] r1Dirs = {"east"};
        Room[] r1Dests = {room2};
        String[] r1Items = {"chair", "desk"};
        String[] r1ItemDesc = {
            "It is a chair, there is a nail on it",
            "It's a desk, there is an apple on it."
        };
        String[] r1Grabbables = {"nail", "apple"};
        room1.setExitDirections(r1Dirs);
        room1.setExitDestinations(r1Dests);
        room1.setItems(r1Items);
        room1.setItemDescriptions(r1ItemDesc);
        room1.setGrabbables(r1Grabbables);

        // Room 2
        String[] r2Dirs = {"west", "east"};
        Room[] r2Dests = {room1, room3};
        String[] r2Items = {"rug", "fireplace"};
        String[] r2ItemDesc = {
            "A worn rug lies on the floor",
            "A small, cozy fireplace with a faint glow"
        };
        String[] r2Grabbables = {"match"};
        room2.setExitDirections(r2Dirs);
        room2.setExitDestinations(r2Dests);
        room2.setItems(r2Items);
        room2.setItemDescriptions(r2ItemDesc);
        room2.setGrabbables(r2Grabbables);

        // Room 3
        String[] r3Dirs = {"west", "south"};
        Room[] r3Dests = {room2, room4};
        String[] r3Items = {"bookshelf", "alcove"};
        String[] r3ItemDesc = {
            "A tall bookshelf filled with dusty tomes",
            "A small alcove with a rusted lantern hanging"
        };
        String[] r3Grabbables = {"scroll", "lantern"};
        room3.setExitDirections(r3Dirs);
        room3.setExitDestinations(r3Dests);
        room3.setItems(r3Items);
        room3.setItemDescriptions(r3ItemDesc);
        room3.setGrabbables(r3Grabbables);

        // Room 4
        String[] r4Dirs = {"north", "west"};
        Room[] r4Dests = {room3, room1};
        String[] r4Items = {"table", "chest"};
        String[] r4ItemDesc = {
            "A small wooden table with a strange key on it",
            "An old chest with a tarnished coin on top"
        };
        String[] r4Grabbables = {"key", "coin"};
        room4.setExitDirections(r4Dirs);
        room4.setExitDestinations(r4Dests);
        room4.setItems(r4Items);
        room4.setItemDescriptions(r4ItemDesc);
        room4.setGrabbables(r4Grabbables);

        currentRoom = room1;
    }

    // static nested Room class so it can be used from static methods
    private static class Room {
        private final String name;
        private String[] exitDirections;   // e.g., {"north","east"}
        private Room[] exitDestinations;   // parallel to exitDirections
        private String[] items;
        private String[] itemDescriptions;
        private String[] grabbables;

        public Room(String name) {
            this.name = name;
        }

        // setters
        public void setExitDirections(String[] exitDirections) {
            this.exitDirections = exitDirections;
        }

        public void setExitDestinations(Room[] exitDestinations) {
            this.exitDestinations = exitDestinations;
        }

        public void setItems(String[] items) {
            this.items = items;
        }

        public void setItemDescriptions(String[] itemDescriptions) {
            this.itemDescriptions = itemDescriptions;
        }

        public void setGrabbables(String[] grabbables) {
            this.grabbables = grabbables;
        }

        // getters
        public String[] getItems() {
            return items;
        }

        public String[] getItemDescriptions() {
            return itemDescriptions;
        }

        // returns the Room for a given direction, or null if none
        public Room getExitDestination(String direction) {
            if (exitDirections == null || exitDestinations == null) return null;
            for (int i = 0; i < exitDirections.length && i < exitDestinations.length; i++) {
                if (direction.equalsIgnoreCase(exitDirections[i])) return exitDestinations[i];
            }
            return null;
        }

        // grabbable helpers
        public boolean isGrabbable(String item) {
            if (grabbables == null) return false;
            for (String g : grabbables) {
                if (g != null && g.equalsIgnoreCase(item)) return true;
            }
            return false;
        }

        public void removeGrabbable(String item) {
            if (grabbables == null) return;
            int keep = 0;
            for (String g : grabbables) if (g != null && !g.equalsIgnoreCase(item)) keep++;
            String[] next = new String[keep];
            int idx = 0;
            for (String g : grabbables) {
                if (g != null && !g.equalsIgnoreCase(item)) next[idx++] = g;
            }
            grabbables = next;
        }

        public void addGrabbable(String item) {
            if (grabbables == null) {
                grabbables = new String[] { item };
                return;
            }
            String[] next = Arrays.copyOf(grabbables, grabbables.length + 1);
            next[next.length - 1] = item;
            grabbables = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("\nYou are in ").append(name).append("\nExits: ");
            if (exitDirections != null) {
                for (String d : exitDirections) sb.append(d).append(" ");
            }
            sb.append("\nItems: ");
            if (items != null) {
                for (String it : items) sb.append(it).append(" ");
            }
            sb.append("\n");
            return sb.toString();
        }
    }
}

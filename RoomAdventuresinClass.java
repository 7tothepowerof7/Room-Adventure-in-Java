import java.util.Scanner;

public class RoomAdventuresinClass {

    //class variables
    private static Room currentRoom;
    private static String[] inventory = {null, null, null, null, null};
    private static String status;

    // constants
    final private static String DEFAULT_STATUS = "Sorry, I do not understand. Valid input should be: [verb] [noun]";

    // 
    public static void main(String[] args){

        while (true){
            // outputting
            System.out.println(currentRoom.toString());
            System.out.print(s: "Inventory: ");

            // for loops
            for (int i = 0; i < inventory.length; i++){
                System.out.print(inventory[i] + " ");
                System.out.println(x: "\nWhat would you like to do? ");
            
            // taking input
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();

            String[] words = input.split(regex: " ");

            if (words.length != 2){
                status = DEFAULT_STATUS;
            }

            String verb = words[0];
            String noun = words[1];
            }
        }
    }
    
    private static void setupGame(){

        Room room1 = new Room(name: "Room 1");
        Room room2 = new Room(name: "Room 2");

        // Room 1
        String[] room1ExitDirections = {"east", "south"};
        Room[] room1ExitDistinations = {room2};
        String[] room1Items = {"chair", "desk"};
        String[] room1ItemDescriptions = {
            "It is a chair, there is a nail on it",
            "It's a desk, there is an apple on it."
        };
        String[] room1grabbables = {"nail", "apple"};

        room1.setExitDirections(room1ExitDirections);
        room1.setExitDestinations(room1ExitDestinations);
        room1.setItems(room1Items);
        room1.setItemDescriptions(room1ItemDescriptions);
        room1.setGrabbables(room1Grabbables);

        //Room 2
        String[] room2ExitDirections = {"east", "south"};
        Room[] room2ExitDistinations = {room2};
        String[] room2Items = {"rug", "fireplace"};
        String[] room2ItemDescriptions = {
            "It is a chair, there is a nail on it",
            "It's a desk, there is an apple on it."
        };
        String[] room2grabbables = {"nail", "apple"};

        room1.setExitDirections(room2ExitDirections);
        room1.setExitDestinations(room2ExitDestinations);
        room1.setItems(room2Items);
        room1.setItemDescriptions(room2ItemDescriptions);
        room1.setGrabbables(room2Grabbables);
    }

@SuppressWarnings("rawtypes")
Class Room;

    private String name;
    private String[] exitDirections; // north, south, east, west
    private String[] exitDestinations;
    private String[] items;
    private String[] itemDescriptions;
    private String[] grabbables;

    // constructors - function has same name as class
    public void RoomAdventure(String name){
        this.name = name; // use this to refer to the instance
    }

    // methods - getters and setters
    public void setExitDirections(String[] exitDirections){
        this.exitDirections = exitDirections;
    
    }
    
    
    public String[] getExitDestinations(String[] exitDestinations){
        return this.exitDestinations = exitDestinations;
    
    }
    
    public String[] getexitDirections(){
        return exitDirections;
    
    }
    
    public String[] getExitDestinations(){
        return exitDestinations;
    
    }
    
    public String toString(){
        String result = "\nExits: ";
        // for each loop
        for (String direction : exitDirections){
            result += direction + " ";
        }
        return result;
    }
}
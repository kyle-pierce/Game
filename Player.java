import java.util.*;
import java.io.*;

public class Player {
   private Scanner console = new Scanner(System.in);
   private String name;
   private String playerClass;
   private Map<Item, Integer> inventory = new TreeMap<Item, Integer>();
   private Map<String, Item> equipment = new TreeMap<String, Item>();
   private int[] stats = new int[3]; //index 0 is strength, 1 is agility, 2 is megicka

   public Player() {
      makeName();
      makeRole();
      makeInventory();
      makeEquipment();
      setStats();
   }
   
   private void makeName() {
      System.out.print("Hello, adventurer.  What is your name? ");
      name = console.nextLine();
      System.out.println();
      
   }
   
   private  void makeRole() {
      System.out.println("Welcome, " + name + ". Which class are you? (Type 'info' for more information)");
      System.out.println("   Warrior   Ranger   Mage");
      String input = console.nextLine().toLowerCase().trim();
      while (!(input.contains("warrior") || input.contains("ranger") || input.contains("mage"))) {  
         if (input.contains("info")) {
            try {
               Scanner text = new Scanner(new File("ClassInfo.txt"));
               while (text.hasNextLine()) {
                  System.out.println(text.nextLine());
               }
               input = console.next();
            } catch (FileNotFoundException e) {
               System.out.println("Well...too bad!");
            }
         }
         else {
            System.out.println("Invalid class. Please choose a valid class. (Or type 'info')");
            System.out.println("   Warrior   Ranger   Mage");
            input = console.next().toLowerCase().trim();
         }
      }
      playerClass = assignClass(input);
   }  
   
   private String assignClass(String input) {
      if (input.contains("warrior")) {
         return "warrior";
      } else if (input.contains("ranger")) {
         return "ranger";
      } else {
         return "mage";
      }
   } 
      
   private void makeInventory() {
      if (playerClass.equals("warrior")) {
         inventory.put(new Weapon("iron sword", 5, "main-hand"), 1);
         inventory.put(new Weapon("hide buckler", 10, "off-hand"), 1);
      } else if (playerClass.equals("ranger")) {
         inventory.put(new Weapon("hunting bow", 5, "main-hand"), 1);
         inventory.put(new Item("arrow"), 100);
      } else {
         inventory.put(new Weapon("gnarled staff", 5, "main-hand"), 1);
         inventory.put(new Weapon("oak wand", 5, "main-hand"), 1);
      }
      inventory.put(new Item("gold coin"), 10);
      inventory.put(new Item("lantern"), 1);
      inventory.put(new Armor("Gold Chestpiece", 100, "chest"), 1);
   }
   
   private void makeEquipment() {
      equipment.put("head", null);
      equipment.put("chest", null);
      equipment.put("legs", null);
      equipment.put("hands", null);
      equipment.put("feet", null);
      equipment.put("waist", null);
      equipment.put("shoulders", null);
      equipment.put("main-hand", null);
      equipment.put("off-hand", null);
   }
   
   private void setStats() {
      if (playerClass.equals("warrior")) {
         stats[0] = 10;
         stats[1] = 0;
         stats[2] = 0;
      } else if (playerClass.equals("ranger")) {
         stats[0] = 0;
         stats[1] = 10;
         stats[2] = 0;
      } else {
         stats[0] = 0;
         stats[1] = 0;
         stats[2] = 10;
      }
   }
   
   public String getRole() {
      return playerClass;
   }
   
   public String getName() {
      return name;
   }
   
   public void printInventory() {
      System.out.println("Current Player Inventory:");
      System.out.println();
      for (Item i : inventory.keySet()) {
         System.out.println(i + ": " + inventory.get(i));
      }
      System.out.println();
   }
   
   public void printEquipment() {
      System.out.println("Current Player Equipment:");
      System.out.println();
      for (String s : equipment.keySet()) {
         if (equipment.get(s) != null) {
            System.out.print(s + ": " + equipment.get(s));
         }
      }
      if (equipment.values().size() == 1) {
         System.out.println("You do not have anything equipped.");
      }
      System.out.println();
   }
   
   public void stats() {
      System.out.println("Your current attributes are: ");
      System.out.println(" Strength: " + stats[0]);
      System.out.println(" Agility:  " + stats[1]);
      System.out.println(" Magicka:  " + stats[2]);
      System.out.println();
   }
   
   public void equip(String itemName) {
      Item equipped = checkInventory(itemName);
      if (equipped != null) {
         if (equipped.getSlot().length() > 0) {
            equipment.put(equipped.getSlot(), equipped);
            inventory.remove(equipped);
         } else {
            System.out.println("You can't equip that!");
         }
      } else {
         System.out.println("Looks like you don't have any of those.");
      }
   }
   
   private Item checkInventory(String itemName) {
      for (Item i : inventory.keySet()) {
         if (i.toString().equals(itemName)) {
            return i;
         }
      }
      return null;
   }
}

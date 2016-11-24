import java.util.*;
import java.io.*;

public class Player {
   private Scanner console = new Scanner(System.in);
   private String name;
   private String playerClass;
   private Inventory inventory;
   private Equipment equipment;

   public Player() {
      makeName();
      makeRole();
      inventory = new Inventory(playerClass);
      equipment = new Equipment();
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
   
   public String getRole() {
      return playerClass;
   }
   
   public String getName() {
      return name;
   }
   
   public void printInventory() {
      inventory.print();
   }
   
   public void printEquipment() {
      equipment.print();
   }
   
   public void equip(String s) {
      equipment.add(s, inventory);
   }
}

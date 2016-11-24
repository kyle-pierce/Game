import java.util.*;

public class Basilisk extends Enemy {
   
   public Basilisk(int maxHealth) {
      super(maxHealth, "Basilisk", "Shhhess");
   }
   
   public int attack() {
      Random generate = new Random();
      int yeetEm = generate.nextInt(30);
      if(yeetEm == 1) {
         System.out.println(super.getName() + " got you with poison and did 60 damage");
         return 60;
      }
      int damage = generate.nextInt(6) + 10;
      System.out.println(super.getName() + " bites you and did " + damage + " damage");
      return damage;
   }
}
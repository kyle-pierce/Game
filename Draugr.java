import java.util.*;

public class Draugr extends Enemy {
   public Draugr(int maxHealth) {
      super(maxHealth, "Draugr", "You shall Die");
   }
   
   public int attack() {
      super.heal(5);
      Random generate = new Random();
      int damage = generate.nextInt(5) + 12;
      System.out.println("Draugr attacks with his longsword and does " + damage +  " damage");
      return damage;
   }
}
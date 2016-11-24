public class Spider extends Enemy {
   
   public Spider(int maxHealth) {
      super(maxHealth, "Spider", "Tap Tap");
   }
   
   public int attack() {
      System.out.println("Spider bites you and does 10 damage");
      return 10;
   }
}
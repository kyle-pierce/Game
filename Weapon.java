public class Weapon extends Item {
   private int damage;
   private String hand;
   
   public Weapon(String name, int damage, String hand) {
      super(name);
      this.damage = damage;
      this.hand = hand;
   }
   
   public String getHand() {
      return hand;
   }
}

public class Enemy { 
   private int maxHealth;
   private int healthPoints;
   private String name;
   private String sound;
   
   public Enemy(int maxHealth, String name, String sound) {
      this.maxHealth = maxHealth;
      this.maxHealth = healthPoints;
      this.name = name;
      this.sound = sound;
   }
   
   public int health() {
      return healthPoints;
   }
   
   public int hit(int damage) {
      healthPoints -= damage;
      if(healthPoints <= 0) {
         System.out.println("You have slain the " + name);
         healthPoints = 0;
      }
      return healthPoints;
   }
   
   public void printHealth() {
      System.out.println(name + " at " + healthPoints + "/" + maxHealth + "health");
   } 
   
   public String getName() {
      return name;
   } 
   
   public void encounter() {
      System.out.println(sound);
      System.out.println("You have encountered a " + name);
   }
   
   public void heal(int value) {
      if((maxHealth - healthPoints) > value) {
         healthPoints += value;
         System.out.println(name + "has healed " + value + "health points");
      }
   }
}
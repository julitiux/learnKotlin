import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class Jhava {

  private int hitPoints = 52489112;
  private String greeting = "BLARGH";

  public static void main(String[] args) {
    System.out.println(Hero.makeProclamation());

    System.out.println("Spells:");
    Spellbook spellbook = new Spellbook();
    for (String spell : spellbook.spells) {
      System.out.println(spell);
    }

    System.out.println("Max spell count: " + Spellbook.MAX_SPELL_COUNT);

    Spellbook.getSpellbookGreeting();
  }

  @NotNull
  public String utterGreenting() {
    return greeting;
  }

  @Nullable
  public String determineFriendshipLevel() {
    return null;
  }

  public int getHitPoints() {
    return hitPoints;
  }

  public String getGreeting() {
    return greeting;
  }

  public void setGreeting(String greeting) {
    this.greeting = greeting;
  }

  public void offerFood() {
    Hero.handOverFood("pizza");
  }

  public void extendHandInFriendship() throws Exception {
    throw new Exception();
  }

  public void apologize() {
    try {
      Hero.acceptApology();
    } catch (Exception e){
      System.out.println("Caught!");
    }
  }
}
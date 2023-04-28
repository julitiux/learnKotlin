import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class Jhava {

  private int hitPoints = 52489112;
  private String greeting = "BLARGH";

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
}
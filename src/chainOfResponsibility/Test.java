import java.util.ArrayList;
import java.util.List;

abstract class Creature
{
  public abstract int getAttack();
  public abstract int getDefense();
}

class Goblin extends Creature
{
  public Goblin(Game game)
  {
    // todo
  }

  @Override
  public int getAttack()
  {
    // todo
  }

  @Override
  public int getDefense()
  {
    // todo
  }
}

class GoblinKing extends Goblin
{
  public GoblinKing(Game game)
  {
    // todo
  }
}

enum Statistic
{
  ATTACK, DEFENSE
}

class Game
{
  public List<Creature> creatures = new ArrayList<>();
}
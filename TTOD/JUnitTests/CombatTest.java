import com.company.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class CombatTest {
    @Test
    public void attack() {
        Combat c = getBasicCombat();
        Assert.assertEquals(c.attack().PlayerAction, Types.CombatActionResult.Attacked);
        Assert.assertTrue(c.CurrentEnemy.Life < c.CurrentEnemy.MaxLife);
    }

    @Test
    public void defense() {
        Combat c = getBasicCombat();
        Assert.assertEquals(c.defense().PlayerAction, Types.CombatActionResult.Defended);
    }

    @Test
    public void usePotion() throws Exception {
        Combat c = getBasicCombat();
        Item potion = new Item();
        potion.Type = Types.ItemType.Potion;
        potion.Attack = 100;
        Assert.assertEquals(c.usePotion(potion).PlayerAction, Types.CombatActionResult.ItemUsed);
        Assert.assertTrue(c.CurrentEnemy.Life < c.CurrentEnemy.MaxLife);
    }

    @Test
    public void flee() {
        Combat c = getBasicCombat();
        boolean couldFlee = false;
        for (int i = 0; i < 1000; i++) {
            if(c.flee().PlayerAction.equals(Types.CombatActionResult.Escaped))
            {
                i = 1000;
                couldFlee = true;
            }
        }
        Assert.assertTrue(couldFlee);
    }

    @Test
    public void getAttacked() {
        Combat c = getBasicCombat();
        Assert.assertEquals(c.getAttacked().PlayerAction, Types.CombatActionResult.Waited);
    }

    private Combat getBasicCombat(){
        new Game().initializeGodModePlayer();
        Combat c = new Combat(new Enemy());
        c.CurrentEnemy.setMaxLife(30);
        c.CurrentEnemy.Attack = 10;
        c.CurrentEnemy.Defense = 10;
        c.CurrentEnemy.Initiative = 0;
        return c;
    }
}
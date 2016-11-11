import com.company.Player;
import com.company.Town;
import com.company.Trader;
import com.company.Types;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class TownTest {
    @Test
    public void generateDefaultTraders() {
        Town t = new Town();
        for (Trader trader: t.Traders) {
            Assert.assertTrue(trader.GEIL > 0);
            Assert.assertTrue(trader.Charisma > 0);
            Assert.assertTrue(trader.Items.size() > 0);
            Assert.assertTrue(trader.Name != new Trader().Name);
        }
    }

    @Test
    public void goSleeping() {
        Player.getOurInstance().setMaxLife(100);
        Player.getOurInstance().Life = 50;
        Town t = new Town();
        t.goSleeping();
        Assert.assertTrue(Player.getOurInstance().Life == Player.getOurInstance().MaxLife);
    }

}
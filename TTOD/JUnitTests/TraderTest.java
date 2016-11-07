import com.company.Item;
import com.company.Player;
import com.company.Trader;
import com.company.Types;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michael on 04.11.2016.
 */
public class TraderTest {
    @Test
    public void buyItem() {
        Player.getOurInstance().GEIL = 90000;
        Player.getOurInstance().MaxItems = 20;
        Trader t = new Trader();
        t.GEIL = 1;
        Item traderitem = new Item();
        traderitem.Value = 300;
        t.Items.add(traderitem);
        t.buyItem(traderitem);
        Assert.assertTrue(t.GEIL > 1);
        Assert.assertTrue(Player.getOurInstance().Items.contains(traderitem));
    }

    @Test
    public void getItemSellPrice() {
        Item tradeitem = new Item();
        tradeitem.Value = 100;
        Player.getOurInstance().Charisma = 50;
        Trader t = new Trader();
        t.Charisma = 80;
        Player.getOurInstance().Items.add(tradeitem);
        float sellPrice = t.getItemSellPrice(tradeitem);
        Assert.assertTrue(sellPrice < tradeitem.Value);
    }

    @Test
    public void getItemBuyPrice()  {
        Item tradeitem = new Item();
        tradeitem.Value = 100;
        Player.getOurInstance().Charisma = 50;
        Trader t = new Trader();
        t.Charisma = 80;
        t.Items.add(tradeitem);
        float buyPrice = t.getItemBuyPrice(tradeitem);
        Assert.assertTrue(buyPrice > tradeitem.Value);
    }

    @Test
    public void sellItem() {
        Trader t = new Trader();
        t.GEIL = 1;
        Item traderitem = new Item();
        traderitem.Value = 300;
        Player.getOurInstance().Items.add(traderitem);
        t.sellItem(traderitem);
        Assert.assertTrue(t.GEIL == 0);
        Assert.assertFalse(Player.getOurInstance().Items.contains(traderitem));
    }
}
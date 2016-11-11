import com.company.Game;
import com.company.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class GameTest {
    @Test
    public void startNewDefaultGame() {
        Game game = new Game();
        game.startNewDefaultGame();
        Assert.assertTrue(game.Dungeon.Floors.size() == 8);
        Assert.assertTrue(game.Town.Traders.size() > 0);
        Assert.assertTrue(Player.getOurInstance().Life > 0);
    }

    @Test
    public void initializeDefaultPlayer() {
        Game game = new Game();
        Player.getOurInstance().Name = "Test Player";
        game.initializeDefaultPlayer();
        Assert.assertTrue(Player.getOurInstance().MaxLife == Player.getOurInstance().Life);
        Assert.assertTrue(Player.getOurInstance().Life > 0);
        Assert.assertTrue(Player.getOurInstance().Defense < 100 && Player.getOurInstance().Defense > 0);
        Assert.assertTrue(Player.getOurInstance().Attack < 100 && Player.getOurInstance().Attack > 0);
        Assert.assertEquals(Player.getOurInstance().Name, "Test Player");
    }

    @Test
    public void initializeGodModePlayer() {
        Game game = new Game();
        Player.getOurInstance().Name = "Test Player";
        game.initializeGodModePlayer();
        Assert.assertTrue(Player.getOurInstance().MaxLife == Player.getOurInstance().Life);
        Assert.assertTrue(Player.getOurInstance().Life > 100);
        Assert.assertTrue(Player.getOurInstance().Defense > 100);
        Assert.assertTrue(Player.getOurInstance().Attack > 100);
        Assert.assertEquals(Player.getOurInstance().Name, "Test Player");
    }

}
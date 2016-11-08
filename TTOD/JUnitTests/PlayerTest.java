import com.company.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class PlayerTest {
    @Test
    public void getOurInstance() {
        Player.getOurInstance().Life = 100;
        Assert.assertTrue(Player.getOurInstance().Life == 100);
    }
}
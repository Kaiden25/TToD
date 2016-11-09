import com.company.Enemy;
import com.company.Floor;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class FloorTest {
    @Test
    public void nextCombat() {
        Floor floor = new Floor();
        Enemy e = new Enemy();
        floor.PossibleEnemies.add(e);
        Assert.assertEquals(floor.nextCombat().CurrentEnemy.Name, e.Name);
    }

    @Test
    public void canLeave() {
        Floor floor = new Floor();
        floor.PossibleEnemies.add(new Enemy());
        boolean leftOnce = false;
        for (int i = 0; i < 900; i++) {
            if(floor.canLeave())
                leftOnce = true;
        }
    }

}
import com.company.Enemy;
import com.company.EnemyController;
import com.company.Types;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class EnemyControllerTest {
    @Test
    public void getEnemy() {
        for (Types.Enemy e: Types.Enemy.values()) {
            Enemy enemy = new EnemyController().getEnemy(e);
            Assert.assertTrue(enemy.Name != new Enemy().Name);
            Assert.assertEquals(enemy.Type, e);
        }
    }

}
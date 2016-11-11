import com.company.Enemy;
import com.company.Types;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class EnemyTest {
    @Test
    public void getType() {
        Enemy e = new Enemy();
        e.Type = Types.Enemy.Dragon;
        Assert.assertTrue(e.getType() == Types.Enemy.Dragon);
    }

    @Test
    public void setType() {
        Enemy e = new Enemy();
        e.setType(Types.Enemy.Dragon);
        Assert.assertTrue(e.Type == Types.Enemy.Dragon);
    }

    @Test
    public void cloneEnemy() {
        Enemy e = new Enemy();
        e.Type = Types.Enemy.Dragon;
        e.Name = "Lucifer";
        e.Attack = 100;
        e.Defense = 100;
        e.Luck = 100;
        e.MaxLife = 2000;
        Enemy e2 = e.cloneEnemy();
        Assert.assertTrue(e2.Name == e.Name);
        Assert.assertTrue(e2.Attack == e.Attack);
        Assert.assertTrue(e2.Type == e.Type);
        Assert.assertTrue(e2.Defense == e.Defense);
        Assert.assertTrue(e2.Luck == e.Luck);
        Assert.assertTrue(e2.MaxLife == e.MaxLife);
    }

}
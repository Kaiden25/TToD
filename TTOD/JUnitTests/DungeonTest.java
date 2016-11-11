import com.company.Dungeon;
import com.company.Floor;
import com.company.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class DungeonTest {
    @Test
    public void generateDefaultFloors() {
        Dungeon dungeon = new Dungeon();
        dungeon.generateDefaultFloors();
        Assert.assertTrue(dungeon.Floors.size() == 8);
    }

    @Test
    public void nextFloor() {
        Dungeon dungeon = new Dungeon();
        dungeon.generateDefaultFloors();
        Player.getOurInstance().FloorCount = 0;
        Assert.assertEquals(dungeon.nextFloor(), dungeon.Floors.get(0));
        Player.getOurInstance().FloorCount = 5;
        Assert.assertEquals(dungeon.nextFloor(), dungeon.Floors.get(5));
    }

}
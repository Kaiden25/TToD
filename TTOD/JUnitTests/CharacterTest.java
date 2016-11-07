import com.company.Character;
import com.company.Item;
import com.company.Types;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class CharacterTest {
    @Test
    public void addItem() throws Exception {
        Character c = new Character();
        c.addItem(new Item());
        Assert.assertTrue(c.Items.size() == 1);
    }

    @Test
    public void removeItem() throws Exception {
        Character c = new Character();
        Item i = new Item();
        c.addItem(i);
        c.removeItem(i);
        Assert.assertTrue(c.Items.size() == 0);
    }

    @Test
    public void setArmor() throws Exception {
        Character c = new Character();
        Item i = new Item();
        i.Type = Types.ItemType.Armor;
        c.addItem(i);
        c.setArmor(i);
        Assert.assertTrue(c.Armor != null);
    }

    @Test
    public void setWeapon() throws Exception {
        Character c = new Character();
        Item i = new Item();
        i.Type = Types.ItemType.Weapon;
        c.addItem(i);
        c.setWeapon(i);
        Assert.assertTrue(c.Weapon != null);
    }

    @Test
    public void setMaxLife() throws Exception {
        Character c = new Character();
        c.setMaxLife(42);
        Assert.assertTrue(c.MaxLife == 42 && c.Life == 42);
    }

}
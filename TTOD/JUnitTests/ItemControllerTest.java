import com.company.Item;
import com.company.ItemController;
import com.company.Types;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pstieger on 07.11.2016.
 */
public class ItemControllerTest {
    @Test
    public void getItem() {
        for (Types.ItemType itemType:Types.ItemType.values() ) {
            Item item = ItemController.getItem(itemType);
            Assert.assertTrue(item.Type == itemType);
            Assert.assertTrue(item.Name != "");
        }
    }
}
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChangeTest {
    @Test
    public void whenValueEqual50andPriceEqual35() {
        Change change = new Change();
        assertThat(change.changes(50, 35), is(new int[]{10, 5}));
    }
}

import org.junit.Test;

import java.io.IOException;


public class MenuTest {
    @Test
    public void displayMenuOptions() throws IOException {
        Menu m = new Menu();
        m.run();
    }

}
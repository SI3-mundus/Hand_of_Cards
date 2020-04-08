import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorTest {
<<<<<<< HEAD
    private String color_A="Ca";
    private String color_B="Co";
    private Color color;

=======
    private String color_A="Spade";
    private String color_B="Heart";
>>>>>>> c0588f5405f61daa17a1592cf8e484f922652fb7


    @Test
    void constructor(){
        assertAll(
                () -> assertNotNull(color_A),
                () -> assertNotNull(color_B)
        );
    }
    @Test
    void testToString() {
        assertEquals(color_A, color_A.toString());
    }
<<<<<<< HEAD

=======
    @Test
    void getColor(){
        assertAll(
                () -> assertEquals(1,Color.getColor(color_A)),
                () -> assertEquals(2,Color.getColor(color_B))
        );
    }
    @Test
    void verifyColor(){
        assertAll(
                () -> assertTrue(Color.verifyColor(color_B)),
                () -> assertTrue(Color.verifyColor(color_A))
        );
    }
>>>>>>> c0588f5405f61daa17a1592cf8e484f922652fb7
}


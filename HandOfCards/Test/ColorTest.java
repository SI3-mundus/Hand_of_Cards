import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorTest {
    private String color_A="Spade";
    private String color_B="Heart";


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
}


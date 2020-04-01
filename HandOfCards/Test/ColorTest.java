import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorTest {
    private String color_A="Ca";
    private String color_B="Co";
    private Color color;
    @BeforeEach
    void setUp(){
       color=new Color();
    }


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
                () -> assertEquals(1,color.getColor(color_A)),
                () -> assertEquals(2,color.getColor(color_B))
        );
    }
    @Test
    void verifyColor(){
        assertAll(
                () -> assertTrue(color.verifyColor(color_B)),
                () -> assertTrue(color.verifyColor(color_A))
        );
    }
}


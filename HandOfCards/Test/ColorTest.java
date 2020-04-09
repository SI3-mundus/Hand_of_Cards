import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorTest {

    private String color_A="Ca";
    private String color_B="Co";
    private Color color;



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
    void getColor(){
        assertAll(
                () -> assertEquals(1,Color.getValueOfColor(color_A)),
                () -> assertEquals(2,Color.getValueOfColor(color_B))
        );
    }
    @Test
    void verifyColor(){
        assertAll(
                () -> assertTrue(Color.verifyColor(color_B),true),
                () -> assertTrue(Color.verifyColor(color_A))
        );
    }
}
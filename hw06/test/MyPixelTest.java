import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


/** 
 *  Use this file to test your implementation of Pixel.
 * 
 *  We will manually grade this file to give you feedback
 *  about the completeness of your test cases.
 */

public class MyPixelTest {


    /*
     * Remember, UNIT tests should ideally have one point of failure. Below we
     * give you an example of a unit test for the Pixel constructor that takes
     * in three ints as arguments. We use the getRed(), getGreen(), and
     * getBlue() methods to check that the values were set correctly. This one
     * test does not comprehensively test all of Pixel so you must add your own.
     *
     * You might want to look into assertEquals, assertTrue, assertFalse, and
     * assertArrayEquals at the following:
     * http://junit.sourceforge.net/javadoc/org/junit/Assert.html
     *
     * Note, if you want to add global variables so that you can reuse Pixels
     * in multiple tests, feel free to do so.
     */

    @Test
    public void testConstructInBounds() {
        Pixel p = new Pixel(40, 50, 60);
        assertEquals(40, p.getRed());
        assertEquals(50, p.getGreen());
        assertEquals(60, p.getBlue());
    }

    @Test
    public void testConstructOuttaBounds() {
        Pixel p = new Pixel(-1, 260, 0);
    	assertEquals(0, p.getRed());
    	assertEquals(255, p.getGreen());
    	assertEquals(0, p.getBlue());
    }
    
    @Test
    public void testNullColorComponentArray() {
    	Pixel p = new Pixel(null);
    	assertEquals(0, p.getRed());
    	assertEquals(0, p.getGreen());
    	assertEquals(0, p.getBlue());
    }
    
    @Test
    public void testPixelConstructArray() {
    	int [] colorArray = {40, 50, 60};
    	Pixel p = new Pixel(colorArray);
     	assertEquals(40, p.getRed());
    	assertEquals(50, p.getGreen());
    	assertEquals(60, p.getBlue());
    }
    
    @Test
    public void testPixelConstructArrayOuttaBounds() {
    	int [] colorArray = {-40, 350, 60};
    	Pixel p = new Pixel(colorArray);
     	assertEquals(0, p.getRed());
    	assertEquals(255, p.getGreen());
    	assertEquals(60, p.getBlue());
    }
    
    @Test
    public void testLessThanThreeEntries() {
    	int [] colorArray = {40, 50};
    	Pixel p = new Pixel(colorArray);
    	assertEquals(40, p.getRed());
    	assertEquals(50, p.getGreen());
    	assertEquals(0, p.getBlue());
    	assertEquals(colorArray, p.getComponents());
    }
    
    @Test
    public void testMoreThanThreeEntries() {
    	int [] colorArray = {40, 50, 60, 70};
    	Pixel p = new Pixel(colorArray);
     	assertEquals(40, p.getRed());
    	assertEquals(50, p.getGreen());
    	assertEquals(60, p.getBlue());
    }
    
    @Test
    public void testDistance() {
    	Pixel p1 = new Pixel(40, 50, 60);
    	Pixel p2 = new Pixel(10, 20, 30);
    	assertEquals(90, p1.distance(p2));
    }
    
    @Test
    public void testDistanceNull() {
    	Pixel p1 = new Pixel(40, 50, 60);
    	Pixel p2 = null;
    	assertEquals(-1, p1.distance(p2));
    }
    
    @Test
    public void testDistanceOuttaBounds() {
    	Pixel p1 = new Pixel(-1, 50, 60);
    	Pixel p2 = new Pixel(10, 20, 30);
    	assertEquals(70, p1.distance(p2));
    }
    

    @Test
    public void testToString() {
    	Pixel p = new Pixel(40, 50, 60);
    	assertEquals("(40, 50, 60)", p.toString());
    }
    
    @Test
    public void testToStringComponentArray() {
    	int [] colorArray = {40, 50, 60};
    	Pixel p = new Pixel(colorArray);
    	assertEquals("(40, 50, 60)", p.toString());
    }
    
    @Test
    public void testToStringOuttaBounds() {
    	Pixel p = new Pixel(-40, 50, 60);
    	assertEquals("(0, 50, 60)", p.toString());
    }
    
    @Test
    public void testEqualsTrue() {
    	Pixel p1 = new Pixel(40, 50, 60);
    	Pixel p2 = new Pixel(40, 50, 60);
    	assertTrue(p1.equals(p2));
    }
    
    @Test
    public void testEqualsFalse() {
    	Pixel p1 = new Pixel(40, 50, 60);
    	Pixel p2 = new Pixel(0, 50, 60);
    	assertFalse(p1.equals(p2));
    }
    
    @Test
    public void testEqualsTrueWithOuttaBounds() {
    	Pixel p1 = new Pixel(-1, 50, 260);
    	Pixel p2 = new Pixel(0, 50, 255);
    	assertTrue(p1.equals(p2));
    }
    
    @Test
    public void testEqualsTrueWithBothOuttaBounds() {
    	Pixel p1 = new Pixel(-1, 0, 260);
    	Pixel p2 = new Pixel(0, -50, 255);
    	assertTrue(p1.equals(p2));
    }
    
    @Test
    public void testEqualsFalseWithBothOuttaBounds() {
    	Pixel p1 = new Pixel(-1, 50, 260);
    	Pixel p2 = new Pixel(0, 50, -1);
    	assertFalse(p1.equals(p2));
    }
    
    @Test
    public void testEqualsFalseWithOuttaBounds() {
    	Pixel p1 = new Pixel(10, 50, 260);
    	Pixel p2 = new Pixel(0, 50, -1);
    	assertFalse(p1.equals(p2));
    }
    
    @Test
    public void testEqualsFalseWithNull() {
    	Pixel p1 = new Pixel(-1, 50, 260);
    	Pixel p2 = new Pixel(null);
    	assertFalse(p1.equals(p2));
    }
}

    

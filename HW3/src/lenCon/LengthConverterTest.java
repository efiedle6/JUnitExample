package lenCon;

/*Ed Fiedler
 * SE433 Section 901
 * Assignment 4
 */

import org.junit.*;
import static org.junit.Assert.*;
import static lenCon.LengthConverter.*; 

public class LengthConverterTest {
	//----For km to mile----
	
	@Test //test simple km to mile
	public void testKmToMile1(){
		LengthConverter lc = new LengthConverter();
		double km = 1.0;
		assertEquals(lc.kmToMile(km), 0.621371192, 0.0001);
	}
	
	@Test //test 0 km to mile
	public void testKmToMile2(){
		LengthConverter lc = new LengthConverter();
		double km = 0.0;
		assertEquals(lc.kmToMile(km), 0.0, 0.0001);
	}
	
	@Test //test MAX_VALUE km to mile
	public void testKmToMile3(){
		LengthConverter lc = new LengthConverter();
		double km = Double.MAX_VALUE;
		assertEquals(lc.kmToMile(km), (Double.MAX_VALUE*0.621371192), 0.0001);
	}
	
	@Test //test Negative km to mile
	public void testKmToMile4(){
		LengthConverter lc = new LengthConverter();
		double km = -1;
		try{
			lc.mileToKm(km);
			fail("Exception should have occured");
		} catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Distances must be positive or zero.\n");
		}
	}
	
	@Test //test Infinity km to mile
	public void testKmToMile5(){
		LengthConverter lc = new LengthConverter();
		double km = Double.POSITIVE_INFINITY;
		assertEquals(lc.kmToMile(km), (Double.POSITIVE_INFINITY*0.621371192), 0.0001);
	}
	
	//----For mile to km----
	
	@Test //test simple mile to km
	public void testMileToKm1(){
		LengthConverter lc = new LengthConverter();
		double mile = 0.621371192;
		assertEquals(lc.mileToKm(mile), 1.0, 0.0001);
	}
	
	@Test //test 0 mile to km
	public void testMileToKm2(){
		LengthConverter lc = new LengthConverter();
		double mile = 0.0;
		assertEquals(lc.mileToKm(mile), 0.0, 0.0001);
	}
	
	@Test //test MAX_VALUE mile to km
	public void testMileToKm3(){
		LengthConverter lc = new LengthConverter();
		double mile = Double.MAX_VALUE;
		assertEquals(lc.mileToKm(mile), (Double.MAX_VALUE/0.621371192), 0.0001);
	}
	
	@Test //test Negative mile to km
	public void testMileToKm4(){
		LengthConverter lc = new LengthConverter();
		double mile = -1;
		try{
			lc.mileToKm(mile);
			fail("Exception should have occured");
		} catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Distances must be positive or zero.\n");
		}
	}
	
	@Test //test Infinity mile to km
	public void testMileToKm5(){
		LengthConverter lc = new LengthConverter();
		double mile = Double.POSITIVE_INFINITY;
		assertEquals(lc.kmToMile(mile), (Double.POSITIVE_INFINITY/0.621371192), 0.0001);
	}

}

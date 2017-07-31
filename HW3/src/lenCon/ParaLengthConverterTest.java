package lenCon;

/*Ed Fiedler
 * SE433 Section 901
 * Assignment 4
 */

import org.junit.*;

import static org.junit.Assert.*;
import static lenCon.LengthConverter.*; 

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;


//Test class for kmToMile method
@RunWith(Parameterized.class)
public class ParaLengthConverterTest {
	//create a different set of parameters to test for each method and for illegal args
	private Type type;
	enum Type {kmToMile, mileToKm, forIllArg};
	private Object expected; //expected output could be string or double
	private double value; //input
	private double delta; //allowable difference
	
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
			//Type applies the values to the correct tests only	
			//in the order of {Type, expected, input value, delta}	
			{Type.kmToMile, 0.621371192, 1.0, 0.0001}, 
			{Type.kmToMile, 0.0, 0.0, 0.0001},
			{Type.kmToMile, Double.MAX_VALUE*0.621371192, Double.MAX_VALUE, 0.0001},
			{Type.kmToMile, Double.POSITIVE_INFINITY*0.621371192,Double.POSITIVE_INFINITY,0.0001},
			{Type.mileToKm, 1.0, 0.621371192, 0.0001}, 
			{Type.mileToKm, 0.0, 0.0, 0.0001},
			{Type.mileToKm, Double.MAX_VALUE/0.621371192, Double.MAX_VALUE, 0.0001},	
			{Type.mileToKm, Double.POSITIVE_INFINITY/0.621371192,Double.POSITIVE_INFINITY,0.0001},
			{Type.forIllArg, "Distances must be positive or zero.\n", -1, 0},
		});
	}
	
	//Constructor
	public ParaLengthConverterTest(Type type, Object expected, double value, double delta){
		this.type = type;
		this.expected = expected;
		this.value = value;
		this.delta = delta;
		
	}
	
	//for testing kmToMile
	@Test
	public void kmToMile(){
		//use assumeTrue to only test if it has the correct type
		Assume.assumeTrue(type== Type.kmToMile);
		LengthConverter lc = new LengthConverter();
		assertEquals((Double)expected, lc.kmToMile(value), delta);
	}
	
	//for testing mileToKm
	@Test
	public void mileToKm(){
		//use assumeTrue to only test if it has the correct type
		Assume.assumeTrue(type== Type.mileToKm);
		LengthConverter lc = new LengthConverter();
		assertEquals((Double)expected, lc.mileToKm(value), delta);
	}
	
	//for testing mileToKm illegal input
	@Test
	public void forIllArg(){
		//use assumeTrue to only test if it has the correct type
		Assume.assumeTrue(type== Type.forIllArg);
		LengthConverter lc = new LengthConverter();
		try{
			lc.mileToKm(value);
			fail("Exception should have occured");
		} catch (IllegalArgumentException e){
			assertEquals((String)expected, e.getMessage());
		}
	}
		
	//for testing kmToMile illegal input
	@Test
	public void forIllArg2(){
		//use assumeTrue to only test if it has the correct type
		Assume.assumeTrue(type== Type.forIllArg);
		LengthConverter lc = new LengthConverter();
		try{
			lc.kmToMile(value);
			fail("Exception should have occured");
		} catch (IllegalArgumentException e){
			assertEquals((String)expected, e.getMessage());
			}
		
	}
	
	
}

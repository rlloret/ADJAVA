package serpis.ad;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTest {

	@Test
	public void testMin() {
		
		assertEquals(2, Vector.min(new int[] {4,7,3,9,45,21,12,2}));
		assertEquals(2, Vector.min(new int[] {2,4,7,3,9,45,21,12}));
		assertEquals(2, Vector.min(new int[] {4,7,3,9,2,45,21,12}));
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testMinEmpty(){
		
		Vector.min(new int[]{});
		
	}
}

package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {

	@Test
	public void testConvertFoward(){
		int[] cipher = new int[26];

		Reflector r = Reflector.reflectorFactory("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		int expected = 1;
		int actual = r.convertForward(1);
		assertEquals(expected,actual);

	}

	/*@Test
	public void test_ConvertBackward()
	{
		Reflector r = Reflector.reflectorFactory("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		int expected = -1;
		int actual = r.convertBackward(1);
		assertEquals(expected,actual);
	}*/
}

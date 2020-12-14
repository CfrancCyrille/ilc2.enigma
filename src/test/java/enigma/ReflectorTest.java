package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {


	@Test
	public void testConvertFoward_Int_Int(){
		Reflector r = Reflector.reflectorFactory("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		int expected = 1;
		int actual = r.convertForward(1);
		assertEquals(expected,actual);

	}

}

package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {

	@Test
	public void testConvertForrward_1_1() {
		Reflector r1 = Reflector.reflectorFactory("ABCDEFGHIJKLMNOPQRETUVWXYZ");
		int expected = 1;
		int actual = r1.convertForward(1);
		assertEquals(expected, actual);

	}


}

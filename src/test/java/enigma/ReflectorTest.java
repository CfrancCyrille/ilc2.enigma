package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {

	Reflector refl = Reflector.reflectorFactory("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T");


	@Test
	public void test_ConvertForward_5_18() {
		int any = 5;
		int actual = refl.convertForward( any);
		int expected = 18;

		assertEquals(expected, actual);
	}

	@Test
	public void test_ConvertForward_7_3() {
		int any = 7;
		int actual = refl.convertForward( any);
		int expected = 3;

		assertEquals(expected, actual);
	}

	@Test
	public void test_ConvertForward_33_3() {
		int any = 33;
		int actual = refl.convertForward( any);
		int expected = 3; //'cause 33 % 26 is 7

		assertEquals(expected, actual);
	}


	@Test(expected = UnsupportedOperationException.class)
	public void test_convertBackward() {

		int actual = refl.convertBackward(1);
	}



}

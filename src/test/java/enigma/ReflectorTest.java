package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {

	Reflector reflectorB = Reflector
			.reflectorFactory("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T");

	@Test(expected=UnsupportedOperationException.class)
	public void convertBackward_Any_UnsupportedOperationException(){
		int any =5;
		int actual = reflectorB.convertBackward(any);
	}

	@Test
	public void convertForward_5_18(){
		int actual = reflectorB.convertForward(5);
		int expected = 18; // 5th letter of rotor
							// is S and S is the 19e letter in alphabet (18 if A=0)
		assertEquals(expected, actual);
	}

	@Test
	public void convertForward_31_18(){
		int actual = reflectorB.convertForward(31);
		int expected = 18; // 31 % 26 = 5th letter of rotor is S = 18
		assertEquals(expected, actual);
	}

	@Test
	public void convertForward_0_24(){
		int actual = reflectorB.convertForward(0);
		int expected = 24; // first letter of rotor is Y = 24
		assertEquals(expected, actual);
	}
}

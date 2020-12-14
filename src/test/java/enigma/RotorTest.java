package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {

	Rotor rotor1 = Rotor.rotorFactory(
			"E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");
	// GIVEN WHEN THEN
	@Test
	public void convertForward_5_6() {
		int actual = rotor1.convertForward(5);
		int expected = 6;

		assertEquals(expected, actual);
	}

	@Test
	public void convertForward_0_4() {
		int actual = rotor1.convertForward(0);
		int expected = 4;

		assertEquals(expected, actual);
	}

	@Test
	public void convertForward_31_25() {
		int actual = rotor1.convertForward(31);
		int expected = 6;

		assertEquals(expected, actual);
	}

	@Test
	public void convertBackward_5_6() {
		int actual = rotor1.convertBackward(5);
		int expected = 3;

		assertEquals(expected, actual);
	}

	@Test
	public void convertBackward_0_4() {
		int actual = rotor1.convertBackward(0);
		int expected = 20;

		assertEquals(expected, actual);
	}

	@Test
	public void convertBackward_31_25() {
		int actual = rotor1.convertBackward(31);
		int expected = 3;

		assertEquals(expected, actual);
	}

}

package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {

	Rotor rot = Rotor.rotorFactory(
			"E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");

	@Test
	public void test_Convert_Forward_1_10() {
		int expected = 10;
		int actual = rot.convertForward(1);

		assertEquals(expected, actual);
	}

	@Test
	public void test_Convert_Forward_11_19() {
		int expected = 19;
		int actual = rot.convertForward(11);

		assertEquals(expected, actual);
	}


	@Test
	public void test_Convert_Backward_14_12() {
		int expected = 12;
		int actual = rot.convertBackward(14);

		assertEquals(expected, actual);
	}

	@Test
	public void test_Convert_Backward_21_8() {
		int expected = 8;
		int actual = rot.convertBackward(21);

		assertEquals(expected, actual);
	}
}

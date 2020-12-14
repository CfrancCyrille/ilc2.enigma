package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Main;

public class MachineTest {
	
	String config ="* B III IV I AXLE";
	String msg1 = "FROM his shoulder Hiawatha";
	String code1 = "HYIHBSBOEBTWJZSXMWQKYGWSFR";
	String msg2 = "HYIHLBKOMLIUYDCMPPSFSZW";
	String code2 = "FROMHISSHOULDERHIAWATHA";
	
	@Test
	/**
	 * This is more a validation tests, than an unit test
	 */
	public void convert_Msg1_code1() {
		Machine m = new Machine();
		Main.configure(m, config);
		String expected = code1;
		String actual = m.convert(msg1);
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * This is more a validation tests, than an unit test
	 */
	public void Test_setPosition() {
		Machine m = new Machine();
		Main.configure(m, config);

		String actual = new String("ABCD");
		m.setPositions(actual);

		assertEquals(m.getReflector().getPosition(), actual.toCharArray()[0], 'A');
		assertEquals(m.getLeftRotor().getPosition(), actual.toCharArray()[1], 'A');
		assertEquals(m.getMiddleRotor().getPosition(), actual.toCharArray()[2], 'A');
		assertEquals(m.getRightRotor().getPosition(), actual.toCharArray()[3], 'A');
	}

	@Test
	/**
	 * This is more a validation tests, than an unit test
	 */
	public void Test_advanceRotors_rightPosition() {
		Machine m = new Machine();
		Main.configure(m, config);

		m.getRightRotor().setPosition(25);
		m.advanceRotors();

		assertEquals(m.getRightRotor().getPosition(), 0);
	}


}

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

	Machine m = new Machine();

	@Test
	/**
	 * This is more a validation tests, than an unit test
	 */
	public void convert_Msg1_code1() {

		Main.configure(m, config);
		String expected = code1;
		String actual = m.convert(msg1);
		assertEquals(expected, actual);
	}

	@Test
	/**
	 * This is more a validation tests, than an unit test
	 */
	public void unconvert_Msg2_code2() {

		Main.configure(m, config);
		String expected = code2;
		String actual = m.convert(msg2);
		assertEquals(expected, actual);
	}

	@Test
	 /* GIVEN_WHEN_THEN
	 */
	public void test_setPosition()
	{
		Main.configure(m, config);

		String actual = new String("1234");
		m.setPositions(actual);

		assertEquals(m.getReflector().getPosition(),actual.toCharArray()[0], 'A');
		assertEquals(m.getLeftRotor().getPosition(),actual.toCharArray()[1], 'A');
		assertEquals(m.getMiddleRotor().getPosition(),actual.toCharArray()[2], 'A');
		assertEquals(m.getRightRotor().getPosition(),actual.toCharArray()[3], 'A');
	}

	@Test
	public void test_advanceRotors_RightFinalPosition_RightStartposition()
	{
		Main.configure(m, config);

		m.getRightRotor().setPosition(25);
		m.advanceRotors();

		assertEquals(m.getRightRotor().getPosition(),0);
	}



}

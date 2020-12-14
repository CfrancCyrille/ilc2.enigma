package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Main;

public class MachineTest {

	Machine m = new Machine();

	String config ="* B III IV I AXLE";
	String msg1 = "FROM his shoulder Hiawatha";
	String code1 = "HYIHBSBOEBTWJZSXMWQKYGWSFR";
	String msg2 = "HYIHLBKOMLIUYDCMPPSFSZW";
	String code2 = "FROMHISSHOULDERHIAWATHA";



	Rotor leftRotor = Rotor.rotorFactory(
			"B D F H J L C P R T X V Z N Y E I W G A K M U S Q O", "B");
	Rotor middleRotor = Rotor.rotorFactory(
			"E S O V P Z J A Y Q U I R H X L N F T G K D C M W B", "B");
	Rotor rightRotor = Rotor.rotorFactory(
			"E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "B");

	Reflector reflectorB = Reflector
			.reflectorFactory("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T");



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
	public void test_AdvanceRotors_leftNotch_advRight() {
		String setting = "ABAA";
		m.configure(reflectorB, leftRotor, middleRotor, rightRotor, setting);

		// only right should advance
		int expected_left = 1;
		int expected_middle = middleRotor.getPosition();
		int expected_right = rightRotor.getPosition() + 1;

		m.advanceRotors();

		int actual_left = leftRotor.getPosition();
		int actual_middle = middleRotor.getPosition();
		int actual_right = rightRotor.getPosition();

		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);

	}

	@Test
	public void test_AdvanceRotors_middleNotch_advAll() {
		String setting = "AABA";
		m.configure(reflectorB, leftRotor, middleRotor, rightRotor, setting);

		// right, Left and middle should advance
		int expected_left = leftRotor.getPosition() + 1;
		int expected_middle = middleRotor.getPosition() + 1;
		int expected_right = rightRotor.getPosition() + 1;

		m.advanceRotors();

		int actual_left = leftRotor.getPosition();
		int actual_middle = middleRotor.getPosition();
		int actual_right = rightRotor.getPosition();

		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);

	}

	@Test
	public void test_AdvanceRotors_rightNotch_advMiddleRight() {
		String setting = "AAAB";
		m.configure(reflectorB, leftRotor, middleRotor, rightRotor, setting);

		// only right and middle should advance
		int expected_left = leftRotor.getPosition();
		int expected_middle = middleRotor.getPosition() + 1;
		int expected_right = rightRotor.getPosition() + 1;

		m.advanceRotors();

		int actual_left = leftRotor.getPosition();
		int actual_middle = middleRotor.getPosition();
		int actual_right = rightRotor.getPosition();

		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);

	}

	@Test
	public void test_AdvanceRotors_AnyNotch_advRight() {
		String setting = "AAAA";
		m.configure(reflectorB, leftRotor, middleRotor, rightRotor, setting);

		// only right should advance
		int expected_left = leftRotor.getPosition();
		int expected_middle = middleRotor.getPosition();
		int expected_right = rightRotor.getPosition() + 1;

		m.advanceRotors();

		int actual_left = leftRotor.getPosition();
		int actual_middle = middleRotor.getPosition();
		int actual_right = rightRotor.getPosition();

		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);

	}








	@Test
	public void test_SetPosition_reflector() {
		Machine m = new Machine();
		String settings = "ABCD";

		m.configure(reflectorB, leftRotor, middleRotor, rightRotor, settings);

		int expected = 0;
		int actual = reflectorB.getPosition();

		assertEquals(expected, actual);
	}

	@Test
	public void test_SetPosition_rotorLeft() {
		String settings = "ABCD";

		m.configure(reflectorB, leftRotor, middleRotor, rightRotor, settings);

		int expected = 1;
		int actual = leftRotor.getPosition();

		assertEquals(expected, actual);
	}

	@Test
	public void test_SetPosition_rotorMiddle() {
		Machine m = new Machine();
		String settings = "ABCD";

		m.configure(reflectorB, leftRotor, middleRotor, rightRotor, settings);

		int expected = 2;
		int actual = middleRotor.getPosition();

		assertEquals(expected, actual);
	}

	@Test
	public void test_SetPosition_rotorRight() {
		Machine m = new Machine();
		String settings = "ABCD";

		m.configure(reflectorB, leftRotor, middleRotor, rightRotor, settings);

		int expected = 3;
		int actual = rightRotor.getPosition();

		assertEquals(expected, actual);
	}
}

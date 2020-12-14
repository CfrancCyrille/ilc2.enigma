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
	public void unconvert_Msg2_code2() {
		Machine m = new Machine();
		Main.configure(m, config);
		String expected = code2;
		String actual = m.convert(msg2);
		assertEquals(expected, actual);
	}

// **********************************************************
// **********************************************************
// **********************************************************

	Machine m = new Machine();

	Rotor left = Rotor.rotorFactory(
			"A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", "B");
	Rotor middle = Rotor.rotorFactory(
			"A J D K S I R U X B L H W T M C Q G Z N P Y F V O E", "B");
	Rotor right = Rotor.rotorFactory(
			"B D F H J L C P R T X V Z N Y E I W G A K M U S Q O", "B");
	Reflector reflector = Reflector
			.reflectorFactory("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T");

	String setting = "ABCD";

	// GIVEN_WHEN_THEN
	@Test
	public void setPositions_ABCD_0123() {
		m.configure(reflector, left, middle, right, setting);

		int expected_reflector = 0; // A - A = 0
		int expected_left = 1; // A - A = 1
		int expected_middle = 2; // C - A = 2
		int expected_right = 3; // D - A = 3

		int actual_reflector = reflector.getPosition();
		int actual_left = left.getPosition();
		int actual_middle = middle.getPosition();
		int actual_right = right.getPosition();

		assertEquals(expected_reflector, actual_reflector);
		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);
	}

	// GIVEN_WHEN_THEN
	@Test
	public void setPositions__ZYXW__25_24_23_22() {
		String setting = "ZYXW";
		m.configure(reflector, left, middle, right, setting);

		int expected_reflector = 25; // Z - A
		int expected_left = 24; // Y - A
		int expected_middle = 23; // X - A
		int expected_right = 22; // W - A

		int actual_reflector = reflector.getPosition();
		int actual_left = left.getPosition();
		int actual_middle = middle.getPosition();
		int actual_right = right.getPosition();

		assertEquals(expected_reflector, actual_reflector);
		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);
	}

	// GIVEN_WHEN_THEN
	@Test(expected=IndexOutOfBoundsException.class)
	public void setPosition_ABC_IndexOutOfBoundsException(){
		String setting = "ABC";
		m.configure(reflector, left, middle, right, setting);
	}

	@Test
	public void setPosition_ABCDE_0123(){
		String setting = "ABCDE";
		m.configure(reflector, left, middle, right, setting);

		int expected_reflector = 0; // A - A = 0
		int expected_left = 1; // A - A = 1
		int expected_middle = 2; // C - A = 2
		int expected_right = 3; // D - A = 3

		int actual_reflector = reflector.getPosition();
		int actual_left = left.getPosition();
		int actual_middle = middle.getPosition();
		int actual_right = right.getPosition();

		assertEquals(expected_reflector, actual_reflector);
		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);
	}

	// GIVEN WHEN THEN
	@Test
	public void advanceRotors_leftAtNotch_advanceRight(){
		String setting = "ABAA";
		m.configure(reflector, left, middle, right, setting);

		// only Left and middle should advance
		int expected_left = 1;
		int expected_middle = 0;
		int expected_right = 0+1;

		m.advanceRotors();

		int actual_left = left.getPosition();
		int actual_middle = middle.getPosition();
		int actual_right = right.getPosition();

		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);
	}

	// GIVEN WHEN THEN
	@Test
	public void advanceRotors_middleAtNotch_advanceLeftMiddleRight(){
		String setting = "AABA";
		m.configure(reflector, left, middle, right, setting);

		// only Left and middle should advance
		int expected_left = 0+1;
		int expected_middle = 1+1;
		int expected_right = 0+1;

		m.advanceRotors();

		int actual_left = left.getPosition();
		int actual_middle = middle.getPosition();
		int actual_right = right.getPosition();

		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);
	}

	// GIVEN WHEN THEN
	@Test
	public void advanceRotors_rightAtNotch_advanceMiddleRight(){
		String setting = "AAAB";
		m.configure(reflector, left, middle, right, setting);

		// only Left and middle should advance
		int expected_left = 0;
		int expected_middle = 0+1;
		int expected_right = 1+1;

		m.advanceRotors();

		int actual_left = left.getPosition();
		int actual_middle = middle.getPosition();
		int actual_right = right.getPosition();

		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);
	}

	// GIVEN WHEN THEN
	@Test
	public void advanceRotors_noneAtNotch_advanceRight(){
		String setting = "AAAA";
		m.configure(reflector, left, middle, right, setting);

		// only Left and middle should advance
		int expected_left = 0;
		int expected_middle = 0;
		int expected_right = 0+1;

		m.advanceRotors();

		int actual_left = left.getPosition();
		int actual_middle = middle.getPosition();
		int actual_right = right.getPosition();

		assertEquals(expected_left, actual_left);
		assertEquals(expected_middle, actual_middle);
		assertEquals(expected_right, actual_right);
	}

}

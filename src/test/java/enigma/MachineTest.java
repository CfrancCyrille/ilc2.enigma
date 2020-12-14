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
	
	@Test
	/**
	 * setPositions
	 * When input is a string of size 4
	 * Then the positions change
	 */
	public void setPositions_stringOfSize4_negativeOnesChanges() {
		
		String settings = "ABCD";
		m.initRotors(reflector, leftRotor, middleRotor, rightRotor);
		
		int unexpected1 = -1, unexpected2 = -1, unexpected3 = -1, unexpected4 = -1;
		reflector.setPosition(unexpected1);
		leftRotor.setPosition(unexpected2);
		middleRotor.setPosition(unexpected3);
		rightRotor.setPosition(unexpected4);
		m.setPositions(settings);
		int actual1 = reflector.getPosition(), actual2 = leftRotor.getPosition(), 
				actual3 = middleRotor.getPosition(), actual4 = rightRotor.getPosition();
		assertNotEquals(unexpected1, actual1);
		assertNotEquals(unexpected2, actual2);
		assertNotEquals(unexpected3, actual3);
		assertNotEquals(unexpected4, actual4);
	}
	

	@Test(expected = IndexOutOfBoundsException.class)
	/**
	 * setPositions
	 * When input is a string of size less than 4
	 * Then IndexOutOfBoundsException
	 */
	public void advanceRotors_stringOfSizeLessThan4_IndexOutOfBoundsException() {

		String settings = "ABC";
		m.initRotors(reflector, leftRotor, middleRotor, rightRotor);

		m.setPositions(settings);

	}
	
	Machine m = new Machine();
	Rotor leftRotor = Rotor.rotorFactory(
			"E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");
	Rotor middleRotor = Rotor.rotorFactory(
			"E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");
	Rotor rightRotor = Rotor.rotorFactory(
			"E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");
	Reflector reflector = Reflector
			.reflectorFactory("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T");

}

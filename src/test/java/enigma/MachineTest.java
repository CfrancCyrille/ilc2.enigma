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
	
	
	Rotor leftRotor = Rotor.rotorFactory("E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");
	Rotor middleRotor = Rotor.rotorFactory("A J D K S I R U X B L H W T M C Q G Z N P Y F V O E", "E");
	Rotor rightRotor = Rotor.rotorFactory("B D F H J L C P R T X V Z N Y E I W G A K M U S Q O", "V");
	Reflector reflector = Reflector.reflectorFactory("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T");

	String setting = "1234";
	Machine m = new Machine();

	
	@Test
	/*
	 * GIVEN_WHEN_THEN
	 */
	public void setPositions_reflector_toIndex1() {
		
		m.configure(reflector, leftRotor, middleRotor, rightRotor, setting);
		
		int expected = reflector.toIndex('1');
		assertEquals(expected, reflector.getPosition());
		
	}
	
	@Test
	/*
	 * GIVEN_WHEN_THEN
	 */
	public void setPositions_leftRotor_toIndex2() {
		m.configure(reflector, leftRotor, middleRotor, rightRotor, setting);
		
		int expected = leftRotor.toIndex('2');
		assertEquals(expected, leftRotor.getPosition());
	}
	
	@Test
	/*
	 * GIVEN_WHEN_THEN
	 */
	public void setPositions_middleRotor_toIndex3() {
		m.configure(reflector, leftRotor, middleRotor, rightRotor, setting);
		
		int expected = leftRotor.toIndex('3');
		assertEquals(expected, middleRotor.getPosition());
	}
	
	@Test
	/*
	 * GIVEN_WHEN_THEN
	 */
	public void setPositions_rightRotor_toIndex4() {
		m.configure(reflector, leftRotor, middleRotor, rightRotor, setting);
		
		int expected = leftRotor.toIndex('4');
		assertEquals(expected, rightRotor.getPosition());
	}
	
	

}

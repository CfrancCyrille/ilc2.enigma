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
        public void setPositions_ABCD_0123(){
            Machine machine_test = new Machine();
            Main.configure(machine_test, config);
            
            machine_test.setPositions("ABCD");
            
            assertEquals(machine_test.getReflector().getPosition(), 0);
            assertEquals(machine_test.getLeftRotor().getPosition(), 1);
            assertEquals(machine_test.getMiddleRotor().getPosition(), 2);
            assertEquals(machine_test.getRightRotor().getPosition(), 3);
        }
        
        @Test(expected=Exception.class)
        public void setPositions_stringTooShort_exception(){
            Machine machine_test = new Machine();
            Main.configure(machine_test, config);
            
            machine_test.setPositions("AB");
        }
        
        @Test
        public void advanceRotors_rightEndPosition_rightStartPosition(){
            Machine machine_test = new Machine();
            Main.configure(machine_test, config);
            
            machine_test.getRightRotor().setPosition(25);
            
            machine_test.advanceRotors();
            
            assertEquals(machine_test.getRightRotor().getPosition(), 0);
        }
        
        @Test
        public void advanceRotors_middleAtNotch_allRotorAdvance(){
            Machine machine_test = new Machine();
            Main.configure(machine_test, config);
            
            machine_test.getLeftRotor().setPosition(25);
            machine_test.getMiddleRotor().setPosition(-1);
            machine_test.getRightRotor().setPosition(10);
            
            machine_test.advanceRotors();
            
            assertEquals(machine_test.getLeftRotor().getPosition(), 0);
            assertEquals(machine_test.getMiddleRotor().getPosition(), 0);
            assertEquals(machine_test.getRightRotor().getPosition(), 11);
        }

}

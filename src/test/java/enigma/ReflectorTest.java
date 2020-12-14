package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {

	Rotor rotor = Rotor.rotorFactory(
			"E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");
	
	@Test
	public void convertForward_1_differentNumber() {
		int p = 1;
		int unexpected = p;
		int actual = rotor.convertForward(p);
		assertNotEquals(unexpected, actual);
	}
	
	@Test
	public void convertBackward_1_differentNumber() {
		int p = 1;
		int unexpected = p;
		int actual = rotor.convertForward(p);
		assertNotEquals(unexpected, actual);
	}

}

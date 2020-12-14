package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {

	Reflector reflector = Reflector
			.reflectorFactory("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T");
	
	@Test
	public void convertForward_1_differentNumber() {
		int p = 1;
		int unexpected = p;
		int actual = reflector.convertForward(p);
		assertNotEquals(unexpected, actual);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void convertBackward_Anything_UnsupportedOperationException() {
		int p = 1;
		reflector.convertBackward(p);
	}

}

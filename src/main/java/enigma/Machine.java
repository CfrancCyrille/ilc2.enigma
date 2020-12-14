package enigma;

public class Machine {

	/**
	 * The enigma machine is compososed of 3 rotors and one reflector
	 * to connect each rotors and advance its rotors once a character has
	 * been encrypted. It returns the encryption of a given message
	 */


	private Rotor leftRotor;
	private Rotor middleRotor;
	private Rotor rightRotor;
	private Reflector reflector;

	/**
	 * Initialize the machine and its rotors
	 * @param reflector the reflector of the machine
	 * @param left the left rotor
	 * @param middle the middle rotor
	 * @param right the right rotor
	 */
	public void initRotors(Reflector reflector, Rotor left, Rotor middle, Rotor right) {
		this.reflector = reflector;
		leftRotor = left;
		middleRotor = middle;
		rightRotor = right;
	}

	/**
	 * Set the rotors position accroding to the given settings
	 * @param setting the 4 settings (reflector , and 3 rotors)
	 */
	public void setPositions(String setting) {
		char[] charSettings = setting.toCharArray();
		reflector.setPosition(Rotor.toIndex(charSettings[0]));
		leftRotor.setPosition(Rotor.toIndex(charSettings[1]));
		middleRotor.setPosition(Rotor.toIndex(charSettings[2]));
		rightRotor.setPosition(Rotor.toIndex(charSettings[3]));
	}

	/**
	 * Configure the rotors and its positions according to the settings
	 * @param reflector the reflector of the machine
	 * @param left the left rotor
	 * @param middle the middle rotor
	 * @param right the right rotor
	 * @param setting the stringified settings
	 */
	public void configure(Reflector reflector, Rotor left, Rotor middle, Rotor right, String setting) {
		this.initRotors(reflector, left, middle, right);
		this.setPositions(setting);
	}

	/**
	 * Encrypt a message accordign to the existing settings
	 * @param msg the given message to encrypt
	 * @return the encrypted message in upper case
	 */
	public String convert(String msg) {
		msg = msg.toUpperCase();
		char[] msgChars = msg.toCharArray();
		String result = "";
		for (char c : msgChars) {
			result += convertChar(c);
		}
		return result;
	}

	/**
	 * @param c char to be converted
	 * @return the encrypted character
	 */
	char convertChar(char c) {
		advanceRotors();
		int charIndex = Rotor.toIndex(c);
		int output;
		output = rightRotor.convertForward(charIndex);
		output = middleRotor.convertForward(output);
		output = leftRotor.convertForward(output);
		output = reflector.convertForward(output);
		output = leftRotor.convertBackward(output);
		output = middleRotor.convertBackward(output);
		output = rightRotor.convertBackward(output);
		return Rotor.toLetter(output);

	}

	/**
	 * Advance all the rotors according to the enigma principles
	 * the letter after (for ex : B -> C) and when we advance letter Z, it becomes A
	 */
	void advanceRotors() {
		boolean advanceLeft = false;
		boolean advanceMiddle = false;
		boolean advanceRight = true;
		if (leftRotor.atNotch()) {
		}
		if (middleRotor.atNotch()) {
			advanceMiddle = true;
			advanceLeft = true;
		}
		if (rightRotor.atNotch()) {
			advanceMiddle = true;
			advanceRight = true;
		}
		if (advanceLeft) {
			leftRotor.advance();
		}
		if (advanceRight) {
			rightRotor.advance();
		}
		if (advanceMiddle) {
			middleRotor.advance();
		}
	}
}

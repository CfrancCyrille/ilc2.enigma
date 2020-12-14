package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends Rotor {
	
	int[] reflection;

	/**
	 *
	 * @param str
	 * @return
	 */
	public static Reflector reflectorFactory(String str){
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}

	/**
	 *
	 * @param r
	 */
	Reflector(int[] r){
		super(r,0);
		reflection = r;
	}

	/**
	 *
	 * @param p
	 * @return
	 */
    public int convertForward(int p) {
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }

	/**
	 *
	 * @param unused
	 * @return
	 */
	@Override
    public int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

	/**
	 * Override advance method
	 */
	@Override
    public void advance() {
    }

}

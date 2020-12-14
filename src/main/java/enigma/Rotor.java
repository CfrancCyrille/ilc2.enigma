package enigma;

public class Rotor {


    private int position;
    private int[] cipher = new int[26];
    private int[] bcipher = new int[26];
    private int notch1 = -1;
    private int notch2 = -1;

    /**
     *
     * @return position
     */
    public int getPosition() {
        return position;
    }

    /**
     *
     * @param posn
     */
    public void setPosition(int posn) {
        position = posn;
    }

    /**
     *
     * @param str
     * @param notches
     * @return a new rotor
     */
	public static Rotor rotorFactory(String str, String notches){
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		s = notches.trim().replace(" and ", "").toCharArray();
		if (s.length == 2){
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}
		
	}

    /**
     *
     * @param c
     * @param notch1
     * @param notch2
     */
	Rotor(int[] c, int notch1, int notch2) {
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}

    /**
     *
     * @param c
     * @param notch1
     */
	Rotor(int[] c, int notch1) {
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}

    /**
     *
     * @param p
     * @return the converted index by the rotor
     */
    public int convertForward(int p) {
        return ((cipher[((p+position)%26+26)%26]-position)%26+26)%26;
    }

    /**
     *
     * @param e
     * @return the converted index by the rotor
     */
    public int convertBackward(int e) {
        return ((bcipher[((e+position)%26+26)%26]-position)%26+26)%26;
    }

    /**
     *
     */
    public void advance() {
        position = (position+1) % 26;
    }

    /**
     *
     * @return
     */
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }

    /**
     *
     * @param p
     * @return
     */
    protected static char toLetter(int p) {
        return (char)(p + 'A');
    }

    /**
     *
     * @param c
     * @return
     */
    protected static int toIndex(char c) {
        return c - 'A';
    }

    /**
     *
     */
    private void createBCipher() {
		for(int i =0; i<26; i++)
			bcipher[cipher[i]] = i;
	}



}

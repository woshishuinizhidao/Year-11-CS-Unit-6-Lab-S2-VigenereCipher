public class VigenereCipher {

    private String alphabet;
    private String key;

    public VigenereCipher(String key) {
        this.key = key.toLowerCase();
        this.alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public String getAlphabet() {
        return alphabet;
    }

    public String getKey() {
        return key;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String encode(String encodeMe) {
        encodeMe = encodeMe.toLowerCase();
        String lengthenedKey = calculateLengthenedKey(encodeMe);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodeMe.length(); i++) {

            String charToString = "" + encodeMe.charAt(i);
            if (alphabet.contains(charToString)) sb.append((char)calculateShiftedCharactersDecimalEncode(encodeMe.charAt(i), lengthenedKey.charAt(i)));
            else sb.append(charToString);

        }
        return sb.toString();
    }

    public String decode(String decodeMe) {
        decodeMe = decodeMe.toLowerCase();
        String lengthenedKey = calculateLengthenedKey(decodeMe);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < decodeMe.length(); i++) {

            String charToString = "" + decodeMe.charAt(i);
            if (alphabet.contains(charToString)) sb.append((char)calculateShiftedCharactersDecimalDecode(decodeMe.charAt(i), lengthenedKey.charAt(i)));
            else sb.append(charToString);
        }
        return sb.toString();
    }

    private String calculateLengthenedKey(String message) {
        StringBuilder sb = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < message.length(); i++) {
            sb.append(key.charAt(keyIndex++));
            if (keyIndex == key.length()) keyIndex = 0;
        }
        return sb.toString();
    }

    private int calculateShiftedCharactersDecimalEncode(char characterInMessage, char characterInKey) {

        int characterInMessageAscii = characterInMessage;

        int characterInKeyAscii= characterInKey;

        int shiftAmount = characterInKeyAscii - 97;

        int encodedCharacter = characterInMessageAscii + shiftAmount;

        if (encodedCharacter > 122) encodedCharacter -= 26;

        return encodedCharacter;
    }

    private int calculateShiftedCharactersDecimalDecode(char characterInMessage, char characterInKey) {

        int characterInMessageAscii = characterInMessage;
        int characterInKeyAscii= characterInKey;

        int shiftAmount = characterInKeyAscii - 97;

        int encodedCharacter = characterInMessageAscii - shiftAmount;

        if (encodedCharacter < 97) encodedCharacter += 26;

        return encodedCharacter;

    }

    public static void main(String[] args) {

        VigenereCipher vigenereCipher = new VigenereCipher("lemon");
        String encodedMessage = vigenereCipher.encode("attack!atdawn");
        System.out.println(encodedMessage);

//        String decodedMessage = vigenereCipher.decode("lxfopvefrnhr");
//        System.out.println(decodedMessage);

    }
}

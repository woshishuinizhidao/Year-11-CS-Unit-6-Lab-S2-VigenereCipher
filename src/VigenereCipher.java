public class VigenereCipher {
    private String alphabet;
    private String key;
    public VigenereCipher(String key){
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }

    public String getKey(){
        return key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String getAlphabet(){ return alphabet; }

    public String encode(String decText){
        int a = decText.length();
        char[] encText = new char[a];

        for (int i = 0; i < a; i++){
            if(i == key.length()){
                i = 0;
            }
            if(i == a||key.length()==a){
                break;
            }
            key += (key.charAt(i));
        }

        decText = decText.toLowerCase();
        for (int i = 0; i < a; i++){
            if(alphabet.indexOf(decText.charAt(i))!=-1){
                encText[i]=(char)(((decText.charAt(i)+key.charAt(i)+14)%26)+'A');
            }
            else if(alphabet.indexOf(decText.charAt(i))==-1){
                encText[i]=decText.charAt(i);
            }
        }
        return (String.valueOf(encText)).toLowerCase();
    }

    public String decode(String encText){
        int a = encText.length();
        char[] decText = new char[a];

        for (int i = 0; i < a; i++){
            if(i == key.length()){
                i = 0;
            }
            if(i == a||key.length()==a){
                break;
            }
            key += (key.charAt(i));
        }

        encText = encText.toLowerCase();
        for (int i = 0; i < a; i++){
            if(alphabet.indexOf(encText.charAt(i))!=-1){
                decText[i]=(char)(((encText.charAt(i)-key.charAt(i)+26)%26)+'A');
            }
            else if(alphabet.indexOf(encText.charAt(i))==-1){
                decText[i]=encText.charAt(i);
            }
        }
        return (String.valueOf(decText)).toLowerCase();
    }

}

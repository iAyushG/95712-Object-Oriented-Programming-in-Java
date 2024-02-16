/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package exam2;

public class Keyword extends Message {
	
	@Override
	public String encrypt() {
		StringBuilder encrypted = new StringBuilder();
		
		for(int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if(ch != ' ') {
                int shift = key.charAt(i % key.length()) - 'a' + 1;
                char c = (char) ((ch - 'a' + shift) % 26 + 'a');
                encrypted.append(c);
            } 
            else {
                encrypted.append(' ');
            }
        }
		
        return encrypted.toString();
	}

	@Override
	public String decrypt() {
		StringBuilder decrypted = new StringBuilder();
        
        for(int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if(ch != ' ') {
                int shift = key.charAt(i % key.length()) - 'a' + 1;
                char c = (char) ((ch - 'a' - shift + 26) % 26 + 'a');
                decrypted.append(c);
            } 
            else {
                decrypted.append(' ');
            }
        }
        
        return decrypted.toString();
    }
}
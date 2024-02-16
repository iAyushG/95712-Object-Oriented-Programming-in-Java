/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package exam2;

public class Caesar extends Message {
	
	@Override
	public String encrypt() {
		 StringBuilder encrypted = new StringBuilder();
	        int shift = Integer.parseInt(key);
	        
	        for(char ch : message.toCharArray()) {
	            if(ch != ' ') {
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
        int shift = Integer.parseInt(key);
        
        for(char ch : message.toCharArray()) {
            if(ch != ' ') {
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
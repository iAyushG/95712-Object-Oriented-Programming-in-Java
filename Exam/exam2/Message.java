/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package exam2;

public abstract class Message implements Encryptable {
	String message;
	String key;
	
	void setMessage(String message, String key) {
		this.message = message;
		this.key = key;
	}
}
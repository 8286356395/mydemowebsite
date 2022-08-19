package library.encryption;


import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Encryption {
	private static final String ALGORITHM = "AES";
	private static final byte[] keyValue = "1234567891234567".getBytes();



	private Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		return key;
	}

	public String encrypt(String valueToEnc) throws Exception {

		Key key = generateKey();
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] encValue = cipher.doFinal(valueToEnc.getBytes());
		byte[] encryptedByteValue = new Base64().encode(encValue);
		

		return new String(encryptedByteValue);
	}

	public String decrypt(String encryptedValue) throws Exception { // Key key = generateKey(); Cipher
		Key key = generateKey();
		Cipher cipher = Cipher.getInstance(ALGORITHM); // cipher =
		// Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);

		byte[] decodedBytes = new Base64().decode(encryptedValue.getBytes());

		byte[] enctVal = cipher.doFinal(decodedBytes);

		
		return new String(enctVal);
	}

}
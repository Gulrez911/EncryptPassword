package com.gul.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHA512Example {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String passwordToHash = "password";
//		System.out.println("Main Salt: " + salt);
		String securePassword;
		for (int i = 1; i <= 10; i++) {
			byte[] salt = getSalt();
			securePassword = get_SHA_512_SecurePassword(passwordToHash, salt);
			System.out.println(securePassword);
		}

	}

	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
//		System.out.println("Salt: " + salt);
		return salt;
	}

	private static String get_SHA_512_SecurePassword(String passwordToHash, byte[] salt) {
		// Use MessageDigest md = MessageDigest.getInstance("SHA-512");
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
}

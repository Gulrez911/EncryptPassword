package com.gul.test;

import org.mindrot.jbcrypt.BCrypt;

public class BcryptPassword {
	private static int workload = 12;

	public static void main(String[] args) {
		String test_password = "1234";
		String test_hash = "$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC";
		System.out.println("Test Password: " + test_password);
		System.out.println("Test Stored Hash: " + test_hash);
		String computed_hash = hashPassword(test_password);
		System.out.println("Test computed hash: " + computed_hash);
		System.out.println();
		System.out.println("Verifying that hash and  stored hash both match for test password...");
		System.out.println();
		System.out.println("Test Computed hash: " + computed_hash);
		String compare_test = checkPassword(test_password, test_hash) ? "Passwords Match"
				: "Passwords do not match";
		String compare_computed = checkPassword(test_password, computed_hash) ? "Passwords Match"
				: "Passwords do not match";

		System.out.println("Verify against stored hash: " + compare_test);
		System.out.println("Verify against coputed hash: " + compare_computed);
	}

	public static String hashPassword(String plainText) {
		String salt = BCrypt.gensalt(workload);
		System.out.println("Salt: "+salt);
		String hash_pasword = BCrypt.hashpw(plainText, salt);
		return hash_pasword;
	}

	public static boolean checkPassword(String plaintext, String computed_hash) {
		boolean password_verified = false;
		password_verified = BCrypt.checkpw(plaintext, computed_hash);
		return password_verified;
	}

}

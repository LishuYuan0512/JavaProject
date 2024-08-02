/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rosal
 */
public class InputValidator {
   /**
     * Validates if the given email is in the correct format.
     *
     * @param email the email address to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
        );
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Validates if the given phone number is a 10-digit number.
     *
     * @param phone the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    public static boolean isValidPhone(String phone) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * Validates the password to ensure it meets the criteria.
     * Criteria: At least 4 characters, containing at least one letter and one number.
     *
     * @param password the password to validate
     * @return true if the password is valid, false otherwise
     */
    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * Validates if the two passwords match.
     *
     * @param password the password
     * @param retypePassword the password confirmation
     * @return true if the passwords match, false otherwise
     */
    public static boolean doPasswordsMatch(String password, String retypePassword) {
        return password.equals(retypePassword);
    }
}
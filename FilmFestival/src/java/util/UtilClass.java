/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Igor
 */
public class UtilClass {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }
    
    public static final Pattern VALID_PHONE_NUMBER_REGEX = 
        Pattern.compile("[(^\\+[0-9]{3}\\s[0-9]{2}\\s[0-9]{3}\\s[0-9]{4}) | (^0[0-9]{2}\\s[0-9]{3}\\s[0-9]{4}) | (^[0-9]{9,10})]", Pattern.CASE_INSENSITIVE);

    public static boolean validatePhone(String phone) {
        Matcher matcher = VALID_PHONE_NUMBER_REGEX .matcher(phone);
        return matcher.find();
    }
}

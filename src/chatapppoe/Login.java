//******************************************************************************
//                                   START                                      
//******************************************************************************
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapppoe;

import java.util.regex.Pattern;

/**
 *
 * @author Sabbir Nirob ST10446290 sabbirnirob1000@gmail.com
 */

//******************************************************************************

public class Login {
    
    // These variables store the user's registration information.
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;
    // Stores the username and password entered during login.
    private String loginUsername;
    private String loginPassword;
    
    public Login(String firstName, String lastName, String username,
        String password, String cellPhoneNumber) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.cellPhoneNumber = cellPhoneNumber;
}
    
    // Stores the username entered during login.
    public void setLoginUsername(String loginUsername) {
    this.loginUsername = loginUsername;
}

    // Stores the password entered during login.
    public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
}

    public boolean checkUserName() {

    // The username must contain an underscore
    // and must not be longer than 5 characters.
    return username.contains("_") && username.length() <= 5;
}
    
    // Checks if the password meets all complexity requirements.
public boolean checkPasswordComplexity() {

    boolean hasCapitalLetter = false;
    boolean hasNumber = false;
    boolean hasSpecialCharacter = false;

    // Check every character in the password.
    for (int i = 0; i < password.length(); i++) {

        char currentCharacter = password.charAt(i);

        if (Character.isUpperCase(currentCharacter)) {
            hasCapitalLetter = true;
        }

        if (Character.isDigit(currentCharacter)) {
            hasNumber = true;
        }

        if (!Character.isLetterOrDigit(currentCharacter)) {
            hasSpecialCharacter = true;
        }
    }

    // Password must meet all four requirements.
    return password.length() >= 8
            && hasCapitalLetter
            && hasNumber
            && hasSpecialCharacter;
}

// Checks if the cellphone number uses the South African
// international country code (+27) followed by 9 digits.
//
// Regex reference:
// Oracle Java Pattern documentation:
// https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html
public boolean checkCellPhoneNumber() {

    String cellPhonePattern = "^\\+27\\d{9}$";

    return Pattern.matches(cellPhonePattern, cellPhoneNumber);
}

   // Registers the user if all registration details are valid.
public String registerUser() {

    if (!checkUserName()) {
        return "Username is not correctly formatted; please ensure that "
                + "your username contains an underscore and is no more "
                + "than five characters in length.";
    }

    if (!checkPasswordComplexity()) {
        return "Password is not correctly formatted; please ensure that "
                + "the password contains at least eight characters, "
                + "a capital letter, a number, and a special character.";
    }

    if (!checkCellPhoneNumber()) {
        return "Cell phone number incorrectly formatted or does not "
                + "contain international code.";
    }

    return "User registered successfully.";
}
    
    // Checks if the login details match the registered details.
public boolean loginUser() {

    return username.equals(loginUsername)
            && password.equals(loginPassword);
}

    // Returns the correct message depending on the login result.
public String returnLoginStatus() {

    if (loginUser()) {
        return "Welcome " + firstName + ", " + lastName
                + " it is great to see you again.";
    }

    return "Username or password incorrect, please try again.";
}

}

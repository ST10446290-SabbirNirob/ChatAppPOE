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
 * @author Sabbir Nirob
 */
//******************************************************************************
public class Login {

    //**************************************************************************
    //                    USER REGISTRATION INFORMATION
    //**************************************************************************

    // Stores the user's first name.
    private String firstName;

    // Stores the user's last name.
    private String lastName;

    // Stores the username created during registration.
    private String username;

    // Stores the password created during registration.
    private String password;

    // Stores the cellphone number entered during registration.
    private String cellPhoneNumber;


    //**************************************************************************
    //                         LOGIN INFORMATION
    //**************************************************************************

    // Stores the username entered when the user tries to log in.
    private String loginUsername;

    // Stores the password entered when the user tries to log in.
    private String loginPassword;


    //**************************************************************************
    //                              CONSTRUCTOR
    //**************************************************************************

    /**
     * The constructor receives and stores the user's registration information.
     *
     * @param firstName       the user's first name
     * @param lastName        the user's last name
     * @param username        the user's registered username
     * @param password        the user's registered password
     * @param cellPhoneNumber the user's cellphone number
     */
    public Login(String firstName, String lastName, String username,
            String password, String cellPhoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }


    //**************************************************************************
    //                         LOGIN SETTER METHODS
    //**************************************************************************

    /**
     * Stores the username entered during login.
     *
     * @param loginUsername the username entered by the user
     */
    public void setLoginUsername(String loginUsername) {

        this.loginUsername = loginUsername;
    }

    /**
     * Stores the password entered during login.
     *
     * @param loginPassword the password entered by the user
     */
    public void setLoginPassword(String loginPassword) {

        this.loginPassword = loginPassword;
    }


    //**************************************************************************
    //                         USERNAME VALIDATION
    //**************************************************************************

    /**
     * Checks whether the username follows the required format.
     *
     * The username must:
     * - Contain an underscore (_)
     * - Be no more than 5 characters long
     *
     * @return true if the username is valid, otherwise false
     */
    public boolean checkUserName() {

        // Both username requirements must be true.
        return username.contains("_") && username.length() <= 5;
    }


    //**************************************************************************
    //                         PASSWORD VALIDATION
    //**************************************************************************

    /**
     * Checks whether the password meets all complexity requirements.
     *
     * The password must:
     * - Be at least 8 characters long
     * - Contain a capital letter
     * - Contain a number
     * - Contain a special character
     *
     * @return true if the password meets all requirements, otherwise false
     */
    public boolean checkPasswordComplexity() {

        // These variables keep track of the password requirements.
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        // Loop through every character in the password.
        for (int i = 0; i < password.length(); i++) {

            // Get the current character being checked.
            char currentCharacter = password.charAt(i);

            // Check if the current character is a capital letter.
            if (Character.isUpperCase(currentCharacter)) {
                hasCapitalLetter = true;
            }

            // Check if the current character is a number.
            if (Character.isDigit(currentCharacter)) {
                hasNumber = true;
            }

            // Check if the current character is a special character.
            if (!Character.isLetterOrDigit(currentCharacter)) {
                hasSpecialCharacter = true;
            }
        }

        // The password is only valid if all four requirements are met.
        return password.length() >= 8
                && hasCapitalLetter
                && hasNumber
                && hasSpecialCharacter;
    }


    //**************************************************************************
    //                      CELLPHONE NUMBER VALIDATION
    //**************************************************************************

    /**
     * Checks whether the cellphone number follows the required
     * South African international format.
     *
     * The number must:
     * - Start with the South African international country code +27
     * - Have 9 digits after the +27 country code
     *
     * Regex reference:
     * Oracle Java Pattern documentation:
     * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/regex/Pattern.html
     *
     * @return true if the cellphone number is valid, otherwise false
     */
    public boolean checkCellPhoneNumber() {

        // Regex pattern for +27 followed by exactly 9 digits.
        String cellPhonePattern = "^\\+27\\d{9}$";

        // Compare the cellphone number against the regex pattern.
        return Pattern.matches(cellPhonePattern, cellPhoneNumber);
    }


    //**************************************************************************
    //                          USER REGISTRATION
    //**************************************************************************

    /**
     * Attempts to register the user.
     *
     * The username, password, and cellphone number are checked.
     * If any information is incorrect, the correct error message is returned.
     *
     * @return a message explaining whether registration was successful
     */
    public String registerUser() {

        // First check whether the username is valid.
        if (!checkUserName()) {

            return "Username is not correctly formatted; please ensure that "
                    + "your username contains an underscore and is no more "
                    + "than five characters in length.";
        }

        // Next check whether the password meets all requirements.
        if (!checkPasswordComplexity()) {

            return "Password is not correctly formatted; please ensure that "
                    + "the password contains at least eight characters, "
                    + "a capital letter, a number, and a special character.";
        }

        // Finally check whether the cellphone number is valid.
        if (!checkCellPhoneNumber()) {

            return "Cell phone number incorrectly formatted or does not "
                    + "contain international code.";
        }

        // This message is returned if all registration information is valid.
        return "User registered successfully.";
    }


    //**************************************************************************
    //                           LOGIN VALIDATION
    //**************************************************************************

    /**
     * Checks whether the username and password entered during login
     * match the username and password created during registration.
     *
     * @return true if both login details match, otherwise false
     */
    public boolean loginUser() {

        // Both the username AND password must match.
        return username.equals(loginUsername)
                && password.equals(loginPassword);
    }


    //**************************************************************************
    //                            LOGIN STATUS
    //**************************************************************************

    /**
     * Returns the correct message depending on whether login
     * was successful or unsuccessful.
     *
     * @return the appropriate login status message
     */
    public String returnLoginStatus() {

        // Call loginUser() to check if the login details are correct.
        if (loginUser()) {

            // Successful login message containing the user's name.
            return "Welcome " + firstName + ", " + lastName
                    + " it is great to see you again.";
        }

        // This message is returned when the login information is incorrect.
        return "Username or password incorrect, please try again.";
    }
}

//******************************************************************************
//                                    END
//******************************************************************************
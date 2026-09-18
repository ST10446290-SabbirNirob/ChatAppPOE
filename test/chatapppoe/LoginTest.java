//******************************************************************************
//                                   START                                      
//******************************************************************************
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chatapppoe;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sabbir Nirob
 */
//******************************************************************************
public class LoginTest {

    //**************************************************************************
    //                          USERNAME TESTS
    //**************************************************************************
    /**
     * Tests a correctly formatted username. "kyl_1" contains an underscore and
     * is no more than 5 characters.
     */
    @Test
    public void testUsernameCorrectlyFormatted() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // We expect the username validation to return true.
        assertTrue(user.checkUserName());
    }

    /**
     * Tests an incorrectly formatted username. "kyle!!!!!!!" does not follow
     * the username requirements.
     */
    @Test
    public void testUsernameIncorrectlyFormatted() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyle!!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // We expect the username validation to return false.
        assertFalse(user.checkUserName());
    }

    //**************************************************************************
    //                          PASSWORD TESTS
    //**************************************************************************
    /**
     * Tests a password that meets all complexity requirements.
     */
    @Test
    public void testPasswordMeetsComplexityRequirements() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // The password is valid, so we expect true.
        assertTrue(user.checkPasswordComplexity());
    }

    /**
     * Tests a password that does not meet the complexity requirements.
     */
    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "password",
                "+27838968976"
        );

        // The password is invalid, so we expect false.
        assertFalse(user.checkPasswordComplexity());
    }

    //**************************************************************************
    //                       CELLPHONE NUMBER TESTS
    //**************************************************************************
    /**
     * Tests a correctly formatted South African cellphone number.
     */
    @Test
    public void testCellPhoneCorrectlyFormatted() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // The cellphone number is valid, so we expect true.
        assertTrue(user.checkCellPhoneNumber());
    }

    /**
     * Tests an incorrectly formatted cellphone number.
     */
    @Test
    public void testCellPhoneIncorrectlyFormatted() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553"
        );

        // The number does not contain the +27 code.
        // Therefore, we expect false.
        assertFalse(user.checkCellPhoneNumber());
    }

    //**************************************************************************
    //                         REGISTRATION TESTS
    //**************************************************************************
    /**
     * Tests registration when all information is correct.
     */
    @Test
    public void testSuccessfulRegistration() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        String expected = "User registered successfully.";

        // Compare the expected message to the actual message.
        assertEquals(expected, user.registerUser());
    }

    /**
     * Tests the registration message when the username is incorrect.
     */
    @Test
    public void testIncorrectUsernameRegistrationMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyle!!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        String expected
                = "Username is not correctly formatted; please ensure that "
                + "your username contains an underscore and is no more "
                + "than five characters in length.";

        // Check that the correct username error message is returned.
        assertEquals(expected, user.registerUser());
    }

    /**
     * Tests the registration message when the password is incorrect.
     */
    @Test
    public void testIncorrectPasswordRegistrationMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "password",
                "+27838968976"
        );

        String expected
                = "Password is not correctly formatted; please ensure that "
                + "the password contains at least eight characters, "
                + "a capital letter, a number, and a special character.";

        // Check that the correct password error message is returned.
        assertEquals(expected, user.registerUser());
    }

    /**
     * Tests the registration message when the cellphone number is incorrect.
     */
    @Test
    public void testIncorrectCellPhoneRegistrationMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553"
        );

        String expected
                = "Cell phone number incorrectly formatted or does not "
                + "contain international code.";

        // Check that the correct cellphone error message is returned.
        assertEquals(expected, user.registerUser());
    }

    //**************************************************************************
    //                            LOGIN TESTS
    //**************************************************************************
    /**
     * Tests a successful login.
     *
     * The username and password entered during login are the same as the
     * registered username and password.
     */
    @Test
    public void testLoginSuccessful() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Enter the correct login information.
        user.setLoginUsername("kyl_1");
        user.setLoginPassword("Ch&&sec@ke99!");

        // Login should return true.
        assertTrue(user.loginUser());
    }

    /**
     * Tests an unsuccessful login.
     *
     * Incorrect login information is deliberately entered.
     */
    @Test
    public void testLoginFailed() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Enter incorrect login information.
        user.setLoginUsername("wrong");
        user.setLoginPassword("wrongpassword");

        // Login should return false.
        assertFalse(user.loginUser());
    }

    //**************************************************************************
    //                         LOGIN MESSAGE TESTS
    //**************************************************************************
    /**
     * Tests the message displayed after a successful login.
     */
    @Test
    public void testSuccessfulLoginMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Enter the correct login details.
        user.setLoginUsername("kyl_1");
        user.setLoginPassword("Ch&&sec@ke99!");

        String expected
                = "Welcome Kyle, Smith it is great to see you again.";

        // Compare the expected login message with the actual message.
        assertEquals(expected, user.returnLoginStatus());
    }

    /**
     * Tests the message displayed after an unsuccessful login.
     */
    @Test
    public void testFailedLoginMessage() {

        Login user = new Login(
                "Kyle",
                "Smith",
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976"
        );

        // Enter incorrect login details.
        user.setLoginUsername("wrong");
        user.setLoginPassword("wrongpassword");

        String expected
                = "Username or password incorrect, please try again.";

        // Compare the expected error message with the actual message.
        assertEquals(expected, user.returnLoginStatus());
    }
}

//******************************************************************************
//                                    END
//******************************************************************************

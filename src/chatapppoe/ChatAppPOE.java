//******************************************************************************
//                                   START                                      
//******************************************************************************
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapppoe;

import java.util.Scanner;

/**
 *
 * @author Sabbir Nirob ST10446290 sabbirnirob1000@gmail.com
 */
//******************************************************************************
public class ChatAppPOE {

    /**
     * @param args the command line arguments
     */
    
    //**************************************************************************
    //                              MAIN METHOD
    //**************************************************************************
    
    public static void main(String[] args) {
        // TODO code application logic here


        //**********************************************************************
        //                          SCANNER SETUP
        //**********************************************************************

        // Create a Scanner object so the user can enter information
        // through the console.
        Scanner input = new Scanner(System.in);


        //**********************************************************************
        //                        USER REGISTRATION
        //**********************************************************************

        // Display the registration heading.
        System.out.println("===== CHAT APP REGISTRATION =====");
        System.out.println();

        // Ask the user to enter their first name.
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        // Ask the user to enter their last name.
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        // Ask the user to create a username.
        System.out.print("Enter your username: ");
        String username = input.nextLine();

        // Ask the user to create a password.
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        // Ask the user to enter their cellphone number.
        System.out.print("Enter your cellphone number: ");
        String cellPhoneNumber = input.nextLine();


        //**********************************************************************
        //                       CREATE LOGIN OBJECT
        //**********************************************************************

        /*
         * Create a Login object using the information entered by the user.
         *
         * The Login class will store the information and perform
         * the registration and login checks.
         */
        Login user = new Login(
                firstName,
                lastName,
                username,
                password,
                cellPhoneNumber
        );


        //**********************************************************************
        //                       REGISTRATION RESULTS
        //**********************************************************************

        System.out.println();
        System.out.println("===== REGISTRATION RESULTS =====");


        //**********************************************************************
        //                         CHECK USERNAME
        //**********************************************************************

        /*
         * Call checkUserName() from the Login class.
         *
         * If it returns true, the username is valid.
         * If it returns false, an error message is displayed.
         */
        if (user.checkUserName()) {

            System.out.println("Username successfully captured.");

        } else {

            System.out.println(
                    "Username is not correctly formatted; "
                    + "please ensure that your username contains an "
                    + "underscore and is no more than five characters "
                    + "in length."
            );
        }


        //**********************************************************************
        //                         CHECK PASSWORD
        //**********************************************************************

        /*
         * Call checkPasswordComplexity() from the Login class.
         *
         * The password must contain at least eight characters,
         * a capital letter, a number, and a special character.
         */
        if (user.checkPasswordComplexity()) {

            System.out.println("Password successfully captured.");

        } else {

            System.out.println(
                    "Password is not correctly formatted; "
                    + "please ensure that the password contains at least "
                    + "eight characters, a capital letter, a number, "
                    + "and a special character."
            );
        }


        //**********************************************************************
        //                     CHECK CELLPHONE NUMBER
        //**********************************************************************

        /*
         * Call checkCellPhoneNumber() from the Login class.
         *
         * The cellphone number must use the correct South African
         * international format.
         */
        if (user.checkCellPhoneNumber()) {

            System.out.println("Cell phone number successfully added.");

        } else {

            System.out.println(
                    "Cell phone number incorrectly formatted "
                    + "or does not contain international code."
            );
        }


        //**********************************************************************
        //                    DISPLAY REGISTRATION STATUS
        //**********************************************************************

        System.out.println();

        /*
         * Call registerUser() to display the overall
         * registration result.
         */
        System.out.println(user.registerUser());


        //**********************************************************************
        //                      CHECK REGISTRATION
        //**********************************************************************

        /*
         * The user is only allowed to continue to the login section
         * if the username, password, and cellphone number are all valid.
         *
         * The && symbol means AND.
         *
         * This means all three checks must return true.
         */
        if (user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber()) {


            //******************************************************************
            //                         USER LOGIN
            //******************************************************************

            System.out.println();
            System.out.println("===== CHAT APP LOGIN =====");
            System.out.println();

            // Ask the user to enter their username again for login.
            System.out.print("Enter your username: ");
            String loginUsername = input.nextLine();

            // Ask the user to enter their password again for login.
            System.out.print("Enter your password: ");
            String loginPassword = input.nextLine();


            //******************************************************************
            //                       STORE LOGIN DETAILS
            //******************************************************************

            /*
             * Send the login username and password to the Login object.
             *
             * These values will be compared with the username and
             * password that were entered during registration.
             */
            user.setLoginUsername(loginUsername);
            user.setLoginPassword(loginPassword);


            //******************************************************************
            //                       DISPLAY LOGIN RESULT
            //******************************************************************

            System.out.println();

            /*
             * returnLoginStatus() checks whether the login was successful
             * and returns the correct message.
             */
            System.out.println(user.returnLoginStatus());

        } else {


            //******************************************************************
            //                       REGISTRATION FAILED
            //******************************************************************

            /*
             * If any registration requirement is incorrect,
             * the user is not allowed to continue to login.
             */
            System.out.println(
                    "Registration failed. Please correct your details."
            );
        }


        //**********************************************************************
        //                          CLOSE SCANNER
        //**********************************************************************

        /*
         * Close the Scanner because the application no longer
         * needs to receive input from the user.
         */
        input.close();
    }
}

//******************************************************************************
//                                    END
//******************************************************************************
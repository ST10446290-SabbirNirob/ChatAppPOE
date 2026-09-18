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
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Scanner allows the user to enter information in the console.
        Scanner input = new Scanner(System.in);

        System.out.println("===== CHAT APP REGISTRATION =====");
        System.out.println();

        // Ask the user for their personal information.
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter your username: ");
        String username = input.nextLine();

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        System.out.print("Enter your cellphone number: ");
        String cellPhoneNumber = input.nextLine();

        // Create the Login object using the entered information.
        Login user = new Login(
                firstName,
                lastName,
                username,
                password,
                cellPhoneNumber
        );

        System.out.println();
        System.out.println("===== REGISTRATION RESULTS =====");

        // Check username.
        if (user.checkUserName()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; "
                    + "please ensure that your username contains an "
                    + "underscore and is no more than five characters "
                    + "in length.");
        }

        // Check password.
        if (user.checkPasswordComplexity()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; "
                    + "please ensure that the password contains at least "
                    + "eight characters, a capital letter, a number, "
                    + "and a special character.");
        }

        // Check cellphone number.
        if (user.checkCellPhoneNumber()) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted "
                    + "or does not contain international code.");
        }

        System.out.println();

        // Display the overall registration result.
        System.out.println(user.registerUser());

        // Only allow login if registration was successful.
        if (user.checkUserName()
                && user.checkPasswordComplexity()
                && user.checkCellPhoneNumber()) {

            System.out.println();
            System.out.println("===== CHAT APP LOGIN =====");
            System.out.println();

            System.out.print("Enter your username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = input.nextLine();

            // Store the login attempt.
            user.setLoginUsername(loginUsername);
            user.setLoginPassword(loginPassword);

            System.out.println();

            // Display the login result.
            System.out.println(user.returnLoginStatus());

        } else {

            System.out.println(
                    "Registration failed. Please correct your details."
            );
        }

        input.close();
    }
    
}

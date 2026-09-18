//******************************************************************************
//                                   START                                      
//******************************************************************************
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapppoe;

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
        System.out.println("Chat App POE started successfully!");
        // Create a temporary user to test username validation.
        Login user = new Login(
                "Test",
                "User",
                "sab_1",
                "snfkjKNFAS172#",
                "+27908932444"
        );

        // Display whether the username is valid.
        System.out.println(user.checkUserName());
        System.out.println(user.checkPasswordComplexity());
    }
    
}

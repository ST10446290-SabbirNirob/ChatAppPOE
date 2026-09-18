//******************************************************************************
//                                   START                                      
//******************************************************************************
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapppoe;

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
    
    public Login(String firstName, String lastName, String username,
        String password, String cellPhoneNumber) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.cellPhoneNumber = cellPhoneNumber;
}
    
    public boolean checkUserName() {

    // The username must contain an underscore
    // and must not be longer than 5 characters.
    return username.contains("_") && username.length() <= 5;
}
    
}

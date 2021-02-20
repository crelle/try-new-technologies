package com.crelle.junit.ignoretest;

/**
 * @author:crelle
 * @className:MessageUtil
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class MessageUtil {
    private String message;

    //Constructor
    //@param message to be printed
    public MessageUtil(String message){
        this.message = message;
    }

    // prints the message
    public String printMessage(){
        System.out.println(message);
        return message;
    }

    // add "Hi!" to the message
    public String salutationMessage(){
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }
}

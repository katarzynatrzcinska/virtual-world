/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworld;

/**
 *
 * @author Kasia
 */
public class MyException extends Exception {
   String string = new String();
    public MyException(String string) {
        super(string);
        this.string = string;
    }
    
    public String message() {
        return string;
    }
}

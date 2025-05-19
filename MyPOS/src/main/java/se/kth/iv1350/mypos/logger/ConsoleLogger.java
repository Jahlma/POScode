/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.logger;

/**
 *
 * @author jojoa
 */

    /**
 * Prints log messages to <code>System.out</code>.
 */
public class ConsoleLogger implements Logger {

    /**
     * Prints the specified string to <code>System.out</code>.
     *
     * @param message The string that will be printed to <code>System.out</code>.
     */
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}


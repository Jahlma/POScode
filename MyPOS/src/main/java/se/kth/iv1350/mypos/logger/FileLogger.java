/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.logger;
/**
 *
 * @author jojoa
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Prints log messages to a file. The log file will be in the current directory and will be called
 * log.txt.
 */
public class FileLogger implements Logger{
    private PrintWriter log;

    /**
     * Creates a new instance and also creates a new log file. An existing log file will be deleted.
     */
    public FileLogger() {
       try {
            log = new PrintWriter(new FileWriter("log.txt", true),true); 
        } catch (IOException e) {
            System.out.println("Kunde inte skriva till loggfilen.");
            }
        }
    

    /**
     * Prints the specified string to the log file.
     *
     * @param message The string that will be printed to the log file.
     */
    @Override
    public void log(String message) {
        if(log != null)
        log.println(message);
         
    }
}
    


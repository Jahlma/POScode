/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se.kth.iv1350.mypos.logger;

/**
 *
 * @author jojoa
 */

/**
 * Specifies an object that can print to a log. This interface does not handle log locations, it is
 * up to the implementing class to decide where the log is.
 */
public interface Logger {

    /**
     * The specified message is printed to the log.
     *
     * @param message The message that will be logged.
     */
    void log(String message);
}

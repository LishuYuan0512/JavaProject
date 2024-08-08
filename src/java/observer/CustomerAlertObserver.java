/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import entity.FoodItem;
import entity.Subscription;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.juli.FileHandler;

/**
 * A class that implements the Observer interface to receive alerts and log messages for customers.
 * It supports two types of communication methods: email and SMS.
 * Logs are saved in separate files for email and SMS alerts.
 */
public class CustomerAlertObserver implements Observer{

private static final String LOG_FILE_EMAIL = "EMAIL_alert.log";
private static final String LOG_FILE_MSG = "MSG_alert.log";

    /**
     * Updates the observer with the given subscription details.
     * It sends alerts to customers based on their preferred communication method.
     *
     * @param subscription The Subscription object containing subscription details.
     */

    @Override
    public void update(Subscription subscription) {
        // 发送用户提示
        if(subscription.getCommunicationMethod() == 1 ){
            receiveEmail(subscription);
        }else if (subscription.getCommunicationMethod() == 2 ){
        receiveMessage(subscription);
    }else{
            System.out.println("Invaid CommunicationMethod");
        }

    }
  /**
     * Logs email messages to the log file.
     *
     * @param message The message to be logged.
     */
    private void logMessageEmail(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_EMAIL, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.println(timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Logs SMS messages to the log file.
     *
     * @param message The message to be logged.
     */
    private void logMessageSMS(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_MSG, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.println(timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Receives an email alert for the given subscription.
     *
     * @param subscription The Subscription object containing subscription details.
     */
public void receiveEmail(Subscription subscription){
	System.out.println("Receive Email:");
	String message = "Alert: New Subscription Added with Email: " + subscription;
	logMessageEmail(message);

}
    /**
     * Receives an SMS alert for the given subscription.
     *
     * @param subscription The Subscription object containing subscription details.
     */
public void receiveMessage(Subscription subscription){
	System.out.println("Receive message:");
	String message = "Alert: New Subscription Added with Message: " + subscription;
	logMessageSMS(message);


}
  /**
     * Updates the observer with the given food item details.
     * This method is not supported in this class.
     *
     * @param foodItem The FoodItem object containing food item details.
     */

    @Override
    public void update(FoodItem foodItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	

}
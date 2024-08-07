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
 *
 * @author ZU
 */
public class CustomerAlertObserver implements Observer{
//     @Override
//    public void update(FoodItem foodItem) {
//        // 发送用户提示
//        if (foodItem.getIsPlus() == 1) {
//            System.out.println("Alert: New Food Item Added/Updated with isPlus=true: " + foodItem);
//            // 在这里可以添加实际的发送用户提示逻辑，比如发送邮件或短信
//        }
//    }
private static final String LOG_FILE_EMAIL = "EMAIL_alert.log";
private static final String LOG_FILE_MSG = "MSG_alert.log";

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

    private void logMessageEmail(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_EMAIL, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.println(timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void logMessageSMS(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_MSG, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.println(timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//新增方法
public void receiveEmail(Subscription subscription){
	System.out.println("Receive Email:");
	String message = "Alert: New Subscription Added with Email: " + subscription;
	logMessageEmail(message);

}
//新增方法
public void receiveMessage(Subscription subscription){
	System.out.println("Receive message:");
	String message = "Alert: New Subscription Added with Message: " + subscription;
	logMessageSMS(message);


}

    @Override
    public void update(FoodItem foodItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	

}
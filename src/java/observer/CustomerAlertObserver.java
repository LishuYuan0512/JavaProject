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
private static final String LOG_FILE_NAME = "customer_alert.log";

    @Override
    public void update(Subscription subscription) {
        // 发送用户提示
            String message = "Alert: New Subscription Added with isPlus=true: " + subscription;
            System.out.println(message);
            logMessage(message);
    }

    private void logMessage(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_NAME, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pw.println(timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

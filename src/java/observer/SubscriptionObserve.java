/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import entity.Subscription;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZU
 */
public class SubscriptionObserve {
    private static List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public static void notifyObservers(Subscription subscription) {
        for (Observer observer : observers) {
            observer.update(subscription);
        }
    }

    public static void addSubscriptionObserver(Subscription subscription) {
        // 这里是添加用户订阅的逻辑
        // 例如，保存订阅信息到数据库，更新订阅列表等
            notifyObservers(subscription);
    }
}

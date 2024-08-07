/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import entity.FoodItem;
import entity.Subscription;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZU
 */
public abstract class FoodItemObserverService implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(FoodItem foodItem) {
        for (Observer observer : observers) {
            observer.update(foodItem);
        }
    }

    public void addOrUpdateFoodItem(FoodItem foodItem) {
        // 这里是添加或更新FoodItem的逻辑
        // 如果foodItem.isPlus()为true，通知所有观察者
        if (foodItem.getIsPlus() == 1) {
            notifyObservers(foodItem);
        }
    }

  
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import entity.FoodItem;
import entity.Subscription;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import service.FoodItemService;
import service.FoodItemServiceImpl;
import utils.DbUtil;

/**
 *
 * @author ZU
 */
public class SubscriptionObserve implements Observable{
    private static List<Observer> observers = new ArrayList<>();
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Subscription subscription) {
        for (int i = 0; i< observers.size(); i++) {
	observers.get(i).update(subscription);
        }
    }

//新增方法，只要isSruplu == 1成立，就会通知用户。该判断条件应该加在被观察者中，而不是观察者。
	public void checkChange(Subscription subscription){
                        //check isPlus
            int foodID = subscription.getFoodPrefer();
            FoodItemService foodservice = new FoodItemServiceImpl();
            int isSruplu = foodservice.getFoodItemIsPlus(foodID);
		if(isSruplu == 1){//这里需要从数据库中调取相关数据，此处是为了简便
                notifyObservers(subscription);

	}
        }

    @Override
    public void update(FoodItem foodItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
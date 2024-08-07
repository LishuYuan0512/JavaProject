/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package observer;

import entity.FoodItem;
import entity.Subscription;

/**
 *
 * @author ZU
 */
public interface Observer {
    public void update(Subscription subscription);

    public void update(FoodItem foodItem);



    
	
}
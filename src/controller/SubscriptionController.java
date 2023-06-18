package controller;

import model.Subscription;
import service.SubscriptionServices;


public class SubscriptionController {
    SubscriptionServices subscriptionservices = new SubscriptionServices();
    
    //Insert Subscription by user;
    public boolean createSubscription(int subscriptionId, String type, double discountRate){
        Subscription subscription = new Subscription(subscriptionId, type, discountRate);
        return subscriptionservices.createSubscription(subscription);
        
    }
    //Update Subscription by user;
    public boolean updateSubscription(int subscriptionId, String type, double discountRate){
        Subscription subscription = new Subscription(subscriptionId, type, discountRate);
        return subscriptionservices.updateSubscription(subscription);
    }
    
    //Show list of the subscription type;
    public void showSubscriptionList(){
        for (Subscription sublist :  subscriptionservices.listSubscription()){
            
        }
    }
}

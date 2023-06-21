package service;
import java.util.ArrayList;
import model.Subscription;

public interface ISubscriptionService {
    public boolean createSubscription(Subscription subscription);
    public boolean updateSubscription(Subscription subscription);
    public boolean deleteSubscription(Subscription subscription);
    public ArrayList<Subscription> listSubscription();
    
}

package controller;

import service.HomeService;
import model.Income;
import java.util.ArrayList;

public class HomeController {
    HomeService homeService;
    public HomeController(){
        homeService = new HomeService();
    }
    public ArrayList<Income> showIncomeData(){
        ArrayList<Income> incomeList = homeService.calculateTotalIncome();
        return incomeList;      
    }
}

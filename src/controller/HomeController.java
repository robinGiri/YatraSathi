package controller;

import service.HomeService;
//import model.Income;
import java.util.ArrayList;
import model.MonthlyIncome;

public class HomeController {
    HomeService homeService;

    public HomeController() {
        homeService = new HomeService();
    }

    public ArrayList<MonthlyIncome> showIncomeData() {
        ArrayList<MonthlyIncome> incomeList = homeService.calculateTotalIncome();
       return incomeList;
    }
}

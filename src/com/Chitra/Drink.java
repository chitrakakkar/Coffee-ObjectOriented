package com.Chitra;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;

/**
 * Created by chitrakakkar on 3/15/16.
 */

// a class which creates drink with following attributes//
public class Drink
{

    String Name;
    Double ShopExpense;
    Double CustomerExpense;
    Integer NumberSold;
    // a constructor
    Drink(String name,Double shopExpense,Double customerExpense,Integer numberSold)
    {

        this.Name = name;
        this.ShopExpense = shopExpense;
        this.CustomerExpense =customerExpense;
        this.NumberSold = numberSold;
    }
    // method to perform calculation

    public List<Double> Getinfo(List<Double> GetTotal)throws IOException
    {
        FileWriter writer = new FileWriter("Sales-Report.txt",true); // stack -overflow
        List<Double> GetTot = new ArrayList<>();
        Double TotalExpense = GetTotal.get(0);
        Double TotalRevenue = GetTotal.get(1);
        Double TotalProfit = GetTotal.get(2);

        Double Expense = (this.ShopExpense * this.NumberSold);
        TotalExpense= TotalExpense + Expense;
        Double Revenue = this.CustomerExpense * this.NumberSold;
        TotalRevenue = TotalRevenue + Revenue;
        Double Profit =  Revenue-Expense;
        TotalProfit = TotalProfit + Profit;
        writer.write(this.Name +" : " + "Sold" +this.NumberSold + "," +  " Expense $" + Expense +" Revenue $"+ Revenue+ " Profit $ " +  Profit + "\n");
        GetTot.add(TotalExpense);GetTot.add(TotalRevenue);GetTot.add(TotalProfit);
        writer.close();
        return GetTot;
    }

}

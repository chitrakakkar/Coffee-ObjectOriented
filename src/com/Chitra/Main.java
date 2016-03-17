package com.Chitra;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        // reading from file
        FileReader reader = new FileReader("coffee.txt");
        BufferedReader bufReader = new BufferedReader(reader);
        String line = bufReader.readLine();
        List<String> CoffeeInfo = new ArrayList<>();

        while (line != null)
        {
            CoffeeInfo.add(line);  // adds line to the list
            //System.out.println(line);
            line = bufReader.readLine();

        }
        String name = " ";
        double ShopExpense = 0.0;
        double CustomerExpense =0.0;
        // for each loop to split the items from the lines in the file

        List<Drink> DrinkList = new ArrayList<>();
        for (String ST : CoffeeInfo
                )
        {
            List<Double> valUes = new ArrayList<>();
            name = ST.split(";")[0];
            valUes.add(Double.parseDouble(ST.split(";")[1]));
            valUes.add(Double.parseDouble(ST.split(";")[2]));
            ShopExpense = valUes.get(0);
            CustomerExpense = valUes.get(1);
            Integer NumberSold = UserInput(name); // Input validation
            // creating drink objects
            Drink name1 = new Drink(name,ShopExpense,CustomerExpense,NumberSold);
            DrinkList.add(name1); // adding objects to a list
        }
        // initializing variables to store total of all
        Double TotalExpense =0.0;
        Double TotalRevenue =0.0;
        Double TotalProfit = 0.0;
        List<Double> CalculateTotal = new ArrayList<>();
        CalculateTotal.add(TotalExpense);CalculateTotal.add(TotalRevenue);CalculateTotal.add(TotalProfit);
        // a loop to get the info on each object
        for (Drink d:DrinkList
             )
        {
          CalculateTotal =  d.Getinfo(CalculateTotal);
        }
        // writing report in a file
        FileWriter writer = new FileWriter("Sales-Report.txt",true);

        writer.write("\nTotal Expense $" + CalculateTotal.get(0).toString());
        writer.write("\nTotal Revenue $" + CalculateTotal.get(1).toString());
        writer.write("\nTotal Profit $" + CalculateTotal.get(2).toString());
        writer.close();

    }
    // user input validation
    public static Integer UserInput(String name)
    {
        while (true)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.println("How many " + name  + " sold today ?");
                Integer NumberSold = scanner.nextInt();
                return NumberSold;

            }
            catch (InputMismatchException ime)
            {
                System.out.println("Please enter an Integer value ");
                continue;
            }
        }
        }





}

package org.example;
import java.util.*;
public class Main { //A litre of paint generally covers 10m². 1 l = 1.8£
    public static void main(String[] args) { // main method
        PaintCalculator();
    }

    private static void PaintCalculator() { //provides information and asks how many walls user will be painting
        System.out.println("This program assumes a litre of paint covers 10m² and costs £1.8");
//        System.out.println("Would you like to specify a different rate? Y/N");
        double paintRate = 10;
        double paintCost = 1.8;
        System.out.print("How many walls will you be painting? ");
        int numberOfwalls = (int) Input();
//        System.out.print("How many coats will be done? ");
//        int numberOfcoats = (int) Input();
        Wall(numberOfwalls, paintRate, paintCost);
    }

    private static void Wall(int wallCount, double a, double b) {  //takes in dimensions input from user does all calculations
        int counter = 0;
        double totalCost=0;
        double totalPaint=0;
        while (counter < wallCount){
            counter++;
            System.out.println("Wall " +counter + ": ");
            System.out.println("What are the wall dimensions (including areas to exclude)? ");
            double wallArea = Area();
            double litrePaint = wallArea/a;
            double cost = litrePaint*b;
            System.out.print("How many areas to exclude (Windows/doors etc)): ");
            int numberOfexclusion = (int) Input();
            for(int i=0;i<numberOfexclusion;i++){
                System.out.println("Exclusion "+(i+1) + ":");
                System.out.println("What are the dimensions to exclude? ");
                double excludeArea = Area();
                double excludelitrePaint = excludeArea/10;
                litrePaint = litrePaint - excludelitrePaint;
                double excludecost = excludelitrePaint*1.8;
                cost = cost - excludecost;
            }
            double wallPaint = (double) Math.round(litrePaint * 100) /100;
            double wallCost = (double) Math.round(cost * 100) /100;
            System.out.println("Amount of paint required for this wall: " + wallPaint + " Litres");
            System.out.println("Cost to paint this wall: £" + wallCost);
            totalCost = (double) (Math.round(((totalCost + cost)) * 100)) /100;
            totalPaint = (double) (Math.round(((totalPaint+litrePaint)) * 100)) /100;
        }
        System.out.println("Total amount of paint: "+ totalPaint + " Litres");
        System.out.println("Total amount of cost: £"+ totalCost);
    }
    public static double Area(){ //takes in length and width and calculates area
        System.out.print("Please Input Length (mm): ");
        double length= Input()/1000;
        System.out.print("Please Input Width (mm): ");
        double width= Input()/1000;
        return length*width;
    }
    public static double Input(){
        Scanner sc1 = new Scanner(System.in);
        return Double.parseDouble(sc1.nextLine());
    }
}

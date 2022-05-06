package divingcalculations;

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.InputMismatchException;



/**
 * Write a description of class Driver here.
 *
 * @author Eril Levana
 * @id 2263444
 * FAN leva0007
 * @version (a version number or a date)
 */
public class DiveFormulas {



    public static double input_oxygenMixPercentage(Scanner inputScan){

        String ans = ":: Enter the percentage of Oxygen: ";
        System.out.print(ans);

        String _input = inputScan.nextLine();

        int percentage = -1;
        boolean gate; //exception true or false

        do{
            gate=false;
            try{
                percentage = Integer.parseInt(_input);
                if(percentage >= 0 && percentage <= 100){
                    return percentage;
                }
                else{
                    System.out.print("Invalid percentage. Please reenter: ");
                    _input = inputScan.nextLine();
                    gate=true;
                }
            }
            catch(NumberFormatException e){
                System.out.print("Invalid percentage. Please reenter: ");
                _input = inputScan.nextLine();
                gate=true;
            }

        }while(gate);

        return percentage;
    }

    public static double input_partialPressure(Scanner inputScan){

        String ans = ":: Enter the partial pressure of Oxygen (between 1.1 and 1.6 inclusive): ";
        System.out.print(ans);

        String _input = inputScan.nextLine();

        double oxygenPressure = -1;
        boolean gate; //exception true or false

        do{
            gate=false;
            try{
                oxygenPressure = Double.parseDouble (_input);
                if(oxygenPressure >= 1.1 && oxygenPressure <= 1.6){
                    return oxygenPressure;
                }
                else{
                    System.out.print("Invalid oxygen pressure. Please re-enter: ");
                    _input = inputScan.nextLine();
                    gate=true;
                }
            }
            catch(NumberFormatException e){
                System.out.print("Invalid oxygen pressure. Please re-enter: ");
                _input = inputScan.nextLine();
                gate=true;
            }

        }while(gate);

        return oxygenPressure;
    }


    public static double input_depth(Scanner inputScan){

        String ans = ":: Enter the depth of the dive (in metres): ";
        System.out.print(ans);

        String _input = inputScan.nextLine();

        int depth = -1;
        boolean gate; //exception true or false

        do{
            gate=false;
            try{
                depth = Integer.parseInt(_input);
                if(depth >= 0){
                    return depth;
                }
                else{
                    System.out.print("Invalid depth. Please reenter: ");
                    _input = inputScan.nextLine();
                    gate=true;
                }
            }
            catch(NumberFormatException e){
                System.out.print("Invalid depth. Please reenter: ");
                _input = inputScan.nextLine();
                gate=true;
            }

        }while(gate);

        return depth;
    }



    public void calculateMOD(){

        Scanner inputScan = new Scanner(System.in);

        System.out.println("Calculating the MOD");
        double oxygenMixPercentage = input_oxygenMixPercentage(inputScan);
        double partialPressure = input_partialPressure(inputScan);
        double MOD_ata = partialPressure / (oxygenMixPercentage/100);
        double MOD_metres = (MOD_ata - 1) * 10;

        System.out.println("Maximum operating depth (MOD) for a dive with " + String.format("%.0f",oxygenMixPercentage) +    "% O2 and a partial pressure of " + partialPressure + " is " + (int)MOD_metres + " mertres");

        return;

    }



    public void calculateSMOD(){

        Scanner inputScan = new Scanner(System.in);

        System.out.println("Calculating the MOD for the standard 1.4 partial pressure");
        double oxygenMixPercentage = input_oxygenMixPercentage(inputScan);
        double partialPressure = 1.4;
        double MOD_ata = partialPressure / (oxygenMixPercentage/100);
        double MOD_metres = (MOD_ata - 1) * 10;

        System.out.println("Maximum operating depth (MOD) for a dive with " + String.format("%.0f",oxygenMixPercentage) +    "% O2 and a partial pressure of " + partialPressure + " is " + (int)MOD_metres + " mertres");

        return;

    }


    public void calculateBM(){

        Scanner inputScan = new Scanner(System.in);

        System.out.println("Calculating the Best Mix");
        double partialPressure = input_partialPressure(inputScan);
        double depth_metres = input_depth(inputScan);
        double depth_ata = (depth_metres/10) + 1;
        double BM = (partialPressure / depth_ata) * 100;

        System.out.println("Best mix for a dive to " + depth_metres + " metres with a partial pressure of " +                partialPressure + " is " + (int)BM + "% O2");

        return;

    }

    public void calculatePP(){

        Scanner inputScan = new Scanner(System.in);

        System.out.println("Calculating the Partial Pressure");
        double depth_metres = input_depth(inputScan);
        double depth_ata = (depth_metres/10) + 1;
        double oxygenMixPercentage = input_oxygenMixPercentage(inputScan);
        double PP = (oxygenMixPercentage / 100) * depth_ata;

        System.out.println("Best mix for a dive to " + depth_metres + " metres with a percentage of Oxygen of " + String.format("%.0f",oxygenMixPercentage) + "% is " + String.format("%.2f",PP) + " ata");

        return;

    }


    public void calculateEAD(){

        Scanner inputScan = new Scanner(System.in);

        System.out.println("Calculating the Equivalent Air Depth");
        double depth_metres = input_depth(inputScan);
        double depth_ata = (depth_metres/10) + 1;
        double oxygenMixPercentage = input_oxygenMixPercentage(inputScan);
        double EAD_ata = ((1 - (oxygenMixPercentage/100)) * depth_ata) / 0.79;
        double EAD_metres = (EAD_ata - 1) * 10;

        System.out.println("Equivalent Air Depth for a dive with " + String.format("%.0f",oxygenMixPercentage) + "% O2 to a depth of " + depth_metres + " metres is " + String.format("%.0f",EAD_metres) + " metres");

        return;

    }

    public void calculatePPT(){

        Scanner inputScan = new Scanner(System.in);



        double depth_metres = input_depth(inputScan);
        double depth_ata = (depth_metres/10) + 1;
        double oxygenMixPercentage = input_oxygenMixPercentage(inputScan);
        double EAD_ata = ((1 - (oxygenMixPercentage/100)) * depth_ata) / 0.79;
        double EAD_metres = (EAD_ata - 1) * 10;

        System.out.println("Equivalent Air Depth for a dive with " + String.format("%.0f",oxygenMixPercentage) + "% O2 to a depth of " + depth_metres + " metres is " + String.format("%.0f",EAD_metres) + " metres");

        return;

    }


    public void createPPT(int start_oxygen, int end_oxygen, int start_depth, int end_depth){

        int rows = (end_depth - start_depth) / 3 + 1;
        int columns = (end_oxygen - start_oxygen) + 1;

        int depth_metres = start_depth;
        double depth_ata = (depth_metres/10.0) + 1;

        double [][] table = new double[rows][columns];

        for (int i=0 ; i < rows; i++){
            int oxygenMixPercentage = start_oxygen;
            for (int j = 0 ; j < columns; j++){

                table[i][j] = (oxygenMixPercentage/100.0) * depth_ata;
                oxygenMixPercentage += 1;
            }
            depth_metres += 3;
            depth_ata = (depth_metres/10.0) + 1;

        }
        printPPT(table,start_oxygen,end_oxygen,start_depth, end_depth);


    }




    public void printPPT(double [][] table, int start_oxygen, int end_oxygen, int start_depth, int end_depth){

        System.out.print("\\      ");
        for(int i = start_oxygen ; i <= end_oxygen ; i++ ){

            System.out.print(i + "    ");
        }

        System.out.println("\n ________________________________________________________________________");


        int depth = start_depth;



        for (int j = 0 ; j < table.length ; j++ ){

            System.out.print(depth + "    ");

            for (int k = 0 ; k < table[0].length ; k++){

                if(table[j][k] > 1.6){
                    System.out.print("     ");
                } else {
                    System.out.format("%.2f  ", table[j][k]);
                }
            }

            System.out.println();
            depth += 3;
        }
    }


    //   public void calculateEAD(){

    //   Scanner inputScan = new Scanner(System.in);

    //   System.out.println("Calculating the Equivalent Air Depth");
    //   double depth_metres = input_depth(inputScan);
    //   double depth_ata = (depth_metres/10) + 1;
    //   double oxygenMixPercentage = input_oxygenMixPercentage(inputScan);
    //   double EAD_ata = ((1 - (oxygenMixPercentage/100)) * depth_ata) / 0.79;
    //   double EAD_metres = (EAD_ata - 1) * 10;

    //   System.out.println("Equivalent Air Depth for a dive with " + String.format("%.0f",oxygenMixPercentage) + "% O2 to a depth of " + depth_metres + " metres is " + String.format("%.0f",EAD_metres) + " metres");

    //   return;

    // }


    // System.out.println("Calculating the Equivalent Air Depth");
    //  double depth_metres = input_depth(inputScan);
    //  double depth_ata = (depth_metres/10) + 1;
    //  double oxygenMixPercentage = input_oxygenMixPercentage(inputScan);
    //  double EAD_ata = ((1 - (oxygenMixPercentage/100)) * depth_ata) / 0.79;
    //  double EAD_metres = (EAD_ata - 1) * 10;


    public void createEADT(int start_oxygen, int end_oxygen, int start_depth, int end_depth){

        int rows = (end_depth - start_depth) / 3 + 1;
        int columns = (end_oxygen - start_oxygen) + 1;

        int depth_metres = start_depth;
        double depth_ata = (depth_metres/10.0) + 1;

        double [][] table = new double[rows][columns];

        for (int i=0 ; i < rows; i++){
            int oxygenMixPercentage = start_oxygen;
            for (int j = 0 ; j < columns; j++){

                table[i][j] = ((((1 - (oxygenMixPercentage/100)) * depth_ata) / 0.79) - 1) * 10;

                oxygenMixPercentage += 1;
            }
            depth_metres += 3;
            depth_ata = (depth_metres/10.0) + 1;

        }
        printPPT(table,start_oxygen,end_oxygen,start_depth, end_depth);


    }

    public void printEADT(double [][] table, int start_oxygen, int end_oxygen, int start_depth, int end_depth){

        System.out.print("\\      ");
        for(int i = start_oxygen ; i <= end_oxygen ; i++ ){

            System.out.print(i + "    ");
        }

        System.out.println("\n ________________________________________________________________________");


        int depth = start_depth;



        for (int j = 0 ; j < table.length ; j++ ){

            System.out.print(depth + "    ");

            for (int k = 0 ; k < table[0].length ; k++){

                System.out.format("%.2f  ", table[j][k]);

            }

            System.out.println();
            depth += 3;
        }
    }






}


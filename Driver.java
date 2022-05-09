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
public class Driver {

    //Header
    public static String getHeader(boolean toPrint){
        String ans = "\n\n\n";
        ans += "===============================================================================" + "\n";
        ans += ":: Welcome to the Dive Formula Calculator                                     ::" + "\n";
        ans += "===============================================================================" + "\n";
        if(toPrint)
            System.out.println(ans);
        return ans;
    }


    public static void displayMenu(){
        String ans = getHeader(false);
        ans += ":: Select which calculation you wish to perform:                              ::" + "\n";
        ans += ":: 1. HELP                                                                    ::" + "\n";
        ans += ":: 2. MOD                                                                     ::" + "\n";
        ans += ":: 3. SMOD                                                                    ::" + "\n";
        ans += ":: 4. BM                                                                      ::" + "\n";
        ans += ":: 5. PP                                                                      ::" + "\n";
        ans += ":: 6. EAD                                                                     ::" + "\n";
        ans += ":: 7. PPT                                                                     ::" + "\n";
        ans += ":: 8. EADT                                                                    ::" + "\n";
        ans += ":: 9. Exit                                                                    ::" + "\n";
        ans += "===============================================================================" + "\n";
        System.out.println(ans);
    }

    public static void helpMenu(){
        String ans = getHeader(false);
        ans += ":: Select which calculation you wish to perform:                                                                        ::" + "\n";
        ans += ":: 1. HELP  prints this message.                                                                                        ::" + "\n";
        ans += ":: 2. MOD  (Maximum Operating Depth) for a supplied percentage of Oxygen and partial pressure.                          ::" + "\n";
        ans += ":: 3. SMOD (Standard Maximum Operating Depth) for a supplied percentage of Oxygen and a standard 1.4 partial pressure.  ::" + "\n";
        ans += ":: 4. BM   (Best Mix) for a dive with a supplied partial pressure and depth (in metres).                                ::" + "\n";
        ans += ":: 5. PP   (Partial Pressure) for a supplied percentage of Oxygen and depth (in metres).                                ::" + "\n";
        ans += ":: 6. EAD  (Equivalent Air Depth) for a supplied percentage of Oxygen and depth (in metres).                            ::" + "\n";
        ans += ":: 7. Exit  Exit the Dive Formula Calculator.                                                                           ::" + "\n";
        ans += "===============================================================================" + "\n";
        System.out.println(ans);
    }

    public static int getOption(Scanner inputScan){
        String ans = ":: Enter 1 to 9: ";
        System.out.print(ans);
        String _input = inputScan.nextLine();

        int _option = -1;
        boolean gate; //exception true or false

        do{
            gate=false;
            try{
                _option = Integer.parseInt(_input);
                if(_option >= 1 && _option <= 9){
                    return _option;
                }
                else{
                    System.out.print("Invalid Option. Please re-enter: ");
                    _input = inputScan.nextLine();
                    gate=true;
                }
            }
            catch(NumberFormatException e){
                System.out.print("Invalid Option. Please re-enter: ");
                _input = inputScan.nextLine();
                gate=true;
            }

        }while(gate);


        return _option;
    }



    public static void main(String[] args) {

        // Welcome to the Dive Formula Calculator



        Scanner inputScan = new Scanner(System.in);
        DiveFormulas diveFormulas = new DiveFormulas();
        // new DiveBroker();

        boolean _continue = true;


        while (_continue){

            displayMenu();
            int _option = getOption(inputScan);

            switch(_option) {
                case 1:
                    helpMenu();

                    break;

                case 2:
                    diveFormulas.calculateMOD();

                    break;

                case 3:
                    diveFormulas.calculateSMOD();
                    break;

                case 4:
                    diveFormulas.calculateBM();
                    break;

                case 5:
                    diveFormulas.calculatePP();
                    break;

                case 6:
                    diveFormulas.calculateEAD();
                    break;

                case 7:
                    System.out.println("Generating Partial Pressures Table");
                    System.out.print("Enter a start and end percentage of Oxygen: ");
                    String oxygen_input = inputScan.nextLine();
                    String[] inputOxygen = oxygen_input.split(" ");
                    int start_oxygen = Integer.parseInt(inputOxygen[0]);
                    int end_oxygen = Integer.parseInt(inputOxygen[1]);

                    System.out.print("Enter a start and end depth (in metres): ");
                    String depth_input = inputScan.nextLine();
                    String[] inputDepth = depth_input.split(" ");
                    int start_depth = Integer.parseInt(inputDepth[0]);
                    int end_depth = Integer.parseInt(inputDepth[1]);

                    System.out.println("Partial Pressures Table for " + start_oxygen + " to " + end_oxygen + " percent Oxygen and depths of " + start_depth + " to " + end_oxygen + " metres");

                    System.out.println("=================================================================================");

                    diveFormulas.createPPT(start_oxygen, end_oxygen, start_depth, end_depth );
                    break;
//   Generating Partial Pressures Table
//  Enter a start and end percentage of Oxygen: 33 40
// Enter a start and end depth (in metres): 15 40
// Partial Pressures Table for 33 to 40 percent Oxygen and depths of 15 to 40 metres

                case 8:
                    System.out.println("Generating Partial Pressures Table");
                    System.out.print("Enter a start and end percentage of Oxygen: ");
                    String oxygen_input2 = inputScan.nextLine();
                    String[] inputOxygen2 = oxygen_input2.split(" ");
                    int start_oxygen2 = Integer.parseInt(inputOxygen2[0]);
                    int end_oxygen2 = Integer.parseInt(inputOxygen2[1]);

                    System.out.print("Enter a start and end depth (in metres): ");
                    String depth_input2 = inputScan.nextLine();
                    String[] inputDepth2 = depth_input2.split(" ");
                    int start_depth2 = Integer.parseInt(inputDepth2[0]);
                    int end_depth2 = Integer.parseInt(inputDepth2[1]);

                    System.out.println("Equivalent Air Depth Table for " + start_oxygen2 + " to " + end_oxygen2 + " percent Oxygen and depths of " + start_depth2 + " to " + end_oxygen2 + " metres");

                    System.out.println("=================================================================================");


                    diveFormulas.createEADT(start_oxygen2, end_oxygen2, start_depth2, end_depth2 );
                    break;

                case 9:

                    break;

                default:
            }

            if(_option != 9 ){
                System.out.print("\n Would you like to perform another calculation (y/n)? ");
                String _conitnueOption = inputScan.nextLine().toLowerCase();

                while(!_conitnueOption.equals("y")  && !_conitnueOption.equals("n")){
                    System.out.print("\n Would you like to perform another calculation (y/n)? ");
                    _conitnueOption = inputScan.nextLine().toLowerCase();

                }

                if(_conitnueOption.equals("n")){
                    _continue = false;
                }

            } else {
                break;
            }

        }
    }
}


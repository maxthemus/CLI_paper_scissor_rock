/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author max
 */
public class Menu {
    //Fields
    
    //Constructor
    public Menu() {
    }
    
    
    //Methods
    public int menu() {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        int input = -1;
        
        do {
            System.out.println("PAPER - SCISSORS - ROCK");
            System.out.println("MAIN MENU");
            System.out.println("[0] Play Game");
            System.out.println("[1] EXIT");

            input = sc.nextInt();
            sc.nextLine();//Clearing the input buffer
            
            if(input == 0 || input == 1) {
                validInput = true;
            } else {
                input = -1;
            }
        } while(!validInput);
        
        return input;
    }
    
    
}

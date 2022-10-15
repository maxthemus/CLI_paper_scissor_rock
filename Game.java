/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author max
 */
public class Game {
    //Fields
    private Scanner sc;
    private int p_score;
    private int bot_score;
    private int gameCount;
    private final int TOTAL_GAME_COUNT = 3;
    
    
    //Constructor
    public Game() {
        this.sc = new Scanner(System.in);
        this.p_score = 0;
        this.bot_score = 0;
        this.gameCount = 0;
    }
    
    
    //Methods
    public void startGame() {
        //Print game length
        this.printSpacer();
        System.out.println("Best of " + this.TOTAL_GAME_COUNT);
        this.printSpacer();
        
        //Print score
        //Prompt user for input on turn
        //Show turn
        //Inc score
        //Check if any user score is greater than half of TOTAL_GAME_COUNT
        //Repeat
        boolean winner = false;
        
        do {
            this.printScore();
            
            int userInput = getUserTurn(); //Getting user input
            Gesture playerGesture;
            switch (userInput) {
                case 0:
                    playerGesture = Gesture.PAPER;
                    break;
                case 1:
                    playerGesture = Gesture.SCISSOR;
                    break;
                case 2:
                    playerGesture = Gesture.ROCK;
                    break;
                default:
                    throw new Error("Something went wrong!");
            }
            
            //Get bots gesture
            Gesture botGesture = this.botGestureGenerator();
            
            //Print he gestures
            this.printRound(playerGesture, botGesture);
            
            //Compare gestures and increment player scores
            boolean validGame = this.playRound(playerGesture, botGesture);
            
            if(validGame) {
                //If it was a valid game then we want to check if there is a winner
                //Check if someones score is higher then half total
                if(this.p_score >= ((this.TOTAL_GAME_COUNT / 2) + 1) || this.bot_score >= ((this.TOTAL_GAME_COUNT /2) + 1)) {
                    winner = true;//There is a winner
                }
                
                gameCount++;
            }
        } while(!winner);
        
        //Print out winner and return back to main menu
        this.printWinner();
    }
    
    
    private void printScore() {
        System.out.println("You = " + this.p_score + " : Bot = " + this.bot_score);
        this.printSpacer();
    }
    
    private void printSpacer() {
        System.out.println("+-------------+");
    }
    
    private int getUserTurn() {
        boolean validInput = false;
        int input = -1;
        
        do {
            System.out.println("Input your gesture");
            System.out.println("[0] Paper");
            System.out.println("[1] Scissors");
            System.out.println("[2] Rock");
            
            input = this.sc.nextInt();
            this.sc.nextLine();//Clearing the input buffer
            
            if(input >= 0 && input <= 2) {
                validInput = true;
            } else {
                input = -1;
            }
        } while(!validInput);
        
        return input;
    }
    
    private Gesture botGestureGenerator() {
        int botNum = (int)(Math.random() * 3);
        
        Gesture botGesture;
        switch (botNum) {
            case 0:
                botGesture = Gesture.PAPER;
                break;
            case 1:
                botGesture = Gesture.SCISSOR;
                break;
            case 2:
                botGesture = Gesture.ROCK;
                break;
            default:
                throw new Error("Something went wrong!");
        }
        return botGesture;
    }
    
    private boolean playRound(Gesture playerGesture, Gesture botGesture) {
        boolean nonTieGame = false; //Default Assuming that game is tied
        //Compare gestures
        //Inc winner score
        boolean botWon = false;
        boolean playerWon = false;
        
        switch (playerGesture) {
            case PAPER:
                switch (botGesture) {
                    case PAPER:
                        //Tie game
                        nonTieGame = false;
                        break;
                    case SCISSOR:
                        //Bot wins
                        botWon = true;
                        nonTieGame = true;//There wasn't a tie
                        break;
                    case ROCK:
                        //Player wins
                        playerWon = true;
                        nonTieGame = true;
                        break;
                    default:
                        throw new Error("Something went wrong!");
                }
                break;
            case SCISSOR:
                switch (botGesture) {
                    case PAPER:
                        //Player wins
                        playerWon = true;
                        nonTieGame =true;
                        break;
                    case SCISSOR:
                        //Tie game
                        nonTieGame = false;
                        break;
                    case ROCK:
                        //Bot wins
                        botWon = true;
                        nonTieGame = true;
                        break;
                    default:
                        throw new Error("Something went wrong!");
                }
                break;
            case ROCK:
                switch (botGesture) {
                    case PAPER:
                        //Bot wins
                        botWon = true;
                        nonTieGame = true;
                        break;
                    case SCISSOR:
                        //Player wins
                        playerWon = true;
                        nonTieGame = true;
                        break;
                    case ROCK:
                        //Tie game
                        nonTieGame =false;
                        break;
                    default:
                        throw new Error("Something went wrong!");
                }
                break;
            default:
                throw new Error("Something went wrong!");
        }
        
        if(playerWon) {
            this.p_score++;
            System.out.println("Player won round");
        }
        
        if(botWon) {
            this.bot_score++;
            System.out.println("Bot won round");
        }
        
        return nonTieGame;
    }
    
    private void printWinner() {
        System.out.println("Final score");
        this.printScore();
        
        if(this.p_score > bot_score) {
            System.out.println("Winner is : you");
        } else {
            System.out.println("Winner is : bot");
        }
        
        this.printSpacer();
    }
    
    private void printRound(Gesture playerGesture, Gesture botGesture) {
        System.out.println("You picked " + playerGesture + " : bot picked " + botGesture);
    }
}

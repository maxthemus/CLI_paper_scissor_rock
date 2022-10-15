/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author max
 */
public class PaperScissorRock {
    //Fields
    private Menu menu;
    
    //Constructor
    public PaperScissorRock() {
        this.menu = new Menu();
        
        
    }

    //Methods
    public void start() {
        int input;
        
        while(true) {
            input = this.menu.menu();
        
            switch (input) {
                case 0:
                    //start game
                    Game tempGame = new Game();
                    tempGame.startGame();
                    break;
                case 1:
                    System.exit(0);
            }
        }
    }
    
    
    //Main Method
    public static void main(String[] args) {
        PaperScissorRock main = new PaperScissorRock();
        main.start();
    }
}

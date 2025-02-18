package com.lab;

import java.util.Scanner;

public class App {

    private static Object x;
        private static Object y;

            static Minesweeper initMineField() {
                Minesweeper game = new Minesweeper(9, 9);
                game.setMineCell(0, 1);
                game.setMineCell(1, 5);
                game.setMineCell(1, 8);
                game.setMineCell(2, 4);
                game.setMineCell(3, 6);
                game.setMineCell(4, 2);
                game.setMineCell(5, 4);
                game.setMineCell(6, 2);
                game.setMineCell(7, 2);
                game.setMineCell(8, 6);
                return game;
            }

            static Minesweeper initMineFieldFromFile(String minefieldFile) {
                return new Minesweeper(minefieldFile);
            }

            static void displayMenu() {
                System.out.println("Welcome to Minesweeper!");
                System.out.println("Select an option:");
                System.out.println("1. Use default minefield template");
                System.out.println("2. Load minefield from file");
                System.out.println("3. Exit");
            }
 
            static int getUserChoice() {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Enter your choice: ");
                    return scanner.nextInt();
                }
            }

            static void playerTurn(Minesweeper game) {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Enter row (0-8): ");
                    int x = scanner.nextInt();
                    System.out.print("Enter column (0-8): ");
                    int y = scanner.nextInt();
                    if (game.isMine(x, y)) {
                        System.out.println("BOOM! You hit a mine. Game Over.");
                        game.displayField();
                        return;
                    } else {
                        System.out.println("Safe! Continue playing.");
                        game.displayField();
                    }
                }
            }
        
            public static void main(String[] args) {
                boolean running = true;
        
                while (running) {
                    displayMenu();
                    int choice = getUserChoice();
                    Minesweeper game = null;
        
                    switch (choice) {
                        case 1:
                            game = initMineField();
                            System.out.println("Default minefield selected.");
                            break;
                        case 2:
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("Enter the minefield file name (e.g., minefield/minefield01.txt): ");
                            String fileName = scanner.nextLine();
                            game = initMineFieldFromFile(fileName);
                            System.out.println("Minefield loaded from file: " + fileName);
                            break;
                        case 3:
                            System.out.println("Exiting the game. Goodbye!");
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    if (game != null) {
                        game.displayField();
                        while (true) {
                            playerTurn(game);
                            if (game.isMine(x, y)) {
                        break; 
                    }
                }
            }
        }
    }
}

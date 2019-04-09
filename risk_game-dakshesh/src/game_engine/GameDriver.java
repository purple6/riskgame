/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

import Strategies.Strategy;
import controllers.StartupPhaseController;
import game_engine.Game.GameObjectsWrapper;
import game_engine.Game.SaveGame;
import java.io.IOException;
import models.Player;
import models.GameBoard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import map.mapprocessor.InvalidMapException;
import map.mapprocessor.MapParser;
import models.GameMap;
import resources.Constants.RISKCARD;
import view.GameBoardView;
import view.GameBoardView;
import view.PhaseView;
import view.StartupPhaseView;

/**
 * This class contains all methods used for initialization of game
 *
 * @author daksh
 */
public class GameDriver {

    private static final Logger LOG = Logger.getLogger(GameDriver.class.getName());

    /**
     * Object of the GameBoard {@link models.GameBoard}
     */
    GameBoard gameBoard;
    /**
     * Object of the game map {@link models.GameMap}
     */
    GameMap map;
    /**
     * Object of the current player {@link models.Player}
     */
    Player player[];

    int gameMode = 1;

    int drawTurn = -1;

    int currentTurn = 0;
    int turnCounter = 0;

    String gameResult = null;

    /**
     * Object of the View of the GameBoard {@link view.GameBoardView}
     */
    GameBoardView gameBoardView;
    /**
     * Object of the View of the Phase {@link view.PhaseView}
     */
    PhaseView phaseView;

    public GameDriver() {

    }

    /**
     * GameDriver is the parameterized constructor of GameDriver class
     *
     * @param map Object of the GameMap model {@link models.GameMap}
     * @param numberOfPlayers number of players in the game
     */
    public GameDriver(GameMap map, int numberOfPlayers) {

        //Assigning and creation of models
        this.map = map;

        GameBoard gameBoard = new GameBoard(map, numberOfPlayers);
        this.gameBoard = gameBoard;
        player = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            player[i] = new Player();
        }

        GameBoardView gameBoardView = new GameBoardView();
        this.gameBoardView = gameBoardView;

        PhaseView phaseView = new PhaseView();
        this.phaseView = phaseView;

        this.gameBoard.addObserver(gameBoardView);
        this.gameBoard.addObserver(phaseView);

    }

    public GameDriver(GameMap map, int numberOfPlayers, Strategy strategies[], int mode, int drawTurn) {

        this.gameMode = mode;
        //Assigning and creation of models
        this.map = map;
        this.drawTurn = drawTurn;

        GameBoard gameBoard = new GameBoard(map, numberOfPlayers);
        this.gameBoard = gameBoard;
        player = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            player[i] = new Player(strategies[i]);
        }

        GameBoardView gameBoardView = new GameBoardView();
        this.gameBoardView = gameBoardView;

        PhaseView phaseView = new PhaseView();
        this.phaseView = phaseView;

        this.gameBoard.addObserver(gameBoardView);
        this.gameBoard.addObserver(phaseView);

    }

    public GameDriver(GameBoard gameBoard, Player player[], int currentTurn) {

        this.gameBoard = gameBoard;
        this.player = player;
        this.currentTurn = currentTurn;

        this.map = gameBoard.getMap();

        GameBoardView gameBoardView = new GameBoardView();
        this.gameBoardView = gameBoardView;

        PhaseView phaseView = new PhaseView();
        this.phaseView = phaseView;

        this.gameBoard.addObserver(gameBoardView);
        this.gameBoard.addObserver(phaseView);
    }

    /**
     * Initializes Data Members of GameMap and Player
     *
     * @param map Object of the GameMap model {@link models.GameMap}
     * @param numberOfPlayers number of players in the game
     */
    public void initializeDataMembers(GameMap map, int numberOfPlayers) {

    }

    /**
     * It starts the game. Two things happen:<br> 1) It initialize the game
     * components
     * <br> 2) Runs the game
     */
    public void startGame() {

        try {
            java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {
                    try {
                        initializeGame();
                        runGame();
                    } catch (Exception e) {
                        //    System.out.println(e.printStackTrace());
                        e.printStackTrace();
                    }
                }
            });
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught");
        }

    }

    public void startLoadedGame(GameBoard gameBoard, Player player[], int currentTurn, int gameMode, int drawTurn, int turnCounter, String gameResult) {
        this.gameBoard = gameBoard;
        this.player = player;
        this.currentTurn = currentTurn;
        this.gameMode = gameMode;
        this.drawTurn = drawTurn;
        this.turnCounter = turnCounter;
        this.gameResult = gameResult;

        this.map = gameBoard.getMap();

        GameBoardView gameBoardView = new GameBoardView();
        this.gameBoardView = gameBoardView;

        PhaseView phaseView = new PhaseView();
        this.phaseView = phaseView;

        this.gameBoard.addObserver(gameBoardView);
        this.gameBoard.addObserver(phaseView);

        gameBoardView.showView(gameBoardView);
        phaseView.showView();
        gameBoard.stateChanged();
        runPhases();
    }

    /**
     * Initializes the Game
     */
    public void initializeGame() {
        GameSetup.initializePlayers(gameBoard, player, map);
        GameSetup.initializeGameBoard(gameBoard, player, map);
        gameBoard.stateChanged();
    }

    /**
     * Starts the Game
     */
    public void runGame() {
        if (canRun(gameBoard, player)) {
            gameBoardView.showView(gameBoardView);
            phaseView.showView();
            StartupPhaseController spc = new StartupPhaseController();
            spc.start(gameBoard, player, this);
        } else {
            stopGame("No of players are more than number of countries!!");
        }
    }

    /**
     * Phases of the game are called which are called by the Player class
     */
    public void runPhases() {
        Runnable r1 = () -> {
            //for (int i = 0; i < player.length; i++) 
            int i = currentTurn % player.length;
            while (i < player.length) {
                boolean flag = false;
                if (!gameBoard.isGameOver()) {
                    if (gameBoard.isActivePlayer(player[i])) {
                        player[i].reinforcement(gameBoard);
                        player[i].attack(gameBoard);
                        player[i].fortification(gameBoard);
                        turnCounter++;
                        if (drawTurn != -1) {
                            if (turnCounter >= drawTurn) {
                                gameResult = "Draw";
                                System.out.println("----------------Game Draw------------------");
                                break;
                            }
                        }
                        flag = true;
                    }

                } else {
                    String winner = gameBoard.getWinner();
                    gameResult = winner;
                    System.out.println("-------------------GAME ENDED------------------------");
                    System.out.println("");
                    System.out.println("CONGRATULATIONS : " + winner + "!" + " " + "You won!");
                    System.out.println("Total Turns : " + currentTurn);
                    break;
                }
                currentTurn++;

                if (gameMode == 1 && flag) {
                    //Save logic comes here
                    System.out.println("Do you want to Save Game : y/n ");
                    Scanner sc = new Scanner(System.in);
                    String c = sc.nextLine();
                    if (c.equalsIgnoreCase("y")) {
                        GameObjectsWrapper gow = new GameObjectsWrapper(gameBoard, player, currentTurn, gameMode, drawTurn, turnCounter, gameResult);
                        System.out.println("Enter file name : ");
                        String fileName = sc.nextLine();
                        SaveGame sg = new SaveGame(gow);
                        try {
                            sg.saveGame(fileName);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        stopGame("Game saved!!");
                    }
                }

                i++;
                //Check for player overflow
                if (i >= player.length) {
                    {
                        i = 0;
                    }
                }
            }
        };
        Thread t = new Thread(r1);
        t.start();

    }

    /**
     * Stops the game
     *
     * @param message Reason for the game
     */
    public void stopGame(String message) {
        System.out.println("-------------Game Ended-------------- ");
        System.out.println("Message : " + message);
        System.exit(0);
    }

    /**
     * Checks whether the game can proceed or not.i.e. Number of countries are
     * greater than number of players
     *
     * @param gameBoard gameBoard on which game is being played
     * @param player Player[] that is players playing the game
     * @return true if game can proceed otherwise false
     */
    private boolean canRun(GameBoard gameBoard, Player[] player) {
        int numberOfPlayers = player.length;
        int numberOfCountries = gameBoard.getMap().getNumberOfCountries();
        if (numberOfCountries >= numberOfPlayers) {
            return true;
        } else {
            return false;
        }
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }
    

}

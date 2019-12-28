import java.util.Random;
import java.util.Scanner;
import java.util.zip.DataFormatException;

//////////////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////////////////
//
// Title: Math Game
// Files: GameNode.java, GameList.java, GameOperator.java, GameApplication.java, GameTests.java
// Course: CS 300 Fall term 2018
// Author: Vedaant Tambi
// Email: tambi@wisc.edu
// Lecturer's Name: MOUNA AYARI BEN HADJ KACEM
//
///////////////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION //////////////////////////////
//
// Partner Name:    Keith Westpfahl
// Partner Email:   westpfahl@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
//////////////////////////////////////////CREDIT OUTSIDE HELP //////////////////////////////////////
//                                               NONE
/////////////////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////////////



/**
 * This class represents a number (i.e. node) within a list of such numbers (i.e. linked list). Each
 * node holds a reference to the next number in the list
 * 
 * @author Vedaant Tambi, Keith Westpfahl
 * @version 1.0
 * @since 1.0
 */
public class GameApplication {

  /**
   * The main method is the driver method of the Math Game. This method is responsible for
   * everything from displaying the opening welcome message to printing out the final
   * congratulations of the Math Game program.
   * 
   * @param args
   */
  public static void main(String[] args) {
    // variable declaration and initialization
    Scanner scnr = new Scanner(System.in); // Scanner for taking the number input from the user
    String command = new String(); // refers to the String command given by the user
    Random randGen = new Random(); // Random object used to create numbers for the end of the list
    char userOperator; // the operator given by the user to act on the number of the list
    int numberCommand; // number only part of the user command, i.e. the operand only
    int goal = 10 + randGen.nextInt(90); // the target number; initialized to a number between 10
                                         // and 99 inclusive
    int moveCounter = 0; // variable for counting the moves; number of moves is zero in the
                         // beginning
    GameList puzzleList = new GameList(); // a linked list to hold nodes of type GameNode
    for (int i = 0; i < 7; i++) { // i is the loop variable. Iterated 7x so that only seven nodes
                                  // are added
      puzzleList.addNode(new GameNode(randGen)); // 7 new Nodes are added to puzzleList GameList
    }
    // Welcome message
    System.out
        .println("--------------------------Welcome to the Math Game------------------------");
    do {
      System.out.println("\nGoal: " + goal + " Moves Taken: " + moveCounter);
      // Prints the status of the Linked List
      System.out.println("Puzzle: " + puzzleList);
      // Gives the user the list of operators to choose from
      System.out.println("Number and Operation " + GameOperator.ALL_OPERATORS + " to Apply: ");
      command = scnr.nextLine(); // read user input
      command.trim(); // deletes any leading or trailing whitespaces from user's input
      if (command.toLowerCase().equals("quit")) { // checks whether user has written 'quit'
                                                  // irrespective of the case
        System.out.println("Goodbye for now. Meet you next time!");
        break; // exits the loop and effectively ends the program for the user
      }
      // Try block starts
      try {
        
        if (command.length()!=0) // checks if the user has entered something or not
          // gets last character of command, the operator
          userOperator = command.charAt(command.length() - 1); 
        else 
          // if the user has not entered anything, an exception is thrown
          throw new DataFormatException("WARNING! Please enter something first");
        // only operators specified by GameOperator::ALL_OPERATORS list are allowed
        if (userOperator == '+' || userOperator == '/' || userOperator == 'x' || userOperator == '-'
            || userOperator == '&') {

          if (command.charAt(0) == '-') { // checks if the string containing number is negative
            // converts string of numbers to primitive int type
            numberCommand = -(Integer.parseInt(command.substring(1, command.length() - 1)));
          } else if (command.charAt(0) == '+') { // numbers preceded by a '+' sign are valid
            // substring
            numberCommand = Integer.parseInt(command.substring(1, command.length() - 1));
          } else { // if anything other than numbers are present, NumberFormatException is thrown
            numberCommand = Integer.parseInt(command.substring(0, command.length() - 1));
          }

          if (puzzleList.contains(numberCommand)) { // checks if the integer is present in the list
            moveCounter++; // the number of moves has to be incremented
            /*
             * Here, the node is added to the end of the list before the operation is performed.
             * This is to ensure that, in the event the user picks the last element, the operation
             * is still performed on the element
             */
            puzzleList.addNode(new GameNode(randGen));
            // triggers the computation on the node chosen by the user and combines the node element
            puzzleList.applyOperatorToNumber(numberCommand, GameOperator.getFromChar(userOperator));
          } else { // if the number chosen by the user is not in the the list, an exception is
                   // thrown
            throw new DataFormatException(
                "WARNING! Please choose a number that is present in the list");
          }

        } else { // if the user operator is not chosen from ALL_OPERATORS, an exception is thrown
          throw new DataFormatException("WARNING! Please choose a valid operator");
        }
      } catch (DataFormatException dfe) { // catches exception thrown for incorrect operator
        System.out.println(dfe.getMessage()); // and incorrect number
      } catch (NumberFormatException nfe) { // catches exception thrown by Integer.parseInt(), if
        // anything other than a integer is present in a string
        System.out.println("WARNING! Please add numbers for your integer");
      }

      /*
       * checks if the goal has been reached by the user and executes the congratulation message.
       * The program ends after the break is encountered
       */
      if (puzzleList.contains(goal)) {
        System.out.println("Goal: " + goal + " Moves Taken: " + moveCounter);
        System.out.println("Puzzle: " + puzzleList);
        System.out
            .println("Congrats on winning the math game in " + moveCounter + " moves! Goodbye!");
        break;
      }
    } while (true); // loop runs as long as the user does not quit or the goal has not been reaced
    scnr.close(); // Scanner object is closed to prevent data leak
  }

}

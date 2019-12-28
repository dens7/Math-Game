import java.util.Random;

////////////////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION/////////////////////////////////
//
// Title: Math Game
// Files: GameNode.java, GameList.java, GameOperator.java, GameApplication.java, GameTests.java
// Course: CS 300 Fall term 2018
// Author: Vedaant Tambi
// Email: tambi@wisc.edu
// Lecturer's Name: MOUNA AYARI BEN HADJ KACEM
//
/////////////////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION /////////////////////////////
//
// Partner Name: Keith Westpfahl
// Partner Email: westpfaul@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
////////////////////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////////////
//                                                 NONE
/////////////////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////////////

/**
 * This class is the test class for the methods in GameNode class and GameList class. Test methods 
 * are defined and the results of the tests are displayed to the user
 * 
 * @author Vedaant Tambi, Keith Westpfahl
 * @version 1.0
 * @since 1.0
 */
public class GameTests {
  /**
   * Tests whether the number assigned to the number field of GameNode,by the constructor, is
   * between 0 and 9 only
   * 
   * @returns true for correct functionality, false otherwise
   */
  public static boolean test1GameNodeNumberTest() {
    Random randGen = new Random(); // random object to pass it to the GameNOde constructor
    GameNode testNode = new GameNode(randGen);
    // makes sure the number of the node is between 0 and 9 inclusive
    if ((testNode.getNumber() >= 0) && (testNode.getNumber() < 10)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks whether the 1st node in a list of 2 nodes points to the 2nd node after the 'next' of the
   * node has been set to refer to the 2nd node, i.e. GameNode.setNext() is tested
   * 
   * @returns true for correct functionality, false otherwise
   */
  public static boolean test1GameNodeSetNextTest() {
    Random randGen = new Random(); // random object to pass it to the GameNOde constructor
    // Declaration and initialization of both nodes
    GameNode node1 = new GameNode(randGen);
    GameNode node2 = new GameNode(randGen);
    int num = node2.getNumber(); // 'number' of the second node is stored in an int for comparison
    node1.setNext(node2); // node1 points to node2 now
    if (node1.getNext().getNumber() == num) { // checks whether node2 stores the value of int num
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks whether the right output is printed when the puzzle list is empty, i.e.
   * GameList.toString() is tested.
   * 
   * @returns true for correct functionality, false otherwise
   */
  public static boolean test1GameListStringToMethodTest() {
    GameList emptyList = new GameList(); // empty GameList
    // equality is tested using equals() method
    return emptyList.toString().equals("No puzzle available right now");
  }

  /**
   * Checks GameList.contains() method. An added node in a list is tested if it's present in the
   * list.
   * 
   * @returns true for correct functionality, false otherwise
   */
  public static boolean test1GameListContainsTest() {
    Random randGen = new Random(); // Random object declared is passed to the object
    GameList testList = new GameList(); // empty GameList
    GameNode num = new GameNode(randGen); // new Node is instantiated
    testList.addNode(num); // new node is added to the list
    // checks and returns if the node is present in the list
    return testList.contains(num.getNumber());
  }

  /**
   * This method is responsible for calling the tests methods defined in this class. It provides the
   * user with the results of the functionality of the methods being tested.
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Each test is called sequentially and the test methods are called to display the results
    System.out.println("test1GameNodeNumberTest(): " + test1GameNodeNumberTest());
    System.out.println("test1GameNodeSetNextTest(): " + test1GameNodeSetNextTest());
    System.out.println("test1GameListStringToMethodTest(): " + test1GameListStringToMethodTest());
    System.out.println("test1GameListContainsTest(): " + test1GameListContainsTest());
  }

}

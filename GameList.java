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
//                                                NONE
/////////////////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////////////


/**
 * This class represents a linked list of numbers (i.e. nodes). Each member of the list points to
 * the next element of the list
 * 
 * @author Vedaant Tambi, Keith Westpfahl
 * @version 1.0
 * @since 1.0
 */
public class GameList {
  private GameNode list; // reference to the first GameNode in this list

  /**
   * Constructor that initializes the head(i.e. the first element of the list to null)
   * 
   */
  public GameList() {
    this.list = null; // initializes list to start out empty
  }

  /**
   * Adds a new node of type GameNode to the linked list
   * 
   * @param newNode is the node (of type GameNode) being added to the linked list
   */
  public void addNode(GameNode newNode) {
    if (this.list == null) { // checks if the list is empty
      this.list = newNode; // if the list is empty, the new node is initialized to the first node
    } else {
      GameNode runner = this.list;
      // loop is advanced till the last node on the list is reached
      while (runner.getNext() != null) { // loop is exited once the next element is null
        runner = runner.getNext(); // advances the runner
      }
      runner.setNext(newNode); // the last node points to the newNode; the newNode is last node now
      runner = null; // the runner is set to null to deallocate memory
    }
    newNode = null; // after the new node has been added, newNode is set to null to deallocate
                    // memory
  }

  /**
   * Checks whether the linked list contains a node holding the value of the given number or not
   * 
   * @param number is the number to be checked
   * @return true if the number is present in the list or false otherwise
   */
  public boolean contains(int number) {
    if (this.list == null) // if the list empty, no node is present
      return false;
    GameNode runner = this.list; // create a runner pointer and initialize it to head
    // traverse the list looking for a match with number
    while (runner != null && !(runner.getNumber() == number)) {
      runner = runner.getNext(); // advance runner
    }

    if (runner != null) // item found
      return true;
    else // list entirely traversed without finding a match with specified number
      return false;
  } // only returns true when this list contains a node with the specified number

  /**
   * Returns a string with each number in the list separated by " -> "s, and ending with " -> END"
   * 
   * @return message which gives the status of the List as a string
   */
  @Override
  public String toString() {
    String message = new String();
    if (this.list == null) { // checks whether the list is empty
      message = "No puzzle available right now";
      return message;
    } else {
      GameNode runner = this.list; // declares runner for list traversal; initializes it to 1st node
      while (runner.getNext() != null) {
        message += (runner.getNumber() + " -> "); // each node is concatenated to the String
        runner = runner.getNext(); // the runner is advanced
      }
      message += (runner.getNumber() + " -> END"); // this adds the the last element to the list
      runner = null; // runner is set to null and the memory is deallocated
    }
    return message;
  }

  /**
   * Runs through the list of GameNodes and performs the operation specifies by the operator on the
   * given number
   * 
   * @param number chosen by the user, on which the operation is to be done
   * @param operator chosen by the user, which triggers the operation on the operands
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {
    GameNode runner = this.list; // the runner traverses the linked list
    while (runner != null) {
      if (runner.getNumber() == number) { // checks whether the user number matches the list number
        runner.applyOperator(operator); // once the operation is performed, the break statement is
        break; // encountered and the traversal is stopped.
      }
      runner = runner.getNext(); // advances the runner
    }
  }

}

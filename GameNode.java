import java.util.Random;

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
// Partner Name:    Keith Westpfaul
// Partner Email:   westpfaul@wisc.edu
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
 * This class represents a number (i.e. node) within a list of such numbers (i.e. linked list). Each
 * node holds a reference to the next number in the list
 * 
 * @author Vedaant Tambi, Keith Westpfaul
 * @version 1.0
 * @since 1.0
 */
public class GameNode {

  private int number; // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node

  /**
   * Constructor that initializes the number data field's value to a number between 0 and 9 and the
   * reference to the next node to null.
   * 
   * @param rng is the random number generating object used for initializing number
   */
  public GameNode(Random rng) {
    number = rng.nextInt(10);
    next = null;
  } // initializes number to random 0-9 value, and next to null

  /**
   * 
   * @return the private data field number
   */
  public int getNumber() {
    return this.number;
  } // accessor for the number field

  /**
   * 
   * @return the private data field next (the reference to the next node)
   */
  public GameNode getNext() {
    return next;
  } // accessor for the next field

  /**
   * Mutates the next data field to store a reference to another node
   * 
   * @param next is the new node that the next data field will be assigned
   */
  public void setNext(GameNode next) {
    this.next = next;
  } // mutator for the next field

  /**
   * Applies the operation on the node's number specified by the operator. This method also makes
   * sure that the next data field refers to the next element in the linked list (i.e. the one after
   * the newly computed node)
   * 
   * @param operator is the operator chosen by the user to trigger the computation
   */
  public void applyOperator(GameOperator operator) {
    number = operator.apply(this.number, this.next.getNumber());
    next = this.next.getNext();
  }

}

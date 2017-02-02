import java.util.*;
import java.io.*;
public class VarTest {
  public static void main(String args[]){
    variableInputs(4, 5, 6, 7, 8, 104324);
  }

  static void variableInputs(int...numbers){
    for(int num: numbers){
      System.out.println(num);
    }
  }
}

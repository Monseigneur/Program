/**
 * 
 * @author Milan
 *
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ProgramRunner {
  public static final int WORD_SIZE = 4;
  public static final int ADDR_SIZE = 4000;
  public static final int START_OF_TEXT = 10;
  public static final int START_OF_STACK = ADDR_SIZE - 1;

  public static void main(String[] args) {
    if (args.length != 1) {
      Usage();
      return;
    }
    
    ISA isa = new ISA();
    char[] addrSpace = loadTextRegion(args[0], isa);
    CPU cpu = new CPU(START_OF_TEXT, addrSpace, isa);
    
    cpu.run();
    
    Util.printHex(addrSpace, START_OF_TEXT, 40);
    
    cpu.printRegs();
  }
  
  private static void Usage() {
    System.out.println("USAGE: java ProgramRunner FILENAME");
  }
  
  private static char[] loadTextRegion(String filename, ISA isa) {
    Scanner file;
    try {
      file = new Scanner(new File(filename));      
    } catch (IOException e) {
      return null;
    }
    char[] addrSpace = new char[ADDR_SIZE];
    
    int index = START_OF_TEXT;
    
    while (file.hasNextLine()) {
      String codeLine = file.nextLine();
      Scanner lineScanner = new Scanner(codeLine);
      
      String command = lineScanner.next();
      
      int len = isa.getParamNum(command);
      int paramFlags = 0x0;
      
      int[] params = new int[len];
      for (int i = 0; i < params.length; i++) {
        if (lineScanner.hasNextInt()) {
          params[i] = lineScanner.nextInt();
        } else {
          params[i] = CPU.getRegNum(lineScanner.next().substring(1));
          paramFlags |= (2 - i);
        }
      }
      
      addrSpace[index] = isa.getOpCode(command);
      index++;
      addrSpace[index] = (char)paramFlags;
      index++;
      
      for (int i = 0; i < params.length; i++) {
        char[] arr = Util.intToCharArr(params[i]);
        for (int j = 0; j < arr.length; j++) {
          addrSpace[index] = arr[j];
          index++;
        }
      }
      
      lineScanner.close();
      System.out.println(codeLine);
    }
    
    file.close();
    
    return addrSpace;
  }
  

  

  

}

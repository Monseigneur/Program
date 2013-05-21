/**
 * 
 * @author Milan
 *
 */

public class CPU {
  char[] addrSpace;
  ISA isa;
  
  /* Registers */
  public static final String[] REGISTERS = {
    "eax",
    "ebx",
    "ecx",
    "edx",
    "esp",
    "ebp"
  };
  
  public int[] regs;
  
  private int eip;

  public CPU(int pc, char[] addr, ISA i) {
    regs = new int[6];
    eip = pc;
    addrSpace = addr;
    isa = i;
  }
  
  public void run() {
    char opcode = addrSpace[eip++];
    char paramFlags = addrSpace[eip++];
    
    
  }
  
  public void printRegs() {
    for (int i = 0; i < REGISTERS.length; i++) {
      System.out.println(REGISTERS[i] + ": " + regs[i]);
    }
  }
  
  public static int getRegNum(String reg) {
    if (reg.equals("eax")) {
      return 1;
    } else if (reg.equals("ebx")){
      return 2;
    } else if (reg.equals("ecx")) {
      return 3;
    } else if (reg.equals("edx")) {
      return 4;
    } else if (reg.equals("esp")) {
      return 5;
    } else if (reg.equals("ebp")) {
      return 6;
    } else {
      return 7;
    }
  }
}

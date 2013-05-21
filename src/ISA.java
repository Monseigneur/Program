/**
 * 
 * @author Milan
 *
 */

import java.util.HashMap;
import java.util.Map;

public class ISA {
  /* FORM: command -> [OPCODE, NUM_PARAM, LEN] */
  public static Map<String, Integer[]> codesMap;
  
  public ISA() {
    fillMap();
  }
  
  public int getLen(String command) {
    return codesMap.get(command)[2];
  }
  
  public int getParamNum(String command) {
    return codesMap.get(command)[1];
  }
  
  public char getOpCode(String command) {
    return (char)codesMap.get(command)[0].intValue();
  }
  
  private void fillMap() {
    codesMap = new HashMap<String, Integer[]>();
    codesMap.put("movl", new Integer[] {0x1, 2, 10});
    codesMap.put("addl", new Integer[] {0x2, 2, 10});
    codesMap.put("subl", new Integer[] {0x3, 2, 10});
  }
}

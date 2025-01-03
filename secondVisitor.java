import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class secondVisitor extends DepthFirstAdapter  {
    private Hashtable symtable;	
    private Hashtable valuetable;
    private Map<String, List<FunctionSignature>> functionsMap;

	secondVisitor(Hashtable symtable, Hashtable valuetable,Map<String, List<FunctionSignature>> functionsMap) 
	{
		this.symtable = symtable;
        this.valuetable = valuetable;
        this.functionsMap = functionsMap;
	}


    public void inAFunctionCall(AFunctionCall node){
        String functionName = node.getId().getText();
        if(!functionsMap.containsKey(functionName)){
            //System.out.println("H sunarthsh den uparxei");
        }
        else{
            // Kapoios elegxos
        }
    }
}
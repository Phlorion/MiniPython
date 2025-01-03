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
        int line = node.getId().getLine();
        int col = node.getId().getLine();
        if(!functionsMap.containsKey(functionName)){
            System.out.println("Line: " + line + " Column: " + col + " function " + functionName + " not defined.");
        }
        else{
            // check if arguments are aligned with any function signature
            LinkedList args = node.getArglist();
            int args_size = args.size();
            List func_signatures = functionsMap.get(functionName);
            boolean found_signature = false;

            for(Object o : func_signatures){
                FunctionSignature fs = (FunctionSignature)o;
                int default_args = fs.getDefaultArgs();
                int required_args = fs.getRequiredArgs();
                if(args_size > default_args + required_args || args_size < required_args){
                    //incorrect signature
                }
                else{
                    //correct signature
                    found_signature = true;
                }
            }

            if(!found_signature){
                System.out.println("Line: " + line + " Column: " + col + " invalid arguments for function " + functionName);
            }

        }
    }
}
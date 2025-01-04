import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class secondVisitor extends DepthFirstAdapter  {
    @SuppressWarnings({ "rawtypes", "unused" })
    private Hashtable symtable;	
    @SuppressWarnings({ "unused", "rawtypes" })
    private Hashtable valuetable;
    private Map<String, List<FunctionSignature>> functionsMap;

	@SuppressWarnings("rawtypes")
    secondVisitor(Hashtable symtable, Hashtable valuetable,Map<String, List<FunctionSignature>> functionsMap) 
	{
		this.symtable = symtable;
        this.valuetable = valuetable;
        this.functionsMap = functionsMap;
	}

    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void inAFunctionCall(AFunctionCall node){
        String functionName = node.getId().getText();
        int line = node.getId().getLine();
        int col = node.getId().getLine();
        if(!functionsMap.containsKey(functionName)){
            System.out.println("Line: " + line + " Column: " + col + " function " + functionName + " not defined.");
        }
        else{
            // check if arguments are aligned with any function signature
            LinkedList argListObj = node.getArglist();
            AArglist argListProduction = (AArglist)argListObj.getFirst();
            
            ArrayList args = new ArrayList<PExpression>();
            args.add(argListProduction.getL());
            args.addAll(argListProduction.getMultExprs());
            int args_size = args.size();
            List func_signatures = functionsMap.get(functionName);
            boolean found_signature = false;
            FunctionSignature valid_signature;

            for(Object o : func_signatures){
                FunctionSignature fs = (FunctionSignature)o;
                int default_args = fs.getDefaultArgs();
                int required_args = fs.getRequiredArgs();
                if(args_size > default_args + required_args || args_size < required_args){
                    //incorrect signature
                    continue;
                }
                else{
                    //correct signature
                    found_signature = true;
                    valid_signature = fs;
                }
            }

            if(!found_signature){
                System.out.println("Line: " + line + " Column: " + col + " invalid arguments for function " + functionName);
            }
            else{
                //register argument value types into the function's arguments
                
            }

        }
    }
}
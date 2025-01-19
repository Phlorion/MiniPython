import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import minipython.analysis.*;
import minipython.node.*;

public class thirdVisitor extends DepthFirstAdapter {
    @SuppressWarnings({ "rawtypes", "unused" })
    private Hashtable symtable;	
    @SuppressWarnings({ "unused", "rawtypes" })
    private Hashtable valuetable;
    private Map<String, List<FunctionSignature>> functionsMap;
    @SuppressWarnings("rawtypes")
    private Hashtable function_calls;
    @SuppressWarnings("rawtypes")
    private Hashtable function_returns;

	@SuppressWarnings("rawtypes")
    thirdVisitor(Hashtable symtable, Hashtable valuetable,Map<String, List<FunctionSignature>> functionsMap, Hashtable function_calls, Hashtable function_returns) 
	{
		this.symtable = symtable;
        this.valuetable = valuetable;
        this.functionsMap = functionsMap;
        this.function_calls = function_calls;
        this.function_returns = function_returns;
	}

    public void inAAdditionExpression (AAdditionExpression node){
        PExpression left = node.getL();
        PExpression right = node.getR();

        inOperationExpression(left, right, "addition", node);
    }

    public void inASubtractionExpression (ASubtractionExpression node){
        PExpression left = node.getL();
        PExpression right = node.getR();

        inOperationExpression(left, right, "subtraction", node);
    }

    public void inAMultiplicationExpression (AMultiplicationExpression node){
        PExpression left = node.getL();
        PExpression right = node.getR();

        inOperationExpression(left, right, "multiplication", node);
    }

    public void inADivisionExpression (ADivisionExpression node){
        PExpression left = node.getL();
        PExpression right = node.getR();

        inOperationExpression(left, right, "division", node);
    }
   
    public void inAModuloExpression(AModuloExpression node) {
        PExpression left = node.getL();
        PExpression right = node.getR();

        inOperationExpression(left, right, "modulo", node);
    }

    public void inAPowerExpression(APowerExpression node) {
        PExpression left = node.getL();
        PExpression right = node.getR();

        inOperationExpression(left, right, "power", node);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void inOperationExpression(PExpression first, PExpression second, String operation, Node node) {
        //find out if this expression is inside a function
        //look for the "final" parent of this node either program or function
        Node parent_of_this = node.parent();
        String parent_type;
        AFunction this_Function = null;
        while(true){
            if(parent_of_this instanceof AProgramme){
                parent_type = "program";
                break;
            }
            else if (parent_of_this instanceof AFunction){
                parent_type = "function";
                this_Function = (AFunction)parent_of_this;
                break; 
            }
            parent_of_this = parent_of_this.parent();
        }

        //get all function calls
        switch (parent_type) {
            //if program is final parent, we arent inside a function def
            case "program":
                // already checked this expression on first visitor
                return;
    
            //if function is final parent, we are inside a function def
            case "function":
                //we need to check recorded function calls
                break;
        }

        //find function calls related to this function
        String func_name = this_Function.getId().getText();
        ArrayList calls =(ArrayList)function_calls.get(func_name);
        //find function's signature
        LinkedList<PArguements> args = this_Function.getArguements();
        int req_args = 0;
        int def_args = 0;
        if(args.size()==0){
            //0 args in func def. i.e. def foo():...
        }
        else{
            AArguements eachArguements = (AArguements)args.get(0);
            //check first argument
            if(eachArguements.getValue().size()==0){
                req_args++;
            }
            else{
                def_args++;
            }
            //check multiple arguments
            for(Object o : eachArguements.getMultipleargs()){
                AMultipleargs mult_arg = (AMultipleargs)o;
                if(mult_arg.getValue().size()==0){
                    req_args++;
                }
                else{
                    def_args++;
                }
            }
        }

        //find calls related to this function's signature
        for(Object o : calls){
            ArrayList<PExpression> call = (ArrayList)o;
            int call_size = call.size();
            if(call_size < req_args || call_size > req_args + def_args){
                //not matching call to this signature
                continue;
            }

            //matching call to this signature
            //assign values to all function parameters
            //System.out.println("Executing call for: " + func_name + call.toString());
            if(args.size()>0){
                int index = 0;
                AArguements eachArg = (AArguements)args.get(0);

                String param;
                param = eachArg.getId().toString();

                PExpression call_argExpression;
                call_argExpression = call.get(index);

                PValue val;
                if(call_argExpression instanceof AIdExpression){
                    //copy type of variable and use it for the param
                    valuetable.put(param, (String)valuetable.get(((AIdExpression)call_argExpression).getId().toString()));
                }
                else if (call_argExpression instanceof AValueExpression){ 
                    val = ((AValueExpression)call_argExpression).getValue();
                    if(val instanceof ANoneValue){
                        valuetable.put(param, "none");
                    }
                    else if (val instanceof ANumberValue){
                        valuetable.put(param, "num");
                    }
                    else if (val instanceof ASlitValue){
                        valuetable.put(param, "str");
                    }
                    else {
                        valuetable.put(param, "func_call");
                    }
                }
                else if (call_argExpression instanceof AFunctionCallExpression){
                    valuetable.put(param, "func_call");
                }

                index++;
                LinkedList mult_args = eachArg.getMultipleargs();
                while (index < call.size()) {
                    param = ((AMultipleargs)mult_args.get(index-1)).getId().toString();
                    call_argExpression = call.get(index);
                    if(call_argExpression instanceof AIdExpression){
                        //copy type of variable and use it for the param
                        valuetable.put(param, (String)valuetable.get(((AIdExpression)call_argExpression).getId().toString()));
                    }
                    else if (call_argExpression instanceof AValueExpression){ 
                        val = ((AValueExpression)call_argExpression).getValue();
                        if(val instanceof ANoneValue){
                            valuetable.put(param, "none");
                        }
                        else if (val instanceof ANumberValue){
                            valuetable.put(param, "num");
                        }
                        else if (val instanceof ASlitValue){
                            valuetable.put(param, "str");
                        }
                        else {
                            valuetable.put(param, "func_call");
                        }
                    }
                    else if (call_argExpression instanceof AFunctionCallExpression){
                        valuetable.put(param, "func_call");
                    }
                    
                    index++;
                    
                    //updating of func params is finished, check type missmatches in expression
                    findTypeMissmatch(first, second, operation, call, func_name);
                }
            }  
        }
    }

    private void findTypeMissmatch(PExpression first, PExpression second, String operation, ArrayList<PExpression> call, String func_name){
        String f_type = "";
        int line = 0;
        // check left part of the operation
        if (first instanceof AValueExpression) {
            AValueExpression valueExp = (AValueExpression) first;
            if (valueExp.getValue() instanceof ANoneValue) {
                TNone none = ((ANoneValue) valueExp.getValue()).getNone();
                System.out.println("Line: " + none.getLine() + ", Cannot perform " + operation + " with keyword " + none.toString().trim());
            }
            else if (valueExp.getValue() instanceof ANumberValue){
                f_type = "num";
                line = ((ANumberValue)valueExp.getValue()).getNumber().getLine();
            }
            else if(valueExp.getValue() instanceof ASlitValue){
                f_type = "str";
                line = ((ASlitValue)valueExp.getValue()).getStringLiteral().getLine();
            }
            else{
                f_type = "func_call";
                line = ((AFuncCallValue)valueExp.getValue()).getId().getLine();
            }
        }
        else if(first instanceof AFunctionCallExpression){
            f_type = "func_call";
            line = ((AFunctionCall)((AFunctionCallExpression)first).getFunctionCall()).getId().getLine();
        }
        else if(first instanceof AIdExpression){
            f_type = (String) valuetable.get(((AIdExpression)first).getId().toString());
            line = ((AIdExpression)first).getId().getLine();
        }
        else if(first instanceof ALengthExpression || first instanceof AMinExpression || first instanceof AMaxExpression || first instanceof APowerExpression ||
        first instanceof AMultiplicationExpression || first instanceof AModuloExpression || first instanceof ADivisionExpression){
            f_type = "num";
            line = 0; //too bored to calculate all if statements
        }
        else if(first instanceof AAsciiValExpression){
            f_type = "str";
            line = ((AAsciiValExpression)first).getId().getLine();
        }
        
        String s_type = "";
        // check right part of the operation
        if (second instanceof AValueExpression) {
            AValueExpression valueExp = (AValueExpression) second;
            if (valueExp.getValue() instanceof ANoneValue) {
                TNone none = ((ANoneValue) valueExp.getValue()).getNone();
                System.out.println("Line: " + none.getLine() + ", Cannot perform " + operation + " with keyword " + none.toString().trim());
            }
            else if (valueExp.getValue() instanceof ANumberValue){
                s_type = "num";
                line = ((ANumberValue)valueExp.getValue()).getNumber().getLine();
            }
            else if(valueExp.getValue() instanceof ASlitValue){
                s_type = "str";
                line = ((ASlitValue)valueExp.getValue()).getStringLiteral().getLine();
            }
            else{
                s_type = "func_call";
                line = ((AFuncCallValue)valueExp.getValue()).getId().getLine();
            }
        }
        else if(second instanceof AFunctionCallExpression){
            s_type = "func_call";
            line = ((AFunctionCall)((AFunctionCallExpression)second).getFunctionCall()).getId().getLine();
        }
        else if(second instanceof AIdExpression){
            s_type = (String) valuetable.get(((AIdExpression)second).getId().toString());
            line = ((AIdExpression)second).getId().getLine();
        }
        else if(second instanceof ALengthExpression || second instanceof AMinExpression || second instanceof AMaxExpression || second instanceof APowerExpression ||
        second instanceof AMultiplicationExpression || second instanceof AModuloExpression || second instanceof ADivisionExpression){
            s_type = "num";
            line = 0; //too bored to calculate all if statements
        }
        else if(second instanceof AAsciiValExpression){
            s_type = "str";
            line = ((AAsciiValExpression)second).getId().getLine();
        }

        if(f_type.equals("func_call")){
            //we need to get the type from the relative func table
            Map<String, Object> func__call_pair = new HashMap<>();
            func__call_pair.put(func_name, call);
            
            // find in func_returns hash table
            if (function_returns.get(func__call_pair).equals(ANoneValue.class.getName())) {
                System.out.println("Line: " + line + ", Cannot perform " + operation + " with value none");
                f_type = "none";
            }
            else if (function_returns.get(func__call_pair).equals(ANumberValue.class.getName())) {
                f_type = "num";
            }
            else if (function_returns.get(func__call_pair).equals(ASlitValue.class.getName())) {
                f_type = "str";
            }
            
        }
        if(s_type.equals("func_call")){
            //we need to get the type from the relative func table
            Map<String, Object> func__call_pair = new HashMap<>();
            func__call_pair.put(func_name, call);
            
            // find in func_returns hash table
            if (function_returns.get(func__call_pair).equals(ANoneValue.class.getName())) {
                System.out.println("Line: " + line + ", Cannot perform " + operation + " with value none");
                s_type = "none";
            }
            else if (function_returns.get(func__call_pair).equals(ANumberValue.class.getName())) {
                s_type = "num";
            }
            else if (function_returns.get(func__call_pair).equals(ASlitValue.class.getName())) {
                s_type = "str";
            }
        }

        if(!f_type.equals(s_type) && !f_type.equals("") && !s_type.equals("")){
            System.out.println("Line: " + line + " type missmatch for " + operation + " between " + f_type + " and " + s_type + " for call: " + func_name + call.toString());
        }
    }
}

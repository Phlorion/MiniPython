import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class firstVisitor extends DepthFirstAdapter  {
    @SuppressWarnings("rawtypes")
    private Hashtable symtable;	
    @SuppressWarnings("rawtypes")
    private Hashtable valuetable;
    private Map<String, List<FunctionSignature>> functionsMap;
    @SuppressWarnings("rawtypes")
    private Hashtable function_calls;

	@SuppressWarnings("rawtypes")
    firstVisitor(Hashtable symtable, Hashtable valuetable,Map<String, List<FunctionSignature>> functionsMap, Hashtable function_calls) 
	{
		this.symtable = symtable;
        this.valuetable = valuetable;
        this.functionsMap = functionsMap;
        this.function_calls = function_calls;
	}


    // assign statements
	@SuppressWarnings({ "unchecked" })
    public void inAAssignEqStatement(AAssignEqStatement node) 
	{
		String varName = node.getId().toString();
		symtable.put(varName, node);

        // keep track of each variable's value type
        PExpression rhs = node.getExpression();
        if (rhs instanceof AValueExpression){
            PValue val = ((AValueExpression)rhs).getValue();

            if(val instanceof ANoneValue){
                valuetable.put(varName, "none");
            }
            else if (val instanceof ANumberValue){
                valuetable.put(varName, "num");
            }
            else if (val instanceof ASlitValue){
                valuetable.put(varName, "str");
            }
            else {
                valuetable.put(varName, "func_call");
            }
        }
	}

    public void inAAssignMineqStatement (AAssignMineqStatement node){
        String varName = node.getId().toString();
		int line = node.getId().getLine();
        int pos = node.getId().getPos();
        if(!symtable.containsKey(varName)){
            System.out.println("Line: " + line + " Column: " + pos + ", variable " + varName.trim() + " not defined");
        }
    }

    public void inAAssignDiveqStatement (AAssignDiveqStatement node){
        String varName = node.getId().toString();
		int line = node.getId().getLine();
        int pos = node.getId().getPos();
        if(!symtable.containsKey(varName)){
            System.out.println("Line: " + line + " Column: " + pos + ", variable " + varName.trim() + " not defined");
        }
    }

    public void inAArrayAssignStatement(AArrayAssignStatement node){
        TId id = node.getId();
        if(!symtable.containsKey(id.toString())){
            System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
        }

        PExpression index = node.getIndex();
        if(index instanceof AIdExpression){
            TId indexId = ((AIdExpression)index).getId();
            if(!symtable.containsKey(indexId.toString())){
                System.out.println("Line: " + indexId.getLine() + " Column: " + indexId.getPos() + ", variable " + indexId.toString().trim() + " not defined");
            }
        }

        PExpression rightSide = node.getRightSide();
        if(rightSide instanceof AIdExpression){
            TId rightsideId = ((AIdExpression)rightSide).getId();
            if(!symtable.containsKey(rightsideId.toString())){
                System.out.println("Line: " + rightsideId.getLine() + " Column: " + rightsideId.getPos() + ", variable " + rightsideId.toString().trim() + " not defined");
            }
        }
    }


    // print statement
    public void inAPrintStatement(APrintStatement node){
        PExpression firstExp = node.getL();
        if(firstExp instanceof AIdExpression){
            TId firstId = ((AIdExpression)firstExp).getId();
            if(!symtable.containsKey(firstId.toString())){
                System.out.println("Line: " + firstId.getLine() + " Column: " + firstId.getPos() + ", variable " + firstId.toString().trim() + " not defined");
            }
        }

        for(Object o: node.getCommaExp()){
            PExpression pexp = (PExpression) o;
            if(pexp instanceof AIdExpression){
                TId id = ((AIdExpression)pexp).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
            }
        }
    }

    // return statement
    public void inAReturnStatement(AReturnStatement node){
        PExpression exp = node.getExpression();
        if(exp instanceof AIdExpression){
            TId firstId = ((AIdExpression)exp).getId();
            if(!symtable.containsKey(firstId.toString())){
                System.out.println("Line: " + firstId.getLine() + " Column: " + firstId.getPos() + ", variable " + firstId.toString().trim() + " not defined");
            }
        }
    }

    // for statement
    public void inAForStatement(AForStatement node){
        TId element = node.getElement();
        if(!symtable.containsKey(element.toString())){
            System.out.println("Line: " + element.getLine() + " Column: " + element.getPos() + ", variable " + element.toString().trim() + " not defined");
        }

        TId collection = node.getCollection();
        if(!symtable.containsKey(collection.toString())){
            System.out.println("Line: " + collection.getLine() + " Column: " + collection.getPos() + ", variable " + collection.toString().trim() + " not defined");
        }

    }

    // assert statement
    public void inAAssertStatement (AAssertStatement node){
        PExpression l_exp = node.getL();
        if(l_exp instanceof AIdExpression){
            TId exp_id = ((AIdExpression)l_exp).getId();
                if(!symtable.containsKey(exp_id.toString())){
                    System.out.println("Line: " + exp_id.getLine() + " Column: " + exp_id.getPos() + ", variable " + exp_id.toString().trim() + " not defined");
                }
        }

        for (Object exp : node.getCommaExp()) {
            if((PExpression)exp instanceof AIdExpression){
                TId cexp_id = ((AIdExpression)exp).getId();
                if(!symtable.containsKey(cexp_id.toString())){
                    System.out.println("Line: " + cexp_id.getLine() + " Column: " + cexp_id.getPos() + ", variable " + cexp_id.toString().trim() + " not defined");
                }
            }
        }
    }

    // gia kapoio logo den douleuei
    //
    // // id expression 
    // public void AIdExpression(AIdExpression node){
    //     TId id = node.getId();
    //     if(!symtable.containsKey(id)){
    //         System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
    //     }
    // }

    /**
     * Check for 'None' and different value types in operations
     */
    private void inOperationExpression(PExpression first, PExpression second, String operation, Node node) {

        //find out if this expression is inside a function
        //look for the "final" parent of this node either program or function
        Node parent_of_this = node.parent();
        String parent_type;
        while(true){
            if(parent_of_this instanceof AProgramme){
                parent_type = "program";
                break;
            }
            else if (parent_of_this instanceof AFunction){
                parent_type = "function";
                break; 
            }
            parent_of_this = parent_of_this.parent();
        }
        
        switch (parent_type) {
            //if program is final parent, we arent inside a function def
            case "program":
                // keep checking and compare types
                break;
    
            //if function is final parent, we are inside a function def
            case "function":
                // no need to check on first visitor
                // skip this expression
                return;
        }


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
        }
        if(s_type.equals("func_call")){
            //we need to get the type from the relative func table
        }

        if(!f_type.equals(s_type)){
            System.out.println("Line: " + line + " type missmatch for " + operation + " between " + f_type + " and " + s_type);
        }
    }

    // arithmetic expressions
    public void inAAdditionExpression (AAdditionExpression node){
        PExpression left = node.getL();
        PExpression right = node.getR();
        if (left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }
        if (right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }

        // check if adding with None keyword
        inOperationExpression(left, right, "addition", node);
    }

    public void inASubtractionExpression (ASubtractionExpression node){
        PExpression left = node.getL();
        PExpression right = node.getR();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }

        // check if subtracting with None keyword
        inOperationExpression(left, right, "subtraction", node);
    }

    public void inAMultiplicationExpression (AMultiplicationExpression node){
        PExpression left = node.getL();
        PExpression right = node.getR();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }

        // check if multiplying with None keyword
        inOperationExpression(left, right, "multiplication", node);
    }

    public void inADivisionExpression (ADivisionExpression node){
        PExpression left = node.getL();
        PExpression right = node.getR();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }

        // check if dividing with None keyword
        inOperationExpression(left, right, "division", node);
    }
   
    public void inAModuloExpression(AModuloExpression node) {
        PExpression left = node.getL();
        PExpression right = node.getR();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }

        // check if modulo with None keyword
        inOperationExpression(left, right, "modulo", node);
    }

    public void inAPowerExpression(APowerExpression node) {
        PExpression left = node.getL();
        PExpression right = node.getR();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
        }

        // check if powering with None keyword
        inOperationExpression(left, right, "power", node);
    }

    // list element expression
    public void inAListElementExpression (AListElementExpression node){
        TId id = node.getId();
        if(!symtable.containsKey(id.toString())){
            System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
        }

        PExpression exp = node.getExpression();
        if(exp instanceof AIdExpression){
            TId exp_id = ((AIdExpression)exp).getId();
                if(!symtable.containsKey(exp_id.toString())){
                    System.out.println("Line: " + exp_id.getLine() + " Column: " + exp_id.getPos() + ", variable " + exp_id.toString().trim() + " not defined");
                }
        }
    }

    // len expression
    public void inALengthExpression (ALengthExpression node){
        PExpression exp = node.getExpression();
        if(exp instanceof AIdExpression){
            TId exp_id = ((AIdExpression)exp).getId();
                if(!symtable.containsKey(exp_id.toString())){
                    System.out.println("Line: " + exp_id.getLine() + " Column: " + exp_id.getPos() + ", variable " + exp_id.toString().trim() + " not defined");
                }
        }
    }

    // parenthesis expression
    public void inAParenthesisExpressionExpression (AParenthesisExpressionExpression node){
        PExpression exp = node.getExpression();
        if(exp instanceof AIdExpression){
            TId exp_id = ((AIdExpression)exp).getId();
                if(!symtable.containsKey(exp_id.toString())){
                    System.out.println("Line: " + exp_id.getLine() + " Column: " + exp_id.getPos() + ", variable " + exp_id.toString().trim() + " not defined");
                }
        }
    }


    // min expression
    public void inAMinExpression (AMinExpression node){
    }

    // max expression
    public void inAMaxExpression (AMaxExpression node){
    }

    // list expression
    public void inAListExpression (AListExpression node){
    }


    // ascii expression
    public void inAAsciiValExpression (AAsciiValExpression node){
        TId id = node.getId();
        if(!symtable.containsKey(id.toString())){
            System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
        }
    }


    // comparisons
    public void inAGreatComparisons (AGreatComparisons node){
        PExpression left = node.getLexpr();
        PExpression right = node.getRexpr();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
    }

    public void inALessComparisons (ALessComparisons node){
        PExpression left = node.getLexpr();
        PExpression right = node.getRexpr();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
    }

    
    public void inAGreatEqComparisons (AGreatEqComparisons node){
        PExpression left = node.getLexpr();
        PExpression right = node.getRexpr();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
    }

    public void inALessEqComparisons (ALessEqComparisons node){
        PExpression left = node.getLexpr();
        PExpression right = node.getRexpr();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
    }

    public void inANotEqComparisons (ANotEqComparisons node){
        PExpression left = node.getLexpr();
        PExpression right = node.getRexpr();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
    }
    
    public void inACompEqComparisons (ACompEqComparisons node){
        PExpression left = node.getLexpr();
        PExpression right = node.getRexpr();
        if(left instanceof AIdExpression){
            TId id = ((AIdExpression)left).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
        if(right instanceof AIdExpression){
            TId id = ((AIdExpression)right).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
                }
        }
    }

    // id.func_call value
    public void inAFuncCallValue (AFuncCallValue node){
            TId id = node.getId();
            if(!symtable.containsKey(id.toString())){
                System.out.println("Line: " + id.getLine() + " Column: " + id.getPos() + ", variable " + id.toString().trim() + " not defined");
            }
    }



    // Check function definition
    @SuppressWarnings("unchecked")
    public void inAFunction (AFunction node){
        boolean prevArgDefault = false;
        boolean errorInArgs = false;
        boolean functionConflict = false;
        int requiredArgs = 0;
        int defaultArgs = 0;
        String functionName = node.getId().getText();
        List<PArguements> arguments = node.getArguements();
        if(arguments.size() == 0){      // Periptwsh pou den exei arguments def foo(): ...
            if(!functionsMap.containsKey(functionName)){
                List<FunctionSignature> tempList = new ArrayList<>();
                tempList.add(new FunctionSignature(0, 0));
                functionsMap.put(functionName,tempList);
            }
            else{
                for(FunctionSignature functionSignature: functionsMap.get(functionName)){
                    if(functionSignature.getRequiredArgs() == 0){ // Prosthetoume thn foo(). An uparxei hdh foo() h uparxei foo(a=1,b=1,..) error
                        System.out.println("Line " + node.getId().getLine() + ": Function " + functionName + " is already defined with the same number of arguments");
                        functionConflict = true;
                    }
                }
                if(!functionConflict){ 
                    functionsMap.get(functionName).add(new FunctionSignature(0, 0));
                }
            }
            //System.out.println("Oristike " + functionName + " me 0 orismata");
        }
        else{                           // Periptwsh pou exei 1 toulaxiston argument
            AArguements aArguments = (AArguements) arguments.get(0);
            String firstArg = aArguments.getId().toString();
            symtable.put(firstArg, node);
            if(valuetable.get(firstArg)==null){
                //assign the value type that is given as a default to the arg
                if (aArguments.getValue().size()>0) {
                    PValue val = (PValue)aArguments.getValue().get(0);
                    if(val instanceof ANoneValue){
                        valuetable.put(firstArg, "none");
                    }
                    else if (val instanceof ANumberValue){
                        valuetable.put(firstArg, "num");
                    }
                    else if (val instanceof ASlitValue){
                        valuetable.put(firstArg, "str");
                    }
                    else {
                        valuetable.put(firstArg, "func_call");
                    }
                }
                valuetable.put(firstArg, "num");
            }
            if(aArguments.getValue().size() == 0){
                requiredArgs = 1;
            }else{
                defaultArgs = 1;
                prevArgDefault = true;
            }
            for(Object o: aArguments.getMultipleargs()){
                AMultipleargs aMultArg = (AMultipleargs) o;
                if(aMultArg.getValue().size() == 0){
                    requiredArgs++;
                    if(prevArgDefault == true){
                        errorInArgs = true;
                    }
                }
                else{
                    defaultArgs++;
                    prevArgDefault = true;
                }
                String aMultArgName = aMultArg.getId().toString();
                symtable.put(aMultArgName, node);
                if(valuetable.get(aMultArgName)==null){
                    //assign the value type that is given as a default to the arg
                    if (aMultArg.getValue().size()>0) {
                        PValue val = (PValue)aMultArg.getValue().get(0);
                        if(val instanceof ANoneValue){
                            valuetable.put(aMultArgName, "none");
                        }
                        else if (val instanceof ANumberValue){
                            valuetable.put(aMultArgName, "num");
                        }
                        else if (val instanceof ASlitValue){
                            valuetable.put(aMultArgName, "str");
                        }
                        else {
                            valuetable.put(aMultArgName, "func_call");
                        }
                    }
                    valuetable.put(aMultArgName, "num");
                }
            }
            if(errorInArgs){  // Yparxei lathos tou tupou def foo(a=1,b):
                System.out.println("Line " + node.getId().getLine() + ": non-default argument follows default argument");
            }
            else{
                if(!functionsMap.containsKey(functionName)){
                    List<FunctionSignature> tempList = new ArrayList<>();
                    tempList.add(new FunctionSignature(requiredArgs, defaultArgs));
                    functionsMap.put(functionName,tempList);
                }
                else{
                    for(FunctionSignature functionSignature: functionsMap.get(functionName)){
                        if(functionConflict(requiredArgs,defaultArgs,functionSignature)){
                            System.out.println("Line " + node.getId().getLine() + ": Function " + functionName + " is already defined with the same number of arguments");
                            functionConflict = true;
                        } 
                    }
                    if(!functionConflict){
                        functionsMap.get(functionName).add(new FunctionSignature(requiredArgs, defaultArgs));
                    }
                }
            }
            //System.out.println("Oristike " + functionName + " me orismata required: " + requiredArgs + " default: " + defaultArgs);
        }
        

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void inAFunctionCall(AFunctionCall node){
        //record the function call to be used by the second visitor
        String func_name = node.getId().getText();
        ArrayList<PExpression> exps = new ArrayList<>();
        LinkedList arglist = node.getArglist();

        if(arglist.size()==0){
            if (function_calls.get(func_name)==null){
                ArrayList temp = new ArrayList<>();
                temp.add(exps);
                function_calls.put(func_name, temp);
                System.out.println("Recorded func call for func: " + func_name + exps.toString());
            }
            else{
              ((ArrayList)function_calls.get(func_name)).add(exps);
              System.out.println("Recorded func call for func: " + func_name + exps.toString());
            }
            return;
        }

        AArglist trueArgList = (AArglist)arglist.get(0);
        //add all parameter expressions
        exps.add(trueArgList.getL());
        for (Object object : trueArgList.getMultExprs()) {
            exps.add((PExpression)object);
        }

        //write array of calls
        if (function_calls.get(func_name)==null){
            ArrayList temp = new ArrayList<>();
            temp.add(exps);
            function_calls.put(func_name, temp);
            System.out.println("Recorded func call for func: " + func_name + exps.toString());
        }
        else{
          ((ArrayList)function_calls.get(func_name)).add(exps);
          System.out.println("Recorded func call for func: " + func_name + exps.toString());
        }
    }


    // Basismenh sta error pou exei h ekfwnhsh
    public boolean functionConflict(int requiredArgs, int defaultArgs, FunctionSignature fs){

        if(defaultArgs > 0 && fs.getRequiredArgs()-requiredArgs<=defaultArgs){     //Case 1
            return true;
        }

        if(fs.getDefaultArgs() == defaultArgs && fs.getRequiredArgs() == requiredArgs){ //Case 2
            return true;
        }

        if(fs.getDefaultArgs()+fs.getRequiredArgs() == requiredArgs+defaultArgs){
            return true;
        }


        return false;
    }
}
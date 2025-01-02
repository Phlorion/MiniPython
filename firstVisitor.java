import minipython.analysis.*;
import minipython.node.*;

import java.util.*;

public class firstVisitor extends DepthFirstAdapter  {
    private Hashtable symtable; 

	firstVisitor(Hashtable symtable) 
	{
		this.symtable = symtable;
	}

	public void inAAssignEqStatement(AAssignEqStatement node) 
	{
		String varName = node.getId().toString();
		int line = node.getId().getLine();
        int pos = node.getId().getPos();
		symtable.put(varName, node);
        // System.out.println("Oristike sti grammh " + line + " h metablhth " + varName);
	}

    public void inAPrintStatement(APrintStatement node){
        PExpression firstExp = node.getL();
        if(firstExp instanceof AIdExpression){
            TId firstId = ((AIdExpression)firstExp).getId();
            if(!symtable.containsKey(firstId.toString())){
                System.out.println("Line: " + firstId.getLine() + ", " + firstId.toString().trim() + " not defined");
            }
        }

        for(Object o: node.getCommaExp()){
            PExpression pexp = (PExpression) o;
            if(pexp instanceof AIdExpression){
                TId id = ((AIdExpression)pexp).getId();
                if(!symtable.containsKey(id.toString())){
                    System.out.println("Line: " + id.getLine() + ", " + id.toString().trim() + " not defined");
                }
            }
        }

    
    }


    /**
     * Check for 'None' in operations
     */
    private void inOperationExpression(PExpression first, PExpression second) {
        // check left part of the operation
        if (first instanceof AValueExpression) {
            AValueExpression valueExp = (AValueExpression) first;
            if (valueExp.getValue() instanceof ANoneValue) {
                TNone none = ((ANoneValue) valueExp.getValue()).getNone();
                System.out.println("Line: " + none.getLine() + ", Cannot perform operation with keyword " + none.toString().trim());
            }
        }
        
        // check right part of the operation
        if (second instanceof AValueExpression) {
            AValueExpression valueExp = (AValueExpression) second;
            if (valueExp.getValue() instanceof ANoneValue) {
                TNone none = ((ANoneValue) valueExp.getValue()).getNone();
                System.out.println("Line: " + none.getLine() + ", Cannot perform operation with keyword " + none.toString().trim());
            }
        }
    }

    // addition
    public void inAAdditionExpression(AAdditionExpression node) {
        PExpression firstExp = node.getL();
        PExpression secondExp = node.getR();
        
        inOperationExpression(firstExp, secondExp);
    }

    // subtraction
    public void inASubtractionExpression(ASubtractionExpression node) {
        PExpression firstExp = node.getL();
        PExpression secondExp = node.getR();
        
        inOperationExpression(firstExp, secondExp);
    }

    // multiplication
}
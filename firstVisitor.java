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
}
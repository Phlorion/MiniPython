/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.analysis;

import java.util.*;
import minipython.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(Node node)
    {
    }

    public void defaultOut(Node node)
    {
    }

    public void caseStart(Start node)
    {
        inStart(node);
        node.getPProgramme().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAProgramme(AProgramme node)
    {
        defaultIn(node);
    }

    public void outAProgramme(AProgramme node)
    {
        defaultOut(node);
    }

    public void caseAProgramme(AProgramme node)
    {
        inAProgramme(node);
        {
            Object temp[] = node.getCommands().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PCommands) temp[i]).apply(this);
            }
        }
        outAProgramme(node);
    }

    public void inAStatCommands(AStatCommands node)
    {
        defaultIn(node);
    }

    public void outAStatCommands(AStatCommands node)
    {
        defaultOut(node);
    }

    public void caseAStatCommands(AStatCommands node)
    {
        inAStatCommands(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAStatCommands(node);
    }

    public void inAFuncCommands(AFuncCommands node)
    {
        defaultIn(node);
    }

    public void outAFuncCommands(AFuncCommands node)
    {
        defaultOut(node);
    }

    public void caseAFuncCommands(AFuncCommands node)
    {
        inAFuncCommands(node);
        if(node.getFunction() != null)
        {
            node.getFunction().apply(this);
        }
        outAFuncCommands(node);
    }

    public void inAIfStatement(AIfStatement node)
    {
        defaultIn(node);
    }

    public void outAIfStatement(AIfStatement node)
    {
        defaultOut(node);
    }

    public void caseAIfStatement(AIfStatement node)
    {
        inAIfStatement(node);
        if(node.getComparisons() != null)
        {
            node.getComparisons().apply(this);
        }
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAIfStatement(node);
    }

    public void inAWhileStatement(AWhileStatement node)
    {
        defaultIn(node);
    }

    public void outAWhileStatement(AWhileStatement node)
    {
        defaultOut(node);
    }

    public void caseAWhileStatement(AWhileStatement node)
    {
        inAWhileStatement(node);
        if(node.getComparisons() != null)
        {
            node.getComparisons().apply(this);
        }
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAWhileStatement(node);
    }

    public void inAForStatement(AForStatement node)
    {
        defaultIn(node);
    }

    public void outAForStatement(AForStatement node)
    {
        defaultOut(node);
    }

    public void caseAForStatement(AForStatement node)
    {
        inAForStatement(node);
        if(node.getElement() != null)
        {
            node.getElement().apply(this);
        }
        if(node.getCollection() != null)
        {
            node.getCollection().apply(this);
        }
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAForStatement(node);
    }

    public void inAReturnStatement(AReturnStatement node)
    {
        defaultIn(node);
    }

    public void outAReturnStatement(AReturnStatement node)
    {
        defaultOut(node);
    }

    public void caseAReturnStatement(AReturnStatement node)
    {
        inAReturnStatement(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAReturnStatement(node);
    }

    public void inAPrintStatement(APrintStatement node)
    {
        defaultIn(node);
    }

    public void outAPrintStatement(APrintStatement node)
    {
        defaultOut(node);
    }

    public void caseAPrintStatement(APrintStatement node)
    {
        inAPrintStatement(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        {
            Object temp[] = node.getCommaExp().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PExpression) temp[i]).apply(this);
            }
        }
        outAPrintStatement(node);
    }

    public void inAAssignEqStatement(AAssignEqStatement node)
    {
        defaultIn(node);
    }

    public void outAAssignEqStatement(AAssignEqStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssignEqStatement(AAssignEqStatement node)
    {
        inAAssignEqStatement(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAAssignEqStatement(node);
    }

    public void inAAssignMineqStatement(AAssignMineqStatement node)
    {
        defaultIn(node);
    }

    public void outAAssignMineqStatement(AAssignMineqStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssignMineqStatement(AAssignMineqStatement node)
    {
        inAAssignMineqStatement(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAAssignMineqStatement(node);
    }

    public void inAAssignDiveqStatement(AAssignDiveqStatement node)
    {
        defaultIn(node);
    }

    public void outAAssignDiveqStatement(AAssignDiveqStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssignDiveqStatement(AAssignDiveqStatement node)
    {
        inAAssignDiveqStatement(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAAssignDiveqStatement(node);
    }

    public void inAArrayAssignStatement(AArrayAssignStatement node)
    {
        defaultIn(node);
    }

    public void outAArrayAssignStatement(AArrayAssignStatement node)
    {
        defaultOut(node);
    }

    public void caseAArrayAssignStatement(AArrayAssignStatement node)
    {
        inAArrayAssignStatement(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getIndex() != null)
        {
            node.getIndex().apply(this);
        }
        if(node.getRightSide() != null)
        {
            node.getRightSide().apply(this);
        }
        outAArrayAssignStatement(node);
    }

    public void inAAssertStatement(AAssertStatement node)
    {
        defaultIn(node);
    }

    public void outAAssertStatement(AAssertStatement node)
    {
        defaultOut(node);
    }

    public void caseAAssertStatement(AAssertStatement node)
    {
        inAAssertStatement(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        {
            Object temp[] = node.getCommaExp().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PExpression) temp[i]).apply(this);
            }
        }
        outAAssertStatement(node);
    }

    public void inAFuncCallStatement(AFuncCallStatement node)
    {
        defaultIn(node);
    }

    public void outAFuncCallStatement(AFuncCallStatement node)
    {
        defaultOut(node);
    }

    public void caseAFuncCallStatement(AFuncCallStatement node)
    {
        inAFuncCallStatement(node);
        if(node.getFunctionCall() != null)
        {
            node.getFunctionCall().apply(this);
        }
        outAFuncCallStatement(node);
    }

    public void inAImportStatement(AImportStatement node)
    {
        defaultIn(node);
    }

    public void outAImportStatement(AImportStatement node)
    {
        defaultOut(node);
    }

    public void caseAImportStatement(AImportStatement node)
    {
        inAImportStatement(node);
        if(node.getImportCall() != null)
        {
            node.getImportCall().apply(this);
        }
        outAImportStatement(node);
    }

    public void inAFunction(AFunction node)
    {
        defaultIn(node);
    }

    public void outAFunction(AFunction node)
    {
        defaultOut(node);
    }

    public void caseAFunction(AFunction node)
    {
        inAFunction(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            Object temp[] = node.getArguements().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PArguements) temp[i]).apply(this);
            }
        }
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        outAFunction(node);
    }

    public void inAArguements(AArguements node)
    {
        defaultIn(node);
    }

    public void outAArguements(AArguements node)
    {
        defaultOut(node);
    }

    public void caseAArguements(AArguements node)
    {
        inAArguements(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            Object temp[] = node.getValue().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PValue) temp[i]).apply(this);
            }
        }
        {
            Object temp[] = node.getMultipleargs().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PMultipleargs) temp[i]).apply(this);
            }
        }
        outAArguements(node);
    }

    public void inAMultipleargs(AMultipleargs node)
    {
        defaultIn(node);
    }

    public void outAMultipleargs(AMultipleargs node)
    {
        defaultOut(node);
    }

    public void caseAMultipleargs(AMultipleargs node)
    {
        inAMultipleargs(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            Object temp[] = node.getValue().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PValue) temp[i]).apply(this);
            }
        }
        outAMultipleargs(node);
    }

    public void inAAdditionExpression(AAdditionExpression node)
    {
        defaultIn(node);
    }

    public void outAAdditionExpression(AAdditionExpression node)
    {
        defaultOut(node);
    }

    public void caseAAdditionExpression(AAdditionExpression node)
    {
        inAAdditionExpression(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        outAAdditionExpression(node);
    }

    public void inASubtractionExpression(ASubtractionExpression node)
    {
        defaultIn(node);
    }

    public void outASubtractionExpression(ASubtractionExpression node)
    {
        defaultOut(node);
    }

    public void caseASubtractionExpression(ASubtractionExpression node)
    {
        inASubtractionExpression(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        outASubtractionExpression(node);
    }

    public void inAMultiplicationExpression(AMultiplicationExpression node)
    {
        defaultIn(node);
    }

    public void outAMultiplicationExpression(AMultiplicationExpression node)
    {
        defaultOut(node);
    }

    public void caseAMultiplicationExpression(AMultiplicationExpression node)
    {
        inAMultiplicationExpression(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        outAMultiplicationExpression(node);
    }

    public void inADivisionExpression(ADivisionExpression node)
    {
        defaultIn(node);
    }

    public void outADivisionExpression(ADivisionExpression node)
    {
        defaultOut(node);
    }

    public void caseADivisionExpression(ADivisionExpression node)
    {
        inADivisionExpression(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        outADivisionExpression(node);
    }

    public void inAModuloExpression(AModuloExpression node)
    {
        defaultIn(node);
    }

    public void outAModuloExpression(AModuloExpression node)
    {
        defaultOut(node);
    }

    public void caseAModuloExpression(AModuloExpression node)
    {
        inAModuloExpression(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        outAModuloExpression(node);
    }

    public void inAPowerExpression(APowerExpression node)
    {
        defaultIn(node);
    }

    public void outAPowerExpression(APowerExpression node)
    {
        defaultOut(node);
    }

    public void caseAPowerExpression(APowerExpression node)
    {
        inAPowerExpression(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        outAPowerExpression(node);
    }

    public void inAListElementExpression(AListElementExpression node)
    {
        defaultIn(node);
    }

    public void outAListElementExpression(AListElementExpression node)
    {
        defaultOut(node);
    }

    public void caseAListElementExpression(AListElementExpression node)
    {
        inAListElementExpression(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAListElementExpression(node);
    }

    public void inAFunctionCallExpression(AFunctionCallExpression node)
    {
        defaultIn(node);
    }

    public void outAFunctionCallExpression(AFunctionCallExpression node)
    {
        defaultOut(node);
    }

    public void caseAFunctionCallExpression(AFunctionCallExpression node)
    {
        inAFunctionCallExpression(node);
        if(node.getFunctionCall() != null)
        {
            node.getFunctionCall().apply(this);
        }
        outAFunctionCallExpression(node);
    }

    public void inAValueExpression(AValueExpression node)
    {
        defaultIn(node);
    }

    public void outAValueExpression(AValueExpression node)
    {
        defaultOut(node);
    }

    public void caseAValueExpression(AValueExpression node)
    {
        inAValueExpression(node);
        if(node.getValue() != null)
        {
            node.getValue().apply(this);
        }
        outAValueExpression(node);
    }

    public void inAIdExpression(AIdExpression node)
    {
        defaultIn(node);
    }

    public void outAIdExpression(AIdExpression node)
    {
        defaultOut(node);
    }

    public void caseAIdExpression(AIdExpression node)
    {
        inAIdExpression(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdExpression(node);
    }

    public void inALengthExpression(ALengthExpression node)
    {
        defaultIn(node);
    }

    public void outALengthExpression(ALengthExpression node)
    {
        defaultOut(node);
    }

    public void caseALengthExpression(ALengthExpression node)
    {
        inALengthExpression(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outALengthExpression(node);
    }

    public void inAAsciiValExpression(AAsciiValExpression node)
    {
        defaultIn(node);
    }

    public void outAAsciiValExpression(AAsciiValExpression node)
    {
        defaultOut(node);
    }

    public void caseAAsciiValExpression(AAsciiValExpression node)
    {
        inAAsciiValExpression(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAAsciiValExpression(node);
    }

    public void inAMinExpression(AMinExpression node)
    {
        defaultIn(node);
    }

    public void outAMinExpression(AMinExpression node)
    {
        defaultOut(node);
    }

    public void caseAMinExpression(AMinExpression node)
    {
        inAMinExpression(node);
        if(node.getLvalue() != null)
        {
            node.getLvalue().apply(this);
        }
        {
            Object temp[] = node.getMultVals().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PValue) temp[i]).apply(this);
            }
        }
        outAMinExpression(node);
    }

    public void inAMaxExpression(AMaxExpression node)
    {
        defaultIn(node);
    }

    public void outAMaxExpression(AMaxExpression node)
    {
        defaultOut(node);
    }

    public void caseAMaxExpression(AMaxExpression node)
    {
        inAMaxExpression(node);
        if(node.getLvalue() != null)
        {
            node.getLvalue().apply(this);
        }
        {
            Object temp[] = node.getMultVals().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PValue) temp[i]).apply(this);
            }
        }
        outAMaxExpression(node);
    }

    public void inAParenthesisExpressionExpression(AParenthesisExpressionExpression node)
    {
        defaultIn(node);
    }

    public void outAParenthesisExpressionExpression(AParenthesisExpressionExpression node)
    {
        defaultOut(node);
    }

    public void caseAParenthesisExpressionExpression(AParenthesisExpressionExpression node)
    {
        inAParenthesisExpressionExpression(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAParenthesisExpressionExpression(node);
    }

    public void inAListExpression(AListExpression node)
    {
        defaultIn(node);
    }

    public void outAListExpression(AListExpression node)
    {
        defaultOut(node);
    }

    public void caseAListExpression(AListExpression node)
    {
        inAListExpression(node);
        if(node.getLvalue() != null)
        {
            node.getLvalue().apply(this);
        }
        {
            Object temp[] = node.getMultVals().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PValue) temp[i]).apply(this);
            }
        }
        outAListExpression(node);
    }

    public void inAImportImportCall(AImportImportCall node)
    {
        defaultIn(node);
    }

    public void outAImportImportCall(AImportImportCall node)
    {
        defaultOut(node);
    }

    public void caseAImportImportCall(AImportImportCall node)
    {
        inAImportImportCall(node);
        if(node.getModule() != null)
        {
            node.getModule().apply(this);
        }
        {
            Object temp[] = node.getAsIdent().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PAsIdent) temp[i]).apply(this);
            }
        }
        {
            Object temp[] = node.getCmodAsIdent().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PCmodAsIdent) temp[i]).apply(this);
            }
        }
        outAImportImportCall(node);
    }

    public void inAFromImportImportCall(AFromImportImportCall node)
    {
        defaultIn(node);
    }

    public void outAFromImportImportCall(AFromImportImportCall node)
    {
        defaultOut(node);
    }

    public void caseAFromImportImportCall(AFromImportImportCall node)
    {
        inAFromImportImportCall(node);
        if(node.getModule() != null)
        {
            node.getModule().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            Object temp[] = node.getAsIdent().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PAsIdent) temp[i]).apply(this);
            }
        }
        {
            Object temp[] = node.getCidentAsIdent().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PCidentAsIdent) temp[i]).apply(this);
            }
        }
        outAFromImportImportCall(node);
    }

    public void inACmodAsIdent(ACmodAsIdent node)
    {
        defaultIn(node);
    }

    public void outACmodAsIdent(ACmodAsIdent node)
    {
        defaultOut(node);
    }

    public void caseACmodAsIdent(ACmodAsIdent node)
    {
        inACmodAsIdent(node);
        if(node.getModule() != null)
        {
            node.getModule().apply(this);
        }
        {
            Object temp[] = node.getAsIdent().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PAsIdent) temp[i]).apply(this);
            }
        }
        outACmodAsIdent(node);
    }

    public void inACidentAsIdent(ACidentAsIdent node)
    {
        defaultIn(node);
    }

    public void outACidentAsIdent(ACidentAsIdent node)
    {
        defaultOut(node);
    }

    public void caseACidentAsIdent(ACidentAsIdent node)
    {
        inACidentAsIdent(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            Object temp[] = node.getAsIdent().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PAsIdent) temp[i]).apply(this);
            }
        }
        outACidentAsIdent(node);
    }

    public void inAAsIdent(AAsIdent node)
    {
        defaultIn(node);
    }

    public void outAAsIdent(AAsIdent node)
    {
        defaultOut(node);
    }

    public void caseAAsIdent(AAsIdent node)
    {
        inAAsIdent(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAAsIdent(node);
    }

    public void inAModule(AModule node)
    {
        defaultIn(node);
    }

    public void outAModule(AModule node)
    {
        defaultOut(node);
    }

    public void caseAModule(AModule node)
    {
        inAModule(node);
        {
            Object temp[] = node.getIdentDot().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PIdentDot) temp[i]).apply(this);
            }
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAModule(node);
    }

    public void inAIdentDot(AIdentDot node)
    {
        defaultIn(node);
    }

    public void outAIdentDot(AIdentDot node)
    {
        defaultOut(node);
    }

    public void caseAIdentDot(AIdentDot node)
    {
        inAIdentDot(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIdentDot(node);
    }

    public void inAOrComparisons(AOrComparisons node)
    {
        defaultIn(node);
    }

    public void outAOrComparisons(AOrComparisons node)
    {
        defaultOut(node);
    }

    public void caseAOrComparisons(AOrComparisons node)
    {
        inAOrComparisons(node);
        if(node.getC1() != null)
        {
            node.getC1().apply(this);
        }
        if(node.getC2() != null)
        {
            node.getC2().apply(this);
        }
        outAOrComparisons(node);
    }

    public void inAAndComparisons(AAndComparisons node)
    {
        defaultIn(node);
    }

    public void outAAndComparisons(AAndComparisons node)
    {
        defaultOut(node);
    }

    public void caseAAndComparisons(AAndComparisons node)
    {
        inAAndComparisons(node);
        if(node.getC1() != null)
        {
            node.getC1().apply(this);
        }
        if(node.getC2() != null)
        {
            node.getC2().apply(this);
        }
        outAAndComparisons(node);
    }

    public void inANotComparisons(ANotComparisons node)
    {
        defaultIn(node);
    }

    public void outANotComparisons(ANotComparisons node)
    {
        defaultOut(node);
    }

    public void caseANotComparisons(ANotComparisons node)
    {
        inANotComparisons(node);
        if(node.getComparisons() != null)
        {
            node.getComparisons().apply(this);
        }
        outANotComparisons(node);
    }

    public void inAGreatComparisons(AGreatComparisons node)
    {
        defaultIn(node);
    }

    public void outAGreatComparisons(AGreatComparisons node)
    {
        defaultOut(node);
    }

    public void caseAGreatComparisons(AGreatComparisons node)
    {
        inAGreatComparisons(node);
        if(node.getLexpr() != null)
        {
            node.getLexpr().apply(this);
        }
        if(node.getRexpr() != null)
        {
            node.getRexpr().apply(this);
        }
        outAGreatComparisons(node);
    }

    public void inALessComparisons(ALessComparisons node)
    {
        defaultIn(node);
    }

    public void outALessComparisons(ALessComparisons node)
    {
        defaultOut(node);
    }

    public void caseALessComparisons(ALessComparisons node)
    {
        inALessComparisons(node);
        if(node.getLexpr() != null)
        {
            node.getLexpr().apply(this);
        }
        if(node.getRexpr() != null)
        {
            node.getRexpr().apply(this);
        }
        outALessComparisons(node);
    }

    public void inAGreatEqComparisons(AGreatEqComparisons node)
    {
        defaultIn(node);
    }

    public void outAGreatEqComparisons(AGreatEqComparisons node)
    {
        defaultOut(node);
    }

    public void caseAGreatEqComparisons(AGreatEqComparisons node)
    {
        inAGreatEqComparisons(node);
        if(node.getLexpr() != null)
        {
            node.getLexpr().apply(this);
        }
        if(node.getRexpr() != null)
        {
            node.getRexpr().apply(this);
        }
        outAGreatEqComparisons(node);
    }

    public void inALessEqComparisons(ALessEqComparisons node)
    {
        defaultIn(node);
    }

    public void outALessEqComparisons(ALessEqComparisons node)
    {
        defaultOut(node);
    }

    public void caseALessEqComparisons(ALessEqComparisons node)
    {
        inALessEqComparisons(node);
        if(node.getLexpr() != null)
        {
            node.getLexpr().apply(this);
        }
        if(node.getRexpr() != null)
        {
            node.getRexpr().apply(this);
        }
        outALessEqComparisons(node);
    }

    public void inANotEqComparisons(ANotEqComparisons node)
    {
        defaultIn(node);
    }

    public void outANotEqComparisons(ANotEqComparisons node)
    {
        defaultOut(node);
    }

    public void caseANotEqComparisons(ANotEqComparisons node)
    {
        inANotEqComparisons(node);
        if(node.getLexpr() != null)
        {
            node.getLexpr().apply(this);
        }
        if(node.getRexpr() != null)
        {
            node.getRexpr().apply(this);
        }
        outANotEqComparisons(node);
    }

    public void inACompEqComparisons(ACompEqComparisons node)
    {
        defaultIn(node);
    }

    public void outACompEqComparisons(ACompEqComparisons node)
    {
        defaultOut(node);
    }

    public void caseACompEqComparisons(ACompEqComparisons node)
    {
        inACompEqComparisons(node);
        if(node.getLexpr() != null)
        {
            node.getLexpr().apply(this);
        }
        if(node.getRexpr() != null)
        {
            node.getRexpr().apply(this);
        }
        outACompEqComparisons(node);
    }

    public void inATrueComparisons(ATrueComparisons node)
    {
        defaultIn(node);
    }

    public void outATrueComparisons(ATrueComparisons node)
    {
        defaultOut(node);
    }

    public void caseATrueComparisons(ATrueComparisons node)
    {
        inATrueComparisons(node);
        outATrueComparisons(node);
    }

    public void inAFalseComparisons(AFalseComparisons node)
    {
        defaultIn(node);
    }

    public void outAFalseComparisons(AFalseComparisons node)
    {
        defaultOut(node);
    }

    public void caseAFalseComparisons(AFalseComparisons node)
    {
        inAFalseComparisons(node);
        outAFalseComparisons(node);
    }

    public void inAFunctionCall(AFunctionCall node)
    {
        defaultIn(node);
    }

    public void outAFunctionCall(AFunctionCall node)
    {
        defaultOut(node);
    }

    public void caseAFunctionCall(AFunctionCall node)
    {
        inAFunctionCall(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        {
            Object temp[] = node.getArglist().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PArglist) temp[i]).apply(this);
            }
        }
        outAFunctionCall(node);
    }

    public void inAArglist(AArglist node)
    {
        defaultIn(node);
    }

    public void outAArglist(AArglist node)
    {
        defaultOut(node);
    }

    public void caseAArglist(AArglist node)
    {
        inAArglist(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        {
            Object temp[] = node.getMultExprs().toArray();
            for(int i = 0; i < temp.length; i++)
            {
                ((PExpression) temp[i]).apply(this);
            }
        }
        outAArglist(node);
    }

    public void inAFuncCallValue(AFuncCallValue node)
    {
        defaultIn(node);
    }

    public void outAFuncCallValue(AFuncCallValue node)
    {
        defaultOut(node);
    }

    public void caseAFuncCallValue(AFuncCallValue node)
    {
        inAFuncCallValue(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getFunctionCall() != null)
        {
            node.getFunctionCall().apply(this);
        }
        outAFuncCallValue(node);
    }

    public void inANumberValue(ANumberValue node)
    {
        defaultIn(node);
    }

    public void outANumberValue(ANumberValue node)
    {
        defaultOut(node);
    }

    public void caseANumberValue(ANumberValue node)
    {
        inANumberValue(node);
        if(node.getNumber() != null)
        {
            node.getNumber().apply(this);
        }
        outANumberValue(node);
    }

    public void inASlitValue(ASlitValue node)
    {
        defaultIn(node);
    }

    public void outASlitValue(ASlitValue node)
    {
        defaultOut(node);
    }

    public void caseASlitValue(ASlitValue node)
    {
        inASlitValue(node);
        if(node.getStringLiteral() != null)
        {
            node.getStringLiteral().apply(this);
        }
        outASlitValue(node);
    }

    public void inANoneValue(ANoneValue node)
    {
        defaultIn(node);
    }

    public void outANoneValue(ANoneValue node)
    {
        defaultOut(node);
    }

    public void caseANoneValue(ANoneValue node)
    {
        inANoneValue(node);
        if(node.getNone() != null)
        {
            node.getNone().apply(this);
        }
        outANoneValue(node);
    }
}

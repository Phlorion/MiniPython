import java.io.*;
import minipython.lexer.Lexer;
import minipython.parser.Parser;
import minipython.node.*;
import java.util.*;

public class ParserTest
{
  public static void main(String[] args)
  {
    try
    {
      Parser parser =
        new Parser(
        new Lexer(
        new PushbackReader(
        new FileReader("exampleFunctions.py"), 1024)));

     Hashtable symtable =  new Hashtable();
     Hashtable valuetable = new Hashtable();
     Map<String, List<FunctionSignature>> functionsMap = new HashMap<>();
     Start ast = parser.parse();
     ast.apply(new firstVisitor(symtable,valuetable,functionsMap));
     ast.apply(new secondVisitor(symtable, valuetable, functionsMap));
     /* Gia ton deutero visitor grapste thn entolh
      * ast.apply(new mysecondvisitor(symtable));
      */
    }
    catch (Exception e)
    {
      System.err.println(e);
    }
  }
}


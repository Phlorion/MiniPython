import java.io.*;
import minipython.lexer.Lexer;
import minipython.parser.Parser;
import minipython.node.*;
import java.util.*;

public class ParserTest
{
  @SuppressWarnings("rawtypes")
  public static void main(String[] args)
  {
    try
    {
      Parser parser =
        new Parser(
        new Lexer(
        new PushbackReader(new FileReader("example4.py"))));
        /*new FileReader(args[0].toString()), 1024))*/

     Hashtable symtable =  new Hashtable();
     Hashtable valuetable = new Hashtable();
     Map<String, List<FunctionSignature>> functionsMap = new HashMap<>();
     Hashtable function_calls = new Hashtable();
     Start ast = parser.parse();
     ast.apply(new firstVisitor(symtable,valuetable,functionsMap,function_calls));
     ast.apply(new secondVisitor(symtable, valuetable, functionsMap,function_calls));
     
    }
    catch (Exception e)
    {
      System.err.println(e);
    }
  }
}


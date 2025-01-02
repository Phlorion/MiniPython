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
        new FileReader(args[0].toString()), 1024)));

     Hashtable symtable =  new Hashtable();
     Hashtable valuetable = new Hashtable();
     Start ast = parser.parse();
     ast.apply(new firstVisitor(symtable,valuetable));
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


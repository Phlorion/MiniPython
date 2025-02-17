/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import minipython.analysis.*;

public final class TEqualEqual extends Token
{
    public TEqualEqual()
    {
        super.setText("==");
    }

    public TEqualEqual(int line, int pos)
    {
        super.setText("==");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TEqualEqual(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTEqualEqual(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TEqualEqual text.");
    }
}

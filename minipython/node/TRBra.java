/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import minipython.analysis.*;

public final class TRBra extends Token
{
    public TRBra()
    {
        super.setText("]");
    }

    public TRBra(int line, int pos)
    {
        super.setText("]");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TRBra(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTRBra(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TRBra text.");
    }
}

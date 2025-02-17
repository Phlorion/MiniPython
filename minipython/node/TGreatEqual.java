/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import minipython.analysis.*;

public final class TGreatEqual extends Token
{
    public TGreatEqual()
    {
        super.setText(">=");
    }

    public TGreatEqual(int line, int pos)
    {
        super.setText(">=");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TGreatEqual(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTGreatEqual(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TGreatEqual text.");
    }
}

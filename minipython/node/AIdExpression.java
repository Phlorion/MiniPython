/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AIdExpression extends PExpression
{
    private TId _id_;

    public AIdExpression()
    {
    }

    public AIdExpression(
        TId _id_)
    {
        setId(_id_);

    }
    public Object clone()
    {
        return new AIdExpression(
            (TId) cloneNode(_id_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIdExpression(this);
    }

    public TId getId()
    {
        return _id_;
    }

    public void setId(TId node)
    {
        if(_id_ != null)
        {
            _id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _id_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_id_);
    }

    void removeChild(Node child)
    {
        if(_id_ == child)
        {
            _id_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

    }
}

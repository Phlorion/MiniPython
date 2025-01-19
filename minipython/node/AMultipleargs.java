/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AMultipleargs extends PMultipleargs
{
    private TId _id_;
    private final LinkedList _value_ = new TypedLinkedList(new Value_Cast());

    public AMultipleargs()
    {
    }

    public AMultipleargs(
        TId _id_,
        List _value_)
    {
        setId(_id_);

        {
            this._value_.clear();
            this._value_.addAll(_value_);
        }

    }
    public Object clone()
    {
        return new AMultipleargs(
            (TId) cloneNode(_id_),
            cloneList(_value_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultipleargs(this);
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

    public LinkedList getValue()
    {
        return _value_;
    }

    public void setValue(List list)
    {
        _value_.clear();
        _value_.addAll(list);
    }

    public String toString()
    {
        return ""
            + toString(_id_)
            + toString(_value_);
    }

    void removeChild(Node child)
    {
        if(_id_ == child)
        {
            _id_ = null;
            return;
        }

        if(_value_.remove(child))
        {
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

        for(ListIterator i = _value_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

    }

    private class Value_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PValue node = (PValue) o;

            if((node.parent() != null) &&
                (node.parent() != AMultipleargs.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AMultipleargs.this))
            {
                node.parent(AMultipleargs.this);
            }

            return node;
        }
    }
}

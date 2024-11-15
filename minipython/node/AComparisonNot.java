/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AComparisonNot extends PComparisonNot
{
    private TNot _not_;
    private PComparison _comparison_;

    public AComparisonNot()
    {
    }

    public AComparisonNot(
        TNot _not_,
        PComparison _comparison_)
    {
        setNot(_not_);

        setComparison(_comparison_);

    }
    public Object clone()
    {
        return new AComparisonNot(
            (TNot) cloneNode(_not_),
            (PComparison) cloneNode(_comparison_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComparisonNot(this);
    }

    public TNot getNot()
    {
        return _not_;
    }

    public void setNot(TNot node)
    {
        if(_not_ != null)
        {
            _not_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _not_ = node;
    }

    public PComparison getComparison()
    {
        return _comparison_;
    }

    public void setComparison(PComparison node)
    {
        if(_comparison_ != null)
        {
            _comparison_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _comparison_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_not_)
            + toString(_comparison_);
    }

    void removeChild(Node child)
    {
        if(_not_ == child)
        {
            _not_ = null;
            return;
        }

        if(_comparison_ == child)
        {
            _comparison_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_not_ == oldChild)
        {
            setNot((TNot) newChild);
            return;
        }

        if(_comparison_ == oldChild)
        {
            setComparison((PComparison) newChild);
            return;
        }

    }
}

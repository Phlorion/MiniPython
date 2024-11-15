/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ALessEqComparison extends PComparison
{
    private PExpression _lexpr_;
    private TLessEqual _lessEqual_;
    private PExpression _rexpr_;

    public ALessEqComparison()
    {
    }

    public ALessEqComparison(
        PExpression _lexpr_,
        TLessEqual _lessEqual_,
        PExpression _rexpr_)
    {
        setLexpr(_lexpr_);

        setLessEqual(_lessEqual_);

        setRexpr(_rexpr_);

    }
    public Object clone()
    {
        return new ALessEqComparison(
            (PExpression) cloneNode(_lexpr_),
            (TLessEqual) cloneNode(_lessEqual_),
            (PExpression) cloneNode(_rexpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALessEqComparison(this);
    }

    public PExpression getLexpr()
    {
        return _lexpr_;
    }

    public void setLexpr(PExpression node)
    {
        if(_lexpr_ != null)
        {
            _lexpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lexpr_ = node;
    }

    public TLessEqual getLessEqual()
    {
        return _lessEqual_;
    }

    public void setLessEqual(TLessEqual node)
    {
        if(_lessEqual_ != null)
        {
            _lessEqual_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lessEqual_ = node;
    }

    public PExpression getRexpr()
    {
        return _rexpr_;
    }

    public void setRexpr(PExpression node)
    {
        if(_rexpr_ != null)
        {
            _rexpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rexpr_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_lexpr_)
            + toString(_lessEqual_)
            + toString(_rexpr_);
    }

    void removeChild(Node child)
    {
        if(_lexpr_ == child)
        {
            _lexpr_ = null;
            return;
        }

        if(_lessEqual_ == child)
        {
            _lessEqual_ = null;
            return;
        }

        if(_rexpr_ == child)
        {
            _rexpr_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_lexpr_ == oldChild)
        {
            setLexpr((PExpression) newChild);
            return;
        }

        if(_lessEqual_ == oldChild)
        {
            setLessEqual((TLessEqual) newChild);
            return;
        }

        if(_rexpr_ == oldChild)
        {
            setRexpr((PExpression) newChild);
            return;
        }

    }
}

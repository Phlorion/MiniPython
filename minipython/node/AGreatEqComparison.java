/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AGreatEqComparison extends PComparison
{
    private PExpression _lexpr_;
    private TGreatEqual _greatEqual_;
    private PExpression _rexpr_;

    public AGreatEqComparison()
    {
    }

    public AGreatEqComparison(
        PExpression _lexpr_,
        TGreatEqual _greatEqual_,
        PExpression _rexpr_)
    {
        setLexpr(_lexpr_);

        setGreatEqual(_greatEqual_);

        setRexpr(_rexpr_);

    }
    public Object clone()
    {
        return new AGreatEqComparison(
            (PExpression) cloneNode(_lexpr_),
            (TGreatEqual) cloneNode(_greatEqual_),
            (PExpression) cloneNode(_rexpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGreatEqComparison(this);
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

    public TGreatEqual getGreatEqual()
    {
        return _greatEqual_;
    }

    public void setGreatEqual(TGreatEqual node)
    {
        if(_greatEqual_ != null)
        {
            _greatEqual_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _greatEqual_ = node;
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
            + toString(_greatEqual_)
            + toString(_rexpr_);
    }

    void removeChild(Node child)
    {
        if(_lexpr_ == child)
        {
            _lexpr_ = null;
            return;
        }

        if(_greatEqual_ == child)
        {
            _greatEqual_ = null;
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

        if(_greatEqual_ == oldChild)
        {
            setGreatEqual((TGreatEqual) newChild);
            return;
        }

        if(_rexpr_ == oldChild)
        {
            setRexpr((PExpression) newChild);
            return;
        }

    }
}

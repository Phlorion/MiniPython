/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AImportImportCall extends PImportCall
{
    private TImport _import_;
    private PModule _module_;
    private PAsIdent _asIdent_;
    private final LinkedList _cmodAsIdent_ = new TypedLinkedList(new CmodAsIdent_Cast());

    public AImportImportCall()
    {
    }

    public AImportImportCall(
        TImport _import_,
        PModule _module_,
        PAsIdent _asIdent_,
        List _cmodAsIdent_)
    {
        setImport(_import_);

        setModule(_module_);

        setAsIdent(_asIdent_);

        {
            this._cmodAsIdent_.clear();
            this._cmodAsIdent_.addAll(_cmodAsIdent_);
        }

    }
    public Object clone()
    {
        return new AImportImportCall(
            (TImport) cloneNode(_import_),
            (PModule) cloneNode(_module_),
            (PAsIdent) cloneNode(_asIdent_),
            cloneList(_cmodAsIdent_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAImportImportCall(this);
    }

    public TImport getImport()
    {
        return _import_;
    }

    public void setImport(TImport node)
    {
        if(_import_ != null)
        {
            _import_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _import_ = node;
    }

    public PModule getModule()
    {
        return _module_;
    }

    public void setModule(PModule node)
    {
        if(_module_ != null)
        {
            _module_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _module_ = node;
    }

    public PAsIdent getAsIdent()
    {
        return _asIdent_;
    }

    public void setAsIdent(PAsIdent node)
    {
        if(_asIdent_ != null)
        {
            _asIdent_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _asIdent_ = node;
    }

    public LinkedList getCmodAsIdent()
    {
        return _cmodAsIdent_;
    }

    public void setCmodAsIdent(List list)
    {
        _cmodAsIdent_.clear();
        _cmodAsIdent_.addAll(list);
    }

    public String toString()
    {
        return ""
            + toString(_import_)
            + toString(_module_)
            + toString(_asIdent_)
            + toString(_cmodAsIdent_);
    }

    void removeChild(Node child)
    {
        if(_import_ == child)
        {
            _import_ = null;
            return;
        }

        if(_module_ == child)
        {
            _module_ = null;
            return;
        }

        if(_asIdent_ == child)
        {
            _asIdent_ = null;
            return;
        }

        if(_cmodAsIdent_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_import_ == oldChild)
        {
            setImport((TImport) newChild);
            return;
        }

        if(_module_ == oldChild)
        {
            setModule((PModule) newChild);
            return;
        }

        if(_asIdent_ == oldChild)
        {
            setAsIdent((PAsIdent) newChild);
            return;
        }

        for(ListIterator i = _cmodAsIdent_.listIterator(); i.hasNext();)
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

    private class CmodAsIdent_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PCmodAsIdent node = (PCmodAsIdent) o;

            if((node.parent() != null) &&
                (node.parent() != AImportImportCall.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AImportImportCall.this))
            {
                node.parent(AImportImportCall.this);
            }

            return node;
        }
    }
}

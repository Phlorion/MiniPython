def foo(a,b,c=1):
    return a+b+c
def foo(a):
    return a

assert foo(1)
assert foo(1,2)
assert foo(1,2,3)
assert foo(1,2,3,4) #error line 
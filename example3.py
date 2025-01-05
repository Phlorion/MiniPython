def foo(a,b,c=1):
    return "hello2"
def foo():
    return "hello"

assert foo()
assert foo(1)
assert foo(1,2)
assert foo(1,2,3)
assert foo(1,2,3,4) 
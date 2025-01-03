def foo(a,b,c=1):
    return a+b+c
def foo(a):
    return a

print foo(1)
print foo(1,2)
print foo(1,2,3)
print foo(1,2,3,4)
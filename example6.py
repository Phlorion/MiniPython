def foo(a, b, c=1):
    if a == a:
        return b
    
def foo():
    if 1 == 1:
        return 5 + 5

print foo(1, None)
print foo(1, 2)
print foo()
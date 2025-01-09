def foo(a, b, c=1):
    if a == a:
        return 5
    
def foo():
    if 1 == 1:
        return 5 + 5

print foo(1, 2)
print foo(1, 2, 3)
print foo()
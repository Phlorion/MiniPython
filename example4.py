x = 5
y = "string literal"
z = x + y
def foo(a,b,c=1):
    return a + b + c

def foo(a):
    return "hello"

print foo(1, "str", 2)
print foo(1, 2, 2)

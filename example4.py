x = 5
y = "string literal"
c = x + y
def foo(a,b,c=1):
    return a + b + c

def foo(a):
    return "hello"

print foo(1, "str")
print foo(2)

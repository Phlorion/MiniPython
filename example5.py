def addNone():
    a = None + 2
    b = 1 + None

def subNone():
    a = None - 5
    b = 10 - None

def mulNone():
    a = None * 3
    b = 4 * None

def divNone():
    a = None / 5
    b = 9 / None

def moduloNone():
    a = 3 % None
    b = None % 8

def powerNone():
    a = None ** 2
    b = 3 ** None

def noneWithIds():
    a = None
    b = None

    return a + 3 * b

def returnNone():
    return None

def noneWithFuncs():
    return returnNone() + 5 ** returnNone() % returnNone()
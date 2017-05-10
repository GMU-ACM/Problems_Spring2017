def solve(pancakes, k):
    flips = 0
    for i in range(0, len(pancakes) - k + 1):
        if pancakes[i] == 0:
            flip(pancakes, i, i + k)
            flips += 1
    return flips

def flip(pancakes, start, end):
    for i in range(start, end):
        if pancakes[i] == 1:
            pancakes[i] = 0
        else:
            pancakes[i] = 1

def check(pancakes):
    if 0 in pancakes:
        return False
    return True

def solver(pancakes, k):
    num_flips = solve(pancakes, k)
    valid = check(pancakes)
    if valid:
        print (num_flips)
    else:
        print ("IMPOSSIBLE")

pancakes = [1,0,0,1,0,0,1]
k = 3
solver(pancakes, k)
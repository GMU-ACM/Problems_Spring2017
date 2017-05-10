import sys

def solver(line):
    s = ["1","4","78"]
    if line in s:
        return "+"
    if line[-2:] == "35":
        return "-"
    if line[0] == "9" and line[-1:]:
        return "*"
    if line[0:3] == "190":
        return "?"

numLines = next(sys.stdin)
for i in range(0, int(numLines)):
    print (solver(next(sys.stdin).rstrip()))
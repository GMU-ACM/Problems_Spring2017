def check(number):
    digits = list(str(number))
    digits = [ int(x) for x in digits ]
    for i in range(0, len(digits) - 1):
        if (digits[i] > digits[i+1]):
            return False
    return True

def brute(max):
    while True:
        if check(max):
            return max
        max -= 1

def main():
    results = []
    with open("B-small-practice.in","r") as f:
        lines = f.readlines()
        for i in range(1, len(lines)):
            results.append(brute(int(lines[i])))
    with open("B-small-practice.out","w") as f:
        for i in range(0, len(results)):
            f.write("Case #" + str(i+1) + ": " + str(results[i]) + "\n")

if __name__ == "__main__":
    main()
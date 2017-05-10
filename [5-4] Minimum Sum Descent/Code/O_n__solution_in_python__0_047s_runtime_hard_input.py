class node:
    def __init__(self, value, left, right):
        self.value = value
        self.left = left
        self.right = right
        self.cost = 0
    def __str__(self):
        return "[" + str(self.left) + "|" + str(self.cost) + "|" + str(self.right) + "]"

def get_input(fileName):
    arr = []
    with open(fileName) as f:
        c = f.readline()
        for i in range(0, int(c)):
            line = f.readline().rstrip()
            for value in line.split(" "):
                arr.append(node(int(value), None, None))
    return make_relationships(c, arr)

def make_relationships(c, arr):
    current_value = 2
    end_line = 1
    line_pos = 0
    for i in range(0, len(arr) - int(c)):
        arr[i].left = current_value - 1
        arr[i].right = current_value + 1 - 1
        current_value += 1
        line_pos += 1
        if (line_pos == end_line):
            current_value += 1
            line_pos = 0
            end_line += 1
    return arr

def MSD(arr):
    for i in range(len(arr) - 1, -1, -1):
        if (arr[i].left == None):
            arr[i].cost = arr[i].value
        else:
            left = arr[arr[i].left].cost
            right = arr[arr[i].right].cost
            if (left < right):
                arr[i].cost = arr[i].value + left
            else:
                arr[i].cost = arr[i].value + right
    return arr[0].cost

def solve(fileName):
    arr = get_input(fileName)
    print("Minimum Sum Descent: " + str(MSD(arr)))

solve("hardInput")
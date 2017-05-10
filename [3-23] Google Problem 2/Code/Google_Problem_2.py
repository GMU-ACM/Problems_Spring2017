import fileinput

def sim_size(value, memory):
    return [-1]*value

def sim_alloc(value, memory):
    l = 0
    for i in range(0,len(memory)):
        if memory[i] == -1:
            l = 0
            for j in range(i, len(memory)):
                if memory[j] != -1:
                    break
                l += 1
                if l == value:
                    print (i)
                    return allocate_between(memory, i, j)
    print (-1)
    return memory

def allocate_between(memory, start, end):
    for i in range(start, end+1):
        memory[i] = start
    return memory

def sim_free(value, memory):
    for i in range(0, len(memory)):
        if memory[i] == value:
            memory[i] = -1
    return memory

memory = []

for line in fileinput.input():
    (command, value) = line.split(" ")
    if command == "size":
        memory = sim_size(int(value), memory)
    elif command == "alloc":
        memory = sim_alloc(int(value), memory)
    elif command == "free":
        memory = sim_free(int(value), memory)
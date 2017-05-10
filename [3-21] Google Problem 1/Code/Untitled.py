import fileinput

def queue(task, time):
    minutes = str(time)[-2:]
    if len(str(time)) == 4:
        hours = str(time)[:2]
    else:
        hours = str(time)[:1]
    minutes = (int(hours) * 60) + int(minutes)
    if task == 'A':
        wait_time = update(A, 5, minutes)
        A.append(minutes)
    elif task == 'B':
        wait_time = update(B, 10, minutes)
        B.append(minutes)
    else:
        wait_time = update(C, 20, minutes)
        C.append(minutes)
    return wait_time

def update(line, inc, time):
    i = 0
    while i < len(line):
        if line[i] + inc < time:
            line.pop(i)
        else:
            break
    end_time = 0
    if len(line) != 0:
        end_time = line[0] + inc
    for i in range(1,len(line)):
        end_time += inc
    if end_time > time:
        return end_time - time
    return 0

A = []
B = []
C = []

for line in fileinput.input():
    (task, time) = line.split(" ")
    print(queue(task, int(time)))

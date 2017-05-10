import time;

f = open(filepath);
file = True;

rowCount = int(f.readline().strip()) if file else int(input());

triangle = [None] * rowCount;

for i in range(rowCount):
    triangle[i] = [];
    raw = f.readline().strip().split(" ") if file else input().split(" ");
    for r in raw:
        triangle[i].append(int(r));

triangleMin = [];

for row in triangle:
    newRow = [];
    for e in row:
        newRow.append(-1);
    triangleMin.append(newRow);

def calcCost(row, col):
    if triangleMin[row][col] == -1:
        if row == rowCount-1:
            triangleMin[row][col] = triangle[row][col];
        else:
            triangleMin[row][col] = triangle[row][col] + min(calcCost(row+1, col), calcCost(row+1, col+1));
    return triangleMin[row][col];

def calcCostLikeAnAsshole(row, col):
    if triangleMin[row][col] == -1:
        if row == rowCount-1:
            triangleMin[row][col] = triangle[row][col];
        else:
            leftMinCost = triangleMin[row+1][col];
            rightMinCost = triangleMin[row+1][col+1];
        if leftMinCost == -1 and rightMinCost == -1:
            leftCost = triangle[row+1][col];
            rightCost = triangle[row+1][col+1];
            if leftCost > rightCost:
                rightMinCost = calcCostLikeAnAsshole(row+1, col+1);
                if leftCost > rightMinCost:
                    triangleMin[row][col] = triangle[row][col] + rightMinCost;
                else:
                    leftMinCost = calcCostLikeAnAsshole(row+1, col);
                    triangleMin[row][col] = triangle[row][col] + min(rightMinCost, leftMinCost);
            else:
                leftMinCost = calcCostLikeAnAsshole(row+1, col);
                if rightCost > leftMinCost:
                    triangleMin[row][col] = triangle[row][col] + leftMinCost;
                else:
                    rightMinCost = calcCostLikeAnAsshole(row+1, col+1);
                    triangleMin[row][col] = triangle[row][col] + min(rightMinCost, leftMinCost);
        elif leftMinCost == -1:
            leftCost = triangle[row+1][col];
            if leftCost > rightMinCost:
                triangleMin[row][col] = triangle[row][col] + rightMinCost;
            else:
                leftMinCost = calcCostLikeAnAsshole(row+1, col);
                triangleMin[row][col] = triangle[row][col] + min(rightMinCost, leftMinCost);
        elif rightMinCost == -1:
            rightCost = triangle[row+1][col+1];
            if rightCost > leftMinCost:
                triangleMin[row][col] = triangle[row][col] + leftMinCost;
            else:
                rightMinCost = calcCostLikeAnAsshole(row+1, col+1);
                triangleMin[row][col] = triangle[row][col] + min(rightMinCost, leftMinCost);
        else:
            triangleMin[row][col] = triangle[row][col] + min(rightMinCost, leftMinCost);
    return triangleMin[row][col];

start = time.time();
print (calcCost(0, 0));
print (time.time() - start);
start = time.time();
print (calcCostLikeAnAsshole(0, 0));
print (time.time() - start);
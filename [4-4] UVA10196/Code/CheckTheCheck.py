import sys
global black

def get_check(board):
    open_tiles = 0
    for i in range(0, 8):
        for j in range(0, 8):
            if board[i][j].lower() == "p":
                if check_pawn(board, i, j):
                    return True
            elif board[i][j].lower() == "r":
                if check_rook(board, i, j):
                    return True
            elif board[i][j].lower() == "b":
                if check_bishop(board, i, j):
                    return True
            elif board[i][j].lower() == "q":
                if check_queen(board, i, j):
                    return True
            elif board[i][j].lower() == "n":
                if check_knight(board, i, j):
                    return True
            else:
                open_tiles += 1
    if open_tiles >= 64:
        return None
    return False

def check_pawn(board, x, y):
    # Moving Up
    if board[x][y] == "P":
        if x > 1 and y < 6:
            if board[x-1][y+1] == "k":
                set_black()
                return True
        if x > 1 and y > 1:
            if board[x-1][y-1] == "k":
                set_black()
                return True
    # Moving Down
    else:
        if x < 6 and y < 6:
            if board[x+1][y+1] == "K":
                return True
        if x < 6 and y > 1:
            if board[x+1][y-1] == "K":
                return True
    return False

def check_rook(board, x, y):
    little = board[x][y].islower()
    # Moving right
    for i in range(0, 7 - x):
        if board[x + i][y] == "K" and little:
            set_black()
            return True
        elif board[x + i][y] == "k":
            set_black()
            return True
        elif board[x + i][y] != ".":
            break
    # Moving left
    for i in range(0, x):
        if board[x - i][y] == "K" and little:
            return True
        elif board[x - i][y] == "k":
            set_black()
            return True
        elif board[x + i][y] != ".":
            break
    # Moving up
    for i in range(0, y):
        if board[x][y - i] == "K" and little:
            return True
        elif board[x][y - i] == "k":
            set_black()
            return True
        elif board[x][y - i] != ".":
            break
    # Moving down
    for i in range(0, 7 - y):
        if board[x][y + i] == "K" and little:
            return True
        elif board[x][y + i] == "k":
            set_black()
            return True
        elif board[x][y-1] != ".":
            break
    return False

def check_bishop(board, x, y):
    little = board[x][y].islower()
    xMod = 0
    yMod = 0
    while (valid(x + xMod + 1, y + yMod + 1)):
        xMod += 1
        yMod += 1
        if board[x + xMod][y + yMod] == "K" and little:
            return True
        elif board[x + xMod][y + yMod] == "k":
            set_black()
            return True
        elif board[x + xMod][y + yMod] != ".":
            break
    xMod = 0
    yMod = 0
    while (valid(x + xMod - 1, y + yMod + 1)):
        xMod -= 1
        yMod += 1
        if board[x + xMod][y + yMod] == "K" and little:
            return True
        elif board[x + xMod][y + yMod] == "k":
            set_black()
            return True
        elif board[x + xMod][y + yMod] != ".":
            break
    xMod = 0
    yMod = 0
    while (valid(x + xMod + 1, y + yMod - 1)):
        xMod += 1
        yMod -= 1
        if board[x + xMod][y + yMod] == "K" and little:
            return True
        elif board[x + xMod][y + yMod] == "k":
            set_black()
            return True
        elif board[x + xMod][y + yMod] != ".":
            break
    xMod = 0
    yMod = 0
    while (valid(x + xMod - 1, y + yMod - 1)):
        xMod -= 1
        yMod -= 1
        if board[x + xMod][y + yMod] == "K" and little:
            return True
        elif board[x + xMod][y + yMod] == "k":
            set_black()
            return True
        elif board[x + xMod][y + yMod] != ".":
            break
    return False

def check_queen(board, x, y):
    if check_bishop(board, x, y):
        return True
    if check_rook(board, x, y):
        return True
    return False

def check_knight(board, x, y):
    little = board[x][y].islower()
    if valid(x+1, y+2):
        if board[x+1][y+2] == "K" and little:
            return True
        elif board[x+1][y+2] == "k":
            set_black()
            return True
    if valid(x - 1, y + 2):
        if board[x - 1][ y + 2] == "K" and little:
            return True
        elif board[x - 1][ y + 2] == "k":
            set_black()
            return True
    if valid(x + 1, y - 2):
        if board[x + 1][ y - 2] == "K" and little:
            return True
        elif board[x + 1][ y - 2] == "k":
            set_black()
            return True
    if valid(x - 1, y - 2):
        if board[x - 1][ y - 2] == "K" and little:
            return True
        elif board[x - 1][ y - 2] == "k":
            set_black()
            return True
    if valid(x + 2, y + 1):
        if board[x + 2][ y + 1] == "K" and little:
            return True
        elif board[x + 2][ y + 1] == "k":
            set_black()
            return True
    if valid(x + 2, y - 1):
        if board[x + 2][ y - 1] == "K" and little:
            return True
        elif board[x + 2][ y - 1] == "k":
            set_black()
            return True
    if valid(x - 2, y + 1):
        if board[x - 2][ y + 1] == "K" and little:
            return True
        elif board[x - 2][ y + 1] == "k":
            set_black()
            return True
    if valid(x - 2, y - 1):
        if board[x - 2][ y - 1] == "K" and little:
            return True
        elif board[x - 2][ y - 1] == "k":
            set_black()
            return True
    return False

def valid(x, y):
    if x >= 8 or x < 0 or y < 0 or y >= 8:
        return False
    return True

def set_black():
    global black
    black = True

result = ""
count = 0
while True:
    count += 1
    black = False
    board = []
    for i in range(0,8):
        board.append(sys.stdin.readline().rstrip())
    state = get_check(board)
    if state is None:
        print (result.rstrip())
        exit(0)
    elif state:
        if (not black):
            result += "Game #" + str(count) + ": white king is in check.\n"
        else:
            result += "Game #" + str(count) + ": black king is in check.\n"
    elif not state:
        result += "Game #" + str(count) + ": no king is in check.\n"
    sys.stdin.readline()
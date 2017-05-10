import itertools
arr = str(raw_input()).split(",")
for combo in list(itertools.product(["+","-"], repeat=len(arr) - 1)):
    if eval("".join([x for x in itertools.chain.from_iterable(itertools.izip_longest(arr,combo)) if x])) == 100:
        print ([y for y in itertools.chain.from_iterable(itertools.izip_longest(arr,combo)) if y])

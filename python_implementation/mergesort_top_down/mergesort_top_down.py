def mergesort_top_down(list):
    if (len(list) == 1):
        return list

    middle = len(list) / 2

    a = mergesort(list[0, middle])
    b = mergesort(list[middle, len(list)])
    ab = merge(a, b)
    return ab

def merge(a, b):
    result = []
    c = []

    while (len(a) != 0 and len(b) != 0):
        if (a[0] < b[0]):
            result.append(a[0])
            del a[0]
        else:
            result.append(b[0])
            del b[0]

        if (len(a) == 0):
            c = b
        elif (len(b) == 0):
            c = a

    for i in c:
        result.append(i)

    return result

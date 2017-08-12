import matplotlib.pyplot as plt
import numpy as np

array_mergesort = open("java_implementation/array/tester_data_mergesort.txt", "r")
array_mergesort_data = []
array_mergesort_lists = []

for line in array_mergesort:
    if (line != '\n'):
        array_mergesort_data.append(int(line))
array_mergesort.close()

for i in range(len(array_mergesort_data)):
    array_mergesort_lists.append(i)

plt.xlabel("Elements in Array")
plt.ylabel("Nanoseconds (Millions)")
plt.ylim(0, 1000000 * 15)
plt.plot(array_mergesort_lists, array_mergesort_data, color = "lightblue", linewidth = 3, label = "Array Mergesort Sorting Time")
plt.legend()
plt.savefig("graphs/mergesort.jpg")

import matplotlib.pyplot as plt
import numpy as np

# Create array mergesort graph
array_mergesort = open("java_implementation/array/tester_data_mergesort.txt", "r")
array_mergesort_data = []

# Number of total elements in array
array_lists = []

for line in array_mergesort:
    array_mergesort_data.append(int(line))
array_mergesort.close()

for i in range(len(array_mergesort_data)):
    array_lists.append(i)

plt.figure(0)
plt.xlabel("Elements in Array")
plt.ylabel("Nanoseconds (Millions)")
plt.ylim(0, 1000000 * 15)
plt.plot(array_lists, array_mergesort_data, color = "lightblue", linewidth = 3, label = "Array Mergesort Sorting Time")
plt.legend()
plt.savefig("graphs/array_mergesort_nsec.jpg")

plt.figure(1)
plt.xlabel("Elements in Array")
plt.ylabel("Seconds")
plt.ylim(0, 0.5)
array_mergesort_data_seconds = np.array(array_mergesort_data).astype(np.float)
array_mergesort_data_seconds /= 1000000000
plt.plot(array_lists, array_mergesort_data_seconds, color = "lightblue", linewidth = 3, label = "Array Mergesort Sorting Time")
plt.legend()
plt.savefig("graphs/array_mergesort_sec.jpg")

# Create array quicksort graphs
array_quicksort = open("java_implementation/array/tester_data_quicksort.txt", "r")
array_quicksort_data = []
array_quicksort_lists = []

for line in array_quicksort:
    array_quicksort_data.append(int(line))
array_quicksort.close()

plt.figure(2)
plt.xlabel("Elements in Array")
plt.ylabel("Nanoseconds (Millions)")
plt.ylim(0, 1000000 * 15)
plt.plot(array_lists, array_quicksort_data, color = "lightblue", linewidth = 3, label = "Array Quicksort Sorting Time")
plt.legend()
plt.savefig("graphs/array_quicksort_nsec.jpg")

def find_limit(array):

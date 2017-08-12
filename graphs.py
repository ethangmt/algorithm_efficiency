import matplotlib.pyplot as plt
import numpy as np

array_path = "graphs/array/"
list_path = "graphs/linked_list"
array_tester_path = "java_implementation/array/"
list_tester_path = "java_implementation/linked_list/"

linew = 3
array_mergesort_color = "blue"
array_quicksort_color = "red"
list_mergesort_color = "green"
list_quicksort_color = "yellow"
array_color = "cyan"
list_color = "magenta"

def find_limit(a, b):
    limit = 0
    for i in a:
        if i > limit:
            limit = i
    if not b is None:
        blimit = 0
        for i in b:
            if i > blimit:
                blimit = i
        if blimit > limit:
            limit = blimit
    return limit

# Create array mergesort graph
array_mergesort = open(array_tester_path + "tester_data_mergesort.txt", "r")
array_mergesort_data = []

# Number of total elements in array
array_lists = []

for line in array_mergesort:
    array_mergesort_data.append(int(line))
array_mergesort.close()

for i in range(len(array_mergesort_data)):
    array_lists.append(i)

array_quicksort = open(array_tester_path + "tester_data_quicksort.txt", "r")
array_quicksort_data = []
array_quicksort_lists = []

for line in array_quicksort:
    array_quicksort_data.append(int(line))
array_quicksort.close()

plt.figure(0)
plt.xlabel("Elements in Array")
plt.ylabel("Nanoseconds")
axes = plt.gca().twinx()
axes.set_ylabel("Seconds")
axes.set_ylim(0, .01)
plt.ylim(0, find_limit(array_mergesort_data, None))
plt.plot(array_lists, array_mergesort_data, color = array_mergesort_color, linewidth = linew, label = "Array Mergesort")
plt.legend()
plt.suptitle("Array Mergesort Sorting Time")
plt.savefig(array_path + "array_mergesort_ns.jpg")

plt.figure(1)
array_mergesort_data_seconds = np.array(array_mergesort_data).astype(np.float)
array_mergesort_data_seconds /= 1000000000
plt.xlabel("Elements in Array")
plt.ylabel("Seconds")
#plt.ylim(0, find_limit(array_mergesort_data_seconds, None))
plt.plot(array_lists, array_mergesort_data_seconds, color = array_mergesort_color, linewidth = linew, label = "Array Mergesort")
plt.legend()
plt.suptitle("Array Mergesort Sorting Time")
plt.savefig(array_path + "array_mergesort_s.jpg")

# Create array quicksort graphs
plt.figure(2)
plt.xlabel("Elements in Array")
plt.ylabel("Nanoseconds")
#plt.ylim(0, find_limit(array_quicksort_data, None))
plt.plot(array_lists, array_quicksort_data, color = array_quicksort_color, linewidth = linew, label = "Array Quicksort")
plt.legend()
plt.suptitle("Array Quicksort Sorting Time")
plt.savefig(array_path + "array_quicksort_ns.jpg")

plt.figure(3)
array_quicksort_data_seconds = np.array(array_quicksort_data).astype(np.float)
array_quicksort_data_seconds /= 1000000000
plt.xlabel("Elements in Array")
plt.ylabel("Seconds")
#plt.ylim(0, find_limit(array_quicksort_data_seconds, None))
plt.plot(array_lists, array_quicksort_data_seconds, color = array_quicksort_color, linewidth = linew, label = "Array Quicksort")
plt.legend()
plt.suptitle("Array Quicksort Sorting Time")
plt.savefig(array_path + "array_quicksort_s.jpg")

# Array mergesort and quicksort graphs
plt.figure(4)
plt.xlabel("Elements in Array")
plt.ylabel("Nanoseconds")
#plt.ylim(0, find_limit(array_mergesort_data, array_quicksort_data))
plt.plot(array_lists, array_mergesort_data, color = array_mergesort_color, linewidth = linew, label = "Array Mergesort")
plt.plot(array_lists, array_quicksort_data, color = array_quicksort_color, linewidth = linew, label = "Array Quicksort")
plt.legend()
plt.suptitle("Array Quicksort and Mergesort Sorting Time")
plt.savefig(array_path + "array_comparison_ns.jpg")

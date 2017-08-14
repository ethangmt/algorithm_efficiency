import matplotlib.pyplot as plt
import numpy as np

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

def setSecondaryAxes(plot):

    if plot is None:
        primary_axes = plt.gca()
    else:
        primary_axes = plot.axes
    secondary_axes = primary_axes.twinx()
    secondary_axes.set_ylabel("Seconds")
    bottom, top = primary_axes.get_ylim()
    secondary_axes.set_ylim(bottom, float(top / 1000000000))

def getData(array_path):
    array_mergesort_data = []
    array_mergesort_total = 0
    array_mergesort_average = 0
    array_quicksort_data = []
    array_quicksort_total = 0
    array_quicksort_average = 0
    array_elements = []
    list_mergesort_data = []
    list_quicksort_data = []

    #Array
    array_mergesort = open(array_path + "tester_data_mergesort.txt", "r")
    for line in array_mergesort:
        if line != "\n":
            array_mergesort_data.append(int(line))
        else:
            break;
    #Store total and averages TODO 
    array_mergesort.close()

    array_quicksort = open(array_path + "tester_data_quicksort.txt", "r")
    for line in array_quicksort:
        if line != "\n":
            array_quicksort_data.append(int(line))
        else:
            break;
    array_quicksort.close()

    #Linked List TODO

    #Total number of elements
    for i in range(len(array_mergesort_data)):
        array_elements.append(i)

    data = {"array_mergesort_data": array_mergesort_data, "array_quicksort_data": array_quicksort_data,
    "list_mergesort_data": list_mergesort_data, "list_quicksort_data": list_quicksort_data, "array_elements": array_elements}
    return data


array_path = "graphs/array/"
list_path = "graphs/linked_list"
array_tester_path = "java_implementation/array/tester/"
list_tester_path = "java_implementation/linked_list/"

linew = 3

array_mergesort_color = "blue"
array_quicksort_color = "red"
list_mergesort_color = "green"
list_quicksort_color = "yellow"
array_color = "cyan"
list_color = "magenta"

data = getData(array_tester_path)


#Put in for loop
plt.figure(0)
plt.plot(data["array_elements"], data["array_mergesort_data"], color = array_mergesort_color, linewidth = linew, label = "Array Mergesort")
plt.legend()
plt.xlabel("Elements in Array")
plt.ylabel("Nanoseconds")
setSecondaryAxes(None)
plt.suptitle("Array Mergesort Sorting Time")
plt.savefig(array_path + "array_mergesort.jpg")

plt.figure(1)
plt.plot(data["array_elements"], data["array_quicksort_data"], color = array_quicksort_color, linewidth = linew, label = "Array Quicksort")
plt.legend()
plt.xlabel("Elements in Array")
plt.ylabel("Nanoseconds")
setSecondaryAxes(None)
plt.suptitle("Array Quicksort Sorting Time")
plt.savefig(array_path + "array_quicksort.jpg")

plt.figure(2)
plt.plot(data["array_elements"], data["array_mergesort_data"], color = array_mergesort_color, linewidth = linew, label = "Array Mergesort")
plt.plot(data["array_elements"], data["array_quicksort_data"], color = array_quicksort_color, linewidth = linew, label = "Array Quicksort")
plt.legend()
plt.xlabel("Elements in Array")
plt.ylabel("Nanoseconds")
setSecondaryAxes(None)
plt.suptitle("Array Quicksort and Mergesort Sorting Time")
plt.savefig(array_path + "array_comparison.jpg")

plt.figure(3)
f, plot = plt.subplots(2, sharex = True, sharey = True)
plot[0].plot(data["array_elements"], data["array_mergesort_data"], color = array_mergesort_color, linewidth = linew, label = "Array Mergesort")
plot[0].legend()
plot[0].set_xlabel("Elements in Array")
plot[0].set_ylabel("Nanoseconds")
plot[1].plot(data["array_elements"], data["array_quicksort_data"], color = array_quicksort_color, linewidth = linew, label = "Array Quicksort")
plot[1].legend()
plot[1].set_xlabel("Elements in Array")
plot[1].set_ylabel("Nanoseconds")
setSecondaryAxes(plot[0])
setSecondaryAxes(plot[1])
plt.savefig(array_path + "array_comparisons.jpg")

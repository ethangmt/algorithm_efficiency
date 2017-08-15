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

def getData(array_path, list_path):
    #Array
    array_mergesort_data = []
    array_mergesort_total = 0
    array_mergesort_average = 0
    array_quicksort_data = []
    array_quicksort_total = 0
    array_quicksort_average = 0
    array_elements = []

    array_mergesort = open(array_path + "tester_data_mergesort.txt", "r")
    for line in array_mergesort:
        array_mergesort_data.append(float(line))

    array_mergesort_average = array_mergesort_data[len(array_mergesort_data) - 1]
    array_mergesort_data.pop()
    array_mergesort_total = array_mergesort_data[len(array_mergesort_data) - 2]
    array_mergesort_data.pop()
    array_mergesort.close()

    array_quicksort = open(array_path + "tester_data_quicksort.txt", "r")
    for line in array_quicksort:
        array_quicksort_data.append(float(line))

    array_quicksort_average = array_quicksort_data[len(array_quicksort_data) - 1]
    array_quicksort_data.pop()
    array_quicksort_total = array_quicksort_data[len(array_quicksort_data) - 2]
    array_quicksort_data.pop()
    array_quicksort.close()

    for i in range(len(array_mergesort_data)):
        array_elements.append(i)

    #Linked List
    list_mergesort_data = []
    list_mergesort_total = 0
    list_mergesort_average = 0
    list_quicksort_data = []
    list_quicksort_total = 0
    list_quicksort_average = 0
    list_elements = []

    list_mergesort = open(list_path + "tester_data_mergesort.txt", "r")
    for line in list_mergesort:
        list_mergesort_data.append(float(line))

    list_mergesort_average = list_mergesort_data[len(list_mergesort_data) - 1]
    list_mergesort_data.pop()
    list_mergesort_total = list_mergesort_data[len(list_mergesort_data) - 1]
    list_mergesort_data.pop()
    list_mergesort.close()

    list_quicksort = open(list_path + "tester_data_quicksort.txt", "r")
    for line in list_quicksort:
        list_quicksort_data.append(float(line))

    list_quicksort_average = list_quicksort_data[len(list_quicksort_data) - 1]
    list_quicksort_data.pop()
    list_quicksort_total = list_quicksort_data[len(list_quicksort_data) - 2]
    list_quicksort_data.pop()
    list_quicksort.close()

    for i in range(len(list_quicksort_data)):
        list_elements.append(i)

    array_data = {"array_mergesort_data": array_mergesort_data, "array_quicksort_data": array_quicksort_data,
    "array_mergesort_average": array_mergesort_average, "array_mergesort_total": array_mergesort_total,
    "array_quicksort_average": array_quicksort_average, "array_quicksort_total": array_quicksort_total,
    "array_elements": array_elements}

    list_data = {"list_mergesort_data": list_mergesort_data, "list_quicksort_data": list_quicksort_data,
    "list_mergesort_average": list_mergesort_average, "list_mergesort_total": list_mergesort_total,
    "list_quicksort_average": list_quicksort_average, "list_quicksort_total": list_quicksort_total,
    "list_elements": list_elements}

    data = [array_data, list_data]

    return data

path = ["graphs/array/", "graphs/linked_list/"]
tester_path = ["java_implementation/array/tester/", "java_implementation/linked_list/tester/"]

linew = 3
data_structures = ["array", "list"]

mergesort_color = ["blue", "green"]
quicksort_color = ["red", "yellow"]
array_color = "cyan"
list_color = "magenta"

data = getData(tester_path[0], tester_path[1])

#First loop - Array graphs
#Seconds loop - Linked List graphs
index = 0
for i in range(2):
    plt.figure(i + index)
    plt.plot(data[i][data_structures[i] + "_elements"], data[i][data_structures[i] + "_mergesort_data"], color = mergesort_color[i], linewidth = linew, label = data_structures[i] + " mergesort")
    plt.legend()
    plt.xlabel("elements in " + data_structures[i])
    plt.ylabel("Nanoseconds")
    setSecondaryAxes(None)
    plt.suptitle(data_structures[i] + " mergesort sorting time")
    plt.savefig(path[i] + (data_structures[i] + "_mergesort.jpg"))

    index += 1
    plt.figure(i + index)
    plt.plot(data[i][data_structures[i] + "_elements"], data[i][data_structures[i] + "_quicksort_data"], color = quicksort_color[i], linewidth = linew, label = data_structures[i] + " quicksort")
    plt.legend()
    plt.xlabel("elements in " + data_structures[i])
    plt.ylabel("Nanoseconds")
    setSecondaryAxes(None)
    plt.suptitle(data_structures[i] + " quicksort sorting time")
    plt.savefig(path[i] + (data_structures[i] + "_quicksort.jpg"))

    index += 1
    plt.figure(i + index)
    plt.plot(data[i][data_structures[i] + "_elements"], data[i][data_structures[i] + "_mergesort_data"], color = mergesort_color[i], linewidth = linew, label = data_structures[i] + " mergesort")
    plt.plot(data[i][data_structures[i] + "_elements"], data[i][data_structures[i] + "_quicksort_data"], color = quicksort_color[i], linewidth = linew, label = data_structures[i] + " quicksort")
    plt.legend()
    plt.xlabel("elements in " + data_structures[i])
    plt.ylabel("Nanoseconds")
    setSecondaryAxes(None)
    plt.suptitle(data_structures[i] + " quicksort and mergesort sorting time")
    plt.savefig(path[i] + (data_structures[i] + "_comparison.jpg"))

    index += 1
    plt.figure(i + index)
    f, plot = plt.subplots(2, sharex = True, sharey = True)
    plot[0].plot(data[i][data_structures[i] + "_elements"], data[i][data_structures[i] + "_mergesort_data"], color = mergesort_color[i], linewidth = linew, label = data_structures[i] + " mergesort")
    plot[0].legend()
    plot[0].set_xlabel("elements in " + data_structures[i])
    plot[0].set_ylabel("Nanoseconds")
    plot[1].plot(data[i][data_structures[i] + "_elements"], data[i][data_structures[i] + "_quicksort_data"], color = quicksort_color[i], linewidth = linew, label = data_structures[i] + " quicksort")
    plot[1].legend()
    plot[1].set_xlabel("elements in " + data_structures[i])
    plot[1].set_ylabel("Nanoseconds")
    setSecondaryAxes(plot[0])
    setSecondaryAxes(plot[1])
    plt.suptitle(data_structures[i] + " quicksort and mergesort sorting time")
    plt.savefig(path[i] + (data_structures[i] + "_comparisons.jpg"))
    index += 1

plt.figure(index)
plt.plot(data[0]["array_elements"], data[1]["list_mergesort_data"], color = mergesort_color[1], linewidth = linew, label = data_structures[1] + " mergesort")
plt.plot(data[0]["array_elements"], data[0]["array_mergesort_data"], color = mergesort_color[0], linewidth = linew, label = data_structures[0] +  " mergesort")
plt.legend()
plt.xlabel("elements in array and list")
plt.ylabel("Nanseconds")
setSecondaryAxes(None)
plt.suptitle("array mergesort and linked list mergesort sorting time")
plt.savefig("graphs/mergesorts.jpg")

index += 2 #BUG
plt.figure(index)
plt.plot(data[0]["array_elements"], data[1]["list_quicksort_data"], color = quicksort_color[1], linewidth = linew, label = data_structures[1] + " quicksort")
plt.plot(data[0]["array_elements"], data[0]["array_quicksort_data"], color = quicksort_color[0], linewidth = linew, label = data_structures[0] +  " quicksort")
plt.legend()
plt.xlabel("elements in array and list")
plt.ylabel("Nanseconds")
setSecondaryAxes(None)
plt.suptitle("array quicksort and linked list quicksort sorting time")
plt.savefig("graphs/quicksorts.jpg")

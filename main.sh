#!/bin/bash

javac java_implementation/tools/*.java
javac java_implementation/array/*/*.java
javac java_implementation/linked_list/*/*.java
javac java_implementation/data_structures/data_structures.java
javac java_implementation/tester/tester.java

java java_implementation/data_structures/data_structures
java java_implementation/tester/tester

python graphs.py

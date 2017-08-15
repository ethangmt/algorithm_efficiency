#!/bin/bash

#Compile everything
javac */*/*/*.java

#Run tests
java java_implementation/tester/tester
java java_implementation/data_structures

#Create graphs
python graphs.py

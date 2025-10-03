#!/bin/bash
echo "Compiling Follow the White Rabbit v2..."
javac WhiteRabbit.java
if [ $? -ne 0 ]; then
    echo ""
    echo "ERROR: Compilation failed. Make sure Java JDK is installed."
    echo "Download Java from: https://www.oracle.com/java/technologies/downloads/"
    exit 1
fi
echo ""
echo "Starting the game..."
echo ""
java WhiteRabbit

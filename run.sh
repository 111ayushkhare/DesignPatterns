#!/bin/bash

echo "===================================================="
echo "   Running All Java Design Pattern Examples"
echo "===================================================="

# Compile all Java files
echo
echo "Compiling source files..."

find . -name "*.java" > source.txt
javac @source.txt
if [ $? -ne 0 ]; then
	echo "Compilation failed."
	exit 1
fi

echo
echo "Running examples..."
echo "----------------------------------------------------"

# Decorator Pattern
if [ -f DecoratorPattern/Pizza.class ] && [ -f DecoratorPattern/StarbuzzCoffee.class ]; then
	echo "[DecoratorPattern]"
	echo "----------------------------------------------------" 
	echo ">> Pizza"
	java DecoratorPattern.Pizza
	echo 
	echo ">> StarbuzzCoffee"
	java DecoratorPattern.StarbuzzCoffee
	echo "----------------------------------------------------"
fi

# Factory Pattern
if [ -f FactoryPattern/PizzaFactory.class ]; then
  echo "[Factory Pattern]"
  echo "----------------------------------------------------" 
  java FactoryPattern.PizzaFactory
  echo "----------------------------------------------------"
fi

# Abstract Factory Pattern
if [ -f AbstractFactoryPattern/PizzaAbstractFactory.class ]; then
  echo "[Abstract Factory Pattern]"
  echo "----------------------------------------------------" 
  java AbstractFactoryPattern.PizzaAbstractFactory
  echo "----------------------------------------------------"
fi

# Singleton Pattern
if [ -f SingletonPattern/SingletonChocolateBoiler/ChocolateBoilerDemo.class ] && 
	[ -f SingletonPattern/SingletonChocolateBoiler/ChocolateBoiler.class ] &&
	[ -f SingletonPattern/SingletonChocolateBoiler/ChocolateBoilerThreadSafe.class ] &&
	[ -f SingletonPattern/SingletonChocolateBoiler/ChocolateBoilerLockDoubleCheck.class ]; then
  	echo "[Singleton Pattern]"
  	echo "----------------------------------------------------" 
  	cd ./SingletonPattern
  	java SingletonChocolateBoiler.ChocolateBoilerDemo
  	cd ..
  	echo "----------------------------------------------------"
fi

rm source.txt

echo 
echo "All patterns executed successfully!"
echo
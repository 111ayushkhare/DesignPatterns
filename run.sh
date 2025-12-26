#!/bin/bash

echo "===================================================="
echo "   Running All Java Design Pattern Examples"
echo "===================================================="

# Compile all Java files
echo
echo "Compiling source files..."

find . -name "*.java" > source.txt
javac -d out/classes @source.txt
if [ $? -ne 0 ]; then
	echo "Compilation failed."
	exit 1
fi

echo
echo "Running examples..."
echo "----------------------------------------------------"

# Decorator Pattern
if [ -f ./out/classes/decorator/Pizza.class ] && [ -f ./out/classes/decorator/StarbuzzCoffee.class ]; then
	echo "[DecoratorPattern]"
	echo "----------------------------------------------------" 
	echo ">> Pizza"
	java -cp out/classes decorator.Pizza
	echo 
	echo ">> StarbuzzCoffee"
	java -cp out/classes decorator.StarbuzzCoffee
	echo "----------------------------------------------------"
fi

# Factory Pattern
if [ -f ./out/classes/factory/PizzaFactory.class ]; then
  echo "[Factory Pattern]"
  echo "----------------------------------------------------" 
  java -cp out/classes factory.PizzaFactory
  echo "----------------------------------------------------"
fi

# Abstract Factory Pattern
if [ -f ./out/classes/abstractfactory/PizzaAbstractFactory.class ]; then
  echo "[Abstract Factory Pattern]"
  echo "----------------------------------------------------" 
  java -cp out/classes abstractfactory.PizzaAbstractFactory
  echo "----------------------------------------------------"
fi

# Singleton Pattern
if [ -f ./out/classes/singleton/chocolateboiler/ChocolateBoilerDemo.class ] && 
	[ -f ./out/classes/singleton/chocolateboiler/ChocolateBoiler.class ] &&
	[ -f ./out/classes/singleton/chocolateboiler/ChocolateBoilerThreadSafe.class ] &&
	[ -f ./out/classes/singleton/chocolateboiler/ChocolateBoilerLockDoubleCheck.class ] &&
	[ -f ./out/classes/singleton/chocolateboilerenum/ChocolateBoilerDemo.class ] && 
	[ -f ./out/classes/singleton/chocolateboilerenumvsstatic/ChocolateBoilerThreadSafetyDemo.class ]; then
  	echo "[Singleton Pattern]"
  	echo "----------------------------------------------------" 
  	echo ">> ChocolateBoiler - by STATIC"
  	java -cp out/classes singleton.chocolateboiler.ChocolateBoilerDemo
  	echo
  	echo ">> ChocolateBoiler - By ENUM"
  	java -cp out/classes singleton.chocolateboilerenum.ChocolateBoilerDemo
  	echo
  	echo ">> ChocolateBoiler - ENUM vs STATIC"
  	java -cp out/classes singleton.chocolateboilerenumvsstatic.ChocolateBoilerThreadSafetyDemo
  	echo "----------------------------------------------------"
fi

# Strategy Pattern
if [ -f ./out/classes/strategy/paymentprocessing/Driver.class ]; then 
	echo "[StrategyPattern]" 
	echo "----------------------------------------------------"
	echo ">> PaymentPocessingStrategy" 
	java -cp out/classes strategy.paymentprocessing.Driver
	echo "----------------------------------------------------" 
fi

rm source.txt

echo 
echo "All patterns executed successfully!"
echo
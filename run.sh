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
if [ -f ./out/classes/decorator/pizza/Driver.class ] && [ -f ./out/classes/decorator/starbuzzcoffee/Driver.class ]; then
	echo "[DecoratorPattern]"
	echo "----------------------------------------------------" 
	echo ">> Pizza"
	java -cp out/classes decorator.pizza.Driver
	echo 
	echo ">> StarbuzzCoffee"
	java -cp out/classes decorator.starbuzzcoffee.Driver
	echo "----------------------------------------------------"
fi

# Factory Pattern
if [ -f ./out/classes/factory/pizza/Driver.class ]; then
  echo "[Factory Pattern]"
  echo "----------------------------------------------------" 
  java -cp out/classes factory.pizza.Driver
  echo "----------------------------------------------------"
fi

# Abstract Factory Pattern
if [ -f ./out/classes/abstractfactory/pizza/Driver.class ]; then
  echo "[Abstract Factory Pattern]"
  echo "----------------------------------------------------" 
  java -cp out/classes abstractfactory.pizza.Driver
  echo "----------------------------------------------------"
fi

# Singleton Pattern
if [ -f ./out/classes/singleton/chocolateboiler/Driver.class ] && 
	[ -f ./out/classes/singleton/chocolateboilerenum/Driver.class ] && 
	[ -f ./out/classes/singleton/chocolateboilerenumvsstatic/Driver.class ]; then
  	echo "[Singleton Pattern]"
  	echo "----------------------------------------------------" 
  	echo ">> ChocolateBoiler - by STATIC"
  	java -cp out/classes singleton.chocolateboiler.Driver
  	echo
  	echo ">> ChocolateBoiler - By ENUM"
  	java -cp out/classes singleton.chocolateboilerenum.Driver
  	echo
  	echo ">> ChocolateBoiler - ENUM vs STATIC"
  	java -cp out/classes singleton.chocolateboilerenumvsstatic.Driver
  	echo "----------------------------------------------------"
fi

# Strategy Pattern
if [ -f ./out/classes/strategy/paymentprocessing/Driver.class ] && 
	[ -f ./out/classes/strategy/filecompressionutils/Driver.class ]; then 
	echo "[StrategyPattern]" 
	echo "----------------------------------------------------"
	echo ">> PaymentPocessingStrategy" 
	java -cp out/classes strategy.paymentprocessing.Driver
	echo
	echo ">> FileCompressionUtility" 
	java -cp out/classes strategy.filecompressionutils.Driver
	echo "----------------------------------------------------" 
fi

# Builder Pattern
if [ -f ./out/classes/builder/httprequestbuilder/Driver.class ]; then 
	echo "[BuilderPattern]" 
	echo "----------------------------------------------------"
	echo ">> HttpRequestBuilder" 
	java -cp out/classes builder.httprequestbuilder.Driver
	echo "----------------------------------------------------" 
fi

rm source.txt

echo 
echo "All patterns executed successfully!"
echo
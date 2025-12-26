REM TODO: PATH-AND-COMMAND-FIXES

@echo off
echo ====================================================
echo    Running All Java Design Pattern Examples
echo ====================================================

REM Compile all Java files
echo.
echo Compiling source files...

dir /s /b *.java > source.txt
javac @source.txt
IF %ERRORLEVEL% NEQ 0 (
    echo Compilation failed.
    exit /b 1
)

echo.
echo Running examples...
echo ----------------------------------------------------

REM Decorator Pattern
IF EXIST DecoratorPattern\Pizza.class IF EXIST DecoratorPattern\StarbuzzCoffee.class (
    echo [DecoratorPattern]
    echo ----------------------------------------------------
    echo >> Pizza
    java DecoratorPattern.Pizza
    echo.
    echo >> StarbuzzCoffee
    java DecoratorPattern.StarbuzzCoffee
    echo ----------------------------------------------------
)

REM Factory Pattern
IF EXIST FactoryPattern\PizzaFactory.class (
    echo [Factory Pattern]
    echo ----------------------------------------------------
    java FactoryPattern.PizzaFactory
    echo ----------------------------------------------------
)

REM Abstract Factory Pattern
IF EXIST AbstractFactoryPattern\PizzaAbstractFactory.class (
    echo [Abstract Factory Pattern]
    echo ----------------------------------------------------
    java AbstractFactoryPattern.PizzaAbstractFactory
    echo ----------------------------------------------------
)

REM Singleton Pattern
IF EXIST SingletonPattern\SingletonChocolateBoiler\ChocolateBoilerDemo.class (
    IF EXIST SingletonPattern\SingletonChocolateBoiler\ChocolateBoiler.class (
        IF EXIST SingletonPattern\SingletonChocolateBoiler\ChocolateBoilerThreadSafe.class (
            IF EXIST SingletonPattern\SingletonChocolateBoiler\ChocolateBoilerLockDoubleCheck.class (
                IF EXIST SingletonPattern\SingletonChocolateBoilerEnum\ChocolateBoilerDemo.class (
                    IF EXIST SingletonPattern\SingletonChocolateBoilerEnumVsStatic\ChocolateBoilerThreadSafetyDemo.class
                    echo [Singleton Pattern]
                    echo ----------------------------------------------------
                    cd SingletonPattern
                    echo >> ChocolateBoiler - by STATIC
                    java SingletonChocolateBoiler.ChocolateBoilerDemo
                    echo
                    echo >> ChocolateBoiler - by ENUM
                    java SingletonChocolateBoilerEnum.ChocolateBoilerDemo
                    echo
                    echo >> ChocolateBoiler - ENUM vs STATIC
                    java SingletonChocolateBoilerEnumVsStatic.ChocolateBoilerThreadSafetyDemo
                    cd ..
                    echo ----------------------------------------------------
                )
            )
        )
    )
)

REM StrategyPattern
IF EXIST StrategyPattern\strategypaymentprocessing\Driver.class (
    echo [StrategyPattern] 
    echo ----------------------------------------------------
    cd StrategyPattern
    echo >> PaymentPocessingStrategy
    java strategypaymentprocessing.Driver
    echo 
    cd ..
    echo ----------------------------------------------------
)


DEL source.txt

echo.
echo All patterns executed successfully!
echo.
pause

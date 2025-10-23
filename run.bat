@echo off
echo ====================================================
echo    Running All Java Design Pattern Examples
echo ====================================================

REM Compile all Java files
echo.
echo Compiling source files...

javac */*.java
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
IF EXIST FactoryPattern\PizzaAbstractFactory.class (
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

echo.
echo All patterns executed successfully!
echo.
pause

## Price Basket Application

This application solves a coding assignment to resolve the offers in a shopping basket.
The project has been built using Java 11 and its lifecycle is managed with Maven. 
It uses two two reference files in predefined CSV format at runtime:
 - inventory.csv - Contains item name and unit price in pence
 - offers.csv - Contains the discount configuration used for calculating discount

#### package

The command below prepares the JAR file in the target directory.

```
./mvnw clean package
```

## Running the jar

The example command below runs the JAR file in the target directory along with the item names as arguments. 
The item names need to be as per reference data files (inventory.csv and offers.csv) present in src/main/resources directory.

```
java -jar target/coding-assignment-1.0-SNAPSHOT.jar Apples Milk Bread ...
```

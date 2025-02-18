# Minesweeper Game

## Compile 

```
mvn compile
```

## Run 

```
mvn exec:java -q
```

## Task 1: Display the mine field to terminal

Implement method `displayField` in class `Minesweeper` to display the mine field on the terminal.

### Example

a 9x9 mine field display.

```
.X.......
.....X..X
....X....
......X..
..X......
....X....
..X......
..X......
......X..
```

## Task 2: Load mine field from file.

Implement method `initFromFile(String mineFieldFile)` of `Minesweeper` class to load a mine field from a text file.

### Example

When calling `initMineFieldFromFile("minefield/minefield01.txt")`, the method should read mine field information from the text file and create a `Minesweeper` object.

#### File format:
* The first line is the field width (fieldX)
* The second line is the field height (fieldY)
* The remaining line display the `fieldX` rows by `fieldY` columns mine field.
  * 'X' means that this cell is a mine
  * '.' means that this cell is safe.

```
9   
9   
.X.......   
.....X..X
....X....
......X..
..X......
....X....
..X......
..X......
......X..
```
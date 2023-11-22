# Specification-based Testing - Unique

## 1. Goal, inputs and outputs
- Goal: return double array with only one value keeped. Order was descending
- Input domain: [1, 2, 3, 2]
- Output domain: [3, 2, 1]

## 2. Explore the program

- Inputs:
  - data = [1, 2, 3]
- Outputs
  - return = [3, 2, 1]

- Inputs:
    - data = [4, 2.2, 3, 4]
- Outputs
  - return = [4, 3, 2.2]

## 3. Identify input and output partitions

### Input partitions

#### Individual inputs

- data Array
    - Null
    - Empty
    - Of length 1
    - Of lenth > 1

#### Combinations of input values

- No combinaison juste one entry

### Output partitions

- result Array
  - Null exception
  - Empty
  - Of length 1
  - of lenth > 1

## 4. Identify boundaries

1. Empty array
2. Array with only same number multiple time

## 5. Select test cases

- T1: *data* null
- T2: *data* empty
- T3: *data* with one entry
- T4: *data* with multiple value
- T5: *data* width ...
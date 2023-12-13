# Specification-based Testing - Concatenate

## 1. Goal, inputs and outputs
- Goal: Concaténation d'un 
- Input domain: [[1,2,3], [4,2,1]]
- Output domain: 

## 2. Explore the program
- Inputs:
    - [[1,2,3], [4,2,1]]
- Outputs:
    - return = [1,2,3,4,2,1]

- Inputs:
    - [[1.12,2,3], [4,2,1]]
- Outputs:
    - return = [1.12,2,3,4,2,1]

- Inputs:
    - [[1,2,3], [4,5,6], [7,8,9]]
- Outputs:
    - return = [1,2,3,4,5,6,7,8,9]

## 3. Identify input and output partitions

### Input partitions

#### Partition de tableau
- pas d'argument
- null
- 1 arguments
- plusieurs arguments

#### Partition sous tableau
- null
- []
- [1]
- [1, 2, 3, ...]

### Output partitions
- List 
- []
- NullPointerException

## 4. Identify boundaries
- null ==> NullPointerException
- [] ==> []
- [[]] => []


## 5. Select test cases
- T1: null ==> NullPointerException
- T1: [null] => NullPointerException
- T2: [] ==> []
- T3: [[]] => []
# Specification-based Testing - Adding list of digits

## 1. Goal, inputs and outputs
- Goal: With two list, return a list containing sum of each items.
- Input domain: program receive two list, each list must contain digit only from [0-9]
- Output domain: return list composed of all added number

## 2. Explore the program
- Inputs: 
  - List1 [2,3] 
  - List2 [4,2]
- Outputs: 
  - return = [6,5]

- Inputs:
    - List1 [2,3]
    - List2 [1,4,2]
- Outputs:
    - return = [1,6,5]

- Inputs:
    - List1 [9,9]
    - List2 [9,9]
- Outputs:
    - return = [1,9,8]

## 3. Identify input and output partitions

### Left 
- One entry
  - null
  - empty
  - one digit
- List item
  - null
  - empty
  - one digit

### right
- Same case then left

Both Null

### Output partitions
- Array of digit
- One digit at the end
- Empty List
- IllegalArgumentException
Données différentes mais type de résultat similaire.

## 4. Identify boundaries
- both is zero: [0] + [0]
- one of item is zero: [0] + [1,2,3,4,5]
- one of item is other size: [1] + [1,2,3,4,5,6]
- two item who made more then two digit at the end: [9,9] + [9,9]
- multiple zero before: [0,0,0,1,2]

## 5. Select test cases
- T1: *Left* is null
- T2: *Right* is null
- T3: *Left* is empty
- T4: *Right* is empty
- T5: *Left* and *Right* is zero
- T6: One of both is one digit (array with one entry), other with many digit
- T7: Result of one calcule made more then 2 digit.

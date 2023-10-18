# Specification-based Testing - Substrings Between

## 1. Goal, inputs and outputs

- Goal: to collect all substrings in a String that are delimited by a start and end tag, which are also provided by the user.
- Input domain: the program receives 3 parameters
  - *str*: represents the "big" string, the one the program will use to extract the substrings from
  - *open* and *close* tags which the program will use to find where the substring starts and where the substring ends
- Output domain: the program returns an array composed of all the substrings found by the program

## 2. Explore the program

### Single substring
- Inputs:
  - str = "abcd"
  - open = "a"
  - close = "d"
- Outputs:
  - return = {"bc"}

### Multiple substrings
- Inputs:
  - str = "abcdabcdab"
  - open = "a"
  - close = "d"
- Outputs:
  - return = {"bc", "bc"}

### Open and close tags are longer
- Inputs:
  - str = "aabcddaabcddaab"
  - open = "aa"
  - close = "dd"
- Outputs:
  - return = {"bc", "bc"}

## 3. Identify input and output partitions

### Input partitions

#### Individual inputs
- *str* parameter category: it seems that the string can by any string. I see that the specification mentions the "null" and "empty" cases. Given that this is a string, I will also test what happens in case the string has length 1. Here are the 4 partitions:
  - Null
  - Empty
  - Of length 1
  - Of length > 1
- *open* parameter category: the open input parameter can also be anything. I will try it with null and empty, as I learned from the str parameter that those cases are special in this program. I will also try strings with length 1 and length greater than 1.
  - Null
  - Empty
  - Of length 1
  - Of length > 1
- *close* parameter category: the same as for the *open* parameter
  - Null
  - Empty
  - Of length 1
  - Of length > 1

#### Combinations of input values
*open* and *close* may or may not be in the *str*. We can also imagine that *open* is there, but *close* is not, and vice-versa. We can call this category (*str*, *open*, *close*):
- *str* does not contain either *open* and *close*
- *str* contains *open* but not *close*
- *str* contains *close* but not *open*
- *str* contains both *open* and *close* once
- *str* contains both *open* and *close* multiple times

### Output partitions
- Array of strings
  - Null
  - Empty
  - Of length 1
  - Of length > 1
- For each individual string in the array
  - Null
  - Empty
  - Of length 1
  - Of length > 1

The output partitions are already covered by the input partitions, so they are not necessary.

## 4. Identify boundaries
Two discovered boundaries:
1. *str* contains both *open* and *close*, with no characters in between them
2. *str* contains both *open* and *close*, with characters in between them

The second test is not necessary, as other tests already exercise it. Therefore, we can discard it.

## 5. Select test cases

There are 4 categories, each with 4 or 5 partitions: *str* category with 4 partitions, *open* category with 4 partitions, *close* category with 4 partitions and (*str*, *open*, *close*) with 5 partitions. We would end up with 4 x 4 x 4 x 5 = 320 tests !

To decrease this number, we decide which partitions should be extensively combined with others, and which should not. A first idea is to test exceptional cases only once and not combine them:
- T1: *str* is null
- T2: *str* is empty
- T3: *open* is null
- T4: *open* is empty
- T5: *close* is null
- T6: *close* is empty

There might be even other partitions we do not need to combine fully. I see two:
- The *str length = 1*: given that the string has length 1, maybe two tests where the single character in the string matches the open and close, and one test where the character does not is enough.
- We can think that the program handles open and close tags the same way, so I would say we do not need the 4 combinations of (open length = 1, close length = 1), (open length > 1, close length = 1), (open length = 1, close length > 1) and (open length > 1, close length > 1). Maybe just (open length = 1, close length = 1) and (open length > 1, close length > 1) are enough.

Here are the test cases for the two points discussed above:
- T7: the single char in str matches the open tag
- T8: the single char in str matches the close tag
- T9: the single char in str does not match either the open and close tag
- T10: the single char in str matches both open and close tag

Now, with str length > 1, open length = 1, close length = 1:
- T11: str does not contain either open and close
- T12: str contains open but not close
- T13: str contains close but not open
- T14: str contains both open and close
- T15: str contains both open and close multiple times

With str length > 1, open length > 1, close length > 1:
- T16: str does not contain either open and close
- T17: str contains open but not close
- T18: str contains close but not open
- T19: str contains both open and close
- T20: str contains both open and close multiple times

Finally, the test for the boundary:
- T21: str contains both open and close, with no character between them
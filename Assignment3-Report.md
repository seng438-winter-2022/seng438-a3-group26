**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group 26         |          |                |
| ---------------- | -------- | -------------- |
| Liana Goodman    | 30089196 | LianaBG        |
| Amir Abdrakmanov | 30085827 | aabdrakmanov   |
| Jared Lundy      | 30086687 | jared840       |
| Jordan Lundy     | 30086686 | jordan427-prog |

### Table of Contents

1. [Introduction](#1-introduction)
2. [Manual Data-Flow Coverage Calculations for `calculateColumnTotal` and `constrain` Methods](#2---manual-data-flow-coverage-calculations-for-calculatecolumntotal-and-constrain-methods)
3. [Testing Strategy for New Unit Tests](#3---testing-strategy-for-new-unit-tests)
4. [Selected Test Cases Using Coverage Information and How They Have Increased Code Coverage](#4---selected-test-cases-using-coverage-information-and-how-they-have-increased-code-coverage)
5. [Coverage Achieved for Each Class and Method](#5---coverage-achieved-for-each-class-and-method)
6. [Pros and Cons of Coverage Tools Used and Metrics Reported](#6---pros-and-cons-of-coverage-tools-used-and-metrics-reported)
7. [Comparing the Advantages and Disadvantages of Requirements-Based Test Generation and Coverage-Based Test Generation](#7---comparing-advantages-and-disadvantages-of-requirements-based-test-generation-and-coverage-based-test-generation)
8. [Teamwork Allocation](#8---teamwork-allocation)
9. [Difficulties, Challenges, and Lessons Learned](#9---difficulties-challenges-and-lessons-learned)
10. [Comments and Feedback](#10---comments-and-feedback)

# 1 - Introduction

This lab explores whitebox testing as well as coverage calculations and tools. Using the same base we used for blackbox testing, we will be able to explore the differences while also practicing JUnit4 and coverage calculations. Throughout the lab, we will also be exploring and comparing some differences between the coverage methods, meeting minimum coverage requirements, and data flow.

# 2 - Manual Data-Flow Coverage Calculations for `calculateColumnTotal` and `constrain` Methods

## calculateColumnTotal

### Data Flow Graph

![](media/code2flow_EYkoVr.png)

### Def-Use Table

note: line 123 = 1
| _Variable_ | _Def_ | _Use_ |
| --- | --- | --- |
| data | 1 | 2, 4, 6 |
| column | 1 | 6 |
| total | 3, 8 | 8, 11 |
| rowCount | 4 | 5 |
| r | 5 | 5 ,6 , 9 |
| n | 6 | 7, 8 |

## constrain

### Data Flow Graph

![](media/constrainDataFlowGraph.png)

### Def-Use Table

| _Variable_ | _Def_ | _Use_   |
| ---------- | ----- | ------- |
| value      | 0     | 1,2,3,5 |
| result     | 1,4,6 | 7       |

### Def Use set per Variable

| _Variable_ | _Def Set_ | _C-Use Set_ | _P-Use Set_ |
| ---------- | --------- | ----------- | ----------- |
| value      | {0}       | {1}         | {2,3,5}     |
| result     | {1,4,6}   | {7}         | {}          |

### DU pairs per Variable

| _Variable_ | _C-Use Pairs_         | _P-Use Pairs_         |
| ---------- | --------------------- | --------------------- |
| value      | {(0,1)}               | {(0,2), (0,3), (0,5)} |
| result     | {(1,7), (4,7), (6,7)} | {}                    |

### Test case pair coverage

| _Test Case_              | _value Pairs_              | _result Pairs_ |
| ------------------------ | -------------------------- | -------------- |
| testRangePositive        | (0,1), (0,2)               | (1,7)          |
| testRangeNegative        | (0,1), (0,2)               | (1,7)          |
| testRangeOutOfRangeAbove | (0,1), (0,2), (0,3)        | (1,7), (4,7)   |
| testRangeOutOfRangeBelow | (0,1), (0,2), (0,3), (0,5) | (1,7), (6,7)   |
| testRangeBoundaryUpper   | (0,1), (0,2)               | (1,7)          |
| testRangeBoundaryLower   | (0,1), (0,2)               | (1,7)          |

### DU Pair Coverage

The dupair coverage for the `constrain` method is 100%, as all pairs appear in the test cases.

# 3 - Testing Strategy for New Unit Tests

## DataUtilities

### clone
> Returns a clone of the specified array.

`clone` specifies that the argument is not permitted to be null and states that the returned value should be a clone of the passed object. Looking at the method code shows that the function copies the contents from one to the other without anything too complicated happenning.

To test this method, we will explore 
- null parameters
- even 2D array with a variety of double entries
- a jagged 2D array with a variety of double entries

## Range

### equals
> Tests this object for equality with an arbitrary object.

Based on the provided method description and available code, the following test cases will cover all.
- equivalent null object
- equivalent Range object
- non-equivalent non-Range object
- non-equivalent Range object
- non-equivalent null object

### combineIgnoringNaN
> Returns a new range that spans both range1 and range2. This method has a special handling to ignore Double.NaN values.

Based on the documentation and visible code, these test cases were appropriate to build:
- null ranges with null return
- 2 cases with each range being null
- Range with Double.NaN value expecting null
- Range without Double.NaN value (covered by the 2 cases testing individueal null)

### expand

# 4 - Selected Test Cases Using Coverage Information and How They Have Increased Code Coverage

## 4.1 -

## 4.2 -

## 4.3 -

## 4.4 -

## 4.5 -

# 5 - Coverage Achieved for Each Class and Method

## 5.1 - Blackbox Coverage

The screenshots below are captures of coverage from black box testing and as a result does not show all of the methods in a class.

![](media/DataUtilsLine.png)

_Figue 1 - DataUtilities line coverage for blackbox testing_

![](media/RangeLine.png)

_Figure 2 - Range line coverage for blackbox testing_

![](media/DataUtilsBranch.png)

_Figue 3 - DataUtilities branch coverage for blackbox testing_

![](media/RangeBranch.png)

_Figure 4 - Range branch coverage for blackbox testing_

![](media/DataUtilsMethod.png)

_Figue 5 - DataUtilities method coverage for blackbox testing_

![](media/RangeMethod.png)

_Figure 6 - Range method coverage for blackbox testing_

## 5.2 - Whitebox Coverage

The screenshots below show the coverage form white box testing and show the full class coverage.

# 6 - Pros and Cons of Coverage Tools Used and Metrics Reported

# 7 - Comparing Advantages and Disadvantages of Requirements-Based Test Generation and Coverage-Based Test Generation

# 8 - Teamwork Allocation

Team work divided evenly as follows:

- **Measuring control flow coverage** was done as a full team to familarize ourselves with the system, explore EclEmma and ensure we were all on the same page.
- **Manual coverage calculations** were divided into pair programming to allow groups to work efficiently and on their own schedule (since it is midterm season). Jared and Jordan worked on `calculateColumnTotal` while Amir and Liana worked on `constrain`.
- **Developing new test cases** were divided equally between all members to, once again, allow for schedule flexibility.

Once all work was done, the group came together once again to review eachother's work, build the report, and practice the demo.

# 9 - Difficulties, Challenges, and Lessons Learned

# 10 - Comments and Feedback

It would have been nice for the lab to have reminders or examples on the manual coverage but this did not prove to be overly inconvenient as it was just looked up in the class notes and adapted to the lab.

# QuickSort Imperative VS Declarative

## Files

* QuickSortDEC.java: A functional Java Version of QuickSort.
    * Note: The functional paradigm does not mutate the original data.
* QuickSortIMP.java: An imperative Java Version of QuickSort that **mutates** the original List.
* QuickSortIMPnoMutate.java: An imperative Java Version of QuickSort that does **NOT mutate** the original List.
* quickSort.kt: A functional version of QuickSort in a true functional language.

## The QuickSort Algorithm in PseudoCode

```bash
sort a list:
  if size of list is zero or one:
    list is sorted
  else:
    let pivot be first element in list
    let leftSublist be list elements smaller than pivot
    let rightSublist be list elements greater or equal than pivot
    
    concatenate:
      result of sorting leftSublist with
      pivot with
      result of sorting rightSublist
```

## Discussion of Results

* Why is the fastest version of QuickSort the Java OO version that mutates the list?
* Why is the OO version that doesn't mutate the list still faster than both functional versions?
* What about code readability?
* What about code size?
* What about compile code size?
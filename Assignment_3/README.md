# Assignment 3: HashTable and BST

This project contains implementations of a generic Hash Table using separate chaining and a Binary Search Tree (BST).

## Project Structure

- `hashtable/`: Implementation of a Hash Table with a custom testing class.
- `bst/`: Implementation of a Binary Search Tree with in-order traversal.

## How to Run

### 1. Hash Table Tests
This test adds 10,000 random elements to the Hash Table and displays the distribution across buckets to verify the `hashCode` implementation.

```bash
javac -d bin hashtable/*.java
java -cp bin hashtable.Main
```

### 2. Binary Search Tree Tests
This test demonstrates the `put`, `get`, `delete`, and `size` operations, as well as an in-order traversal using an iterator.

```bash
javac -d bin bst/*.java
java -cp bin bst.MainBST
```

## Features

### Hash Table
- Separate chaining for collision resolution.
- Custom `hashCode` implementation in `MyTestingClass` for uniform distribution.
- Support for `put`, `get`, `remove`, `contains`, and `getKey`.

### Binary Search Tree
- Standard BST operations: `put`, `get`, `delete`.
- `size` tracking.
- `Iterable` implementation for in-order traversal, providing access to both keys and values.

# Knapsack Problem Solver - CS311 Project

A Java implementation of various algorithms for solving the Knapsack Problem, comparing both greedy and randomized strategies.

## Project Overview

This project implements and compares different algorithmic approaches to solve the Knapsack Problem:
- **2 Greedy Algorithms**: Value-to-weight ratio and absolute value strategies
- **2 Randomized Algorithms**: Random sampling and Monte Carlo simulation


## Algorithms Implemented

### Greedy Algorithms
1. **Greedy Ratio** - Sorts items by value-to-weight ratio (supports fractional knapsack)
2. **Greedy Value** - Sorts items by absolute value (0-1 knapsack only)

### Randomized Algorithms
1. **Random Sampling** - Randomly shuffles items and selects greedily
2. **Monte Carlo** - Runs multiple random trials and returns the best solution

## How to Run

### Prerequisites
- Java JDK 8 or higher
- Any Java IDE (Eclipse, IntelliJ, VS Code) or command line

### Steps
1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   cd projectcs311

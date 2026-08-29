# Stock Trading Platform

A Java-based desktop simulation designed to model real-time stock market transactions, portfolio evaluation, and user asset management. This application provides a platform for tracking market price variations, executing mock buy and sell orders, and evaluating individual portfolio performance.

## Project Overview

The Stock Trading Platform acts as a financial market simulator. It updates mock stock values dynamically, lets users maintain a cash balance, and enables real-time testing of investment strategies by tracking shifting market data and recording transactions securely.

## Detailed Description & Architecture

This application utilizes core Object-Oriented Programming (OOP) principles to construct a realistic trading ecosystem. By segregating structural components into dedicated entities (`Stock`, `Portfolio`, and `StockTradingPlatform`), the architecture mirrors actual system environments. 

The `Stock` module manages data points regarding market ticker names, corporate labels, and algorithmic price fluctuations. The `Portfolio` layer serves as an analytical storage vault, monitoring available liquid currency alongside active share allocations while dynamically calculating current net worth based on market updates. 

Bridging these structures, the primary command loop coordinates user inputs to execute strict transaction logic. This pipeline validates liquid capital availability for purchases, cross-checks active share ownership rules for sales, and scales market numbers into clear, accessible statistical dashboard values.

## Key Features

* **Dynamic Portfolio Tracking:** Computes current asset values, tracking remaining cash against investment capital.
* **Market Simulation:** Models simulated stocks with distinct ticker symbols and fluctuating values.
* **Transaction Engine:** Implements precise logic to handle buying and selling stocks seamlessly.
* **Data Transparency:** Provides clear summaries of individual share values, holdings, and overall portfolio profits.

## Technologies Used

* **Language:** Java (JDK 8 or higher)
* **Concepts:** Object-Oriented Design (Classes & Objects), Encapsulation, Collections (List/Map), Loops, and Financial Logic Validation.

## How to Run the Application

1. Ensure you have the Java Development Kit (JDK) installed on your system.
2. Download or clone this repository to your local machine.
3. Open your terminal or command prompt and navigate to the project directory.
4. Compile all source files using the following command:
   ```bash
   javac *.java
   ```
5. Run the main application file with:
   ```bash
   java StockTradingPlatform
   ```
6. Follow the on-screen menu choices to monitor stocks, buy/sell assets, and track your wallet metrics.
  

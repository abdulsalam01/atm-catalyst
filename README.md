# ATM

by Abdul Salam

## Problem Statement

You are tasked with developing a Command Line Interface (CLI) to simulate the interaction of an ATM with a retail bank.

## Features and Commands

### Core Commands

- **`login [name]`**
  - Logs in as the specified customer. Creates the customer if they do not already exist.

- **`deposit [amount]`**
  - Deposits the specified amount to the logged-in customer's account.

- **`withdraw [amount]`**
  - Withdraws the specified amount from the logged-in customer's account.

- **`transfer [target] [amount]`**
  - Transfers the specified amount from the logged-in customer's account to the target customer.

- **`logout`**
  - Logs out of the current customer.

- **`history`**
  - Displays the transaction history for the logged-in customer.

- **`balance`**
  - Displays the current balance of the logged-in customer's account.

### Startup Messages

Upon starting, the application displays a welcome screen with usage instructions:

```
=================
DKATALIS ATM
=================
login: use keyword `login <username>`
deposit: use keyword `deposit <amount>`
withdraw: use keyword `withdraw <amount>`
transfer: use keyword `transfer <target> <amount>`
list history: use keyword `history`
get current balance: use keyword `balance`
logout: use keyword `logout`
```

## Code Overview

The ATM CLI is implemented with modular validation and transaction handling. Here are the key elements of the implementation:

### `boot` Method
This method orchestrates the CLI interface and handles user input dynamically.

- **Input Handling:**
  - Reads commands using a `Scanner` and splits them into parts.
  - Validates commands using a chain of responsibility implemented with `iValidator`.

- **Supported Operations:**
  - `login`, `deposit`, `withdraw`, `transfer`, `history`, `balance`, `logout`.

- **Dynamic Balance Updates:**
  - Displays the current balance after each successful transaction when logged in.

### Validators (`iValidator`)
The `prepare` method sets up a chain of responsibility with validators for each operation:

- **LoginValidator**
- **DepositValidator**
- **WithdrawValidator**
- **TransferValidator**

### Utility Methods

- **`print` Method:**
  Handles output formatting with optional newline support.

- **`prepareMachineWords` Method:**
  Prints instructions for using the CLI commands.

## Example Workflow

```bash
$ login Alice
Current balance is $0

$ deposit 100
Your balance is $100

$ logout

$ login Bob
Current balance is $0

$ deposit 80
Current balance is $80

$ transfer Alice 50
Current balance is $30

$ transfer Alice 100
Current balance is $0

$ deposit 30
Current balance is $0

$ logout

$ login Alice
Current balance is $210

$ transfer Bob 30
Current balance is $210

$ logout

```

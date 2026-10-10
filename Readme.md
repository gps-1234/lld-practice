- atm system
- **User Authentication:** Users must authenticate using a card and PIN.
- **Balance Inquiry:** Users can check their account balance.
- **Cash Withdrawal:** Users can withdraw cash if sufficient balance and cash are available.
- **Cash Deposit:** Users can deposit cash into their account.
- **Cash Dispenser:** The ATM manages its own cash inventory and dispenses cash securely.

##non-functional
- **Concurrency & Consistency:** The system handles concurrent access and ensures data consistency.

Consistency and atomicity: a withdrawal must either fully succeed (balance deducted and cash dispensed) or fully roll back.
Thread safety: the same account can be accessed from two ATMs, so balance updates must be atomic.
- **Extensibility:** Easy to add new features such as mini-statements, fund transfers, or multi-currency support.

elevator system

Functional requirements

From the repo:

The system has multiple elevators serving multiple floors.
github
Each elevator has a capacity limit and must not exceed it.
github
Users can request an elevator from any floor and select a destination floor.
github
The system handles requests efficiently and optimizes elevator movement to minimize waiting time.
github
Requests are prioritized by direction of travel and by how close each elevator is to the requested floor.
github


Non-functional requirements

From the repo:

The system must be thread-safe and prevent race conditions when multiple threads interact with the elevators.

- **Efficient Movement:** The elevator processes requests in an efficient order (e.g., all UP requests, then all DOWN requests).
- **Extensibility:** Easy to add more elevators or advanced scheduling algorithms.
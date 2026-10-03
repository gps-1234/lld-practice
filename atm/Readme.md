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
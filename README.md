# Expense_tracker_App
this is company assessment given by alephys.
Base URL
Assuming your app runs locally on port 8080:

bash
Copy
Edit
http://localhost:8080/api/transactions
1. Add a transaction (POST)
URL:

bash
Copy
Edit
POST http://localhost:8080/api/transactions
Request JSON body example:

json
Copy
Edit
{
  "description": "Groceries",
  "amount": 100.5,
  "date": "2025-05-20",
  "type": "EXPENSE",
  "category": "FOOD"
}
type should be "INCOME" or "EXPENSE" (based on your TransactionType enum).

category should match your Category enum values, e.g. "FOOD", "RENT", "SALARY", etc.

Response:
Returns the saved Transaction object (with any generated ID or timestamps).

2. Get all transactions (GET)
URL:

bash
Copy
Edit
GET http://localhost:8080/api/transactions
Response:
Returns a JSON array of all transactions, e.g.

json
Copy
Edit
[
  {
    "id": 1,
    "description": "Groceries",
    "amount": 100.5,
    "date": "2025-05-20",
    "type": "EXPENSE",
    "category": "FOOD"
  },
  {
    "id": 2,
    "description": "Salary",
    "amount": 1500,
    "date": "2025-05-01",
    "type": "INCOME",
    "category": "SALARY"
  }
]
3. Get monthly summary by category (GET)
URL:

sql
Copy
Edit
GET http://localhost:8080/api/transactions/monthly?year=2025&month=5
Query params:

year (e.g., 2025)

month (e.g., 5 for May)

Response:
Returns a JSON object where keys are categories and values are sums for that month, e.g.

json
Copy
Edit
{
  "FOOD": 300.5,
  "SALARY": 1500,
  "RENT": 700
}
4. Get monthly balance (income - expenses) (GET)
URL:

sql
Copy
Edit
GET http://localhost:8080/api/transactions/monthly-balance?year=2025&month=5
Query params same as above

Response:
Returns a number, e.g.:

json
Copy
Edit
999.5

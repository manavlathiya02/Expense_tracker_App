# Expense_tracker_App
this is company assessment given by alephys.
# Expense Tracker App - API Documentation

Base URL (Local):  
http://localhost:8080/api/transactions

yaml
Copy
Edit

---

## 1. Add a Transaction

**Endpoint:**  
`POST /api/transactions`

**Request Body Example:**

```json
{
  "description": "Groceries",
  "amount": 100.5,
  "date": "2025-05-20",
  "type": "EXPENSE",
  "category": "FOOD"
}
type values: "INCOME" or "EXPENSE"

category values: Must match your Category enum, e.g. "FOOD", "RENT", "SALARY", etc.

Response:
Returns the saved Transaction object with details like generated ID.

2. Get All Transactions
Endpoint:
GET /api/transactions

Response Example:

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
3. Get Monthly Summary by Category
Endpoint:
GET /api/transactions/monthly

Query Parameters:

year (e.g., 2025)

month (e.g., 5 for May)

Example URL:

bash
Copy
Edit
http://localhost:8080/api/transactions/monthly?year=2025&month=5
Response Example:

json
Copy
Edit
{
  "FOOD": 300.5,
  "SALARY": 1500,
  "RENT": 700
}
4. Get Monthly Balance (Income - Expenses)
Endpoint:
GET /api/transactions/monthly-balance

Query Parameters:

year (e.g., 2025)

month (e.g., 5 for May)

Example URL:

bash
Copy
Edit
http://localhost:8080/api/transactions/monthly-balance?year=2025&month=5
Response Example:

json
Copy
Edit
999.5
Note: Replace localhost:8080 with your deployed server URL when applicable.

yaml
Copy
Edit

---

You can copy-paste this entire block into your `README.md`.  
If you want, I can also help you add setup instructions or anything else!








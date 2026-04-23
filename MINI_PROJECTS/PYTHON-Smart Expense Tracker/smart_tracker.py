import csv
import matplotlib.pyplot as plt
import numpy as np
from datetime import datetime
file_path ='expenses_data.csv'
def init_file():
    try:
        with open(file_path, 'x', newline='') as file:
            writer = csv.writer(file)
            writer.writerow(['Date', 'Category', 'Amount','Description'])
    except FileExistsError:
        pass
def add_expense():
    date = input("Enter the date in this format (YYYY-MM-DD): ")
    category = input("Enter the category: ")
    amount = float(input("Enter the amount: "))
    description = input("Enter the description: ")
    with open(file_path, 'a', newline='') as file:
        writer = csv.writer(file)
        writer.writerow([date, category, amount, description])
    print("Expense added successfully!")
def show_expenses():
    with open(file_path, 'r') as file:
        reader = csv.reader(file)
        for r in reader:
            print(r)
def monthlyexpense_summary():
    month = input("Enter the month (YYYY-MM): ")
    total_expenses = 0
    month_name=datetime.strptime(month, "%Y-%m").strftime("%B %Y")
    with open(file_path, 'r') as file:
        reader = csv.DictReader(file)
        for row in reader:
            if row["Date"].startswith(month):
                total_expenses += float(row["Amount"])
    print(f"Total expenses for {month_name}: Rs. {total_expenses:.2f}")
def category_expense_summary():
    data={}
    with open(file_path, 'r') as file:
        reader = csv.DictReader(file)
        for row in reader:
            category = row["Category"]
            amount = float(row["Amount"])
            if category in data:
                data[category] += amount
            else:
                data[category] = amount
    for category, total in data.items():
        print(f"Total expenses for category '{category}': Rs. {total:.2f}")
    plt.pie(data.values(), labels=data.keys(), autopct='%1.1f%%')
    plt.title("Category-wise Expense Breakdown")
    plt.show()

def highest_category_expense():
    data={}
    with open(file_path,'r') as file:
        reader = csv.DictReader(file)
        for row in reader:
            category = row["Category"]
            amount = float(row["Amount"])
            if category in data:
                data[category] += amount
            else:
                data[category] = amount
    max_category = ""
    max_amount = 0
    for category, total in data.items():
        if total > max_amount:
            max_amount = total
            max_category = category
    print(f"Highest spending category: {max_category} with total expenses of Rs. {max_amount:.2f}")
def main():
    init_file()
    while True:
        print("\n Welcome to Expense Tracker:")
        print("1.Add Expense")
        print("2.Show Expenses")
        print("3.Monthly Expense Summary")
        print("4.Category-wise Expense Summary")
        print("5.Highest Spending Category")
        print("6.Exit")
        choice = input("Enter your choice: ")
        if choice == '1':
            add_expense()
        elif choice == '2':
            show_expenses()
        elif choice == '3':
            monthlyexpense_summary()
        elif choice == '4':
            category_expense_summary()
        elif choice == '5':
            highest_category_expense()
        elif choice == '6':
            print("Exiting! Thank you for using the Expense Tracker...")
            break
        else:
            print("Invalid choice, please try again.")
main()
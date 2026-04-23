import os
from datetime import datetime
def log(log_file):
    error_frequency = {"CRITICAL":0,"ERROR":0,"FAILED LOGIN":0}
    cleaned_log = []

    try:
        with open(log_file, 'r') as file:
            for line in file:
                cleaned_line=line.strip().upper()
                if "CRITICAL" in cleaned_line:
                     error_frequency["CRITICAL"] += 1
                elif "ERROR" in cleaned_line:
                     error_frequency["ERROR"] += 1
                elif "FAILED LOGIN" in cleaned_line:
                     error_frequency["FAILED LOGIN"] += 1
                else:
                    continue
                cleaned_log.append(cleaned_line)
        date=datetime.now().strftime("%Y-%m-%d")
        output_file=f"security_alert_{date}.txt"

        with open(output_file, 'w') as out:
            out.write("======Security Alert Summary=======\n\n")
            for line in cleaned_log:
                out.write(line + "\n")
            out.write("\n=====Summary=====\n")
            for key,value in error_frequency.items():
               out.write(f"{key}:{value}\n")
            total_security_alerts=sum(error_frequency.values())
            out.write(f"\nTotal Alerts:{total_security_alerts}\n")
          
        file_size=os.path.getsize(output_file)
        print(f"Security alert summary saved to {output_file} (Size: {file_size} bytes)")
        return error_frequency
    except FileNotFoundError:
        print(f"Error: Log file '{log_file}' not found.")
        return None
def show_summary(error_frequency):
    if error_frequency:
        print("\n======Security Alert Summary=======\n")
        for key,value in error_frequency.items():
            print(f"{key}:{value}")
        total_security_alerts=sum(error_frequency.values())
        print(f"\nTotal Alerts:{total_security_alerts}\n")
    else:
        print("No security alerts found.")
def menu():
    error_frequency=None
    while True:
        print("\n=====Welcome to OpsBot=====")
        print("1. Analyze Log File")
        print("2. Show Summary")
        print("3. Exit")
        option=input("Enter your choice: ")
        if option=="1":
            server_log=input("Enter the log file path: ")
            error_frequency=log(server_log)
        elif option=="2":
            show_summary(error_frequency)
        elif option=="3":
            print("Exiting OpsBot. Goodbye!")
            break
        else:
            print("Invalid choice.Please try again.")
if __name__=="__main__":
    menu()

        
        
        
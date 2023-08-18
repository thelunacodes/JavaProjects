package EN;

import java.util.Scanner;

public class DateValidator_MMDDYYYY {
    public static void main(String[] args) {
        String date;
        Scanner scanner = new Scanner(System.in);
        int slashCouter = 0;
        boolean leapYear = false;

        //User input
        System.out.print("Insert a date (format: MM/DD/YYYY): ");
        date = scanner.nextLine();
        //Verify the number of "/"
        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) == '/') {
                slashCouter++;
            }
        }
        //Check if date string contains two "/"
        if (slashCouter == 2) {
            //Check if date string contains day, month and year
            if (date.split("/").length == 3) {
                //Validate day, month and year
                int month = Integer.parseInt(date.split("/")[0]);
                int day = Integer.parseInt(date.split("/")[1]);
                int year = Integer.parseInt(date.split("/")[2]);
                if ((day > 0 && day <= 31) && (month > 0 && month <= 12) && (year > 0)){
                    //Check if it's a leap year
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        leapYear = true;
                    }
                    //February
                    if (month == 2) {
                        if (day <= 29) {
                            if ((leapYear && day <= 29) || (!leapYear && day <= 28)) {
                                System.out.println(date + " is a valid date!");
                            } else {
                                System.out.println("INVALID DATE: The month of Fabruary ends on the 28th (or on the 29th, at leap years).");
                            }
                        } else {
                            System.out.println("INVALID DATE: The month of Fabruary ends on the 28th (or on the 29th, at leap years).");
                        }
                    //Months that end at 30th (april,june,september and november)
                    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                        if (day <= 30) {
                                System.out.println(date + " is a valid date!");
                        } else {
                            System.out.println("INVALID DATE: April, June, September and November ends on the 30th.");
                        }
                    //Months that end at 31st (january, march, may, july, august, october and december)
                    } else {
                        if (day <= 31) {
                                System.out.println(date + " is a valid date!");
                        } else {
                            System.out.println("INVALID DATE: The months of January, March, May, July, August, October and Deceber end on the 31st.");
                        }
                    }
                } else {
                    System.out.println("INVALID DATE: The day needs to be greater than 0 or less than or equal to 31, the month needs to be greater than 0 and less than or equal to 12, and the year needs to be greater than 0.");
                }

            } else {
                System.out.println("INVALID DATE: The date should contain day, month and year.");
            }
        } else {
            System.out.println("INVALID DATE: The date should have two slashes (\"/\").");
        }
        scanner.close();
    }
}

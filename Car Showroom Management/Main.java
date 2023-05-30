import java.util.Scanner;
//Main Class

import java.util.Scanner;
import java.util.UUID;

interface utility{
    public void get_details();
    public void set_details();
}


public class Main {
    static void main_menu(){
        System.out.println();
        System.out.println("======================= * WELCOME TO SHOWROOM MANAGEMENT SYSTEM * =======================");
        System.out.println();
        System.out.println("=============================== * ENTER YOUR CHOICE * ===============================");
        System.out.println();
        System.out.println("1].ADD SHOWROOMS \t\t\t 2].ADD EMPLOYEES \t\t\t 3].ADD CARS");
        System.out.println();
        System.out.println("4].GET SHOWROOMS \t\t\t 5].GET EMPLOYEES \t\t\t 6].GET CARS");
        System.out.println();
        System.out.println("=============================== * ENTER 0 TO EXIT * ===============================");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k;
        Showroom showroom[] = new Showroom[5];

        int showroom_counter = 0;
        int choice = 100;
        while(choice!=0){

            main_menu();
            choice = sc.nextInt();

            while(choice!=9 && choice!=0){
                switch (choice) {
                    case 1:
                        showroom[showroom_counter] = new Showroom();
                        showroom[showroom_counter].set_details();
                        showroom_counter++;
                        System.out.println();
                        System.out.println("1].ADD NEW SHOWROOM");
                        System.out.println("9].GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;
                    case 2:
                        if(showroom_counter == 0 ){
                            System.out.println("No Showroom Exits");
                        }
                        else {
                            System.out.print("\n\t------------- Showrooms -----------");
                            for(int i=0;i<showroom_counter;i++){
                                System.out.println((i+1)+"==>"+showroom[i].getShowroom_name());
                            }
                            System.out.print("\nEnter Showroom Number ==> ");
                            k=sc.nextInt()-1;

                            showroom[k].employee[showroom[k].counter_employee] = new Employees();

                            showroom[k].employee[showroom[k].counter_employee].set_details_employee();

                            showroom[k].counter_employee++;
                        }
                        System.out.println();
                        System.out.println("2].ADD NEW EMPLOYEE");
                        System.out.println("9].GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;
                    case 3:
                        if(showroom_counter == 0 ){
                            System.out.println("No Showroom Exits");
                        }
                        else {
                            System.out.print("\n\t------------- Showrooms -----------");

                            for(int i=0;i<showroom_counter;i++){
                                System.out.println((i+1)+"==>"+showroom[i].getShowroom_name());
                            }
                            System.out.print("\nEnter Showroom Number ==> ");
                            k=sc.nextInt()-1;

                            showroom[k].car[showroom[k].counter_cars] = new Cars();

                            showroom[k].car[showroom[k].counter_cars].set_details();
                            showroom[k].counter_cars++;
                        }
                        System.out.println();
                        System.out.println("2].ADD NEW EMPLOYEE");
                        System.out.println("9].GO BACK TO MAIN MENU");
                        choice = sc.nextInt();
                        break;
                    case 4:
                        System.out.print("\n\t------------- Showrooms -----------");

                        for (int i = 0; i < showroom_counter; i++) {
                            showroom[i].get_details();
                            System.out.println();
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("9].GO BACK TO MAIN MENU");
                        System.out.println("0].EXIT");
                        choice = sc.nextInt();
                        break;
                    case 5:
                        if(showroom_counter == 0 ){
                            System.out.println("No Showroom Exits");
                        }
                        else {
                            System.out.print("\n\t------------- Showrooms -----------");
                            for(int i=0;i<showroom_counter;i++){
                                System.out.println((i+1)+"==>"+showroom[i].getShowroom_name());
                            }
                            System.out.print("\nEnter Showroom Number ==> ");
                            k=sc.nextInt()-1;

                            for(int i=0;i<showroom[k].counter_employee;i++){
                                System.out.println("\n+"+(i+1)+" ==>");
                                showroom[k].employee[i].get_details_employee();
                            }
                        }
                        System.out.println();
                        System.out.println("9].GO BACK TO MAIN MENU");
                        System.out.println("0].EXIT");
                        choice = sc.nextInt();
                        break;
                    case 6:
                        if(showroom_counter == 0 ){
                            System.out.println("No Showroom Exits");
                        }
                        else {
                            System.out.print("\n\t------------- Showrooms -----------");
                            for(int i=0;i<showroom_counter;i++){
                                System.out.println((i+1)+"==>"+showroom[i].getShowroom_name());
                            }
                            System.out.print("\nEnter Showroom Number ==> ");
                            k=sc.nextInt()-1;

                            for(int i=0;i<showroom[k].counter_cars;i++){
                                System.out.println("\n+"+(i+1)+" ==>");
                                showroom[k].car[i].get_details();
                            }
                        }
                        System.out.println();
                        System.out.println("9].GO BACK TO MAIN MENU");
                        System.out.println("0].EXIT");
                        choice = sc.nextInt();
                        break;
                    default:
                        System.out.println("ENTER VALID CHOICE: ");
                        break;
                }
            }
        }
    }
}
class Showroom implements utility
{
    public String getShowroom_name() {
        return showroom_name;
    }

    String showroom_name;
    String showroom_address;
    int total_employees;
    int total_cars_in_stock;
    String manager_name;

    public int counter_cars;
    public int counter_employee;
    public Employees[] employee;
    public Cars[] car;
    public Showroom(){
        total_employees=0;
        total_cars_in_stock=0;
        counter_cars=0;
        counter_employee=0;
        employee =  new Employees[5];
        car = new Cars[5];
    }
    @Override
    public void get_details() {
        System.out.println("Showroom Name: "+showroom_name);
        System.out.println("Showroom Address: "+showroom_address);
        System.out.println("Manager Name: "+manager_name);
        System.out.println("Total Employees: "+(total_employees+counter_employee));
        System.out.println("Total Cars In Stock: "+(total_cars_in_stock+counter_cars));
    }
    @Override
    public void set_details() {
        Scanner sc = new Scanner(System.in);
        System.out.println("======================= * ENTER SHOWROOM DETAILS * =======================");
        System.out.println();
        System.out.print("SHOWROOM NAME: ");
        showroom_name = sc.nextLine();
        System.out.print(("SHOWROOM ADDRESS: "));
        showroom_address = sc.nextLine();
        System.out.print("MANAGER NAME: ");
        manager_name = sc.nextLine();
        System.out.print("TOTAL NO OF EMPLOYEES: ");
        total_employees = sc.nextInt();
        System.out.print("TOTAL CARS IN STOCK: ");
        total_cars_in_stock = sc.nextInt();
    }
}



//Cars Class


class Cars extends Showroom implements utility {
    String car_name;
    String car_color;
    String car_fuel_type;
    int car_price;
    String car_type;
    String car_transmission;

    @Override
    public void get_details(){
        System.out.println("NAME: "+this.car_name);
        System.out.println("COLOR: "+this.car_color);
        System.out.println("FUEL TYPE: "+this.car_fuel_type);
        System.out.println("PRICE: "+this.car_price);
        System.out.println("CAR TYPE: "+this.car_type);
        System.out.println("TRANSMISSION: "+this.car_transmission);
    }

    @Override
    public void set_details(){
        Scanner sc = new Scanner(System.in);
        System.out.println("======================= * ENTER CAR DETAILS * =======================");
        System.out.println();
        System.out.print("CAR NAME: ");
        this.car_name = sc.nextLine();
        System.out.print(("CAR COLOR: "));
        this.car_color = sc.nextLine();
        System.out.print("CAR FUEL TYPE(PETROL/DIESEL): ");
        this.car_fuel_type = sc.nextLine();
        System.out.print("CAR PRICE: ");
        this.car_price = sc.nextInt();
        sc.nextLine();
        System.out.print("CAR TYPE(SEDAN/SUV/HATCHBACK): ");
        this.car_type = sc.nextLine();
        System.out.print("TRANSMISSION TYPE(AUTOMATIC/MANUAL): ");
        this.car_transmission = sc.nextLine();
    }
}

//Class Employees

class Employees{
    String emp_id;
    String emp_name;
    int emp_age;
    String emp_department;


    public void get_details_employee() {
        System.out.println("ID: "+this.emp_id);
        System.out.println("Name: "+this.emp_name);
        System.out.println("Age: "+this.emp_age);
        System.out.println("Department: "+this.emp_department);
    }
    public void set_details_employee(){
        Scanner sc = new Scanner(System.in);
        UUID uuid = UUID.randomUUID();
        this.emp_id = String.valueOf(uuid);
        System.out.println("======================= * ENTER EMPLOYEE DETAILS * =======================");
        System.out.println();
        System.out.print("EMPLOYEE NAME: ");
        this.emp_name = sc.nextLine();
        System.out.print(("EMPLOYEE AGE: "));
        this.emp_age = sc.nextInt();
        sc.nextLine();
        System.out.print("EMPLOYEE DEPARTMENT: ");
        this.emp_department = sc.nextLine();
    }
}

import java.util.Scanner;

public class PlaneManagement {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void buySeat(int[][] array, String letter, int number) {
        Scanner sn = new Scanner(System.in);
        int letter0;
        if (letter.equals("A")) {
            letter0 = 0;
        } else if (letter.equals("B")) {
            letter0 = 1;
        } else if (letter.equals("C")) {
            letter0 = 2;
        } else if (letter.equals("D")) {
            letter0 = 3;
        } else {
            letter0 = 4;
        }
        if (letter0 < 14 && number < 4) {
            if (array[number][letter0] == 1) {
                System.out.println("THE SEAT NUMBER YOU ENTERED IS BOOKED");
            } else {
                array[number][letter0] = 1;
                System.out.println("To buy a ticket please enter the name:");
                String n = sn.nextLine();
                System.out.println("Now please enter the surname:");
                String s = sn.nextLine();
                System.out.println("Now please enter the email:");
                String e = sn.nextLine();
                Person p1 = new Person(n, s, e);
                System.out.println("We booked your seat.");
                System.out.println("do you want to continue (y/n): ");
                String input = sn.nextLine();
                if(input.equals("y")){

                }
            }
        } else {
            System.out.println("\u001B[31m!WRONG INPUT\u001B[0m");
        }
    }

    public void cancelSeat(int[][] array, String letter, int number) {
        int letter0;
        if (letter.equals("A")) {
            letter0 = 0;
        } else if (letter.equals("B")) {
            letter0 = 1;
        } else if (letter.equals("C")) {
            letter0 = 2;
        } else if (letter.equals("D")) {
            letter0 = 3;
        } else {
            letter0 = 4;
        }
        if (letter0 < 14 && number < 4) {
            if (array[number][letter0] == 1) {
                array[number][letter0] = 0;
                System.out.println("You have cancelled the seat.");
            }
        } else {
            System.out.println("\u001B[31m!WRONG INPUT\u001B[0m");
        }
    }

    public void findFirstAvailable(int[][] array) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 14; j++) {
                if (array[i][j] == 0) {
                    a = i;
                    b = j;
                    break;
                }
            }
            if (a > 0 && b > 0) {
                break;
            }
        }
        if (a == 0) {
            System.out.println("First available seat is: A" + b);
        } else if (a == 1) {
            System.out.println("First available seat is: B" + b);
        } else if (a == 2) {
            System.out.println("First available seat is: C" + b);
        } else if (a == 3) {
            System.out.println("First available seat is: D" + b);
        }
    }

    public void showSeatingPlan(int[][] array) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 14; j++) {
                if (array[i][j] == 1) {
                    System.out.print(" X ");
                } if((i==1 || i==2) && (j==12 || j==13)){
                    System.out.print(" ");
                }
                else {
                    System.out.print(" O ");
                }
            }
            System.out.println(" ");
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("################ WELCOME TO THE PLANE MANAGEMENT APPLICATION ######################");
        System.out.print(" ENTER NUMBER 1 TO PROCEED : ");
        int number1 = scan.nextInt();
        clearScreen();
        String a = "";
        PlaneManagement pm = new PlaneManagement();
        int[][] array = new int[4][14];
        Ticket[] tickets = new Ticket[50];
        if (number1 == 1) {
            do {
                System.out.println("*************************************************");
                System.out.println("*                  MENU  OPTION                 *");
                System.out.println("*************************************************");
                System.out.println(" ");
                System.out.println("1) Buy a seat ");
                System.out.println("2) Cancel a seat ");
                System.out.println("3) Find first available seat ");
                System.out.println("4) Show seating plan ");
                System.out.println("5) Print ticket information and total sales ");
                System.out.println("6) Search ticket ");
                System.out.println("0 QUIT )");
                System.out.println("*************************************************");
                System.out.println(" ");
                System.out.print(" Please select an option :");
                int number2 = scan.nextInt();
                switch (number2) {
                    case 1:
                        System.out.print("Please enter the row letter : ");
                        String letter = scan.next();
                        System.out.print("Please enter the seat number : ");
                        int num = scan.nextInt();
                        pm.buySeat(array, letter, num);
                        tickets[0] = new Ticket("John", "Doe", "john.doe@example.com");
                        tickets[0].row = letter.charAt(0) - 'A';
                        tickets[0].seat = Integer.toString(num);
                        tickets[0].price = 200;
                        tickets[0].save();
                        break;
                    case 2:
                        System.out.print("Please enter the row letter : ");
                        String letter1 = scan.next();
                        System.out.print("Please enter the seat number : ");
                        int num1 = scan.nextInt();
                        pm.cancelSeat(array, letter1, num1);
                        break;
                    case 3:
                        pm.findFirstAvailable(array
                        );
                        break;
                    case 4:
                        pm.showSeatingPlan(array);
                        break;
                    case 5:
                        pm.printTicketsInfo(tickets);
                        break;
                    case 6:
                        System.out.print("Please enter the row letter : ");
                        String letter2 = scan.next();
                        System.out.print("Please enter the seat number : ");
                        int num2 = scan.nextInt();
                        pm.searchTicket(tickets, letter2, num2);
                        break;
                    case 0:
                        break;
                }
                System.out.print("Do you want to contunue (y/n) : ");
                String b = scan.next();
                a = b;
            } while (a.equals("y"));
        }else {
            System.out.println("\u001B[31m!WRONG INPUT\u001B[0m");
        }
    }

    public void printTicketsInfo(Ticket[] tickets) {
        int totalPrice = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                ticket.printTicket();
                totalPrice += ticket.price;
            }
        }
        System.out.println("Total sales: £" + totalPrice);
    }

    public void searchTicket(Ticket[] tickets, String letter, int number) {
        boolean found = false;
        for (Ticket ticket : tickets) {
            if (ticket != null && ticket.row == letter.charAt(0) - 'A' && ticket.seat.equals(Integer.toString(number))) {
                ticket.printTicket();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("This seat is available.");
        }
    }
}

class Person {
    String name;
    String surname;
    String email;

    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public void printPerson() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}

class Ticket {
    String name, surname, email;
    public int row;
    public String seat;
    public int price;

    public Ticket(String ne, String sn, String el) {
        name = ne;
        surname = sn;
        email = el;
    }

    Person person = new Person(name, surname, email);

    public void printTicket() {
        person.printPerson();
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: £" + price);
    }

    public void save() {
        
    }
}

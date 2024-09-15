import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Library_Management_System {

    static public ArrayList<Book> library = new ArrayList<>();
    static public ArrayList<Membership_user> members = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        int option;
        do {
            displayMenu();
            option = sc.nextInt();
            sc.nextLine(); // Clear the buffer
            handleMenuOption(option);
        } while (option != 10);
    }

    public static void displayMenu() {
        System.out.println("-----Anteiku Book Store-----");
        System.out.println(" [1]. Add Book To Store");
        System.out.println(" [2]. Sell Book");
        System.out.println(" [3]. Rent Book");
        System.out.println(" [4]. Return Book");
        System.out.println(" [5]. Display Book Info");
        System.out.println(" [6]. Create Membership");
        System.out.println(" [7]. Display Member Info");
        System.out.println(" [8]. Remove Book From Store");
        System.out.println(" [9]. Remove Membership");
        System.out.println(" [10]. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void handleMenuOption(int option) {
        switch(option) {
            case 1:
                addBookFlow();
                break;
            case 2:
                sellBookFlow();
                break;
            case 3:
                rentBookFlow();
                break;
            case 4:
                returnBookFlow();
                break;
            case 5:
                displayBookFlow();
                break;
            case 6:
                createMembershipFlow();
                break;
            case 7:
                displayMemberInfoFlow();
                break;
            case 8:
                removeBookFlow();
                break;
            case 9:
                removeMembershipFlow();
                break;
            case 10:
                System.out.println("Exiting system.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void addBookFlow() {
        System.out.println("Enter Book ID: ");
        String book_id = sc.nextLine();
        System.out.println("Enter Book Name: ");
        String book_name = sc.nextLine();
        System.out.println("Enter Book Author: ");
        String book_author = sc.nextLine();
        System.out.println("Enter Published Date (yyyy-MM-dd): ");
        LocalDate published_date = inputDate();
        System.out.println("Enter number of books in stock: ");
        int instock = sc.nextInt();
        sc.nextLine(); // Clear the buffer
        addBook(book_id, book_name, book_author, published_date, instock);
    }

    public static void sellBookFlow() {
        System.out.println("Enter Book Name: ");
        String book_name = sc.nextLine();
        System.out.println("Enter Buyer Name: ");
        String buyer_name = sc.nextLine();
        sellBook(book_name, buyer_name);
    }

    public static void rentBookFlow() {
        System.out.println("Enter Book Name: ");
        String book_name = sc.nextLine();
        System.out.println("Enter Member ID: ");
        String membership_id = sc.nextLine();
        rentBook(book_name, membership_id);
    }

    public static void returnBookFlow() {
        System.out.println("Enter Book Name: ");
        String book_name = sc.nextLine();
        System.out.println("Enter Member ID: ");
        String membership_id = sc.nextLine();
        returnBook(book_name, membership_id);
    }

    public static void displayBookFlow() {
        System.out.println("Enter Book ID: ");
        String book_id = sc.nextLine();
        System.out.println("Enter Book Name: ");
        String book_name = sc.nextLine();
        displayBook(book_id, book_name);
    }

    public static void createMembershipFlow() {
        System.out.println("Enter User Name: ");
        String user_name = sc.nextLine();
        System.out.println("Enter User Age: ");
        byte user_age = sc.nextByte();
        sc.nextLine(); // Clear the buffer
        System.out.println("Enter User Address: ");
        String user_address = sc.nextLine();
        System.out.println("Enter Membership ID: ");
        String membership_id = sc.nextLine();
        LocalDate join_date = LocalDate.now();
        LocalDate end_date = join_date.plusYears(1);
        createMembership(user_name, user_age, user_address, membership_id, join_date, end_date);
    }

    public static void displayMemberInfoFlow() {
        System.out.println("Enter Membership ID: ");
        String membership_id = sc.nextLine();
        displayMemberInfo(membership_id);
    }

    public static void removeBookFlow() {
        System.out.println("Enter Book Name: ");
        String book_name = sc.nextLine();
        System.out.println("Enter Book ID: ");
        String book_id = sc.nextLine();
        removeBookFromStore(book_name, book_id);
    }

    public static void removeMembershipFlow() {
        System.out.println("Enter Membership ID: ");
        String membership_id = sc.nextLine();
        System.out.println("Enter User Name: ");
        String user_name2 = sc.nextLine();
        removeMembership(membership_id, user_name2);
    }

    static public void addBook(String book_id, String book_name, String book_author, LocalDate book_publisheddate, int instock) {
        for (Book temp : library) {
            if (temp.getBook_id().equals(book_id) || temp.getBook_name().equals(book_name)) {
                temp.setInstock(temp.getInstock() + instock);
                System.out.println("Book stock updated.");
                return;
            }
        }
        Book newBook = new Book(book_id, book_name, book_author, book_publisheddate, instock);
        library.add(newBook);
        System.out.println("New book added to store.");
    }

    static public void sellBook(String book_name, String buyer_name) {
        for (Book temp : library) {
            if (temp.getBook_name().equals(book_name)) {
                if (temp.getInstock() > 0) {
                    temp.setBuyer_name(buyer_name);
                    temp.setInstock(temp.getInstock() - 1);
                    System.out.println("[Book Sold]");
                } else {
                    System.out.println("[Out Of Stock]");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static public void createMembership(String user_name, byte user_age, String user_address, String membership_id, LocalDate membership_join_date, LocalDate membership_end_date) {
        for (Membership_user temp : members) {
            if (temp.getUser_name().equals(user_name) || temp.getMembership_id().equals(membership_id)) {
                System.out.println("Member already exists.");
                return;
            }
        }
        Membership_user newUser = new Membership_user(user_name, user_age, user_address, membership_id, membership_join_date, membership_end_date);
        members.add(newUser);
        System.out.println("New membership created.");
    }

    static public void displayMemberInfo(String membership_id) {
        for (Membership_user temp : members) {
            if (temp.getMembership_id().equals(membership_id)) {
                System.out.println("Member ID: [" + temp.getMembership_id() + "]");
                System.out.println("Name: [" + temp.getUser_name() + "]");
                System.out.println("Age: [" + temp.getUser_age() + "]");
                System.out.println("Address: [" + temp.getUser_address() + "]");
                System.out.println("Membership Join Date: [" + temp.getMembership_join_date() + "]");
                System.out.println("Membership End Date: [" + temp.getMembership_end_date() + "]");
                System.out.println("Status: [Active]");
                return;
            }
        }
        System.out.println("Member not found.");
    }

    static public void removeMembership(String membership_id, String user_name2) {
        for (Membership_user temp : members) {
            if (temp.getMembership_id().equals(membership_id) && temp.getUser_name().equals(user_name2)) {
                members.remove(temp);
                System.out.println("Membership removed.");
                return;
            }
        }
        System.out.println("Member not found.");
    }

    static public void removeBookFromStore(String book_name, String book_id) {
        for (Book temp : library) {
            if (temp.getBook_id().equals(book_id) && temp.getBook_name().equals(book_name)) {
                library.remove(temp);
                System.out.println("Book removed from store.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static public void displayBook(String book_id, String book_name) {
        
        if (book_id == null && book_name == null) {
            System.out.println("Please provide either a book ID or a book name to search.");
            return;
        }
    
        
        for (Book temp : library) {
            boolean idMatches = (book_id != null && temp.getBook_id().equals(book_id));
            boolean nameMatches = (book_name != null && temp.getBook_name().equals(book_name));
            
            
            if (idMatches || nameMatches) {
                System.out.println("=== Book Details ===");
                System.out.println("Book ID: [" + temp.getBook_id() + "]");
                System.out.println("Book Name: [" + temp.getBook_name() + "]");
                System.out.println("Book Author: [" + temp.getBook_author() + "]");
                System.out.println("Published Date: [" + temp.getBook_publisheddate() + "]");
                System.out.println("Stock Available: [" + temp.getInstock() + "]");
                return;
            }
        }
    
        
        System.out.println("Book not found.");
    }
    

    static public void returnBook(String book_name, String membership_id) {
        for (Book temp : library) {
            if (temp.getBook_name().equals(book_name)) {
                temp.setInstock(temp.getInstock() + 1);
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static public void rentBook(String book_name, String membership_id) {
        for (Membership_user member : members) {
            if (member.getMembership_id().equals(membership_id)) {
                for (Book temp : library) {
                    if (temp.getBook_name().equals(book_name)) {
                        if (temp.getInstock() > 0) {
                            temp.setInstock(temp.getInstock() - 1);
                            System.out.println("Book rented to member.");
                        } else {
                            System.out.println("Book is out of stock.");
                        }
                        return;
                    }
                }
                System.out.println("Book not found.");
                return;
            }
        }
        System.out.println("Member not found.");
    }

    public static LocalDate inputDate() {
        while (true) {
            try {
                String dateString = sc.nextLine();
                return LocalDate.parse(dateString, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
            }
        }
    }
}

import java.time.LocalDate;
import java.util.ArrayList;

public class Membership_user
{
    private String user_name;
    private byte user_age;
    private String user_address;
    private String membership_id;
    private LocalDate membership_join_date;
    private LocalDate membership_end_date;
    private ArrayList<String> borrowed_book = new ArrayList<>();
    
    public Membership_user(String user_name, byte user_age, String user_address, String membership_id, LocalDate membership_join_date, LocalDate membership_end_date)
    {
        this.membership_id = membership_id;
        this.user_name = user_name;
        this.user_age = user_age;
        this.user_address = user_address;
        this.membership_join_date = membership_join_date;
        this.membership_end_date = membership_end_date;
    }

    public String getMembership_id()
    {
        return membership_id;
    }

    public String getUser_name()
    {
        return user_name;
    }

    public byte getUser_age()
    {
        return user_age;
    }

    public String getUser_address()
    {
        return user_address;
    }

    public LocalDate getMembership_join_date()
    {
        return membership_join_date;
    }

    public LocalDate getMembership_end_date()
    {
        return membership_end_date;
    }

    public ArrayList<String> getBorrowed_book()
    {
        return borrowed_book;
    }

    public void setUser_name(String user_name)
    {
        this.user_name = user_name;
    }

    public void setUser_age(byte user_age)
    {
        this.user_age = user_age;
    }

    public void setUser_address(String user_address)
    {
        this.user_address = user_address;
    }
    

    public void setMembership_id(String membership_id)
    {
        this.membership_id = membership_id;
    }

    public void setMembership_join_date(LocalDate membership_join_date)
    {
        this.membership_join_date = membership_join_date;
    }

    public void setMembership_end_date(LocalDate membership_end_date)
    {
        this.membership_end_date = membership_end_date;
    }

    public void remove_book(String book_name)
    {
        borrowed_book.remove(book_name);
    }

    public void addBook(String book_name)
    {
        borrowed_book.add(book_name);
    }

}

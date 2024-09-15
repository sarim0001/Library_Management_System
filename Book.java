import java.time.LocalDate;


public class Book
{
    private String book_id;
    private String book_name;
    private String book_author;
    private LocalDate book_publisheddate;
    private int instock = 0; 
    private String buyer_name = null;


    public Book(String book_id, String book_name, String book_author, LocalDate book_publisheddate, int instock) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_publisheddate = book_publisheddate;
        this.instock = instock;
    }
    

    public void setBook_id(String book_id)
    {
        this.book_id = book_id;
    }

    public void setBook_name(String book_name)
    {
        this.book_name = book_name;
    }

    public void setBook_author(String book_author)
    {
        this.book_author = book_author;
    }

    public void setBook_publisheddate(LocalDate book_publisheddate)
    {
        this.book_publisheddate = book_publisheddate;
    }

    public void setInstock(int instock)
    {
        this.instock = instock;
    }

    public void setBuyer_name(String buyer_name)
    {
        this.buyer_name = buyer_name;
    }

    public String getBook_id()
    {
        return book_id;
    }

    public String getBook_name()
    {
        return book_name;
    }

    public String getBook_author()
    {
        return book_author;
    }

    public LocalDate getBook_publisheddate()
    {
        return book_publisheddate;
    }

    public int getInstock()
    {
        return instock;
    }

    public String getBuyer_name()
    {
        return buyer_name;
    }

}
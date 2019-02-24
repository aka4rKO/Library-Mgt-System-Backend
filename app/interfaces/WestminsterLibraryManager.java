package interfaces;

import io.ebean.Ebean;
import models.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class WestminsterLibraryManager implements LibraryManager {


    @Override
    public String addBook(Book book) {
        System.out.println("inside add book");
        List<Book> books = Ebean.find(Book.class).findList();
        List<Dvd> dvds = Ebean.find(Dvd.class).findList();
        System.out.println(books);
        if(books.size() >= 100) {
            return "max reached";
        }
        for(Book b: books) {
            if(b.getIsbn().equals(book.getIsbn())){
                System.out.println("there is already a book");
                return "invalid";
            }
        }
        for(Dvd d: dvds) {
            if(d.getIsbn().equals(book.getIsbn())){
                System.out.println("there is already a dvd");
                return "invalid";
            }
        }
        for(Author a : book.getAuthors()) {
            a.save();
        }
        book.save();
        return "valid";
    }

    @Override
    public String addDvd(Dvd dvd) {
        System.out.println("inside add dvd");
        List<Book> books = Ebean.find(Book.class).findList();
        List<Dvd> dvds = Ebean.find(Dvd.class).findList();
        System.out.println(dvds);
        if(dvds.size() >= 50) {
            return "max reached";
        }
        for(Dvd d: dvds) {
            if(d.getIsbn().equals(dvd.getIsbn())){
                System.out.println("there is already a dvd");
                return "invalid";
            }
        }
        for(Book b: books) {
            if(b.getIsbn().equals(dvd.getIsbn())){
                System.out.println("there is already a book");
                return "invalid";
            }
        }
        for(Actor a : dvd.getActors()) {
            a.save();
        }
        dvd.save();
        return "valid";
    }

    @Override
    public void addReader(Reader reader) {
        Ebean.save(reader);
    }

    @Override
    public void deleteItem(String isbn) {
        System.out.println(isbn);
        Book book = Ebean.find(Book.class, isbn);
        Dvd dvd = Ebean.find(Dvd.class, isbn);
        if(book != null){
            Ebean.delete(book);
        }else if(dvd != null){
            Ebean.delete(dvd);
        }
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = Ebean.find(Book.class).findList();
        return books;
    }

    @Override
    public List<Dvd> getDvds() {
        List<Dvd> dvds = Ebean.find(Dvd.class).findList();
        return dvds;
    }

    @Override
    public String borrowItem(String isbn, String readerId) {
        Reader reader = Ebean.find(Reader.class, readerId);
        if(reader == null) {
            return "invalid";
        }else{
            Book book = Ebean.find(Book.class, isbn);
            Dvd dvd = Ebean.find(Dvd.class, isbn);
            if(book != null) {
                book.setCurrentReader(reader);
                Date d = new Date();
                book.setBorrowedDateTime(d.toString());
                book.setStatus("not available");
                book.update();
                return "valid";
            }else if(dvd != null) {
                dvd.setCurrentReader(reader);
                Date d = new Date();
                dvd.setBorrowedDateTime(d.toString());
                dvd.setStatus("not available");
                dvd.update();
                return "valid";
            }
            return "valid";
        }
    }

    @Override
    public double returnItem(String isbn) {
        double fee = 0;
        Date currentDate = new Date();
        Book book = Ebean.find(Book.class, isbn);
        Dvd dvd = Ebean.find(Dvd.class, isbn);
        if(book != null) {
            String sDate1=book.getBorrowedDateTime();
            Date date = null;
            try {
                date=new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(sDate1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long diff = getDateDiff(date, currentDate, TimeUnit.HOURS);
            fee = calculateFee(diff, "book");
            System.out.println("fee = "+fee);
            book.setCurrentReader(null);
            book.setBorrowedDateTime(null);
            book.setStatus("available");
            book.update();
        }else if(dvd != null) {
            String sDate1=dvd.getBorrowedDateTime();
            Date date = null;
            try {
                date=new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(sDate1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long diff = getDateDiff(date, currentDate, TimeUnit.HOURS);
            fee = calculateFee(diff, "dvd");
            dvd.setCurrentReader(null);
            dvd.setBorrowedDateTime(null);
            dvd.setStatus("available");
            dvd.update();
        }
        return fee;
    }

    public double calculateFee(long diff, String type) {
        double fee = 0.0;
        if(type.equals("book")) {
            long feeHour = diff - 168;
            if(feeHour > 72) {
                fee+= (72*0.2);
                fee+= ((feeHour-72)*0.5);
            }else if(feeHour > 0 && feeHour <= 72) {
                fee+= (feeHour*0.2);
            }
        }else if(type.equals("dvd")) {
            long feeHour = diff - 72;
            if(feeHour > 72) {
                fee += (72*0.2);
                fee += ((feeHour-72)*0.5);
            }else if(feeHour > 0 && feeHour <= 72) {
                fee += (feeHour*0.2);
            }
        }
        return fee;
    }

    public static long  getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMilllis = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMilllis, TimeUnit.MILLISECONDS);
    }

    @Override
    public void reserveItem(String isbn, Reader readerReserved) {

    }

    public String getReaderId() {
        List<Reader> readers = Ebean.find(Reader.class).findList();
        String next = String.format("R%03d",readers.size()+1);
        return next;
    }

    public List<ReportItem> generateReport() {
        List<Book> books = Ebean.find(Book.class).findList();
        List<Dvd> dvds = Ebean.find(Dvd.class).findList();

        List<ReportItem> filteredItems = new ArrayList<>();
        Date currentDate = new Date();
        for(Book b : books) {
            if(b.getBorrowedDateTime() != null) {
                String sDate1=b.getBorrowedDateTime();
                Date date = null;
                try {
                    date=new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(sDate1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(getDateDiff(date, currentDate, TimeUnit.HOURS) > 168) {
                    double fine = calculateFee(getDateDiff(date, currentDate, TimeUnit.HOURS), "book");
                    ReportItem item = new ReportItem(b.getIsbn(), b.getTitle(), fine, b.getCurrentReader());
                    filteredItems.add(item);
                }
            }
        }

        for(Dvd d: dvds) {
            if(d.getBorrowedDateTime() != null) {
                String sDate1=d.getBorrowedDateTime();
                Date date = null;
                try {
                    date=new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy").parse(sDate1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(getDateDiff(date, currentDate, TimeUnit.HOURS) > 72) {
                    double fine = calculateFee(getDateDiff(date, currentDate, TimeUnit.HOURS), "dvd");
                    ReportItem item = new ReportItem(d.getIsbn(), d.getTitle(), fine, d.getCurrentReader());
                    filteredItems.add(item);
                }
            }
        }
        return filteredItems;
    }
}

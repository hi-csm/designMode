/**
 * 迭代器模式
 */

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
    public static void main(String[] args){
        BookAggregate bookAggregate = new BookAggregate();

        String[] books = {"数据结构", "操作系统", "计算机网络", "计算机组成原理"};
        double[] prices = {10.24, 20.48, 40.96, 81.92};

        for (int i = 0; i < 4; i++){
            bookAggregate.Add(new Book(books[i], prices[i]));
        }

        Iterator bookIterator = bookAggregate.Createlterator();
        while (bookIterator.hasNext()){
            Book book = (Book) bookIterator.next();
            System.out.println(book.getName() + " " + book.getPrice());
        }
    }

}

interface Iterator{
    boolean hasNext();
    Object next();
}

class BookIterator implements Iterator{
    private int index;
    private BookAggregate bookAggregate;

    public BookIterator(BookAggregate bookAggregate){
        this.index = 0;
        this.bookAggregate = bookAggregate;
    }

    @Override
    public boolean hasNext() {
        if (index < bookAggregate.getSize()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object obj = bookAggregate.get(index);
        index++;
        return obj;
    }
}

interface Aggregate{
    Iterator Createlterator();
}

class BookAggregate implements Aggregate{
    private List<Book> list = new ArrayList<Book>();

    public void Add(Book book){
        list.add(book);
    }

    public Book get(int index){
        return list.get(index);
    }

    public int getSize(){
        return list.size();
    }

    @Override
    public Iterator Createlterator() {
        return new BookIterator(this);
    }
}

class Book{
    private String name;
    private double price;

    public Book(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}
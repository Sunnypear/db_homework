package org.scu_db.demo.controller;

import org.scu_db.demo.Repository.TitleRepository;
import org.scu_db.demo.model.Book;
import org.scu_db.demo.model.Member;
import org.scu_db.demo.model.Title;
import org.scu_db.demo.service.BookService;
import org.scu_db.demo.service.MemberService;
import org.scu_db.demo.service.TitleService;
import org.scu_db.demo.service.impl.TitleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private TitleService titleService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private BookService bookService;
    @Autowired
    private TitleRepository titleSer;


    @RequestMapping("/1")
    public List<Integer> homework1(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询所有被借走图书的Book_ID。(对应第2题)
        List<Integer> bookId = new ArrayList<Integer>();
        List<Book> allbook = new ArrayList<Book>();
        //------------在此之下写下执行代码--------------
        allbook = bookService.findAllBooks();
        for(int i=0;i<allbook.size();i++)
        {
            if(allbook.get(i).getBorrowermemno()!=null)
            {
                bookId.add(allbook.get(i).getBookId());
            }
        }
        return bookId;
        //-----------在此之上写下执行代码---------------
        //return null;//TODO:修改返回值为bookId
    }

    @RequestMapping("/2")
    public List<Title> homework2(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询书名为”Iliad”或”Odyssey”的书目信息。(对应第4题)
        List<Title> titles = new ArrayList<Title>();
        List<Title> book = new ArrayList<Title>();
        //------------在此之下写下执行代码-------------
        titles=titleSer.findAll();
        for(int i=0;i<titles.size();i++)
        {
            if(titles.get(i).getName().equals("Iliad") || titles.get(i).getName().equals("Odyssey"))
            {
                book.add(titles.get(i));
            }
        }
        return book;
        //-----------在此之上写下执行代码---------------
        //return null;//TODO:修改返回值为titles
    }


    @RequestMapping("/3")
    public Integer homework3(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询callnumber为”Call123”的图书有多少本。(对应第5题)
        Integer count = 0;

        //------------在此之下写下执行代码--------------
        List<Book> allbook = new ArrayList<Book>();
        allbook=bookService.findAllBooks();
        for(int j=0;j<allbook.size();j++)
        {
            if(allbook.get(j).getCallnumber().equals("Call123"))
            {
                count++;
            }
        }
        return count;


        //-----------在此之上写下执行代码---------------
        //return null;//TODO:修改返回值为books
    }

    @RequestMapping("/4")
    public List<String> homework4(){
        //TODO:请完成相关代码实现下述查询要求：
        //查询本数不超过2本的图书的callnumber号。(对应第7题)
        List<String> callnumbers = new ArrayList<String>();
        //------------在此之下写下执行代码--------------
        List<Book> allbook = new ArrayList<Book>();
        allbook =bookService.findAllBooks();
        int count=0;
        for (int i=0;i<allbook.size();i++)
        {
            for (int j=i+1;j<allbook.size();j++)
            {
                if(allbook.get(i).getCallnumber().equals(allbook.get(j).getCallnumber()))
                {
                    count++;
                    allbook.remove(j);
                }
            }

            if(count <3)
                callnumbers.add(allbook.get(i).getCallnumber());
            count=0;
        }
        return callnumbers;

        //-----------在此之上写下执行代码---------------
        //return null;//TODO:修改返回值为books
    }


}

package com.example.book.concers;

import com.example.book.model.Log;
import com.example.book.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class Logger {
    @Autowired
    private LogService logService;

    @Before("execution(* com.example.book.controller.BookController.index(..))")
    public void initializeLog(JoinPoint joinPoint) {
        if (logService.getSize() == 0) {
            logService.save(new Log());
        }
    }

    @After("execution(* com.example.book.controller.BookController.index(..))")
    public void afterLoad(JoinPoint joinPoint) {
        logService.addVisitor(1);
        System.err.println("[System] There is a new visit. Total number of visitors is " + logService.getVisitorNumber(1) + ".");
    }

    @AfterReturning("execution(* com.example.book.service.impl.BookServiceImpl.borrowBook(..))")
    public void afterBorrowBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.err.println("[System] Book with id " + args[0] + " have been borrowed.");
    }

    @AfterThrowing("execution(* com.example.book.service.impl.BookServiceImpl.borrowBook(..))")
    public void afterOutOfBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.err.println("[System] Quantity = 0. Books with id " + args[0] + " have been fully borrowed.");
    }

    @AfterReturning("execution(* com.example.book.service.impl.BookServiceImpl.returnBook(..))")
    public void afterReturnBook(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.err.println("[System] Book with id " + args[0] + " have been returned.");
    }
}

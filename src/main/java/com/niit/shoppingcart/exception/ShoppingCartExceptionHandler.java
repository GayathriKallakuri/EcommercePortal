package com.niit.shoppingcart.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ShoppingCartExceptionHandler {
private static final Logger log= LoggerFactory.getLogger(ShoppingCartExceptionHandler.class);

@ExceptionHandler(SQLException.class)
public ModelAndView handleSQLException(HttpServletRequest request,Exception e){
   log.error("SQL Exception occured::URL=" +request.getRequestURL());
   log.error("SQL Exception occured:: Exception="+e.getMessage());
   ModelAndView mv=new ModelAndView("error");
   mv.addObject("message", "One of the table or row doest not contain the resource");
   mv.addObject("errorMessage", e.getMessage());
   return mv;
}

@ExceptionHandler(CannotCreateTransactionException.class)
public ModelAndView dbServerNotStarted(HttpServletRequest request,Exception e){
   log.error("SQL Exception occured::URL=" +request.getRequestURL());
   log.error("SQL Exception occured:: Exception="+e.getMessage());
   ModelAndView mv=new ModelAndView("error");
   mv.addObject("message", "Database server is not started");
   mv.addObject("errorMessage", e.getMessage());
   return mv;
}

@ExceptionHandler(QuerySyntaxException.class)
public ModelAndView handleQuerySyntaxException(HttpServletRequest request,Exception e){
   log.error("Query Syntax Exception occured::URL=" +request.getRequestURL());
   log.error("SQL Exception occured:: Exception="+e.getMessage());
   ModelAndView mv=new ModelAndView("error");
   mv.addObject("message", "Error in the syntax of the query written");
   mv.addObject("errorMessage", e.getMessage());
   return mv;
}

@ExceptionHandler(NoHandlerFoundException.class)
public ModelAndView noHandlerException(HttpServletRequest request,Exception e){
   log.error("No handler Exception occured::URL=" +request.getRequestURL());
   log.error("No handler Exception occured:: Exception="+e.getMessage());
   ModelAndView mv=new ModelAndView("error");
   mv.addObject("message", "Specified URL is not valid");
   mv.addObject("errorMessage", e.getMessage());
   return mv;
}

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
@ExceptionHandler(IOException.class)
public ModelAndView handleIOException(HttpServletRequest request,Exception e){
   log.error("IO Exception handler executed");
   log.error("IO Exception occured:: Exception="+e.getMessage());
   ModelAndView mv=new ModelAndView("error");
   mv.addObject("message", "Unable to connect to the server");
   mv.addObject("errorMessage", e.getMessage());
   return mv;
}
}


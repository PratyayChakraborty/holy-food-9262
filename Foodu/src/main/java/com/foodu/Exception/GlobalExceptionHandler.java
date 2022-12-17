package com.foodu.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;




@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyErrorDetails> myAnyExpHandler(AddressException ie,WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	} 
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<MyErrorDetails> myAnyExpHandler(ItemException ie,WebRequest req){
		
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	} 
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<MyErrorDetails> myAnyExpHandler(BillException ie,WebRequest req){
		
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<MyErrorDetails> myAnyExpHandler(RestaurantException ie,WebRequest req){
		
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(CategoryException ie, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
		
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> myAnyExpHandler(LoginException ie,WebRequest req){
		
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myAnyExpHandler(Exception ie,WebRequest req){
		
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
		//to handle Not found exception 
		@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
				
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
						
		}

			
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		}

		
		
		////////////Order Details Exception///////////
		
		
		@ExceptionHandler(OrderException.class)
		public ResponseEntity<OrderErrorDetails> orderExceptionHandler(OrderException oed, WebRequest wr){
			OrderErrorDetails err = new OrderErrorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(oed.getMessage());
			err.setDetails(wr.getDescription(false));
			
		    return new ResponseEntity<OrderErrorDetails>(err,HttpStatus.BAD_REQUEST);
			
			
				
		}
		
		
		
		
		@ExceptionHandler(Exception.class)
		public ResponseEntity<OrderErrorDetails> AnyOrderErrorExceptionHandler(Exception ie,WebRequest wr){
			
			
			OrderErrorDetails err = new OrderErrorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(ie.getMessage());
			err.setDetails(wr.getDescription(false));
			
			
			return new ResponseEntity<OrderErrorDetails>(err, HttpStatus.BAD_REQUEST);
			
		}
		
		
		
		
		
		
		@ExceptionHandler(NoHandlerFoundException.class)
		public ResponseEntity<OrderErrorDetails> myOrdernotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
				
		
			OrderErrorDetails err=new OrderErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
						
		}
		
		
		//////////// Order Details Exception End ////////
		
		
			

}

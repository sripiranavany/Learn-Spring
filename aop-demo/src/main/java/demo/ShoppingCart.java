package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void checkout(String payment){
//        Logging

//        Authentication & Authorization

//        Sanitization

        System.out.println("checkout method from ShoppingCart called");
    }

    public int quantity(){
        return 2;
    }
}

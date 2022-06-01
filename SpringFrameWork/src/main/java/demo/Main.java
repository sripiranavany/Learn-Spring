package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Doctor staff =  context.getBean(Doctor.class);
        staff.assist();
        staff.setQualification("MBBS");
//        System.out.println(staff);
//        Doctor staff2 =  context.getBean(Doctor.class);
//        System.out.println(staff2);
    }
}

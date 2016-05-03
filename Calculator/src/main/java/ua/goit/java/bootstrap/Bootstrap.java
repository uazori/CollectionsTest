package ua.goit.java.bootstrap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.calculator.Calculator;
import ua.goit.calculator.dataTypes.DataType;
import ua.goit.calculator.operators.Operator;

import java.util.Scanner;


/**
 * Created by Vadim on 21.04.2016.
 */
public class Bootstrap {

   static Calculator calculator;



    public static void main(String[] args) {
        ApplicationContext aplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        Bootstrap bootstrap = (Bootstrap) aplicationContext.getBean("bootstrap");
        Calculator calculator = (Calculator) aplicationContext.getBean("Calculator");

        String result = calculator.calculate("f 1 + 5");
        System.out.println("result = " + result);



        System.out.println("Please enter string with task (example:f 1 + 2) or quit for exit: ");

        Scanner scanIn = new Scanner(System.in);

        while (true){

            System.out.println("enter new task: ");

            String taskString = scanIn.nextLine();

            if (taskString.equals("quit")){break;}

            result = calculator.calculate(taskString);

            System.out.println(taskString +" = "+ result);
        }




        scanIn.close();



    }


public void run(){





}


    public void setDataType(DataType dataType) {

        this.calculator.addType("double",dataType);

    }


    public void setDataTypeOperator( Operator operator) {
        this.calculator.addOperator("double","+",operator);
    }







}

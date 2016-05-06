package ua.goit.java.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.calculator.Calculator;
import ua.goit.calculator.dataTypes.DataType;
import ua.goit.calculator.operators.Operator;
import ua.goit.java.dataType.DateType;
import ua.goit.java.operators.AddDateOperator;

import java.util.Scanner;


/**
 * Created by Vadim on 21.04.2016.
 */
public class Bootstrap {

    final static Logger logger = Logger.getLogger(Bootstrap.class);

    private Calculator calculator;


    public static void main(String[] args) {
        ApplicationContext aplicationContext = new ClassPathXmlApplicationContext("spring-config.xml", "aop-context.xml");

        Bootstrap bootstrap = (Bootstrap) aplicationContext.getBean("bootstrap");

        bootstrap.run();


    }


    public void run() {


        Scanner scanIn = new Scanner(System.in);
        String result;
        DateType dateType = new DateType();
        dateType.addOperator("+", new AddDateOperator());
        calculator.addType("date", dateType);

        System.out.println("Please enter string with task (example:f 1 + 2) or quit for exit: ");
        while (true) {


            System.out.println("enter new task: ");

            String taskString = scanIn.nextLine();

            if (taskString.equals("quit")) {
                break;
            }

            result = calculator.calculate(taskString);

            System.out.println(taskString + " = " + result);
        }


        scanIn.close();


    }


    public void setDataType(DataType dataType) {

        this.calculator.addType("date", dataType);

    }


    public void setDataTypeOperator(Operator operator) {
        this.calculator.addOperator("date", "+", operator);
    }


    public void setCalculator(Calculator calculator) {

        this.calculator = calculator;

    }


}

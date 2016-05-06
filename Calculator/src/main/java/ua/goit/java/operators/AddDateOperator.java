package ua.goit.java.operators;

import ua.goit.calculator.operators.Operator;
import ua.goit.calculator.task.CalculatorTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Vadim on 27.04.2016.
 */
public class AddDateOperator implements Operator {
    @Override
    public String Calculate(CalculatorTask task) {

        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");

        Calendar calendar = new GregorianCalendar();


        try {

            date = format.parse(task.getOperand1());

        } catch (ParseException e) {

            System.out.println("Unparseable using " + format);

        }

        calendar.setTime(date);

        int days=Integer.valueOf(task.getOperand2());

        calendar.add(Calendar.DATE,days);


        return format.format(calendar.getTime());
    }
}

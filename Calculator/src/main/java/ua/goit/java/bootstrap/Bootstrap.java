package ua.goit.java.bootstrap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.calculator.Calculator;
import ua.goit.java.ExecutorFactory.ExecutorFactory;
import ua.goit.java.taskProvider.TaskProvider;

import ua.goit.java.executor.Executor;

/**
 * Created by Vadim on 21.04.2016.
 */
public class Bootstrap {

    private TaskProvider taskProvider;
    private ExecutorFactory executorFactory;







    public static void main(String[] args) {
        ApplicationContext aplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        Bootstrap bootstrap = (Bootstrap) aplicationContext.getBean("bootstrap");
        Calculator calculator = (Calculator) aplicationContext.getBean("Calculator");
        bootstrap.execute();
        String result = calculator.calculate("3 + 5");
        System.out.println("result = " + result);


    }
    public void execute() {
        Executor<Integer> executor = executorFactory.getIntegerExecutor();
        System.out.println("Say hello ");
        taskProvider.getAllTasks().forEach(executor::addTask);
        executor.execute();
        executor.execute();
    }




    public void setExecutorFactory(ExecutorFactory executorFactory) {

        this.executorFactory = executorFactory;

    }


    public void setTaskProvider(TaskProvider taskProvider) {
        this.taskProvider = taskProvider;
    }







}

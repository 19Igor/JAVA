package ru.nsu.epov.lab2.OperationFabric;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Stack;
import ru.nsu.epov.lab2.core.CommandContext;
import ru.nsu.epov.lab2.core.Operations;

public class TestCommands {
    static private final Logger LOGGER = LogManager.getLogger(TestCommands.class.getName());
    private final String LOGGER_TEST="TEST";

    private final String DEFINE_a = "a";
    private final String DEFINE_8_STR = "8";
    private final String DEFINE_b = "b";
    private final String DEFINE_bs = "bs";
    private final String DEFINE_as = "ass";
    private final double DEFINE_8_DOUBLE = 8.0;


    @Test
    public void testCommandDefine() {
        Operations defineCommand=new Define();
        HashMap<String,Double> define=new HashMap<>();
        CommandContext context = new CommandContext();
        context.setDefine(define);

        Stack<String> values = new Stack<>();
        context.setValues(values);

        context.getValues().push(PUSH_a);
        context.getValues().push(DEFINE_8_STR);
        defineCommand.workingCommand(context);

        context.getValues().push(DEFINE_b);
        context.getValues().push(PUSH_a);
        defineCommand.workingCommand(context);

        context.getValues().push(DEFINE_bs);
        context.getValues().push(DEFINE_as);
        defineCommand.workingCommand(context);

        HashMap<String, Double> expected=new HashMap<>();
        expected.put(PUSH_a, DEFINE_8_DOUBLE);
        expected.put(DEFINE_b, DEFINE_8_DOUBLE);
        LOGGER.info(defineCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,define);
    }
    private final double DIVISION_MINUS_ZERO=-0.0;
    private final double DIVISION_2=2.0;
    private final double DIVISION_6=6.0;
    private final double DIVISION_3=3.0;

    @Test
    public void testCommandDivision() throws Exception{
        Operations divisionCommand = new Division();
        Stack stack = new Stack();
        stack.push(DIVISION_MINUS_ZERO);
        stack.push(DIVISION_2);
        stack.push(DIVISION_6);

        CommandContext context = new CommandContext();
        context.setStack(stack);

        divisionCommand.workingCommand(context);
        divisionCommand.workingCommand(context);

        Stack expected = new Stack();
        expected.push(DIVISION_MINUS_ZERO);
        expected.push(DIVISION_3);

        LOGGER.info(divisionCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double MINUS_3 = 3.0;
    private final double MINUS_2 = 2.0;
    private final double MINUS_MINUS_1 = -1.0;
    @Test
    public void testCommandMinus() {
        Operations minusCommand=new Minus();
        Stack stack=new Stack();
        stack.push(MINUS_3);
        stack.push(MINUS_2);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        minusCommand.workingCommand(context);
        minusCommand.workingCommand(context);

        Stack expected=new Stack();
        expected.push(MINUS_MINUS_1);

        LOGGER.info(minusCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double MULTIPLICATION_3=3.0;
    private final double MULTIPLICATION_MINUS_2=-2.0;
    private final double MULTIPLICATION_MINUS_6=-6.0;
    @Test
    public void testCommandMultiplication() {
        Operations multiplicationCommand=new Multiplication();
        Stack stack=new Stack();
        stack.push(MULTIPLICATION_3);
        stack.push(MULTIPLICATION_MINUS_2);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        multiplicationCommand.workingCommand(context);;
        multiplicationCommand.workingCommand(context);;

        Stack expected=new Stack();
        expected.push(MULTIPLICATION_MINUS_6);

        LOGGER.info(multiplicationCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double PLUS_1=1.0;
    private final double PLUS_MINUS_2=-2.0;
    private final double PLUS_MINUS_1=-1.0;
    @Test
    public void testCommandPlus() {
        Operations plusCommand=new Plus();
        Stack stack=new Stack();
        stack.push(PLUS_1);
        stack.push(PLUS_MINUS_2);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        plusCommand.workingCommand(context);;
        plusCommand.workingCommand(context);;

        Stack expected=new Stack();
        expected.push(PLUS_MINUS_1);

        LOGGER.info(plusCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double POP_1=1.0;
    @Test
    public void testCommandPop() {
        Operations popCommand=new Pop();
        Stack stack=new Stack();
        stack.push(POP_1);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        popCommand.workingCommand(context);;
        popCommand.workingCommand(context);;

        Stack expected=new Stack();

        LOGGER.info(popCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double PRINT_1=1.0;
    @Test
    public void testCommandPrint() {
        Operations printCommand=new Print();
        Stack stack=new Stack();
        stack.push(PRINT_1);

        CommandContext context=new CommandContext();
        context.setStack(stack);

        printCommand.workingCommand(context);;

        Stack expected=new Stack();
        expected.push(PRINT_1);

        LOGGER.info(printCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final String PUSH_a="a";
    private final double PUSH_2=2.0;
    private final String PUSH_b="b";
    private final String PUSH_1_STR="1";
    private final Double PUSH_1_DOUBLE=1.0;
    @Test
    public void testCommandPush() {
        Operations pushCommand=new Push();
        HashMap<String,Double> define=new HashMap<>();
        define.put(PUSH_a,PUSH_2);
        Stack stack=new Stack();

        CommandContext context=new CommandContext();
        context.setStack(stack);
        context.setDefine(define);

        Stack<String> values = new Stack<>();
        context.setValues(values);

        context.getValues().push(PUSH_1_STR);
        pushCommand.workingCommand(context);
        context.getValues().push(PUSH_b);
        pushCommand.workingCommand(context);
        context.getValues().push(PUSH_a);
        pushCommand.workingCommand(context);
        Stack expected=new Stack();
        expected.push(PUSH_1_DOUBLE);
        expected.push(PUSH_2);

        LOGGER.info(pushCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
    private final double SQRT_4=4.0;
    private final double SQRT_MINUS_1=-1.0;
    private final double SQRT_MINUS_ZERO=-0.0;
    private final double SQRT_2=2.0;
    @Test
    public void testCommandSqrt() {
        Operations sqrtCommand=new SQRT();
        Stack stack=new Stack();
        CommandContext context=new CommandContext();
        context.setStack(stack);
        stack.push(SQRT_4);
        sqrtCommand.workingCommand(context);;
        stack.push(SQRT_MINUS_1);
        sqrtCommand.workingCommand(context);;
        stack.push(SQRT_MINUS_ZERO);
        sqrtCommand.workingCommand(context);;

        Stack expected=new Stack();
        expected.push(SQRT_2);
        expected.push(SQRT_MINUS_1);
        expected.push(SQRT_MINUS_ZERO);

        LOGGER.info(sqrtCommand.getClass().getSimpleName() + LOGGER_TEST);
        Assert.assertEquals(expected,stack);
    }
}
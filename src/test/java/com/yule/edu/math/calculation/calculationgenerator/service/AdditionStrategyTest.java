package com.yule.edu.math.calculation.calculationgenerator.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdditionStrategyTest {

    @Test
    public void generate() {
        AdditionStrategy additionStrategy=new AdditionStrategy(new Parameters.Add(20));
        assertNotNull(additionStrategy.generate());
    }

    @Test
    public void generateThreeOperands() {
        AdditionStrategy additionStrategy=new AdditionStrategy(new Parameters.Add(20,3));
        assertNotNull(additionStrategy.generate());
    }
}
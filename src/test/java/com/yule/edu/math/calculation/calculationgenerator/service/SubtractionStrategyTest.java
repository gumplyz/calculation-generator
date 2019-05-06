package com.yule.edu.math.calculation.calculationgenerator.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubtractionStrategyTest {

    @Test
    public void generate() {
        SubtractionStrategy subtractionStrategy=new SubtractionStrategy(20);
        assertNotNull(subtractionStrategy.generate());
    }
}
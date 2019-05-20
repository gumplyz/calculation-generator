package com.yule.edu.math.calculation.calculationgenerator.service;

import java.util.concurrent.ThreadLocalRandom;

public class AdditionWithCarryStrategy implements IOperationStrategy {
  private Parameters.Add parameter;

  public AdditionWithCarryStrategy(Parameters.Add parameter) {
    this.parameter = parameter;
  }


  @Override
  public String generate() {

    int op2 = ThreadLocalRandom.current().nextInt(2, 10);
    int op1 = ThreadLocalRandom.current().nextInt(11, 10 + op2);
    op1 = op1 - op2;
    op2 = this.parameter.getMax()-10+op2;

    return String.format("%s + %s = ", op1, op2);
  }

  public static IOperationStrategy take(Parameters parameters) {
    if (parameters.getAdd().getMax() > 0) {
      return new AdditionWithCarryStrategy(parameters.getAdd());
    }
    return null;
  }
}

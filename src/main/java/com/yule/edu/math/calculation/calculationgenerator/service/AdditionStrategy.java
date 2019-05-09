package com.yule.edu.math.calculation.calculationgenerator.service;

import java.util.concurrent.ThreadLocalRandom;

public class AdditionStrategy implements IOperationStrategy {
  private Parameters.Add parameter;

  public AdditionStrategy(Parameters.Add max) {
    this.parameter = max;
  }

  @Override
  public String generate() {
    int ops;
    StringBuilder sb = new StringBuilder();
    int sumPrev = 0;
    for (int i = 0; i < this.parameter.getNumOps(); i++) {
      if (i > 0 && i < this.parameter.getNumOps()) {
        sb.append(" + ");
      }
      ops = ThreadLocalRandom.current().nextInt(0, this.parameter.getMax() - sumPrev + 1);
      sumPrev += ops;
      sb.append(ops);
    }

    sb.append(" = ");
    return sb.toString();
  }

  public static IOperationStrategy take(Parameters parameters) {
    if (parameters.getAdd().getMax() > 0) {
      return new AdditionStrategy(parameters.getAdd());
    }
    return null;
  }
}

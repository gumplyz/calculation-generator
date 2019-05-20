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

    for (int i = 0; i < this.parameter.getNumOps(); i++) {
      if (i > 0 && i < this.parameter.getNumOps()) {
        sb.append(" + ");
      }
      ops = ThreadLocalRandom.current().nextInt(1, this.parameter.getMax() + 1);

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

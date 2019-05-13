package com.yule.edu.math.calculation.calculationgenerator.service;

public class Parameters {
  private int numQuestions;
  private Add add;
  private Substract substract;

  public int getNumQuestions() {
    return numQuestions;
  }

  public void setNumQuestions(int numQuestions) {
    this.numQuestions = numQuestions;
  }

  Add getAdd() {
    return add;
  }

  public void setAdd(Add add) {
    this.add = add;
  }

  Substract getSubstract() {
    return substract;
  }

  public void setSubstract(Substract substract) {
    this.substract = substract;
  }

  public static class Add {
    private int max;
    private int numOps=2;

    public Add() {
    }

    public Add(int max) {
      this.max = max;
    }

    Add(int max, int numOps) {
      this.max = max;
      this.numOps = numOps;
    }

    int getMax() {
      return max;
    }

    public void setMax(int max) {
      this.max = max;
    }

    int getNumOps() {
      return numOps;
    }

    public void setNumOps(int numOps) {
      this.numOps = numOps;
    }
  }

  public static class Substract {
    private int max;
    private int numOps=2;

    public Substract() {
    }

    public Substract(int max) {
      this.max = max;
    }

    public Substract(int max, int numOps) {
      this.max = max;
      this.numOps = numOps;
    }

    int getMax() {
      return max;
    }

    public void setMax(int max) {
      this.max = max;
    }

    int getNumOps() {
      return numOps;
    }

    public void setNumOps(int numOps) {
      this.numOps = numOps;
    }
  }
}

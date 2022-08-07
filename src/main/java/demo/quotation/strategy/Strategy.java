package demo.quotation.strategy;

public enum Strategy {
  AGGRESSIVE (StrategyConstants.AGGRESSIVE),
  SAFE (StrategyConstants.SAFE),
  WOLF_OF_WALL_STREET (StrategyConstants.WOLF_OF_WALL_STREET);

  private String name;

  Strategy(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static class StrategyConstants {
    public static final String AGGRESSIVE = "AGGRESSIVE";
    public static final String SAFE = "SAFE";
    public static final String WOLF_OF_WALL_STREET = "WOLF_OF_WALL_STREET";
  }

}

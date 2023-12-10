package be.tbrx.day2;

public class Round {
    private final int redCubes;
    private final int greenCubes;
    private final int blueCubes;

    public Round(int redCubes, int greenCubes, int blueCubes) {
        this.redCubes = redCubes;
        this.greenCubes = greenCubes;
        this.blueCubes = blueCubes;
    }

    public int getRedCubes() {
        return redCubes;
    }

    public int getGreenCubes() {
        return greenCubes;
    }

    public int getBlueCubes() {
        return blueCubes;
    }

    @Override
    public String toString() {
        return "Round{" +
                "redCubes=" + redCubes +
                ", greenCubes=" + greenCubes +
                ", blueCubes=" + blueCubes +
                '}';
    }

    Integer getCube(String colorOfCube) {
        if (colorOfCube.equals("red")) {
            return getRedCubes();
        } else if (colorOfCube.equals("green")) {
            return getGreenCubes();
        } else if (colorOfCube.equals("blue")) {
            return getBlueCubes();
        }
        return null;
    }
}

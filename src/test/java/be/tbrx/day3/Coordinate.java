package be.tbrx.day3;

record Coordinate(int y, int x) {
    public boolean isNextTo(Coordinate b) {
        if (b.x == this.x && b.y == this.y) {
            return false;
        }
        else if (b.x == this.x && b.y == this.y + 1 || b.x == this.x && b.y == this.y - 1) {
            return true;
        }
        else if (b.x == this.x + 1 && b.y == this.y || b.x == this.x - 1 && b.y == this.y) {
            return true;
        }
        else if (b.x == this.x + 1 && b.y == this.y + 1 || b.x == this.x - 1 && b.y == this.y - 1) {
            return true;
        }
        else if (b.x == this.x + 1 && b.y == this.y - 1 || b.x == this.x - 1 && b.y == this.y + 1) {
            return true;
        }
        return false;
    }

}

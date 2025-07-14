//Michael Antigua
//CMSC 203


public class Plot {
    private int x, y, width, depth;

    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setDepth(int depth) { this.depth = depth; }

    public boolean encompasses(Plot plot) {
        return (plot.x >= this.x &&
                plot.y >= this.y &&
                (plot.x + plot.width) <= (this.x + this.width) &&
                (plot.y + plot.depth) <= (this.y + this.depth));
    }

   
    public boolean overlaps(Plot plot) {
        boolean noOverlap = plot.x + plot.width <= this.x ||
                            this.x + this.width <= plot.x ||
                            plot.y + plot.depth <= this.y ||
                            this.y + this.depth <= plot.y;
        return !noOverlap;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}

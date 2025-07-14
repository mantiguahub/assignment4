//Michael Antigua
//CMSC203



public class Property {
    private String propertyName;
    private String city;
    private String owner;
    private double rentAmount;
    private Plot plot;

    public Property() {
        this("", "", 0.0, "", 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner,
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.owner = otherProperty.owner;
        this.rentAmount = otherProperty.rentAmount;
        this.plot = new Plot(otherProperty.plot);
    }

    
    public String getPropertyName() { return propertyName; }
    public String getCity() { return city; }
    public String getOwner() { return owner; }
    public double getRentAmount() { return rentAmount; }
    public Plot getPlot() { return plot; }

    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }
    public void setCity(String city) { this.city = city; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }
    public void setPlot(int x, int y, int width, int depth) { this.plot = new Plot(x, y, width, depth); }

    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}

//Michael Antigua
//CMSC203



public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmFeePer;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

   
    public ManagementCompany() {
        this("", "", 0.0);
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer,
                             int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFeePer = otherCompany.mgmFeePer;
        this.plot = new Plot(otherCompany.plot);
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
        this.numberOfProperties = otherCompany.numberOfProperties;
    }

  
    public String getName() { return name; }
    public Plot getPlot() { return plot; }
    public int getPropertiesCount() { return numberOfProperties; }
    public double getMgmFeePer() { return mgmFeePer; }

    public int addProperty(Property property) {
        if (property == null) return -2;
        if (numberOfProperties >= MAX_PROPERTY) return -1;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
        }

        properties[numberOfProperties] = new Property(property);
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    public int addProperty(String propertyName, String city, double rent, String owner) {
        return addProperty(new Property(propertyName, city, rent, owner));
    }

    public int addProperty(String propertyName, String city, double rent, String owner,
                           int x, int y, int width, int depth) {
        return addProperty(new Property(propertyName, city, rent, owner, x, y, width, depth));
    }

    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        Property highest = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highest.getRentAmount()) {
                highest = properties[i];
            }
        }
        return highest;
    }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("List of the properties for " + name + ", taxID: " + taxID + "\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n");
        sb.append("\n total management Fee: ").append(getTotalRent() * (mgmFeePer / 100));
        return sb.toString();
    }
}

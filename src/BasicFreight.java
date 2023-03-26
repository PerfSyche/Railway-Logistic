public class BasicFreight extends RailroadCar {
    private final String typeOfCargo;
    private final double maxWeightForCargo;

    public BasicFreight(String shipper, String securityInfo, double netWeight,
                        double grossWeight, String typeOfCargo, double maxWeightForCargo) {
        super("Basic Freight", shipper, securityInfo, netWeight, grossWeight);
        this.typeOfCargo = typeOfCargo;
        this.maxWeightForCargo = maxWeightForCargo;
    }

    public double getMaxWeightForCargo() {
        return maxWeightForCargo;
    }

    public String getTypeOfCargo() {
        return typeOfCargo;
    }

    public boolean requiresElectricalConnection() {
        return false;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class RailroadCar {
    private static final Scanner scan = new Scanner(System.in);
    private static final ArrayList<RailroadCar> railroadCars = new ArrayList<>();
    private static int id = -1;
    public int ID;
    private String type;
    private String shipper;
    private String securityInfo;
    private double netWeight;
    private double grossWeight;

    public RailroadCar() {
        ++id;
        ID = id;
    }

    public RailroadCar(String type, String shipper, String securityInfo, double netWeight, double grossWeight) {
        ++id;
        ID = id;
        this.type = type;
        this.shipper = shipper;
        this.securityInfo = securityInfo;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
    }

    public String getType() {
        return type;
    }

    public String getShipper() {
        return shipper;
    }

    public String getSecurityInfo() {
        return securityInfo;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void createRailroadCar() {
        System.out.println("""
                [1] Passenger
                [2] Post Office
                [3] Restaurant
                [4] Baggage and Mail
                [5] Basic Freight
                [6] Heavy Freight
                [7] Default Railroad Car
                """);
        System.out.print("Enter the type: ");
        String type = scan.next();
        System.out.print("Enter the shipper: ");
        String shipper = scan.next();
        System.out.print("Enter the security info: ");
        String securityInfo = scan.next();
        System.out.print("Enter the net weight: ");
        double netWeight = scan.nextDouble();
        System.out.print("Enter the gross weight: ");
        double grossWeight = scan.nextDouble();

        switch (type) {
            case "1" -> {
                System.out.print("Enter the number of seats: ");
                int numberOfSeats = scan.nextInt();
                System.out.print("Enter the number of luggage racks: ");
                int numberOfLuggageRacks = scan.nextInt();
                System.out.println("""
                        [1] Reclining seats
                        [2] Ergonomic seats
                        [3] Sleeper seats
                        [4] Bench seats""");
                System.out.print("Choose the type of the seat: ");
                String typeOfSeatInput = scan.next();
                String typeOfSeat = "Default";

                switch (typeOfSeatInput) {
                    case "1" -> typeOfSeat = "Reclining";
                    case "2" -> typeOfSeat = "Ergonomic";
                    case "3" -> typeOfSeat = "Sleeper";
                    case "4" -> typeOfSeat = "Bench";
                }

                Passenger passenger = new Passenger(shipper, securityInfo,
                        netWeight, grossWeight, numberOfSeats, numberOfLuggageRacks, typeOfSeat);
                railroadCars.add(passenger);
            }

            case "2" -> {
                System.out.print("Enter the number of mail slots: ");
                int numOfMailSlots = scan.nextInt();
                System.out.print("Enter the maximum weight capacity for mail: ");
                double maxWeightForMail = scan.nextDouble();
                PostOffice postOffice = new PostOffice(shipper, securityInfo, netWeight, grossWeight,
                        numOfMailSlots, maxWeightForMail);
                railroadCars.add(postOffice);
            }

            case "3" -> {
                System.out.print("Enter the number of tables and chairs: ");
                int numChairsAndTables = scan.nextInt();
                System.out.println("""
                        [1] American cuisine
                        [2] European cuisine
                        [3] Asian cuisine
                        [4] Vegetarian/vegan cuisine
                        [5] Local cuisine (Depending the route and destination)
                        [6] Fine dining""");

                System.out.print("Enter the type of cuisine served: ");
                String typeOfCuisineInput = scan.next();
                String typeOfCuisine = "Local cuisine";

                switch (typeOfCuisineInput) {
                    case "1" -> typeOfCuisine = "American";
                    case "2" -> typeOfCuisine = "European";
                    case "3" -> typeOfCuisine = "Asian";
                    case "4" -> typeOfCuisine = "Vegetarian/vegan";
                    case "5" -> typeOfCuisine = "Local cuisine";
                    case "6" -> typeOfCuisine = "Fine dining";
                }

                Restaurant restaurant = new Restaurant(shipper, securityInfo, netWeight, grossWeight,
                        numChairsAndTables, typeOfCuisine);
                railroadCars.add(restaurant);
            }

            case "4" -> {
                System.out.print("Enter the maximum number of compartments: ");
                int maxCompartment = scan.nextInt();
                System.out.print("Enter the maximum weight capacity: ");
                double maxWeightCapacity = scan.nextDouble();
                BaggageAndMail baggageAndMail = new BaggageAndMail(shipper, securityInfo, netWeight,
                        grossWeight, maxCompartment, maxWeightCapacity);
                railroadCars.add(baggageAndMail);
            }

            case "5" -> {
                System.out.println("""
                        [1] Bulk goods
                        [2] Packaged goods
                        [3] Building materials
                        [4] Chemicals
                        [5] Liquids""");
                System.out.print("Enter the type of cargo: ");
                String typeOfCargoInput = scan.next();
                String typeOfCargo = "Packaged goods";

                switch (typeOfCargoInput) {
                    case "1" -> typeOfCargo = "Bulk goods";
                    case "2" -> typeOfCargo = "Packaged goods";
                    case "3" -> typeOfCargo = "Building materials";
                    case "4" -> typeOfCargo = "Chemicals";
                    case "5" -> typeOfCargo = "Liquids";
                }

                System.out.print("Enter the maximum weight capacity for cargo: ");
                double maxWeightForCargo = scan.nextDouble();

                BasicFreight basicFreight = new BasicFreight(shipper, securityInfo, netWeight, grossWeight,
                        typeOfCargo, maxWeightForCargo);
                railroadCars.add(basicFreight);
            }

            case "6" -> {
                System.out.println("""
                        [1] Heavy machinery
                        [2] Vehicles
                        [3] Raw materials
                        [4] Aerospace components
                        [5] Military equipment""");
                System.out.print("Enter the type of cargo: ");
                String typeOfCargoInput = scan.next();
                String typeOfCargo = "Heavy machinery";

                switch (typeOfCargoInput) {
                    case "1" -> typeOfCargo = "Heavy machinery";
                    case "2" -> typeOfCargo = "Vehicles";
                    case "3" -> typeOfCargo = "Raw materials";
                    case "4" -> typeOfCargo = "Aerospace components";
                    case "5" -> typeOfCargo = "Military equipment";
                }

                System.out.print("Enter the maximum weight capacity for cargo: ");
                double maxWeightForCargo = scan.nextDouble();

                HeavyFreight heavyFreight = new HeavyFreight(shipper, securityInfo, netWeight,
                        grossWeight, typeOfCargo, maxWeightForCargo);
                railroadCars.add(heavyFreight);
            }

            case "7" -> {
                RailroadCar railroadCar = new RailroadCar(type, shipper, securityInfo, netWeight, grossWeight);
                railroadCars.add(railroadCar);
            }

            default -> System.out.println("Please, choose correct number\n");
        }
    }

    public static void print() {
        for (RailroadCar car : railroadCars) {
            System.out.println(car);
        }
    }

    @Override
    public String toString() {
        if (this instanceof Passenger passenger) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nNumber of Seats: " + passenger.getNumSeats()
                    + "\nNumber of Luggage Racks: " + passenger.getNumLuggageRacks()
                    + "\nType of the Seats: " + passenger.getTypeOfSeat()
                    + "\nRequires Electrical Connection: " + passenger.requiresElectricalConnection();
        } else if (this instanceof PostOffice postOffice) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nNumber of Mail Slots: " + postOffice.getNumOfMailSlots()
                    + "\nMaximum Weight Capacity for Mail: " + postOffice.getMaxWeightForMail()
                    + "\nRequires Electrical Connection: " + postOffice.requiresElectricalConnection();
        } else if (this instanceof Restaurant restaurant) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nNumber of Chairs and Tables: " + restaurant.getNumChairsAndTables()
                    + "\nType of Cuisine: " + restaurant.getTypeOfCuisine()
                    + "\nRequires Electrical Connection: " + restaurant.requiresElectricalConnection();
        } else if (this instanceof BaggageAndMail baggageAndMail) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nMaximum Number of Compartments: " + baggageAndMail.getMaxCompartment()
                    + "\nRequires Electrical Connection: " + baggageAndMail.requiresElectricalConnection();
        } else if (this instanceof BasicFreight basicFreight) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nType of Cargo: " + basicFreight.getTypeOfCargo()
                    + "\nMaximum Weight Capacity for Cargo: " + basicFreight.getMaxWeightForCargo()
                    + "\nRequires Electrical Connection: " + basicFreight.requiresElectricalConnection();
        } else if (this instanceof HeavyFreight heavyFreight) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nType of Cargo: " + heavyFreight.getTypeOfCargo()
                    + "\nMaximum Weight Capacity for Cargo: " + heavyFreight.getMaxWeightForCargo()
                    + "\nRequires Electrical Connection: " + heavyFreight.requiresElectricalConnection();
        } else {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight();
        }
    }
}

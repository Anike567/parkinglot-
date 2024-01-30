import java.io.File;
import java.util.Scanner;

public class Rashmi {
    private class CarsDetails {
        String regNumber;
        String color;

        public CarsDetails(String regNumber, String color) {
            this.regNumber = regNumber;
            this.color = color;
        }
    }

    private class Parkings {
        int slot_no;
        CarsDetails carDetails;
    }

    private Parkings[] parkings;

    public void createParking(int no_of_slots) {
        parkings = new Parkings[no_of_slots];
        for (int i = 0; i < no_of_slots; i++) {
            parkings[i] = new Parkings();
            parkings[i].slot_no = 0;
        }
        System.out.println("Created a parking lot with "+no_of_slots+" slots");
    }

    public void park(String regNumber, String color) {
        int n = parkings.length;
        System.out.println(regNumber+"   "+color);
        for (int i = 0; i < n; i++) {
            if (parkings[i].slot_no == 0) {
                parkings[i].slot_no = 1;
                parkings[i].carDetails = new CarsDetails(regNumber, color);
                System.out.println("Allocated slot number:  "+(++i));
                return;
            }
        }
    }

    public void leave(int slot_no) {
        parkings[slot_no-1].slot_no = 0;
        parkings[slot_no-1].carDetails = null;
        System.out.println("Slot no "+slot_no+" is free");
    }

    public void status() {
        int n = parkings.length;
        for (int i = 0; i < n; i++) {
            if (parkings[i].slot_no == 1 && parkings[i].carDetails != null) {
                System.out.println(parkings[i].carDetails.regNumber + "   " + parkings[i].carDetails.color);
            }
        }
    }

    public void search(String arguments) {
        // Implement search logic here
    }

    public static void main(String[] args) {
        String file_name = args[0];
        Rashmi rashmiInstance = new Rashmi();
        try {
            File obj = new File(file_name);
            Scanner reader = new Scanner(obj);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] parts = data.split(" ");
                switch (parts[0]) {
                    case "create_parking_lot":
                        rashmiInstance.createParking(Integer.parseInt(parts[2]));
                        break;
                    case "park":
                        rashmiInstance.park(parts[1], parts[2]);
                        break;
                    case "leave":
                        rashmiInstance.leave(Integer.parseInt(parts[1]));
                        break;
                    case "status":
                        rashmiInstance.status();
                        break;
                    default:
                        rashmiInstance.search(data);
                        break;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

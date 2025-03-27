 class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

class CircularTour {
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0, deficit = 0, currentFuel = 0;

        for (int i = 0; i < n; i++) {
            currentFuel += pumps[i].petrol - pumps[i].distance;
            if (currentFuel < 0) {
                start = i + 1;
                deficit += currentFuel;
                currentFuel = 0;
            }
        }

        return (currentFuel + deficit >= 0) ? start : -1;
    }
}

public class CircularTourProblem {
    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };

        int startPoint = CircularTour.findStartingPoint(pumps);
        if (startPoint == -1) {
            System.out.println("No solution exists. Cannot complete the tour.");
        } else {
            System.out.println("Start at petrol pump: " + startPoint);
        }
    }
}

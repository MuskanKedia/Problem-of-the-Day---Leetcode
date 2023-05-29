class ParkingSystem {
    int[] count;
    public ParkingSystem(int big, int medium, int small) {
        count = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return count[carType - 1]-- > 0;
    }
}

//Time Complexity : O(1)
//Space Complexity : O(1)

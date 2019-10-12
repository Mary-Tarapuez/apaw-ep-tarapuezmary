package es.upm.miw.apaw_ep_themes.documents;

public class Room {

    private int number;

    private int floor;

    public Room(int number, int floor) {
        this.number = number;
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", floor=" + floor +
                '}';
    }
}

package TextAdventureGame;

class Character {

    int x;
    int y;
    private String location;

    Character(int x, int y) {

        this.x = x;
        this.y = y;

    }

    //This method can be made much better
    String getRoom() {
        if (this.x == 1 && this.y == 1) {
            this.location = "room1";
        } else if (this.x == 2 && this.y == 1) {
            this.location = "room2";
        } else if (this.x == 3 && this.y == 1) {
            this.location = "room3";
        } else if (this.x == 4 && this.y == 1) {
            this.location = "room4";
        } else if (this.x == 1 && this.y == 2) {
            this.location = "room5";
        } else if (this.x == 2 && this.y == 2) {
            this.location = "room6";
        } else if (this.x == 3 && this.y == 2) {
            this.location = "room7";
        } else if (this.x == 4 && this.y == 2) {
            this.location = "room8";
        }

        return this.location;

    }

    int[] getRoomPos() {

        return new int[]{this.x, this.y};
    }

}

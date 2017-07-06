package TextAdventureGame;

class MainCharacter extends Character {

    MainCharacter() {
        super(1, 1);
    }


    boolean lookAround(Character person) {
        return (person.x == this.x) && (person.y == this.y);
    }


    void moveLeft() {
        this.x -= 1;
    }

    void moveRight() {
        this.x += 1;
    }

    void moveUp() {
        this.y += 1;
    }

    void moveDown() {
        this.y -= 1;
    }

}

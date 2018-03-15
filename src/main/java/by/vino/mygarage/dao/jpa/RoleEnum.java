package by.vino.mygarage.dao.jpa;

public enum RoleEnum {
    ADMIN(1),
    USER(2);

    private int i;

    RoleEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

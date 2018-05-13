package by.vino.mygarage.dao.jpa;

public enum RoleEnum {
    ROLE_ADMIN(1),
    ROLE_USER(2);

    private int i;

    RoleEnum(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

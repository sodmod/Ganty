package GantyRex.Ganty.Enums;

import lombok.Getter;

@Getter
public enum Permission {
    READ("read"),
    WRITE("write"),
    DELETE("delete"),
    UPDATE("update");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}

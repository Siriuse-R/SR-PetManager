package net.siriuser.SRPetManager;

import org.bukkit.permissions.Permissible;

public enum Perms {
    // 情報参照
    INFO_WOLF("info.wolf"),
    INFO_OCELOT("info.ocelot"),
    INFO_HORSE("info.horse"),

    // Ignore
    BYPASS_RIDE("ignore.ride"),

    // Admin Permission
    RELOAD("admin.reload"),
    ;

    final String HEADER = "srpm.";
    private String node;

    Perms(final String node) {
        this.node = HEADER + node;
    }

    /**
     * 指定したプレイヤーが権限を持っているか
     *
     * @param player
     *            Permissible. Player, CommandSender etc
     * @return boolean
     */
    public boolean has(final Permissible perm) {
        if (perm == null)
            return false;
        return perm.hasPermission(node);
    }
}
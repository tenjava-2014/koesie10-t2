package com.tenjava.entries.koesie10.t2;

public class Metadata {
    private boolean isMurderer;
    private boolean hasGun;
    private boolean isDead;

    public Metadata(boolean isMurderer, boolean hasGun) {
        this.isMurderer = isMurderer;
        this.hasGun = hasGun;
        this.isDead = false;
    }

    public boolean isMurderer() {
        return isMurderer;
    }

    public boolean isHasGun() {
        return hasGun;
    }

    public void setHasGun(boolean hasGun) {
        this.hasGun = hasGun;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }
}

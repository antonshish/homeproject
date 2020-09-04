package ru.homeproject.studentorder.domain.register;

public class CityRegisterResponse
{
    private boolean registered;
    private boolean temporal;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "CityRegisterResponse{" +
                "existing=" + registered +
                ", temporal=" + temporal +
                '}';
    }
}

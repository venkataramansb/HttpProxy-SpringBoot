package Core;


import java.util.Objects;

public class ProcessorData {

    String vin;
    String status;
    String simNumber;

    public ProcessorData(String vin, String status) {
        this.vin = vin;
        this.status = status;
   }


    public ProcessorData(String vin, String status, String simNumber) {
        this.vin = vin;
        this.status = status;
        this.simNumber = simNumber;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public String getVin() {
        return vin;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessorData that = (ProcessorData) o;
        return Objects.equals(vin, that.vin) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, status);
    }

    public boolean equals1(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProcessorData that = (ProcessorData) obj;
        return Objects.equals(vin, that.vin) && Objects.equals(status, that.status);
    }
}

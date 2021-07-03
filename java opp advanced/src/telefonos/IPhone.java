package telefonos;

public class IPhone extends Phone implements Ringable {
	
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    
    @Override
    public String ring() {
        return "Iphone Sonando...";
    }
    @Override
    public String unlock() {
    	return "Iphone desbloqueado...";
    }
    @Override
    public void displayInfo() {
        System.out.println("Iphone: \n version: "+this.getVersionNumber()+" \n porcentajeBateria: "+this.getBatteryPercentage()+"\n carrier: "+this.getCarrier()+" \n ringTone: "+this.getRingTone());
    }
}

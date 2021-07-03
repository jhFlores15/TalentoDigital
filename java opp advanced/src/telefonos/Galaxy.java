package telefonos;

public class Galaxy extends Phone implements Ringable{

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	@Override
	public String ring() {
		return "Galaxy Sonando...";
	}

	@Override
	public String unlock() {
		return "Galaxy desbloqueado...";
	}

	@Override
	public void displayInfo() {
		System.out.println("Galaxy: \n version: "+this.getVersionNumber()+" \n porcentajeBateria: "+this.getBatteryPercentage()+"\n carrier: "+this.getCarrier()+" \n ringTone: "+this.getRingTone());
	}
}

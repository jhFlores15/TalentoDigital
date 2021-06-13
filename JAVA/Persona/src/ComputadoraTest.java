
public class ComputadoraTest {

	public static void main(String[] args) {
		
		Computadora c = new Computadora();
		
		c.setMarca("Hp");
		c.setCantidadRam(16);
		c.setProcesador("Core i9");
		c.setCantidadAlmacenamiento(1000);
		c.setModelo("HPUX36");
		
		System.out.println("Datos Computadora:");
		
		System.out.println("Marca:          " + c.getMarca() );
		System.out.println("Modelo:         " + c.getModelo() );
		System.out.println("Ram:            " + c.getCantidadRam() + "GB" );
		System.out.println("Procesador:     " + c.getProcesador() );
		System.out.println("Almacenamiento: " + c.getCantidadAlmacenamiento() + "GB" );	
		
	}

}

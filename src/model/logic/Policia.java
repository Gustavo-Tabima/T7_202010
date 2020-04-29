package model.logic;
import java.util.Date;

public class Policia implements Comparable<Policia> {




	private int OBJECTID;

	private String EPODESCRIP;
	private String EPODIR_SITIO;
	private double EPOLATITUD;
	private double EPOLONGITU;
	private String EPOSERVICIO;
	private String EPOHORARIO;
	private int EPOTELEFON;

	private int EPOIULOCAL;







	public Policia(int Id,String Descripcion,String Sitio,  double Longitud, double Latitud,String Servicio,String Horario,int Telefono,int EpoLocal) {

		this.OBJECTID = Id;
		this.EPODESCRIP=Descripcion;
		this.EPODIR_SITIO=Sitio;
		this.EPOLATITUD=Latitud;
		this.EPOLONGITU=Longitud;
		this.EPOSERVICIO=Servicio;
		this.EPOHORARIO=Horario;
		this.EPOTELEFON=Telefono;
		this.EPOIULOCAL=EpoLocal;






	}

	public int dartId() {

		return OBJECTID;
	}

	public void setId(int id) {

		this.OBJECTID = id;
	}

	public String dartDescripcion() {

		return EPODESCRIP;
	}

	public void setDescripcion(String descripcion) {

		this.EPODESCRIP = descripcion;
	}
	public String darSitio() {

		return EPODIR_SITIO;
	}

	public void setSitio(String Sitio) {

		this.EPODIR_SITIO = Sitio;
	}
	public double darLatitud() {

		return EPOLATITUD;
	}

	public void setLatitud(double latitud) {

		this.EPOLATITUD = latitud;
	}
	public double darLongitud() {

		return EPOLONGITU;
	}

	public void setLongitud(int id) {

		this.EPOLONGITU = id;
	}
	public String darHorario() {

		return EPOHORARIO;
	}

	public void setHorario(String horario) {

		this.EPOHORARIO = horario;
	}
	
	public String darServicio() {

		return EPOSERVICIO;
	}

	public void setServicio(String Servicio) {

		this.EPOSERVICIO = Servicio;
	}
	
	
	public int darTelefono() {

		return EPOTELEFON;
	}

	public void setTelefono(int telefono) {

		this.EPOTELEFON = telefono;
	}
	
	
	
	public int darEpoLocal() {

		return OBJECTID;
	}

	public void setEpoLocal(int id) {

		this.OBJECTID = id;
	}
	public int compareTo(Policia o)
	{
		int comparacion = 0;

		if(OBJECTID > o.dartId())
		{
			comparacion = 1;
		}
		else if( OBJECTID < o.dartId())
		{
			comparacion = -1;
		}

		return comparacion;
	}
}

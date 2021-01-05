package gal.udc.fic.vvs.email.archivo;

import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public abstract class Archivo {
	private static EtmMonitor etmMonitor = EtmManager.getEtmMonitor();
    public Archivo(String nombre, String contenido) {
        _nombre = nombre;
        _contenido = contenido;
    }

    public String obtenerNombre() {
    	EtmPoint point = etmMonitor.createPoint("Texto:obtenerNombre");
    	point.collect();
        return _nombre;
    }

    public String obtenerContenido() {
        return _contenido;
    }

    public int obtenerTamaño() {
        return _contenido.length();
    }

    public String obtenerPreVisualizacion() {
        return _nombre + "(" + obtenerTamaño() + " bytes, " + obtenerMimeType() + ")";
    }

    protected abstract String obtenerMimeType();

    private String _nombre;
    private String _contenido;

}

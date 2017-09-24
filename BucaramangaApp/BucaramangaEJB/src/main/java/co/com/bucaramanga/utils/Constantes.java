package co.com.bucaramanga.utils;

public final class Constantes {
	
	private Constantes(){}
	
	public static final String SI = "S";
	public static final String NO = "N";
	
	public static final String LOGIN_OK = "Bienvenido %s.";
	public static final String ACTUALIZACION_EXITO = "Los cambios se han almacenado con éxito.";
	public static final String ACTUALIZACION_FALLO = "Ocurrió un error al tratar de actualizar la información.";
	public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String EMAIL_NO_VALIDO = "El email ingresado no es válido.";
	public static final String ERR_PROVEEDOR_NO_EXISTE = "No existe el proveedor.";
	public static final String ERR_LOGIN_INCORRECTO = "El usuario o la contraseña no son correctos.";
	public static final String USUARIO_NO_EXISTE = "No existen usuarios con Id %s.";
	public static final String USUARIO_EXISTE = "Ya existe un usuario con Id %s.";
	public static final String ERR_USUARIO_INACTIVO = "El usuario está inactivo.";
	public static final String ACCION_CREAR = "CREAR";
	public static final String ACCION_ACTIVAR = "ACTIVAR";
	public static final String ACCION_DESACTIVAR = "DESACTIVAR";
	public static final String ERR_PRODUCTO_EXISTE = "Ya existe un producto con el código ingresado.";
	public static final String ERR_PRODUCTO_NO_EXISTE = "No existe un producto con el código ingresado.";
	
	public static String getMensaje(String mensaje, Long codigo) {
		return getMensaje(mensaje, String.valueOf(codigo));
	}
	
	public static String getMensaje(String mensaje, Long param1, Long param2) {
		return getMensaje(mensaje, String.valueOf(param1), String.valueOf(param2));
	}
	
	public static String getMensaje(String mensaje, String codigo) {
		return String.format(mensaje, codigo);
	}

	public static String getMensaje(String mensaje, String param1, String param2) {
		return String.format(mensaje, param1, param2);
	}

	public static String getMensaje(String mensaje, String param1, Long param2) {
		return getMensaje(mensaje, param1, String.valueOf(param2));
	}





	
}

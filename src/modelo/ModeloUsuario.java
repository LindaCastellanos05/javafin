
package modelo;

/**
 *
 * @author dave_
 */
public class ModeloUsuario {
    
    private int id_usuario;
    private String nombre_usuario;
    private String pwd_usuario;
    private String user_usuario;
    private String correo_usuario;
    private String telefono_usuario;
    private int idtipo_usuario;
    private String fechanac_usuario;
    private String direccion_usuario;
    private String dpi_usuario;
    private String apellido_usuario;
    private String latitud_usuario;
    private String longitud_usuario;
    private int genero_usuario;
    
    //Constructor de la clase
    public ModeloUsuario() {
        
    }

    public ModeloUsuario(int id_usuario, String nombre_usuario, String pwd_usuario, String user_usuario, String correo_usuario, String telefono_usuario, int idtipo_usuario, String fechanac_usuario, String direccion_usuario, String dpi_usuario, String apellido_usuario, String latitud_usuario, String longitud_usuario, int genero_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.pwd_usuario = pwd_usuario;
        this.user_usuario = user_usuario;
        this.correo_usuario = correo_usuario;
        this.telefono_usuario = telefono_usuario;
        this.idtipo_usuario = idtipo_usuario;
        this.fechanac_usuario = fechanac_usuario;
        this.direccion_usuario = direccion_usuario;
        this.dpi_usuario = dpi_usuario;
        this.apellido_usuario = apellido_usuario;
        this.latitud_usuario = latitud_usuario;
        this.longitud_usuario = longitud_usuario;
        this.genero_usuario = genero_usuario;
    }

    public int getGenero_usuario() {
        return genero_usuario;
    }

    public void setGenero_usuario(int genero_usuario) {
        this.genero_usuario = genero_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPwd_usuario() {
        return pwd_usuario;
    }

    public void setPwd_usuario(String pwd_usuario) {
        this.pwd_usuario = pwd_usuario;
    }

    public String getUser_usuario() {
        return user_usuario;
    }

    public void setUser_usuario(String user_usuario) {
        this.user_usuario = user_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public int getIdtipo_usuario() {
        return idtipo_usuario;
    }

    public void setIdtipo_usuario(int idtipo_usuario) {
        this.idtipo_usuario = idtipo_usuario;
    }

    public String getFechanac_usuario() {
        return fechanac_usuario;
    }

    public void setFechanac_usuario(String fechanac_usuario) {
        this.fechanac_usuario = fechanac_usuario;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public String getDpi_usuario() {
        return dpi_usuario;
    }

    public void setDpi_usuario(String dpi_usuario) {
        this.dpi_usuario = dpi_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getLatitud_usuario() {
        return latitud_usuario;
    }

    public void setLatitud_usuario(String latitud_usuario) {
        this.latitud_usuario = latitud_usuario;
    }

    public String getLongitud_usuario() {
        return longitud_usuario;
    }

    public void setLongitud_usuario(String longitud_usuario) {
        this.longitud_usuario = longitud_usuario;
    }
    
}

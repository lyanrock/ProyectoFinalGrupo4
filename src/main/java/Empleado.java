import java.util.List;

public class Empleado {

    private String documento;
    private String nombreEmpleado;
    private String correoEmpleado;
    private Empresa empresaEmpleado;
    private String rol;

    public Empleado() {

    }
    public Empleado(String documento, String nombreEmpleado, String correoEmpleado, Empresa empresaEmpleado, String rol) {
        this.documento = documento;
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.rol = rol;
    }
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void mostrarInfoEmpleado(){
        System.out.println("Documento: " + documento);
        System.out.println("Nombre Empleado: " + nombreEmpleado);
        System.out.println("Correo Electrónico: " + correoEmpleado);
        System.out.println("Empresa: " + empresaEmpleado.getNombreEmpresa());
        System.out.println("Rol: " + rol);
    }
    public boolean BuscarEmpleado(List<Empleado> lista, String valor){

        for (int i = 0;i < lista.size();i++){
            Empleado emp = lista.get(i);

            if (emp.getDocumento().equals(valor)){
                return true;
            }
        }
        return false;
    }
    public Empleado TraerEmpleado(List<Empleado> lista, String dcto){

        Empleado empleado = new Empleado();
        for (int i = 0;i < lista.size();i++){
            Empleado emp = lista.get(i);

            if (emp.getDocumento().equals(dcto)){
                empleado.nombreEmpleado = emp.nombreEmpleado;
                empleado.documento = emp.documento;
                empleado.correoEmpleado = emp.correoEmpleado;
                empleado.empresaEmpleado = emp.empresaEmpleado;
                empleado.rol = emp.rol;

                return empleado;
            }
        }
        return null;
    }
}

import java.util.List;

public class Empresa {
    //Atributos
    private String nit;
    private String nombreEmpresa;

    private String direccion;
    private long telefono;

    public Empresa() {

    }
    public Empresa(String nit, String nombreEmpresa, String direccion, long telefono) {
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void mostrarInfoEmpresa(){
        System.out.println("Nit: " + nit);
        System.out.println("Nombre Empresa: " + nombreEmpresa);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfono: " + telefono);
    }

    public boolean BuscarEmpresa(List<Empresa> lista, String valor){

        for (int i = 0;i < lista.size();i++){
            Empresa emp = lista.get(i);

            if (emp.getNit().equals(valor)){
                return true;
            }
        }
        return false;
    }
    public Empresa TraerEmpresa(List<Empresa> lista, String nit){

        Empresa empresa = new Empresa();
        for (int i = 0;i < lista.size();i++){
            Empresa emp = lista.get(i);

            if (emp.getNit().equals(nit)){
                empresa.nombreEmpresa = emp.nombreEmpresa;
                empresa.nit = emp.nit;
                empresa.direccion = emp.direccion;
                empresa.telefono = emp.telefono;

                return empresa;
            }
        }
        return null;
    }
}

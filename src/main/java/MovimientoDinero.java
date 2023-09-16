import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MovimientoDinero {
    private int id;
    private double monto;
    private String concepto;
    private Empleado usuarioEncargado;
    private Date fechaMovimiento;

    public MovimientoDinero(int id, double monto, String concepto, Empleado usuarioEncargado, Date FechaMovimiento) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
        this.usuarioEncargado = usuarioEncargado;
        this.fechaMovimiento = FechaMovimiento;
    }

    public MovimientoDinero() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getUsuarioEncargado() {
        return usuarioEncargado;
    }

    public void setUsuarioEncargado(Empleado usuarioEncargado) {
        this.usuarioEncargado = usuarioEncargado;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public void mostrarMovimiento(List<MovimientoDinero> lista, int forma, String dcto, Date fecha) throws ParseException {
        double total = 0;
        MovimientoDinero mvto;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        System.out.printf("|%5s|%20s|%20s|%15s|%15s|%30s|%n","ID","Monto","Concepto","UsuEnc","Empresa","Fecha");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        switch (forma) {
            case 1:
                for (int i = 0; i < lista.size(); i++) {
                    mvto = lista.get(i);
                    if (mvto.getUsuarioEncargado().getEmpresaEmpleado().getNit().equals(dcto)) {
                        total = total + mvto.getMonto();
                        System.out.printf("|%5s|%20s|%20s|%15s|%15s|%30s|%n", mvto.getId(), mvto.getMonto(),
                                mvto.getMonto(), mvto.getUsuarioEncargado().getNombreEmpleado(),
                                mvto.getUsuarioEncargado().getEmpresaEmpleado().getNombreEmpresa(),
                                mvto.getFechaMovimiento());
                    }
                }
                break;
            case 2:
                for (int i = 0; i < lista.size(); i++) {
                    mvto = lista.get(i);
                    if (mvto.getUsuarioEncargado().getDocumento().equals(dcto)) {
                        total = total + mvto.getMonto();
                        System.out.printf("|%5s|%20s|%20s|%15s|%15s|%30s|%n", mvto.getId(), mvto.getMonto(),
                                mvto.getConcepto(), mvto.getUsuarioEncargado().getNombreEmpleado(),
                                mvto.getUsuarioEncargado().getEmpresaEmpleado().getNombreEmpresa(),
                                mvto.getFechaMovimiento());
                    }
                }
                break;
            case 3:
                for (int i = 0; i < lista.size(); i++) {
                    mvto = lista.get(i);
                    String fechaBuscada = formatoFecha.format(mvto.getFechaMovimiento().getTime());
                    String fechaFormateada = formatoFecha.format(fecha);
                    if (fechaBuscada.equals(fechaFormateada)) {
                        total = total + mvto.getMonto();
                        System.out.printf("|%5s|%20s|%20s|%15s|%15s|%30s|%n", mvto.getId(), mvto.getMonto(),
                                mvto.getMonto(), mvto.getUsuarioEncargado().getNombreEmpleado(),
                                mvto.getUsuarioEncargado().getEmpresaEmpleado().getNombreEmpresa(),
                                mvto.getFechaMovimiento());
                    }
                }
                break;
            case 4:
                for (MovimientoDinero movto : lista) {
                    total = total + movto.getMonto();
                    System.out.printf("|%5s|%20s|%20s|%15s|%15s|%30s|%n", movto.getId(), movto.getMonto(),
                            movto.getMonto(), movto.getUsuarioEncargado().getNombreEmpleado(),
                            movto.getUsuarioEncargado().getEmpresaEmpleado().getNombreEmpresa(),
                            movto.getFechaMovimiento());
                }
                break;
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("VALOR TOTAL MOVIMIENTOS: " + total);
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

}
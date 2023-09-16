import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Empresa> ListaEmpresas = new ArrayList<>();
        List<Empleado> ListaEmpleados = new ArrayList<>();
        List<MovimientoDinero> ListaMovimientos = new ArrayList<>();
        Scanner opciones = new Scanner(System.in);
        Empresa funcionesEmp = new Empresa();
        Empleado funcionesEmpleados = new Empleado();
        MovimientoDinero funcionesMvtoDinero = new MovimientoDinero();
        int opcionP;


        do{
            System.out.println("---------- MENÚ PRINCIPAL ----------");
            System.out.println("1. Empresas");
            System.out.println("2. Empleados");
            System.out.println("3. Movimientos");
            System.out.println("4. Salir");
            opcionP =  opciones.nextInt();
            opciones.nextLine();

            int opcionEmpr;
            switch (opcionP){
                case 1:
                    do{
                        System.out.println("---------- MENÚ EMPRESA ----------");
                        System.out.println("1. Registrar Empresa");
                        System.out.println("2. Modificar Empresa");
                        System.out.println("3. Mostrar Información Empresa");
                        System.out.println("4. Menú Anterior");
                        opcionEmpr = opciones.nextInt();
                        opciones.nextLine();
                        switch (opcionEmpr){
                            case 1:
                                System.out.println("Ingrese el Nit de la empresa: ");
                                String nit_emp = opciones.nextLine();
                                boolean validador = funcionesEmp.BuscarEmpresa(ListaEmpresas, nit_emp);

                                if(!validador) {
                                    System.out.println("Ingrese el nombre de la empresa: ");
                                    String nombreEmpr = opciones.nextLine();
                                    System.out.println("Ingrese la dirección de la empresa: ");
                                    String direccion = opciones.nextLine();
                                    long telefono = 0;
                                    boolean bandera = false;
                                    while (!bandera) {
                                        System.out.println("Ingrese el teléfono de la empresa: ");
                                        if (opciones.hasNextLong()) {
                                            telefono = opciones.nextLong();
                                            bandera = true;
                                        } else {
                                            System.out.println("Entrada no válida. Por favor, ingrese un número de teléfono válido.");
                                            opciones.next();
                                        }
                                    }

                                    Empresa empresa = new Empresa(nit_emp, nombreEmpr, direccion, telefono);
                                    ListaEmpresas.add(empresa);
                                    System.out.println("Empresa Registrada Correctamente.");
                                }
                                else
                                {
                                    System.out.println("Ya Existe una Empresa con el Nit ingresado. ");
                                }
                                break;
                            case 2:
                                if(ListaEmpleados.isEmpty()){
                                    System.out.println("No Existen Empresas, No se puede realizar la modificación ");
                                    break;
                                }
                                System.out.println("Ingrese el Nit de la empresa a modificar: ");
                                String nitNuevo = opciones.nextLine();
                                boolean encontradoNit = false;

                                for (int i = 0;i < ListaEmpresas.size();i++){
                                    Empresa empr = ListaEmpresas.get(i);

                                    if (empr.getNit().equals(nitNuevo)){
                                        System.out.println("Digite lo que desea cambiar: ");
                                        System.out.println("1. Nit");
                                        System.out.println("2. Nombre");
                                        System.out.println("3. Dirección");
                                        System.out.println("4. Teléfono");
                                        int opModEmpre = opciones.nextInt();
                                        opciones.nextLine();
                                        encontradoNit = true;
                                        boolean validar = false;
                                        switch (opModEmpre) {
                                            case 1:
                                                System.out.println("Ingrese el nuevo Nit: ");
                                                String nuevoNit = opciones.nextLine();
                                                validar = funcionesEmp.BuscarEmpresa(ListaEmpresas,nuevoNit);
                                                if(!validar){
                                                empr.setNit(nuevoNit);
                                                }else
                                                {
                                                    System.out.println("Ya Existe una Empresa con el Nit ingresado. ");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Ingrese el nuevo nombre: ");
                                                String nuevoNomb = opciones.nextLine();
                                                empr.setNombreEmpresa(nuevoNomb);
                                                break;
                                            case 3:
                                                System.out.println("Ingrese la nueva dirección: ");
                                                String nuevoDir = opciones.nextLine();
                                                empr.setDireccion(nuevoDir);
                                                break;
                                            case 4:
                                                System.out.println("Ingrese el nuevo teléfono: ");
                                                long nuevoTel = opciones.nextLong();
                                                opciones.nextLine();
                                                empr.setTelefono(nuevoTel);
                                                break;
                                        }
                                        if (!validar){
                                        System.out.println("Registro Actualizado Correctamente.");
                                        }
                                    }
                                }
                                if (!encontradoNit){
                                    System.out.println("El Nit digitado no existe.");
                                }
                                break;
                            case 3:
                                if(ListaEmpleados.isEmpty()){
                                    System.out.println("No Existen Empresas, No se puede realizar la consulta ");
                                    break;
                                }
                                System.out.println("Ingrese el Nit de la empresa a mostrar: ");
                                String NitInfo = opciones.nextLine();
                                boolean encontradoNit2 = false;

                                for (int i = 0;i < ListaEmpresas.size();i++) {
                                    Empresa empresa1 = ListaEmpresas.get(i);
                                    if (empresa1.getNit().equals(NitInfo)){

                                        empresa1.mostrarInfoEmpresa();
                                        encontradoNit2 = true;
                                    }
                                }
                                if (!encontradoNit2){
                                    System.out.println("El Nit digitado no existe.");
                                }
                                break;
                        }
                    //break;
                    }while (opcionEmpr != 4);
                    break;
                case 2:
                    int opcionEmpl;
                    do{
                        System.out.println("---------- MENÚ EMPLEADOS ----------");
                        System.out.println("1. Registrar Empleado");
                        System.out.println("2. Modificar Empleado");
                        System.out.println("3. Mostrar Información Empleado");
                        System.out.println("4. Menú Anterior");
                        opcionEmpl = opciones.nextInt();
                        opciones.nextLine();
                        switch (opcionEmpl){
                            case 1:
                                if(ListaEmpresas.isEmpty()){
                                    System.out.println("Deber Registrar una Empresa para poder Crear un empleado ");
                                    break;
                                }
                                System.out.println("Ingrese el documento del empleado: ");
                                String documento = opciones.nextLine();
                                boolean validador = funcionesEmpleados.BuscarEmpleado(ListaEmpleados, documento);

                                if(!validador)
                                {
                                    System.out.println("Ingrese el nombre del empleado: ");
                                    String nombreEmpl = opciones.nextLine();
                                    System.out.println("Ingrese el correo del empleado: ");
                                    String correo = opciones.nextLine();
                                    String empresaEmpl = "";
                                    boolean bandera = false;
                                    while (!bandera){
                                        System.out.println("Ingrese el nit de la empresa del empleado: ");
                                        empresaEmpl = opciones.nextLine();
                                        var res = funcionesEmp.BuscarEmpresa(ListaEmpresas, empresaEmpl);
                                        if (res) {
                                            bandera = true;
                                        } else {
                                            System.out.println("El nit de la Empresa ingresado no Existe digite un Nit válido.");
                                        }
                                    }
                                    Empresa empresa = funcionesEmp.TraerEmpresa(ListaEmpresas, empresaEmpl);
                                    System.out.println("Ingrese el rol del empleado: ");
                                    String rol = opciones.nextLine();
                                    Empleado empleado = new Empleado(documento,nombreEmpl,correo,empresa,rol);
                                    ListaEmpleados.add(empleado);
                                    System.out.println("Empleado Registrado Correctamente.");
                                }else{
                                    System.out.println("Ya Existe un Empleado con el Documento ingresado. ");
                                }
                                break;
                            case 2:
                                if(ListaEmpresas.isEmpty()){
                                    System.out.println("Deber Registrar una Empresa para poder Crear un empleado ");
                                    break;
                                }
                                if(ListaEmpleados.isEmpty()){
                                    System.out.println("No Existen Empleados, No se puede realizar la modificación ");
                                    break;
                                }
                                System.out.println("Ingrese el documento de la persona a modificar: ");
                                String DocumentoNuevo = opciones.nextLine();
                                boolean encontradoDoc = false;

                                for (int i = 0;i < ListaEmpleados.size();i++){
                                    Empleado empleado1 = ListaEmpleados.get(i);

                                    if (empleado1.getDocumento().equals(DocumentoNuevo)){
                                        System.out.println("Digite lo que desea cambiar del empleado: ");
                                        System.out.println("1. Nombre");
                                        System.out.println("2. Correo");
                                        System.out.println("3. Empresa");
                                        System.out.println("3. Rol");
                                        int opModEmple = opciones.nextInt();
                                        opciones.nextLine();
                                        encontradoDoc = true;
                                        switch (opModEmple) {
                                            case 1:
                                                System.out.println("Ingrese el nuevo nombre: ");
                                                String nuevoNomb = opciones.nextLine();
                                                empleado1.setNombreEmpleado(nuevoNomb);
                                                break;
                                            case 2:
                                                System.out.println("Ingrese el nuevo correo: ");
                                                String nuevoCorreo = opciones.nextLine();
                                                empleado1.setCorreoEmpleado(nuevoCorreo);
                                                break;
                                            case 3:
                                                String empresaEmpl = "";
                                                boolean bandera = false;
                                                while (!bandera){
                                                    System.out.println("Ingrese el nit de la nueva empresa del empleado: ");
                                                    empresaEmpl = opciones.nextLine();
                                                    var res = funcionesEmp.BuscarEmpresa(ListaEmpresas, empresaEmpl);
                                                    if (res) {
                                                        bandera = true;
                                                    } else {
                                                        System.out.println("El nit de la Empresa ingresado no Existe digite un Nit válido.");
                                                    }
                                                }
                                                Empresa empresa = funcionesEmp.TraerEmpresa(ListaEmpresas, empresaEmpl);
                                                empleado1.setEmpresaEmpleado(empresa);
                                                break;
                                            case 4:
                                                System.out.println("Ingrese el nuevo rol: ");
                                                String nuevoRol = opciones.nextLine();
                                                empleado1.setRol(nuevoRol);
                                                break;
                                        }
                                    }
                                }
                                if (!encontradoDoc){
                                    System.out.println("El documento digitado no existe.");
                                }else{
                                    System.out.println("Registro Actualizado Correctamente.");
                                }
                                break;
                            case 3:
                                if(ListaEmpleados.isEmpty()){
                                    System.out.println("No Existen Empleados, No se puede realizar la consulta ");
                                    break;
                                }
                                System.out.println("Ingrese el documento de la persona a mostrar: ");
                                String DocumentoInfo = opciones.nextLine();
                                boolean encontradoDoc2 = false;

                                for (int i = 0;i < ListaEmpleados.size();i++) {
                                    Empleado empleado1 = ListaEmpleados.get(i);
                                    if (empleado1.getDocumento().equals(DocumentoInfo)){
                                        empleado1.mostrarInfoEmpleado();
                                        encontradoDoc2 = true;
                                    }
                                }
                                if (!encontradoDoc2){
                                    System.out.println("El documento digitado no existe.");
                                }
                                break;
                        }
                    }while (opcionEmpl != 4);
                    break;
                case 3:
                    int opcionMov;
                    do{
                        System.out.println("---------- MENÚ MOVIMIENTOS ----------");
                        System.out.println("1. Registrar Movimiento");
                        System.out.println("2. Modificar Movimiento");
                        System.out.println("3. Mostrar Movimientos");
                        System.out.println("4. Menú Anterior");
                        opcionMov = opciones.nextInt();
                        opciones.nextLine();
                        switch (opcionMov) {
                            case 1:
                                if (ListaEmpleados.isEmpty()) {
                                    System.out.println("Deber Registrar un Empleado para poder grabar Movimientos ");
                                    break;
                                }
                                System.out.println("Ingrese el Monto del movimiento: ");
                                double monto = opciones.nextDouble();
                                opciones.nextLine();
                                System.out.println("Ingrese el Concepto del Movimiento: ");
                                String concepto = opciones.nextLine();
                                String dctoEmpl = "";
                                boolean bandera = false;
                                while (!bandera) {
                                    System.out.println("Ingrese el documento del empleado: ");
                                    dctoEmpl = opciones.nextLine();
                                    var res = funcionesEmpleados.BuscarEmpleado(ListaEmpleados, dctoEmpl);
                                    if (res) {
                                        bandera = true;
                                    } else {
                                        System.out.println("El empleado ingresado no existe digite un documento válido.");
                                    }
                                }
                                Empleado empleado = funcionesEmpleados.TraerEmpleado(ListaEmpleados, dctoEmpl);
                                MovimientoDinero mvto = new MovimientoDinero(ListaMovimientos.size() + 1, monto, concepto, empleado, Calendar.getInstance().getTime());
                                ListaMovimientos.add(mvto);
                                System.out.println("Movimiento Registrado Correctamente.");

                                break;
                            case 2:
                                if (ListaEmpleados.isEmpty()) {
                                    System.out.println("No Existen Empleados, No se puede realizar la modificación ");
                                    break;
                                }
                                System.out.println("Ingrese el id del movimiento a modificar: ");
                                int id = opciones.nextInt();
                                opciones.nextLine();
                                boolean encontradoId = false;

                                for (int i = 0; i < ListaMovimientos.size(); i++) {
                                    MovimientoDinero movto = ListaMovimientos.get(i);

                                    if (movto.getId() == id) {
                                        System.out.println("Digite lo que desea cambiar del movimiento: ");
                                        System.out.println("1. Monto");
                                        System.out.println("2. Concepto");
                                        System.out.println("3. Usuario Encargado");
                                        int opModMvto = opciones.nextInt();
                                        opciones.nextLine();
                                        encontradoId = true;
                                        switch (opModMvto) {
                                            case 1:
                                                System.out.println("Ingrese el nuevo monto: ");
                                                double nuevoMonto = opciones.nextDouble();
                                                opciones.nextLine();
                                                movto.setMonto(nuevoMonto);
                                                break;
                                            case 2:
                                                System.out.println("Ingrese el nuevo concepto: ");
                                                String nuevoConcepto = opciones.nextLine();
                                                movto.setConcepto(nuevoConcepto);
                                                break;
                                            case 3:
                                                String mvtoEmpl = "";
                                                boolean band = false;
                                                while (!band) {
                                                    System.out.println("Ingrese el documento del nuevo empleado: ");
                                                    mvtoEmpl = opciones.nextLine();
                                                    var res = funcionesEmpleados.BuscarEmpleado(ListaEmpleados, mvtoEmpl);
                                                    if (res) {
                                                        band = true;
                                                    } else {
                                                        System.out.println("El documento ingresado no Existe digite un documento válido.");
                                                    }
                                                }
                                                Empleado usuReg = funcionesEmpleados.TraerEmpleado(ListaEmpleados, mvtoEmpl);
                                                movto.setUsuarioEncargado(usuReg);
                                                break;
                                        }
                                    }
                                }
                                if (!encontradoId) {
                                    System.out.println("El id digitado no existe.");
                                } else {
                                    System.out.println("Registro Actualizado Correctamente.");
                                }
                                break;
                            case 3:
                                if (ListaMovimientos.isEmpty()) {
                                    System.out.println("No Existen Movimientos, No se puede realizar la consulta ");
                                    break;
                                }

                                int opcionConMov;
                                do {
                                    System.out.println("---------- CONSULTAR MOVIMIENTOS POR: ----------");
                                    System.out.println("1. Nit Empresa");
                                    System.out.println("2. Usuario Encargado");
                                    System.out.println("3. Fecha de Movimientos");
                                    System.out.println("4. Todos");
                                    System.out.println("5. Menu Anterior");
                                    opcionConMov = opciones.nextInt();
                                    opciones.nextLine();

                                    switch (opcionConMov) {
                                        case 1:
                                            boolean val = false;
                                            String nitEmpresa = "";
                                            while (!val) {
                                                System.out.println("Ingrese el Nit de la empresa: ");
                                                nitEmpresa = opciones.nextLine();
                                                if (funcionesEmp.BuscarEmpresa(ListaEmpresas, nitEmpresa)) {
                                                    val = true;
                                                } else {
                                                    System.out.println("Nit no válido. Por favor, ingrese un Nit válido.");
                                                }
                                            }
                                            funcionesMvtoDinero.mostrarMovimiento(ListaMovimientos, 1, nitEmpresa, null);
                                            break;
                                        case 2:
                                            boolean val2 = false;
                                            String dctoUsu = "";
                                            while (!val2) {
                                                System.out.println("Ingrese el Documento del Usuario Encargado: ");
                                                dctoUsu = opciones.nextLine();
                                                if (funcionesEmpleados.BuscarEmpleado(ListaEmpleados, dctoUsu)) {
                                                    val2 = true;
                                                } else {
                                                    System.out.println("Documento no válido. Por favor, ingrese un Documento válido.");
                                                }
                                            }
                                            funcionesMvtoDinero.mostrarMovimiento(ListaMovimientos, 2, dctoUsu, null);
                                            break;
                                        case 3:
                                            boolean val3 = false;
                                            Date fechaMvto = null;

                                            while (!val3) {
                                                System.out.println("Ingrese la fecha de los movimientos: ");
                                                String fechaText = opciones.nextLine();

                                                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

                                                if (!fechaText.isEmpty()) {
                                                    try {
                                                        fechaMvto = formatoFecha.parse(fechaText);
                                                        val3 = true;
                                                    } catch (ParseException e) {
                                                        System.out.println("Formato incorrecto (dd/MM/yyyy).");
                                                    }
                                                }
                                            }
                                            funcionesMvtoDinero.mostrarMovimiento(ListaMovimientos, 3, null, fechaMvto);
                                            break;

                                        case 4:
                                            funcionesMvtoDinero.mostrarMovimiento(ListaMovimientos, 4, null, null);
                                            break;
                                    }
                                } while (opcionConMov != 5);
                                break;
                        }
                    }while (opcionMov != 4);
                    break;
            }
        }while (opcionP != 4);
    }
}

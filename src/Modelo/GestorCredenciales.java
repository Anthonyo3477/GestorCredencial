/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vicen
 */
public class GestorCredenciales {
    //INTANCIA CREADA CON PATRÓN SINGLETON 
    private static GestorCredenciales instancia;
    private List<Credencial> listaCredenciales;

    private GestorCredenciales() {
        listaCredenciales = new ArrayList<>();
    }

    //ADAPTACIÓN PATRÓN SINGLETON EN ESTE CONSTRUCTOR PRIVADO
    public static GestorCredenciales getInstancia() {
        if (instancia == null) {
            instancia = new GestorCredenciales();
        }
        return instancia;
    }

    public void agregarCredencial(Credencial c) {
        listaCredenciales.add(c);
    }

    public void listarCredenciales() {
        if (listaCredenciales.isEmpty()) {
            System.out.println("No hay credenciales generadas.");
        } else {
            for (int i = 0; i < listaCredenciales.size(); i++) {
                System.out.println((i + 1) + ". " + listaCredenciales.get(i));
            }
        }
    }

    public void eliminarCredencial(int indice) {
        if (indice >= 0 && indice < listaCredenciales.size()) {
            listaCredenciales.remove(indice);
        }
    }

    public List<Credencial> getCredenciales() {
        return listaCredenciales;
    }
}

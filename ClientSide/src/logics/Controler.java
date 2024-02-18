/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics;

import com.Request;
import com.Response;
import coms.Communication;
import com.utils.Operation;
import com.utils.ResponseStatus;
import domain.Klijent;
import domain.RezimTreninga;
import domain.StavkaRezimaTreninga;
import domain.Trener;
import domain.VrstaTreninga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;

/**
 *
 * @author user
 */
public class Controler {
    private static Controler instance;

    private Controler() {
    }
    
    public static Controler getInstance(){
        if(instance == null)
            instance = new Controler();
        
        return instance;
    }

   

    public Trener prijaviTrenera(String username, String password) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_PRIJAVA);
        Trener t = new Trener();
        t.setUsername(username);
        t.setPassword(password);
        request.setData(t);
        System.out.println("Saljem");
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
            return (Trener) response.getData();
        } else {
            throw (Exception) response.getError();
        }
    }

    public void sacuvajKlijenta(Klijent k) throws Exception{
        Request request = new Request();
        request.setOperation(Operation.OPERATION_SACUVAJ_KLIJENTA);
        request.setData(k);
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
        } else {
            throw (Exception) response.getError();
        }
    }

    public ArrayList<Klijent> vratiKlijente() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.VRATI_KLIJENTE);
        Klijent filter = new Klijent();
        
        request.setData(filter);
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
            return (ArrayList<Klijent>) response.getData();
        } else {
            throw (Exception) response.getError();
        }
    
    }

    public void obrisiKlijenta(int klijentId) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_OBRISI_KLIJENTA);
        request.setData(klijentId);
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
        } else {
            throw (Exception) response.getError();
        }
    
    }

    public void sacuvajRezim(RezimTreninga rezim) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_SACUVAJ_REZIM);
        request.setData(rezim);
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
        } else {
            throw (Exception) response.getError();
        }
    }

    public ArrayList<RezimTreninga> vratiRezime() throws Exception{
        Request request = new Request();
        request.setOperation(Operation.VRATI_REZIME);
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
            return (ArrayList<RezimTreninga>) response.getData();
        } else {
            throw (Exception) response.getError();
        }
    }

    public void obrisiStavku(int stavkaId) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_OBRISI_STAVKU);
        request.setData(stavkaId);
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
        } else {
            throw (Exception) response.getError();
        }}

    public void sacuvajStavku(StavkaRezimaTreninga s) throws Exception{
        Request request = new Request();
        request.setOperation(Operation.OPERATION_SACUVAJ_STAVKU);
        request.setData(s);
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
        } else {
            throw (Exception) response.getError();
        }
    }

    public void izmeniStavku(StavkaRezimaTreninga v) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_IZMENI_STAVKU);
        request.setData(v);
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
        } else {
            throw (Exception) response.getError();
        }
    }

    public ArrayList<VrstaTreninga> vratiVrste() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.VRATI_VRSTE);
        ObjectOutputStream outSocket = new ObjectOutputStream(
                Session.getInstance()
                .getSocket()
                .getOutputStream());
        outSocket.writeObject(request);
        ObjectInputStream inSocket = new ObjectInputStream(
                Session.getInstance().getSocket().getInputStream());
        Response response = (Response) inSocket.readObject();
        if (response.getStatus() == ResponseStatus.SUCCESS) {
            return (ArrayList<VrstaTreninga>) response.getData();
        } else {
            throw (Exception) response.getError();
        }
    }
    
    
}

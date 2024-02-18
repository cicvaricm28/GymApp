/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.Request;
import com.Response;
import com.utils.Operation;
import com.utils.ResponseStatus;
import domain.IGeneralEntity;
import domain.Klijent;
import domain.RezimTreninga;
import domain.StavkaRezimaTreninga;
import domain.VrstaTreninga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Controler;

/**
 *
 * @author user
 */
public class KlijentskaNit extends Thread{
    private Socket socket;
    private static int rezimIterator = 1;
    private static int stavkaIterator = 1;
    private static int klijentIterator = 1;
    
    public KlijentskaNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            communication();
            
            System.out.println("Run!");
        } catch (Exception ex) {
            System.out.println("Klijent se otkacio!");
        }
    }
    
    private void communication() throws Exception {
        while (!isInterrupted()) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            Object object = inSocket.readObject();
            if (object instanceof Request) {
                Request request = (Request) object;
                Response response = handleRequest(request);
                sendResponse(socket, response);
            }
        }
    }
    
     private Response handleRequest(Request request) {
        int operation = request.getOperation();
        Response response = new Response();
        System.out.println("Operation: " + request.getOperation());
        switch (operation) {
            case Operation.OPERATION_PRIJAVA: 
                try {
                    System.out.println("Primljen");
                    IGeneralEntity entity = Controler
                            .getInstance()
                            .prijaviTrenera((IGeneralEntity) request.getData());
                    response.setStatus(ResponseStatus.SUCCESS);
                    response.setData(entity);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                 case Operation.OPERATION_SACUVAJ_KLIJENTA:
                try {
                    Klijent k = (Klijent) request.getData();
                    Controler.getInstance().sacuvajKlijenta(k);
                    response.setStatus(ResponseStatus.SUCCESS);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                 case Operation.VRATI_KLIJENTE:
                     try {
                    List<IGeneralEntity> vozila = Controler.getInstance().vratiKlijente((Klijent) request.getData());
                    response.setStatus(ResponseStatus.SUCCESS);
                    response.setData(vozila);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                     
                break;
                 case Operation.OPERATION_OBRISI_KLIJENTA:
                try {
                    Klijent k = new Klijent();
                    k.setKlijentId((int) request.getData());
                    Controler.getInstance().obrisiKlijenta(k);
                    response.setStatus(ResponseStatus.SUCCESS);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                case Operation.OPERATION_SACUVAJ_REZIM:
                try {
                    RezimTreninga r = (RezimTreninga) request.getData();
                    r.setRezimId(rezimIterator++);
                    ArrayList<StavkaRezimaTreninga> list = r.getStavke();
                    for (StavkaRezimaTreninga s : list) {
                        s.setStavkaId(stavkaIterator++);
                        s.setRezim(r);
                    }
                    Controler.getInstance().sacuvajRezim(r);
                    response.setStatus(ResponseStatus.SUCCESS);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                case Operation.VRATI_REZIME:
                try {
                    RezimTreninga r = new RezimTreninga();
                    
                    List<IGeneralEntity> rezimi = Controler.getInstance().vratiSveRezime(r);
                    response.setData(rezimi);
                    response.setStatus(ResponseStatus.SUCCESS);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                case Operation.OPERATION_OBRISI_STAVKU:
                try {
                    StavkaRezimaTreninga s = new StavkaRezimaTreninga();
                    s.setStavkaId((int) request.getData());
                    Controler.getInstance().obrisiStavku(s);
                    response.setStatus(ResponseStatus.SUCCESS);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                case Operation.OPERATION_SACUVAJ_STAVKU:
                try {
                    StavkaRezimaTreninga s = (StavkaRezimaTreninga) request.getData();
                    s.setStavkaId(stavkaIterator++);
                    Controler.getInstance().sacuvajStavku(s);
                    response.setStatus(ResponseStatus.SUCCESS);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                case Operation.OPERATION_IZMENI_STAVKU:
                try {
                    StavkaRezimaTreninga s = (StavkaRezimaTreninga) request.getData();
                    Controler.getInstance().izmeniStavku(s);
                    response.setStatus(ResponseStatus.SUCCESS);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                case Operation.VRATI_VRSTE:
                try {
                    VrstaTreninga r = new VrstaTreninga();
                    
                    List<IGeneralEntity> vrste = Controler.getInstance().vratiSveVrste(r);
                    response.setData(vrste);
                    response.setStatus(ResponseStatus.SUCCESS);
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
        }
        
        return response;
     }
    
    
    private void sendResponse(Socket socket, Response response) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(response);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}

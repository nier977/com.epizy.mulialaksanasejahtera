package com.epizy.mulialaksanasejahtera.Controller;

import com.epizy.mulialaksanasejahtera.DAO.kemampuanBahasaDAO;
import com.epizy.mulialaksanasejahtera.DAOImpelement.kemampuanBahasaDAOImpl;
import com.epizy.mulialaksanasejahtera.Model.kemampuanBahasa;

import javax.swing.*;
import java.util.List;

public class controllerKemampuanBahasa {
    JFrame jFrame;
    JInternalFrame jInternalFrame;
    kemampuanBahasaDAO kemampuanBahasaDAO;
    List<kemampuanBahasa> kemampuanBahasaList;

    public controllerKemampuanBahasa(JFrame jFrame) {
        this.jFrame = jFrame;
        kemampuanBahasaDAO = new kemampuanBahasaDAOImpl();
        kemampuanBahasaList = kemampuanBahasaDAO.GetAll();
    }

    public controllerKemampuanBahasa(JInternalFrame jInternalFrame) {
        this.jInternalFrame = jInternalFrame;
        kemampuanBahasaDAO = new kemampuanBahasaDAOImpl();
        kemampuanBahasaList = kemampuanBahasaDAO.GetAll();
    }

    public void save(Object object1,Object object2,Object object3,Object object4,Object object5,Object object6) {
        kemampuanBahasa kemampuanBahasa = new kemampuanBahasa();
        kemampuanBahasa.setNoRegistrasi(String.valueOf(object1));
        kemampuanBahasa.setInggris(String.valueOf(object2));
        kemampuanBahasa.setMandarin(String.valueOf(object3));
        kemampuanBahasa.setHokian(String.valueOf(object4));
        kemampuanBahasa.setHokka(String.valueOf(object5));
        kemampuanBahasa.setLain(String.valueOf(object6));
        kemampuanBahasaDAO.Save(kemampuanBahasa);
    }
}
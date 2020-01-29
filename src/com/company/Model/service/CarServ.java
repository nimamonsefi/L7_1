package com.company.Model.service;

import com.company.Model.entity.CarEnt;
import com.company.Model.repository.CarRep;

import java.util.List;

public class CarServ {

    private CarServ(){}

    private static CarServ carServ = new CarServ();

    public static CarServ getInstance(){
        return carServ;
    }

    public void save(CarEnt carEnt) throws Exception{
        try (CarRep carRep = new CarRep()){
            carRep.insert(carEnt);
            carRep.commit();
        }
    }

    public void edit(CarEnt carEnt) throws Exception{
        try (CarRep carRep = new CarRep()){
            carRep.update(carEnt);
            carRep.commit();
        }
    }

    public void remove(long id) throws Exception{
        try (CarRep carRep = new CarRep()){
            carRep.delete(id);
            carRep.commit();
        }
    }

    public List<CarEnt> report() throws Exception{
        List<CarEnt> carEntList;
        try (CarRep carRep = new CarRep()){
            carEntList = carRep.select();
        }
        return carEntList;
    }
}

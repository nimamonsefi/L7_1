package com.company;

import com.company.Model.entity.CarEnt;
import com.company.Model.service.CarServ;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choose;
        String name,model,color,name2,model2,color2;
        int year,year2;
        long id,id2,id3;
        System.out.println("\t\tSaipa");
        System.out.println("\n1.InsertCar\n2.UpdateCar\n3.DeleteCar\n4.ShowCars");
        choose = input.nextInt();
        switch (choose){

            case 1:{
                try {
                    System.out.println("__________________________\nINSERTING");
                    System.out.print("Id:");
                    id = input.nextLong();
                    System.out.print("Name:");
                    name = input.next();
                    System.out.print("Model:");
                    model = input.next();
                    System.out.print("Year:");
                    year = input.nextInt();
                    System.out.print("Color:");
                    color = input.next();
                    CarServ.getInstance().save(new CarEnt().setId(id).setName(name).setModel(model).setYear(year).setColor(color));
                    System.out.println("\n\tSaved Successfully");
                } catch (Exception e) {
                    System.out.println("Fail to save!"+e.getMessage());
                }
                break;
            }

            case 2:{
                try {
                    System.out.println("__________________________\nUPDATING");
                    System.out.print("Id(previous one):");
                    id2 = input.nextLong();
                    System.out.print("Name(new one):");
                    name2 = input.next();
                    System.out.print("Model(new one):");
                    model2 = input.next();
                    System.out.print("Year(previous one):");
                    year2 = input.nextInt();
                    System.out.print("Color(previous one):");
                    color2 = input.next();
                    CarServ.getInstance().edit(new CarEnt().setId(id2).setName(name2).setModel(model2).setYear(year2).setColor(color2));
                    System.out.println("\n\tEdited Successfully");
                } catch (Exception e) {
                    System.out.println("Fail to edit!"+e.getMessage());
                }
                break;
            }

            case 3:{
                try {
                    System.out.println("__________________________\nDELETING");
                    System.out.print("Id:");
                    id3 = input.nextLong();
                    CarServ.getInstance().remove(id3);
                    System.out.println("\n\tDeleted Successfully");
                } catch (Exception e) {
                    System.out.println("Fail to delete!"+e.getMessage());
                }
                break;
            }

            case 4:{
                try {
                    System.out.println("__________________________\nCarsInformation");
                    List<CarEnt> carList = CarServ.getInstance().report();
                    for(CarEnt carEnt : carList){
                        System.out.println(carEnt.getId());
                        System.out.println(carEnt.getName());
                        System.out.println(carEnt.getModel());
                        System.out.println(carEnt.getYear());
                        System.out.println(carEnt.getColor());
                    }
                } catch (Exception e) {
                    System.out.println("Fail to Show!"+e.getMessage());
                }
                break;
            }
        }
    }
}

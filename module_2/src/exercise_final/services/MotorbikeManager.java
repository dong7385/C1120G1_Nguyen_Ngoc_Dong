package exercise_final.services;

import exercise_final.commons.FuncReadAndWrite;
import exercise_final.models.Motorbike;

import java.util.ArrayList;
import java.util.List;

public class MotorbikeManager implements IService<Motorbike> {
    private static FuncReadAndWrite<Motorbike> funcReadAndWrite = new FuncReadAndWrite<>();

    @Override
    public List<Motorbike> findAll() {
        List<String[]> list = FuncReadAndWrite.readFile("xeMay.csv");
        List<Motorbike> listMotorbikes = new ArrayList<>();
        for (String[] line : list) {
            Motorbike motorbike = new Motorbike(line);
            listMotorbikes.add(motorbike);
        }
        return listMotorbikes;
    }

    @Override
    public Motorbike findById(String noPlate) {
        List<Motorbike> list = findAll();
        for (Motorbike motorbike : list) {
            if (motorbike.getNoPlate().equals(noPlate)) {
                return motorbike;
            }
        }
        return null;
    }

    @Override
    public void add(Motorbike motorbike) {
        List<Motorbike> list = new ArrayList<>();
        list.add(motorbike);
        funcReadAndWrite.writeFile("xeMay.csv", list, true);
    }

    @Override
    public void edit(Motorbike motorbike, String noPlate) {
        List<Motorbike> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNoPlate().equals(noPlate)) {
                list.remove(i);
                list.add(i, motorbike);
                funcReadAndWrite.writeFile("xeMay.csv", list, false);
                return;
            }
        }
    }

    @Override
    public void delete(String noPlate) {
        List<Motorbike> list = findAll();
        for (Motorbike motorbike : list) {
            if (motorbike.getNoPlate().equals(noPlate)) {
                list.remove(motorbike);
                funcReadAndWrite.writeFile("xeMay.csv", list, false);
                return;
            }
        }
    }
}

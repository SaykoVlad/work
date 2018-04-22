package by.bntu.fitr.povt.cng.controller;
import by.bntu.fitr.povt.cng.model.Creator;
import by.bntu.fitr.povt.cng.model.collections.deprecated.QueueMasImpl;
import by.bntu.fitr.povt.cng.model.entity.Garland;
import by.bntu.fitr.povt.cng.model.entity.Lights;
import by.bntu.fitr.povt.cng.model.entity.StuffedToys;
import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;
import by.bntu.fitr.povt.cng.model.entity.container.JSFContainer.JSFArrayTree;
import by.bntu.fitr.povt.cng.model.entity.container.SmartTree;
import by.bntu.fitr.povt.cng.model.entity.container.ToyType;
import by.bntu.fitr.povt.cng.model.entity.container.Tree;
import by.bntu.fitr.povt.cng.model.logic.JSFLogic.ComparableSort;
import by.bntu.fitr.povt.cng.model.logic.Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        Garland garland = new Garland(1,1,1,1,1,"123123");
        StuffedToys stuffedToys = new StuffedToys(2,3,3,"3","man",3);
        Lights lights = new Lights(6,2,2,2,2,2);

        ArrayList<Toy> toys = new ArrayList<>();
        toys.addAll(Arrays.asList(lights,garland,stuffedToys));

        ComparableSort.sort(toys,ComparableSort.SortType.PRICE_TO_LOWER);
        for (Toy toy : toys){
            System.out.println(toy);
        }

    }

}
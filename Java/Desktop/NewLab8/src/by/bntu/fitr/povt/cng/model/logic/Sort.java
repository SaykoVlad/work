package by.bntu.fitr.povt.cng.model.logic;

import by.bntu.fitr.povt.cng.model.entity.container.JSFContainer.JSFTrees;
import by.bntu.fitr.povt.cng.model.entity.container.Tree;
import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;

import java.util.Comparator;

public class Sort {

    @Deprecated
    public static void insert(Tree tree) {
        Toy temp;
        int j;
        for (int i = 0; i < tree.getSize() - 1; i++) {
            if (tree.getToy(i).getPrice() > tree.getToy(i + 1).getPrice()) {
                temp = tree.getToy(i + 1);
                tree.changeToy(tree.getToy(i), i + 1);
                j = i;
                while (j > 0 && temp.getPrice() < tree.getToy(j - 1).getPrice()) {
                    tree.changeToy(tree.getToy(j - 1), j);
                    j--;
                }
                tree.changeToy(temp, j);
            }
        }
    }


    @Deprecated
    public static void bubble(Tree tree) {
        boolean sorted = true;
        for (int i = tree.getSize(); i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (tree.getToy(j).getPrice() > tree.getToy(j + 1).getPrice()) {
                    Toy tmp = tree.getToy(j);
                    tree.changeToy(tree.getToy(j + 1), j);
                    tree.changeToy(tmp, j + 1);
                    sorted = false;
                }
                if (sorted) {
                    break;
                }

            }
        }
    }


}

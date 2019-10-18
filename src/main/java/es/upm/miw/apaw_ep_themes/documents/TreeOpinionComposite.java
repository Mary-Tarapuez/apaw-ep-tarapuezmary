package es.upm.miw.apaw_ep_themes.documents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreeOpinionComposite implements TreeOpinion {

    private String id;

    private String description;

    private Date dateRegister;

    private List<TreeOpinion> treeOpinionList;

    public TreeOpinionComposite(String description, Date dateRegister) {
        this.description = description;
        this.dateRegister = dateRegister;
        this.treeOpinionList = new ArrayList<>();
    }

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public Date dateRegister() {
        return this.dateRegister;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeOpinion treeOpinion) {
        this.treeOpinionList.add(treeOpinion);
    }

    @Override
    public void remove(TreeOpinion treeOpinion) {
        this.treeOpinionList.remove(treeOpinion);
    }
}

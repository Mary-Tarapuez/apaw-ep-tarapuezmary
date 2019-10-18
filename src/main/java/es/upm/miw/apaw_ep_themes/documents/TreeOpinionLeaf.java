package es.upm.miw.apaw_ep_themes.documents;

import java.util.Date;

public class TreeOpinionLeaf implements TreeOpinion {
    private Opinion opinion;

    public TreeOpinionLeaf(Opinion opinion) {
        this.opinion = opinion;
    }

    @Override
    public String id() {
        return this.opinion.getId();
    }

    @Override
    public String description() {
        return this.opinion.getDescription();
    }

    @Override
    public Date dateRegister() {
        return this.opinion.getDateRegister();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeOpinion treeOpinion) {
        // Do nothing because is leaf
    }

    @Override
    public void remove(TreeOpinion treeOpinion) {
        // Do nothing because is leaf
    }
}

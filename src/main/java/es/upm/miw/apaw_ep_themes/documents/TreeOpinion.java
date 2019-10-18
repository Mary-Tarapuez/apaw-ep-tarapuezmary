package es.upm.miw.apaw_ep_themes.documents;

import java.util.Date;

public interface TreeOpinion {
    String id();
    String description();
    Date dateRegister();
    boolean isComposite();
    void add(TreeOpinion treeOpinion);
    void remove(TreeOpinion treeOpinion);
}

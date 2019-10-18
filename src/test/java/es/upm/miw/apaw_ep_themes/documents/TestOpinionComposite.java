package es.upm.miw.apaw_ep_themes.documents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestOpinionComposite {
    private TreeOpinion root;
    private TreeOpinion sub;
    private TreeOpinion leaf;

    @BeforeEach
    void start(){
        TreeOpinion subOpinion;

        this.root = new TreeOpinionComposite("Opinion Adults", new Date("17/10/2019"));
        this.leaf = new TreeOpinionLeaf(new Opinion("Opinion Teen", new Date("17/10/2019")));
        this.root.add(leaf);

        this.root.add(new TreeOpinionLeaf(new Opinion("Opinion Group", new Date("18/10/2019"))));

        subOpinion = new TreeOpinionComposite("Opinion Clientes", new Date("19/10/2019"));
        this.root.add(subOpinion);
        subOpinion.add(new TreeOpinionLeaf(new Opinion("New rhythms", new Date("20/10/2019"))));
        this.sub = new TreeOpinionComposite("Opinion Bailarines", new Date("20/10/2019"));
        subOpinion.add(sub);

        this.sub.add(new TreeOpinionLeaf(new Opinion("Opinion Lady", new Date("21/10/2019"))));
    }

    @Test
    void testOpinionOfTreeOpinionIfLeaf(){
        assertEquals("Opinion Teen", this.leaf.description());
    }

    @Test
    void testOpinionOfTreeOpinionIfComposite(){
        assertEquals("Opinion Adults", this.root.description());
    }

    @Test
    void testOpinionIfLeaf(){
        assertEquals(new Date("17/10/2019"), this.leaf.dateRegister());
    }
}

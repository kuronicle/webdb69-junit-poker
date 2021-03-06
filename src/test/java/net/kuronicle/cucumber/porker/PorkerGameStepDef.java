package net.kuronicle.cucumber.porker;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

import cucumber.annotation.ja.ならば;
import cucumber.annotation.ja.もし;
import cucumber.annotation.ja.前提;

public class PorkerGameStepDef {
    
    PorkerGame sut;
    
    @前提("^手札に([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+)が配られた$")
    public void 手札にカードが配られた(
            char suit1, int no1,
            char suit2, int no2,
            char suit3, int no3,
            char suit4, int no4,
            char suit5, int no5) {
        
        sut = new PorkerGame();
        sut.setUp(Card.get(suit1, no1),
                Card.get(suit2, no2),
                Card.get(suit3, no3),
                Card.get(suit4, no4),
                Card.get(suit5, no5));
    }

    @もし("^チェンジしない$")
    public void チェンジしない() {
        sut.noChange();
    }

    @ならば("^ノーペアであるべき$")
    public void ノーペアであるべき() {
        Pat result = sut.pat();
        assertThat(result, is(Pat.NO_PAIR));
    }
    
    @ならば("^(\\d+)のワンペアであるべき$")
    public void のワンペアであるべき(int no) throws Throwable {
        Pat result = sut.pat();
        Pat expected = new Pat.OnePair(no);
        assertThat(result, is(expected));
    }

}

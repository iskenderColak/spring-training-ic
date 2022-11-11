package com.icolak;

import com.icolak.casefactory.Case;
import com.icolak.monitorfactory.Monitor;
import com.icolak.motherboardfactory.Motherboard;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PC {

    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;
    @Autowired // Starting with Spring 4.3 if you have constructor di is okey
                // @Autowired is not mandatory, you can omit writing it.
    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}

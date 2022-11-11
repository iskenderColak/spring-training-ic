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

    @Autowired
    private Case theCase;
    @Autowired
    private Monitor monitor;
    @Autowired
    private Motherboard motherboard;



    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}

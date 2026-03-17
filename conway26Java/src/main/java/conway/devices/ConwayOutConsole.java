package conway.devices;

import conway.domain.IOutDev;

public class ConwayOutConsole implements IOutDev {
    @Override
    public void display(String msg) {
        System.out.println(msg);
        System.out.println("-------------------------");
    }
}
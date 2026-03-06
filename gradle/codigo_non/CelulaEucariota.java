package org.santiagom123;

public class CelulaEucariota implements IAtp{

    int Disponible = getInitialATP();
    int Oxigeno = 100;
    int lastTick = 0;


    @Override
    public void usarAtp(int Gasto) {
        this.Disponible =- Gasto;
    }

    @Override
    public void producirAtp() {
        if (this.Oxigeno >= 10) {
            this.Disponible =+ 15;
            this.Oxigeno =- 10;


        }
    }

    @Override
    public void degradarAtp(int Tick) {
        this.lastTick = 0;

        int progreso = Tick - this.lastTick;

        if (progreso >= 5000) {

            this.Disponible = Disponible - 1;

            lastTick = Tick;
        }
    }

}

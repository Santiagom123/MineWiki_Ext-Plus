package org.santiagom123;

public interface IAtp {

    default int getInitialATP() {
        return 100;
    }

    void usarAtp(int Gasto);

    void producirAtp();

    void degradarAtp(int Tick);
}

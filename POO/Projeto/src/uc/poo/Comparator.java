package uc.poo;


import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

class comparador implements Comparator<Publicacao> {

    @Override
    public int compare(Publicacao a, Publicacao b) {
        return new CompareToBuilder()
                .append(b.getAno(), a.getAno())
                .append(a.getTipo(), b.getTipo())
                .append(a.fatorImpacto(), b.fatorImpacto()).toComparison();
    }

}

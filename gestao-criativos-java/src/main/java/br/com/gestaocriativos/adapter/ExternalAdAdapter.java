package br.com.gestaocriativos.adapter;

import br.com.gestaocriativos.domain.Creative;

public class ExternalAdAdapter {
    public Creative toCreative(ExternalAdDTO dto) {
        return new Creative(
                dto.getAdTitle(),
                dto.getAdText(),
                dto.getAdUrl(),
                dto.getCreativeType(),
                dto.getOfferId()
        );
    }
}

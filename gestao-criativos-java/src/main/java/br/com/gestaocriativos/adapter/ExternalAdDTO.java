package br.com.gestaocriativos.adapter;

import br.com.gestaocriativos.domain.CreativeType;

public class ExternalAdDTO {
    private final String adTitle;
    private final String adText;
    private final String adUrl;
    private final CreativeType creativeType;
    private final String offerId;

    public ExternalAdDTO(String adTitle, String adText, String adUrl, CreativeType creativeType, String offerId) {
        this.adTitle = adTitle;
        this.adText = adText;
        this.adUrl = adUrl;
        this.creativeType = creativeType;
        this.offerId = offerId;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public String getAdText() {
        return adText;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public CreativeType getCreativeType() {
        return creativeType;
    }

    public String getOfferId() {
        return offerId;
    }
}

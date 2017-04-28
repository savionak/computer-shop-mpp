package by.bsuir.mpp.computershop.dto;

import java.sql.Timestamp;

public class ImportDto extends BaseDto {
    private ProviderDto provider;

    private ComponentModelDto model;

    private Timestamp importDate;

    private Long count;

    private Long purchasePrice;

    private Long price;

    public ProviderDto getProvider() {
        return provider;
    }

    public void setProvider(ProviderDto provider) {
        this.provider = provider;
    }

    public ComponentModelDto getModel() {
        return model;
    }

    public void setModel(ComponentModelDto model) {
        this.model = model;
    }

    public Timestamp getImportDate() {
        return importDate;
    }

    public void setImportDate(Timestamp importDate) {
        this.importDate = importDate;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

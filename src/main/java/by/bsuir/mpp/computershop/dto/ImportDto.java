package by.bsuir.mpp.computershop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class ImportDto extends BaseDto {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ProviderDto provider;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ComponentModelDto model;

    private Timestamp importDate;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long count;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long purchasePrice;

    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long price;

    public ProviderDto getProvider() {
        return this.provider;
    }

    public void setProvider(ProviderDto provider) {
        this.provider = provider;
    }

    public ComponentModelDto getModel() {
        return this.model;
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
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

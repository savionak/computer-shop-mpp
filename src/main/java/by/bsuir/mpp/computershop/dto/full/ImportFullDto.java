package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.dto.brief.ComponentModelBriefDto;
import by.bsuir.mpp.computershop.dto.brief.ProviderBriefDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NEGATIVE_MESSAGE;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

public class ImportFullDto extends BaseFullDto {

    private Timestamp importDate;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ComponentModelBriefDto model;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private ProviderBriefDto provider;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long purchasePrice;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long count;

    @Min(value = 0, message = CANNOT_BE_NEGATIVE_MESSAGE)
    private Long price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long storedCount;

    public Timestamp getImportDate() {
        return importDate;
    }

    public void setImportDate(Timestamp importDate) {
        this.importDate = importDate;
    }

    public ComponentModelBriefDto getModel() {
        return model;
    }

    public void setModel(ComponentModelBriefDto model) {
        this.model = model;
    }

    public ProviderBriefDto getProvider() {
        return provider;
    }

    public void setProvider(ProviderBriefDto provider) {
        this.provider = provider;
    }

    public Long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getStoredCount() {
        return storedCount;
    }

    public void setStoredCount(Long storedCount) {
        this.storedCount = storedCount;
    }
}

package by.bsuir.mpp.computershop.document;

import by.bsuir.mpp.computershop.document.generator.DocumentGenerator;
import by.bsuir.mpp.computershop.document.generator.impl.CsvGenerator;
import by.bsuir.mpp.computershop.document.generator.impl.PdfGenerator;
import by.bsuir.mpp.computershop.document.generator.impl.XlsxGenerator;
import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;

public enum DocumentType {
    PDF {
        @Override
        public <TMainEntity, TTableEntity> DocumentGenerator<TMainEntity, TTableEntity> createGenerator(ContentProvider<TMainEntity, TTableEntity> contentProvider) {
            return new PdfGenerator<>(contentProvider);
        }
    },

    XLSX {
        @Override
        public <TMainEntity, TTableEntity> DocumentGenerator<TMainEntity, TTableEntity> createGenerator(ContentProvider<TMainEntity, TTableEntity> contentProvider) {
            return new XlsxGenerator<>(contentProvider);
        }
    },

    CSV {
        @Override
        public <TMainEntity, TTableEntity> DocumentGenerator<TMainEntity, TTableEntity> createGenerator(ContentProvider<TMainEntity, TTableEntity> contentProvider) {
            return new CsvGenerator<>(contentProvider);
        }
    };

    public abstract <TMainEntity, TTableEntity> DocumentGenerator<TMainEntity, TTableEntity> createGenerator(ContentProvider<TMainEntity, TTableEntity> contentProvider);
}

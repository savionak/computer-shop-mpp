package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.DocumentController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.wrapper.DocumentGeneratorCallWrapper;
import by.bsuir.mpp.computershop.document.DocumentType;
import by.bsuir.mpp.computershop.document.generator.DocumentGenerator;
import by.bsuir.mpp.computershop.document.model.provider.ContentProvider;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.service.ComponentStoreService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

public class DocumentControllerImpl implements DocumentController {

    private static final Logger logger = Logger.getLogger(DocumentControllerImpl.class);
    private ComponentStoreService storeService;

    @Autowired
    public DocumentControllerImpl(ComponentStoreService storeService) {
        this.storeService = storeService;
    }

    @Override
    public void exportComponentStore(DocumentType documentType, HttpServletResponse response) throws ControllerException {
        Iterable<ComponentStore> store = wrapServiceCall(() -> storeService.getCurrentState(), logger);

        dispatchDocumentRequest(
                response,
                documentType,
                null,
                store,
                new ComponentStoreProvider());
    }

    private <TMainEntity, TTableEntity> void dispatchDocumentRequest(HttpServletResponse response,
                                                                     DocumentType documentType,
                                                                     TMainEntity mainEntity,
                                                                     Collection<TTableEntity> tableEntities,
                                                                     ContentProvider<TMainEntity, TTableEntity> contentProvider) throws ControllerException {
        DocumentGenerator<TMainEntity, TTableEntity> documentGenerator = documentType.createGenerator(contentProvider);
        response.setContentType(documentGenerator.getContentType());
        if (documentGenerator.isForceAttachment()) {
            response.setHeader("Content-disposition", "attachment;filename=" + createFilename(mainEntity, contentProvider, documentGenerator));
        }
        DocumentGeneratorCallWrapper.wrapDocumentGeneratorCall(() -> documentGenerator.writeDocument(
                response,
                mainEntity,
                tableEntities));
    }

    private <TMainEntity, TTableEntity> String createFilename(TMainEntity mainEntity,
                                                              ContentProvider<TMainEntity, TTableEntity> contentProvider,
                                                              DocumentGenerator<TMainEntity, TTableEntity> documentGenerator) {
        String filename = String.format("%s.%s",
                contentProvider.createFilename(mainEntity),
                documentGenerator.getFileExtension());
        filename = sanitizeFilename(filename);
        return filename;
    }

    private static String sanitizeFilename(String filename) {
        return filename.replaceAll("[^a-zA-Z0-9.-]", "_");
    }
}
